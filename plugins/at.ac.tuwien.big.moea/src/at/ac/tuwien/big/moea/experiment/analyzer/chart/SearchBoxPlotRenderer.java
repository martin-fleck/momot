package at.ac.tuwien.big.moea.experiment.analyzer.chart;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.Outlier;
import org.jfree.chart.renderer.OutlierList;
import org.jfree.chart.renderer.OutlierListCollection;
import org.jfree.chart.renderer.category.BoxAndWhiskerRenderer;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.statistics.BoxAndWhiskerCategoryDataset;
import org.jfree.ui.RectangleEdge;

public class SearchBoxPlotRenderer extends BoxAndWhiskerRenderer {

   private static final double BAR_WIDTH_RATIO = 9;

   private static final double WHISKER_WIDTH_RATIO = 0.5;

   private static final long serialVersionUID = -4760842081735463981L;

   protected Paint lowerBoxPaint = new Color(222, 222, 222);
   protected Paint upperBoxPaint = new Color(160, 160, 160);
   protected boolean paintOutliers = false;

   public SearchBoxPlotRenderer() {
      setFillBox(true);
      setWhiskerWidth(WHISKER_WIDTH_RATIO);
      setUseOutlinePaintForWhiskers(true);
      setSeriesOutlinePaint(0, Color.BLACK);
      setSeriesOutlinePaint(1, Color.BLACK);
      setUseOutlinePaintForWhiskers(true);
      setMedianVisible(true);
      setMeanVisible(true);
   }

   protected void drawEllipse(final Point2D point, final double oRadius, final Graphics2D g2) {
      final Paint temp = g2.getPaint();
      g2.setColor(Color.black);
      final Ellipse2D dot = new Ellipse2D.Double(point.getX() + oRadius / 2, point.getY(), oRadius, oRadius);
      g2.draw(dot);
      g2.setPaint(temp);
   }

   protected void drawHighFarOut(final double aRadius, final Graphics2D g2, final double xx, final double m) {
      final Paint temp = g2.getPaint();
      g2.setColor(Color.black);
      final double side = aRadius * 2;
      g2.draw(new Line2D.Double(xx - side, m + side, xx + side, m + side));
      g2.draw(new Line2D.Double(xx - side, m + side, xx, m));
      g2.draw(new Line2D.Double(xx + side, m + side, xx, m));
      g2.setPaint(temp);
   }

   protected void drawLowFarOut(final double aRadius, final Graphics2D g2, final double xx, final double m) {
      final double side = aRadius * 2;
      g2.draw(new Line2D.Double(xx - side, m - side, xx + side, m - side));
      g2.draw(new Line2D.Double(xx - side, m - side, xx, m));
      g2.draw(new Line2D.Double(xx + side, m - side, xx, m));
   }

   protected void drawMultipleEllipse(final Point2D point, final double boxWidth, final double oRadius,
         final Graphics2D g2) {
      final Ellipse2D dot1 = new Ellipse2D.Double(point.getX() - boxWidth / 2 + oRadius, point.getY(), oRadius,
            oRadius);
      final Ellipse2D dot2 = new Ellipse2D.Double(point.getX() + boxWidth / 2, point.getY(), oRadius, oRadius);
      g2.draw(dot1);
      g2.draw(dot2);
   }

