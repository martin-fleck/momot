/*******************************************************************************
 * Copyright (c) 2015 Vienna University of Technology.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * Martin Fleck (Vienna University of Technology) - initial API and implementation
 *
 * Initially developed in the context of ARTIST EU project www.artist-project.eu
 *******************************************************************************/
package at.ac.tuwien.big.moea.ui;

import at.ac.tuwien.big.moea.util.AccumulatorUtil;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Paint;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.CompareToBuilder;
import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.LegendItem;
import org.jfree.chart.LegendItemCollection;
import org.jfree.chart.LegendItemSource;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.block.LineBorder;
import org.jfree.chart.labels.BoxAndWhiskerToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;
import org.jfree.data.xy.DefaultTableXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.YIntervalSeries;
import org.jfree.data.xy.YIntervalSeriesCollection;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.moeaframework.analysis.collector.Accumulator;
import org.moeaframework.analysis.diagnostics.PaintHelper;

public class MetricPlotter {

   private static class DataPoint implements Comparable<DataPoint> {

      /**
       * The number of evaluations of this data point.
       */
      private final int NFE;

      /**
       * The metric value of this data point.
       */
      private final double value;

      /**
       * Constructs a data point with the specified number of evaluations and
       * metric value.
       *
       * @param NFE
       *           the number of evaluations of this data point
       * @param value
       *           the metric value of this data point
       */
      DataPoint(final int NFE, final double value) {
         super();
         this.NFE = NFE;
         this.value = value;
      }

      @Override
      public int compareTo(final DataPoint rhs) {
         return new CompareToBuilder().append(NFE, rhs.NFE).toComparison();
      }

      public int getNFE() {
         return NFE;
      }

      public double getValue() {
         return value;
      }

   }

   private static final int PERCENTILE_THREE_QUARTER = 75;

   private static final int PERCENTILE_QUARTER = 25;

   private static final int PERCENTILE_HALF = 50;

   private final int RESOLUTION = 500;

   private final Map<String, List<Accumulator>> accumulators = new HashMap<>();

   private final PaintHelper paintHelper = new PaintHelper();

   public MetricPlotter add(final String key, final List<Accumulator> accumulators) {
      if(!this.accumulators.containsKey(key)) {
         this.accumulators.put(key, new ArrayList<Accumulator>());
      }
      this.accumulators.get(key).addAll(accumulators);
      return this;
   }

   private void createAndShowGUI(final boolean showIndividualTraces, final String... metrics) {
      final JFrame frame = new JFrame(StringUtils.capitalize("Metrics Viewer"));
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      final JTabbedPane tabbedPane = new JTabbedPane();
      for(final String metric : metrics) {
         // if(metric == AccumulatorUtil.Keys.INDICATOR_HYPERVOLUME)
         // tabbedPane.addTab(WordUtils.capitalize(metric), generateBoxplotChart(metric, showIndividualTraces));
         // else
         tabbedPane.addTab(WordUtils.capitalize(metric), generateXYLineChart(metric, showIndividualTraces));
      }

      frame.add(tabbedPane, BorderLayout.CENTER);
      frame.pack();
      frame.setVisible(true);
      frame.toFront();
   }

   public JPanel generateBoxplotChart(final String metric, final boolean showIndividualTraces) {
      final JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());

      final DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
      for(final String key : accumulators.keySet()) {
         final List<Double> values = new ArrayList<>();
         for(final Accumulator accumulator : getAccumulators(key)) {
            if(accumulator.keySet().contains(metric)) {
               for(int i = 0; i < accumulator.size(metric); i++) {
                  if(accumulator.size(AccumulatorUtil.Keys.NUMBER_OF_EVALUATIONS) > i) {
                     values.add(((Number) accumulator.get(metric, i)).doubleValue());
                  }
               }
            }
         }
         dataset.add(values, key, metric);
      }

