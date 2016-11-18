package at.ac.tuwien.big.moea.experiment.analyzer.chart;

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

import com.google.common.primitives.Doubles;

import at.ac.tuwien.big.moea.experiment.analyzer.SearchAlgorithmResult;
import at.ac.tuwien.big.moea.experiment.analyzer.SearchAnalyzerResults;
import at.ac.tuwien.big.moea.experiment.analyzer.SearchIndicatorResult;
import at.ac.tuwien.big.moea.util.CastUtil;

public class SearchBoxPlot {
	
	protected static Key WIDTH_HINT = new RenderingHints.Key(03172) {
		@Override
		public boolean isCompatibleValue(Object val) {
			return CastUtil.asClass(val, Integer.class) != null;
		}
	};
	protected static Key HEIGHT_HINT = new RenderingHints.Key(03173) {
		@Override
		public boolean isCompatibleValue(Object val) {
			return CastUtil.asClass(val, Integer.class) != null;
		}
	};
	
	protected static void configurePlot(CategoryPlot plot) {
        plot.setRenderer(new SearchBoxPlotRenderer());
        plot.setBackgroundPaint(Color.WHITE);
        plot.setOutlineStroke(new BasicStroke(0f));
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.LIGHT_GRAY);
        plot.setRangeGridlineStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 1f, new float[] { 5f, 2f }, 0f));
        
        configureNumberAxis((NumberAxis) plot.getRangeAxis());
        configureCategoryAxis((CategoryAxis) plot.getDomainAxis());
	}
	
	protected static void configureNumberAxis(NumberAxis axis) {
		axis.setStandardTickUnits(NumberAxis.createStandardTickUnits(Locale.ENGLISH));	
	}
	
	protected static void configureCategoryAxis(CategoryAxis axis) {
		axis.setCategoryMargin(0.22);
	}
	
	protected static DefaultBoxAndWhiskerCategoryDataset createDataSet(String indicator, SearchAnalyzerResults results) {
		final DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
		
		for(SearchAlgorithmResult algorithmResult : results.getAlgorithmResults()) {
			SearchIndicatorResult indicatorResult = algorithmResult.get(indicator);
			if(indicatorResult != null) {
				dataset.add(
					Doubles.asList(indicatorResult.getValues()),
					indicatorResult.getIndicator(), 
					algorithmResult.getAlgorithm());
			}
		}
		return dataset;
	}
	
	protected static DefaultBoxAndWhiskerCategoryDataset createDataSet() {
		final int seriesCount = 1;
        final int categoryCount = 5;
        final int entityCount = 22;
        
        final DefaultBoxAndWhiskerCategoryDataset dataset = new DefaultBoxAndWhiskerCategoryDataset();
		for (int i = 0; i < seriesCount; i++) {
			for (int j = 0; j < categoryCount; j++) {
				final List<Double> list = new ArrayList<>();
                for (int k = 0; k < entityCount; k++) {
                    final double value1 = 10.0 + Math.random() * 3;
                    list.add(new Double(value1));
                    final double value2 = 11.25 + Math.random(); // concentrate values in the middle
                    list.add(new Double(value2));
                }
                dataset.add(list, "Series " + i, " Type " + j);
			}
		}
		return dataset;
	}
	
	public static JFreeChart createIndicatorChart(String indicator, SearchAnalyzerResults results) {
		DefaultBoxAndWhiskerCategoryDataset dataSet = createDataSet(indicator, results);
		
		final JFreeChart chart = ChartFactory.createBoxAndWhiskerChart(
				indicator, "", "", dataSet, false);
		
		CategoryPlot plot = (CategoryPlot)chart.getPlot();		
		configurePlot(plot);  
		
		chart.setAntiAlias(true);
		chart.setBorderVisible(false);
		chart.setTextAntiAlias(true);	

		int width = dataSet.getColumnCount() * 200;
		int height = new Double(width * .75).intValue();
		Font font3 = new Font("Dialog", Font.PLAIN, new Double(height / 30).intValue()); 
		plot.getDomainAxis().setTickLabelFont(font3);
		plot.getRangeAxis().setTickLabelFont(font3);
		
		chart.getRenderingHints().put(WIDTH_HINT, width);
		chart.getRenderingHints().put(HEIGHT_HINT, height);
		
		return chart;
	}
	
	public static void saveIndicatorChart(String indicator, SearchAnalyzerResults results, File file) {
		JFreeChart chart = createIndicatorChart(indicator, results);
		saveChart(chart, file);
	}
	
	public static void saveIndicatorChart(String indicator, SearchAnalyzerResults results, String file) {
		saveIndicatorChart(indicator, results, new File(file));
	}
	
	public static void saveChart(JFreeChart chart, File file) {
		if(chart == null)
			return;
		
		Integer storedWidth = (Integer) chart.getRenderingHints().get(WIDTH_HINT);
		Integer storedHeight = (Integer) chart.getRenderingHints().get(HEIGHT_HINT);
		if(storedWidth != null && storedHeight != null)
			saveChart(chart, file, storedWidth, storedHeight);
		else
			saveChart(chart, file, 700, 500);
	}
	
	public static void saveChart(JFreeChart chart, File file, int width, int height) {
		try {
			ChartUtilities.saveChartAsPNG(file, chart, width, height);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