   @SuppressWarnings({ "rawtypes", "unchecked" })
   @Override
   public void drawVerticalItem(final Graphics2D g2, final CategoryItemRendererState state, final Rectangle2D dataArea,
         final CategoryPlot plot, final CategoryAxis domainAxis, final ValueAxis rangeAxis,
         final CategoryDataset dataset, final int row, final int column) {

      final BoxAndWhiskerCategoryDataset bawDataset = (BoxAndWhiskerCategoryDataset) dataset;

      final double categoryEnd = domainAxis.getCategoryEnd(column, getColumnCount(), dataArea,
            plot.getDomainAxisEdge());
      final double categoryStart = domainAxis.getCategoryStart(column, getColumnCount(), dataArea,
            plot.getDomainAxisEdge());
      final double categoryWidth = categoryEnd - categoryStart;

      double xx = categoryStart;
      final int seriesCount = getRowCount();
      final int categoryCount = getColumnCount();

      if(seriesCount > 1) {
         final double seriesGap = dataArea.getWidth() * getItemMargin() / (categoryCount * (seriesCount - 1));
         final double usedWidth = state.getBarWidth() * seriesCount + seriesGap * (seriesCount - 1);
         // offset the start of the boxes if the total width used is smaller
         // than the category width
         final double offset = (categoryWidth - usedWidth) / 2;
         xx = xx + offset + row * (state.getBarWidth() + seriesGap);
      } else {
         // offset the start of the box if the box width is smaller than the
         // category width
         final double offset = (categoryWidth - state.getBarWidth()) / 2;
         xx = xx + offset;
      }

      double yyAverage;
      double yyOutlier;

      final Paint itemPaint = getItemPaint(row, column);
      g2.setPaint(itemPaint);
      final Stroke s = getItemStroke(row, column);
      g2.setStroke(s);

      double aRadius = 0; // average radius

      final RectangleEdge location = plot.getRangeAxisEdge();

      // get values
      final Number yQ1 = bawDataset.getQ1Value(row, column);
      final Number yQ3 = bawDataset.getQ3Value(row, column);
      final Number yMax = bawDataset.getMaxRegularValue(row, column);
      final Number yMin = bawDataset.getMinRegularValue(row, column);
      final Number yMean = bawDataset.getMeanValue(row, column);
      final Number yMedian = bawDataset.getMedianValue(row, column);

      Shape box = null;
      if(yQ1 != null && yQ3 != null && yMax != null && yMin != null) {
         final double yyQ1 = rangeAxis.valueToJava2D(yQ1.doubleValue(), dataArea, location);
         final double yyQ3 = rangeAxis.valueToJava2D(yQ3.doubleValue(), dataArea, location);
         final double yyMax = rangeAxis.valueToJava2D(yMax.doubleValue(), dataArea, location);
         final double yyMin = rangeAxis.valueToJava2D(yMin.doubleValue(), dataArea, location);
         final double xxmid = xx + state.getBarWidth() / 2.0;
         final double halfW = state.getBarWidth() / 2.0 * getWhiskerWidth();

         if(!isMedianVisible()) {
            // draw the body...
            box = new Rectangle2D.Double(xx, Math.min(yyQ1, yyQ3), state.getBarWidth(), Math.abs(yyQ1 - yyQ3));
            if(getFillBox()) {
               g2.fill(box);
            }
         } else {
            final double yyMedian = rangeAxis.valueToJava2D(yMedian.doubleValue(), dataArea, location);
            final Paint tempPaint = g2.getPaint();
            // draw the upper body...
            box = new Rectangle2D.Double(xx, Math.min(yyQ1, yyMedian), state.getBarWidth(), Math.abs(yyQ1 - yyMedian));
            if(getFillBox()) {
               g2.setPaint(getUpperBoxPaint());
               g2.fill(box);
            }
            // draw the lower body...
            box = new Rectangle2D.Double(xx, Math.min(yyMedian, yyQ3), state.getBarWidth(), Math.abs(yyMedian - yyQ3));
            if(getFillBox()) {
               g2.setPaint(getLowerBoxPaint());
               g2.fill(box);
            }
            g2.setPaint(tempPaint);
            box = new Rectangle2D.Double(xx, Math.min(yyQ1, yyQ3), state.getBarWidth(), Math.abs(yyQ1 - yyQ3));
         }

         final Paint outlinePaint = getItemOutlinePaint(row, column);
         if(getUseOutlinePaintForWhiskers()) {
            g2.setPaint(outlinePaint);
         }

         // draw the upper shadow...
         g2.draw(new Line2D.Double(xxmid, yyMax, xxmid, yyQ3));
         g2.draw(new Line2D.Double(xxmid - halfW, yyMax, xxmid + halfW, yyMax));

         // draw the lower shadow...
         g2.draw(new Line2D.Double(xxmid, yyMin, xxmid, yyQ1));
         g2.draw(new Line2D.Double(xxmid - halfW, yyMin, xxmid + halfW, yyMin));

         g2.setStroke(getItemOutlineStroke(row, column));
         g2.setPaint(outlinePaint);
         g2.draw(box);
      }

      g2.setPaint(getArtifactPaint());

      // draw mean...
      if(isMeanVisible()) {
         if(yMean != null) {
            yyAverage = rangeAxis.valueToJava2D(yMean.doubleValue(), dataArea, location);
            aRadius = state.getBarWidth() / BAR_WIDTH_RATIO;

            final double side = aRadius;
            if(yyAverage > dataArea.getMinY() - aRadius && yyAverage < dataArea.getMaxY() + aRadius) {
               g2.draw(new Line2D.Double(xx + state.getBarWidth() / 2 + side, yyAverage - side,
                     xx + state.getBarWidth() / 2 - side, yyAverage + side));
               g2.draw(new Line2D.Double(xx + state.getBarWidth() / 2 + side, yyAverage + side,
                     xx + state.getBarWidth() / 2 - side, yyAverage - side));
            }
         }
      }

      // draw median...
      if(isMedianVisible()) {
         if(yMedian != null) {
            final double yyMedian = rangeAxis.valueToJava2D(yMedian.doubleValue(), dataArea, location);
            g2.draw(new Line2D.Double(xx, yyMedian, xx + state.getBarWidth(), yyMedian));
         }
      }

      if(isPaintOutliers()) {
         // draw yOutliers...
         final double maxAxisValue = rangeAxis.valueToJava2D(rangeAxis.getUpperBound(), dataArea, location) + aRadius;
         final double minAxisValue = rangeAxis.valueToJava2D(rangeAxis.getLowerBound(), dataArea, location) - aRadius;

         g2.setPaint(itemPaint);

         // draw outliers
         final double oRadius = state.getBarWidth() / 3; // outlier radius
         final List<Outlier> outliers = new ArrayList<>();
         final OutlierListCollection outlierListCollection = new OutlierListCollection();

         // From outlier array sort out which are outliers and put these into a
         // list If there are any farouts, set the flag on the
         // OutlierListCollection
         final List yOutliers = bawDataset.getOutliers(row, column);
         if(yOutliers != null) {
            for(int i = 0; i < yOutliers.size(); i++) {
               final double outlier = ((Number) yOutliers.get(i)).doubleValue();
               final Number minOutlier = bawDataset.getMinOutlier(row, column);
               final Number maxOutlier = bawDataset.getMaxOutlier(row, column);
               final Number minRegular = bawDataset.getMinRegularValue(row, column);
               final Number maxRegular = bawDataset.getMaxRegularValue(row, column);
               if(outlier > maxOutlier.doubleValue()) {
                  outlierListCollection.setHighFarOut(true);
               } else if(outlier < minOutlier.doubleValue()) {
                  outlierListCollection.setLowFarOut(true);
               } else if(outlier > maxRegular.doubleValue()) {
                  yyOutlier = rangeAxis.valueToJava2D(outlier, dataArea, location);
                  outliers.add(new Outlier(xx + state.getBarWidth() / 2.0, yyOutlier, oRadius));
               } else if(outlier < minRegular.doubleValue()) {
                  yyOutlier = rangeAxis.valueToJava2D(outlier, dataArea, location);
                  outliers.add(new Outlier(xx + state.getBarWidth() / 2.0, yyOutlier, oRadius));
               }
               Collections.sort(outliers);
            }

            // Process outliers. Each outlier is either added to the
            // appropriate outlier list or a new outlier list is made
            for(final Outlier outlier : outliers) {
               outlierListCollection.add(outlier);
            }

            for(final Iterator iterator = outlierListCollection.iterator(); iterator.hasNext();) {
               final OutlierList list = (OutlierList) iterator.next();
               final Outlier outlier = list.getAveragedOutlier();
               final Point2D point = outlier.getPoint();

               if(list.isMultiple()) {
                  drawMultipleEllipse(point, state.getBarWidth(), oRadius, g2);
               } else {
                  drawEllipse(point, oRadius, g2);
               }
            }

            // draw farout indicators
            if(outlierListCollection.isHighFarOut()) {
               drawHighFarOut(aRadius / 2.0, g2, xx + state.getBarWidth() / 2.0, maxAxisValue);
            }

            if(outlierListCollection.isLowFarOut()) {
               drawLowFarOut(aRadius / 2.0, g2, xx + state.getBarWidth() / 2.0, minAxisValue);
            }
         }
      }
      // collect entity and tool tip information...
      if(state.getInfo() != null && box != null) {
         final EntityCollection entities = state.getEntityCollection();
         if(entities != null) {
            addItemEntity(entities, dataset, row, column, box);
         }
      }
   }

   public Paint getLowerBoxPaint() {
      return lowerBoxPaint;
   }

   public Paint getUpperBoxPaint() {
      return upperBoxPaint;
   }

   public boolean isPaintOutliers() {
      return paintOutliers;
   }

   public void setLowerBoxPaint(final Paint lowerBoxPaint) {
      this.lowerBoxPaint = lowerBoxPaint;
   }

   public void setPaintOutliers(final boolean paintOutliers) {
      this.paintOutliers = paintOutliers;
   }

   public void setUpperBoxPaint(final Paint upperBoxPaint) {
      this.upperBoxPaint = upperBoxPaint;
   }
}