      final CategoryAxis xAxis = new CategoryAxis("Type");
      final NumberAxis yAxis = new NumberAxis("Value");
      final BoxAndWhiskerRenderer renderer = new BoxAndWhiskerRenderer();
      // renderer.setFillBox(false);
      renderer.setBaseToolTipGenerator(new BoxAndWhiskerToolTipGenerator());
      renderer.setMeanVisible(true);
      renderer.setMedianVisible(true);

      final CategoryPlot plot = new CategoryPlot(dataset, xAxis, yAxis, renderer);
      plot.setBackgroundPaint(Color.WHITE);
      plot.setDomainGridlinePaint(Color.GRAY);
      plot.setRangeMinorGridlinePaint(Color.WHITE);
      plot.setRangeGridlinePaint(Color.GRAY);

      final JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(metric, "Number of Evaluations", metric, dataset,
            false);
      chart.setBackgroundPaint(Color.WHITE);
      panel.setBackground(Color.WHITE);

      // create the legend
      final LegendItemCollection items = plot.getLegendItems();
      final Iterator<?> iterator = items.iterator();
      final Set<Comparable<?>> uniqueKeys = new HashSet<>();

      while(iterator.hasNext()) {
         final LegendItem item = (LegendItem) iterator.next();

         if(uniqueKeys.contains(item.getSeriesKey())) {
            iterator.remove();
         } else {
            uniqueKeys.add(item.getSeriesKey());
         }
      }

      final LegendItemSource source = () -> items;

      final LegendTitle legend = new LegendTitle(source);
      legend.setMargin(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
      legend.setFrame(new LineBorder());
      legend.setBackgroundPaint(Color.WHITE);
      legend.setPosition(RectangleEdge.BOTTOM);
      chart.addLegend(legend);

      // scale the axes
      final NumberAxis domainAxis = new NumberAxis();
      domainAxis.setNumberFormatOverride(NumberFormat.getNumberInstance(Locale.US));
      domainAxis.setAxisLinePaint(Color.LIGHT_GRAY);
      domainAxis.setAutoRange(true);

      plot.getRangeAxis().setLabelFont(domainAxis.getLabelFont());
      plot.getRangeAxis().setTickLabelFont(domainAxis.getTickLabelFont());
      final ValueAxis rangeAxis = plot.getRangeAxis();
      if(rangeAxis instanceof NumberAxis) {
         final NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
         format.setMinimumFractionDigits(1);
         ((NumberAxis) rangeAxis).setNumberFormatOverride(format);
      }

      panel.removeAll();
      panel.add(new ChartPanel(chart), BorderLayout.CENTER);
      panel.revalidate();
      panel.repaint();

      return panel;
   }

   /**
    * Generate the individual series for the specified key.
    *
    * @param key
    *           the key identifying which result to plot
    * @param dataset
    *           the dataset to store the generated series
    */
   protected void generateIndividualSeries(final String key, final DefaultTableXYDataset dataset, final String metric) {
      for(final Accumulator accumulator : getAccumulators(key)) {
         if(!accumulator.keySet().contains(metric)) {
            continue;
         }

         final XYSeries series = new XYSeries(key, false, false);

         for(int i = 0; i < accumulator.size(metric); i++) {
            if(accumulator.size(AccumulatorUtil.Keys.NUMBER_OF_EVALUATIONS) > i) {
               series.add((Number) accumulator.get(AccumulatorUtil.Keys.NUMBER_OF_EVALUATIONS, i),
                     (Number) accumulator.get(metric, i));
            }
         }

         dataset.addSeries(series);
      }
   }

