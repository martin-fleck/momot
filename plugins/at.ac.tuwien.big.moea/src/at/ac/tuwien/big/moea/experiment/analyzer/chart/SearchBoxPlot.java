package at.ac.tuwien.big.moea.experiment.analyzer.chart;

import at.ac.tuwien.big.moea.experiment.analyzer.SearchAlgorithmResult;
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzerResults;
import at.ac.tuwien.big.moea.experiment.analyzer.SearchIndicatorResult;
import at.ac.tuwien.big.moea.util.CastUtil;

import com.google.common.primitives.Doubles;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.RenderingHints;
import java.awt.RenderingHints.Key;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.statistics.DefaultBoxAndWhiskerCategoryDataset;

public final class SearchBoxPlot {

   private static final double FONT_RATIO = 30;

   private static final double HEIGHT_RATIO = .75;
   private static final double MARGIN = 0.22;
   private static final int DEFAULT_HEIGHT = 500;
   private static final int DEFAULT_WIDTH = 700;

   private static final float[] DASH = new float[] { 5f, 2f };

   protected static final Key WIDTH_HINT = new RenderingHints.Key(03172) {
      @Override
      public boolean isCompatibleValue(final Object val) {
         return CastUtil.asClass(val, Integer.class) != null;
      }
   };

   protected static final Key HEIGHT_HINT = new RenderingHints.Key(03173) {
      @Override
      public boolean isCompatibleValue(final Object val) {
         return CastUtil.asClass(val, Integer.class) != null;
      }
   };

   protected static void configureCategoryAxis(final CategoryAxis axis) {
      axis.setCategoryMargin(MARGIN);
   }

   protected static void configureNumberAxis(final NumberAxis axis) {
      axis.setStandardTickUnits(NumberAxis.createStandardTickUnits(Locale.ENGLISH));
   }

   protected static void configurePlot(final CategoryPlot plot) {
      plot.setRenderer(new SearchBoxPlotRenderer());
      plot.setBackgroundPaint(Color.WHITE);
      plot.setOutlineStroke(new BasicStroke(0f));
      plot.setRangeGridlinesVisible(true);
      plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
      plot.setRangeGridlineStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, DASH, 0f));

      configureNumberAxis((NumberAxis) plot.getRangeAxis());
      configureCategoryAxis(plot.getDomainAxis());
   }

   protected static DefaultBoxAndWhiskerCategoryDataset createDataSet() {
      final int seriesCount = 1;
      final int categoryCount = 5;
      final int entityCount = 22;

      final DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
      for(int i = 0; i < seriesCount; i++) {
         for(int j = 0; j < categoryCount; j++) {
            final List<Double> list = new ArrayList<>();
            for(int k = 0; k < entityCount; k++) {
               final double value1 = 10.0 + Math.random() * 3;
               list.add(new Double(value1));
               // concentrate values in the middle
               final double value2 = 11.25 + Math.random();
               list.add(new Double(value2));
            }
            dataset.add(list, "Series " + i, " Type " + j);
         }
      }
      return dataset;
   }

   protected static DefaultBoxAndWhiskerCategoryDataset createDataSet(final String indicator,
         final SearchAnalyzerResults results) {
      final DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();

      for(final SearchAlgorithmResult algorithmResult : results.getAlgorithmResults()) {
         final SearchIndicatorResult indicatorResult = algorithmResult.get(indicator);
         if(indicatorResult != null) {
            dataset.add(Doubles.asList(indicatorResult.getValues()), indicatorResult.getIndicator(),
                  algorithmResult.getAlgorithm());
         }
      }
      return dataset;
   }

   public static JFreeChart createIndicatorChart(final String indicator, final SearchAnalyzerResults results) {
      final DefaultBoxAndWhiskerCategoryDataset dataSet = createDataSet(indicator, results);

      final JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(indicator, "", "", dataSet, false);

      final CategoryPlot plot = (CategoryPlot) chart.getPlot();
      configurePlot(plot);

      chart.setAntiAlias(true);
      chart.setBorderVisible(false);
      chart.setTextAntiAlias(true);

      final int width = dataSet.getColumnCount() * 200;
      final int height = new Double(width * HEIGHT_RATIO).intValue();
      final Font font = new Font("Dialog", Font.PLAIN, new Double(height / FONT_RATIO).intValue());
      plot.getDomainAxis().setTickLabelFont(font);
      plot.getRangeAxis().setTickLabelFont(font);

      chart.getRenderingHints().put(WIDTH_HINT, width);
      chart.getRenderingHints().put(HEIGHT_HINT, height);

      return chart;
   }

   public static void saveChart(final JFreeChart chart, final File file) {
      if(chart == null) {
         return;
      }

      final Integer storedWidth = (Integer) chart.getRenderingHints().get(WIDTH_HINT);
      final Integer storedHeight = (Integer) chart.getRenderingHints().get(HEIGHT_HINT);
      if(storedWidth != null && storedHeight != null) {
         saveChart(chart, file, storedWidth, storedHeight);
      } else {
         saveChart(chart, file, DEFAULT_WIDTH, DEFAULT_HEIGHT);
      }
   }

   public static void saveChart(final JFreeChart chart, final File file, final int width, final int height) {
      try {
         ChartUtilities.saveChartAsPNG(file, chart, width, height);
      } catch(final IOException e) {
         e.printStackTrace();
      }
   }

   public static void saveIndicatorChart(final String indicator, final SearchAnalyzerResults results, final File file) {
      final JFreeChart chart = createIndicatorChart(indicator, results);
      saveChart(chart, file);
   }

   public static void saveIndicatorChart(final String indicator, final SearchAnalyzerResults results,
         final String file) {
      saveIndicatorChart(indicator, results, new File(file));
   }

   private SearchBoxPlot() {
      // empty constructor for utility class
   }
}