   /**
    * Generates the quantile series for the specified key.
    *
    * @param key
    *           the key identifying which result to plot
    * @param dataset
    *           the dataset to store the generated series
    */
   protected void generateQuantileSeries(final String key, final YIntervalSeriesCollection dataset,
         final String metric) {
      final List<DataPoint> dataPoints = new ArrayList<>();

      for(final Accumulator accumulator : getAccumulators(key)) {
         if(!accumulator.keySet().contains(metric)) {
            continue;
         }

         for(int i = 0; i < accumulator.size(metric); i++) {
            if(accumulator.size(AccumulatorUtil.Keys.NUMBER_OF_EVALUATIONS) > i) {
               dataPoints.add(new DataPoint((Integer) accumulator.get(AccumulatorUtil.Keys.NUMBER_OF_EVALUATIONS, i),
                     ((Number) accumulator.get(metric, i)).doubleValue()));
            }
         }
      }

      Collections.sort(dataPoints);

      final YIntervalSeries series = new YIntervalSeries(key);
      final DescriptiveStatistics statistics = new DescriptiveStatistics();
      int index = 0;
      int currentNFE = RESOLUTION;

      while(index < dataPoints.size()) {
         final DataPoint point = dataPoints.get(index);

         if(point.getNFE() <= currentNFE) {
            statistics.addValue(point.getValue());
            index++;
         } else {
            if(statistics.getN() > 0) {
               series.add(currentNFE, statistics.getPercentile(PERCENTILE_HALF),
                     statistics.getPercentile(PERCENTILE_QUARTER), statistics.getPercentile(PERCENTILE_THREE_QUARTER));
            }

            statistics.clear();
            currentNFE += RESOLUTION;
         }
      }

      if(statistics.getN() > 0) {
         // if only entry, add extra point to display non-zero width
         if(series.isEmpty()) {
            series.add(currentNFE - RESOLUTION, statistics.getPercentile(PERCENTILE_HALF),
                  statistics.getPercentile(PERCENTILE_QUARTER), statistics.getPercentile(PERCENTILE_THREE_QUARTER));
         }

         series.add(currentNFE, statistics.getPercentile(PERCENTILE_HALF), statistics.getPercentile(PERCENTILE_QUARTER),
               statistics.getPercentile(PERCENTILE_THREE_QUARTER));
      }

      dataset.addSeries(series);
   }

   public JPanel generateXYLineChart(final String metric, final boolean showIndividualTraces) {
      final JPanel panel = new JPanel();
      panel.setLayout(new BorderLayout());

      XYDataset dataset = null;

      // generate the plot data
      if(showIndividualTraces) {
         dataset = new DefaultTableXYDataset();

         for(final String key : accumulators.keySet()) {
            generateIndividualSeries(key, (DefaultTableXYDataset) dataset, metric);
         }
      } else {
         dataset = new YIntervalSeriesCollection();

         for(final String key : accumulators.keySet()) {
            generateQuantileSeries(key, (YIntervalSeriesCollection) dataset, metric);
         }
      }

      // create the chart
      final JFreeChart chart = ChartFactory.createXYLineChart(metric, "Number of Evaluations", metric, dataset,
            PlotOrientation.VERTICAL, false, true, false);
      chart.setBackgroundPaint(Color.WHITE);
      panel.setBackground(Color.WHITE);

      final XYPlot plot = chart.getXYPlot();
      plot.setBackgroundPaint(Color.WHITE);
      plot.setDomainMinorGridlinePaint(Color.WHITE);
      plot.setDomainGridlinePaint(Color.GRAY);
      plot.setRangeMinorGridlinePaint(Color.WHITE);
      plot.setRangeGridlinePaint(Color.GRAY);

      // setup the series renderer
      if(showIndividualTraces) {

         final XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer(true, false);

         for(int i = 0; i < dataset.getSeriesCount(); i++) {
            final Paint paint = getPaintHelper().get(dataset.getSeriesKey(i));

            renderer.setSeriesStroke(i, new BasicStroke(1f, 1, 1));
            renderer.setSeriesPaint(i, paint);
         }

         plot.setRenderer(renderer);

      } else {
         final DeviationRenderer renderer = new DeviationRenderer(true, false);

         for(int i = 0; i < dataset.getSeriesCount(); i++) {
            final Paint paint = getPaintHelper().get(dataset.getSeriesKey(i));

            renderer.setSeriesStroke(i, new BasicStroke(3f, 1, 1));
            renderer.setSeriesPaint(i, paint);
            renderer.setSeriesFillPaint(i, paint);
         }

         plot.setRenderer(renderer);
      }

      // create the legend
      final LegendItemCollection items = plot.getLegendItems();
      final Iterator<?> iterator = items.iterator();
      final Set<Comparable<?>> uniqueKeys = new HashSet<>();

      while(iterator.hasNext()) {
         final LegendItem item = (LegendItem) iterator.next();

         if(uniqueKeys.contains(item.getSeriesKey())) {
            iterator.remove();
         } else {
            uniqueKeys.add(item.getSeriesKey());
         }
      }

      final LegendItemSource source = () -> items;

      final LegendTitle legend = new LegendTitle(source);
      legend.setMargin(new RectangleInsets(1.0, 1.0, 1.0, 1.0));
      legend.setFrame(new LineBorder());
      legend.setBackgroundPaint(Color.WHITE);
      legend.setPosition(RectangleEdge.BOTTOM);
      chart.addLegend(legend);

      // scale the axes
      final NumberAxis domainAxis = new NumberAxis();
      domainAxis.setNumberFormatOverride(NumberFormat.getNumberInstance(Locale.US));
      domainAxis.setAxisLinePaint(Color.LIGHT_GRAY);
      domainAxis.setAutoRange(true);

      plot.getRangeAxis().setLabelFont(domainAxis.getLabelFont());
      plot.getRangeAxis().setTickLabelFont(domainAxis.getTickLabelFont());
      final ValueAxis rangeAxis = plot.getRangeAxis();
      if(rangeAxis instanceof NumberAxis) {
         final NumberFormat format = NumberFormat.getNumberInstance(Locale.US);
         format.setMinimumFractionDigits(1);
         ((NumberAxis) rangeAxis).setNumberFormatOverride(format);
      }
      plot.setDomainAxis(domainAxis);

      // add overlay for last trace
      // if (controller.getShowLastTrace() &&
      // !controller.getShowIndividualTraces() &&
      // (controller.getLastAccumulator() != null) &&
      // controller.getLastAccumulator().keySet().contains(metric)) {
      // DefaultTableXYDataset dataset2 = new DefaultTableXYDataset();
      // XYSeries series = new XYSeries(
      // localization.getString("text.last"),
      // false, false);
      //
      // for (int i=0; i<controller.getLastAccumulator().size(metric); i++) {
      // series.add(
      // (Number)controller.getLastAccumulator().get("NFE", i),
      // (Number)controller.getLastAccumulator().get(metric, i));
      // }
      //
      // dataset2.addSeries(series);
      //
      // XYLineAndShapeRenderer renderer2 = new XYLineAndShapeRenderer(true,
      // false);
      // renderer2.setSeriesStroke(0, new BasicStroke(1f, 1, 1));
      // renderer2.setSeriesPaint(0, Color.BLACK);
      //
      // plot.setDataset(1, dataset2);
      // plot.setRenderer(1, renderer2);
      // plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
      // }

      // update the chart in the GUI
      panel.removeAll();
      panel.add(new ChartPanel(chart), BorderLayout.CENTER);
      panel.revalidate();
      panel.repaint();

      return panel;
   }

   public Map<String, List<Accumulator>> getAccumulators() {
      return accumulators;
   }

   public List<Accumulator> getAccumulators(final String key) {
      return accumulators.get(key);
   }

   public PaintHelper getPaintHelper() {
      return paintHelper;
   }

   public void show(final boolean showIndividualTraces, final String... metrics) {
      javax.swing.SwingUtilities.invokeLater(() -> createAndShowGUI(showIndividualTraces, metrics));
   }
}
