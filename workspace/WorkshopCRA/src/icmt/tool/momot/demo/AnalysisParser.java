package icmt.tool.momot.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AnalysisParser {

   public static double getTime(final String prefix, final String algoName) {
      final File file = new File(
            prefix + File.separator + "solutions" + File.separator + algoName + File.separator + "times.csv");
      try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
         final String[] spl = reader.readLine().split("\\,");
         return Double.valueOf(spl[spl.length - 1]) / spl.length;
      } catch(final IOException e) {
         e.printStackTrace();
      }
      return 0.0;
   }

   public static void main(final String[] args) {

      for(final String name : new String[] { "CraA", "CraB", "CraC", "CraD" }) {
         final String file = "output" + name + "/analysis/analysis.txt";
         try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            System.out.println(name + ",H-min,H-med,H-avg,H-max,I-min,I-med,I-avg,I-max,timeavg");
            String s;
            String curAlgo = null;
            double[] hypervolumeData = new double[4];
            double[] igddata = new double[4];
            double curTime = 0;
            final List<String> lines = new ArrayList<>();
            while((s = reader.readLine()) != null) {
               if(s.trim().isEmpty()) {
                  continue;
               }
               if(!Character.isWhitespace(s.charAt(0)) && s.endsWith(":")) {
                  // new algorithm
                  if(curAlgo != null) {
                     final StringBuilder builder = new StringBuilder();
                     builder.append(curAlgo);
                     for(final double[] v : new double[][] { hypervolumeData, igddata }) {
                        for(final double d : v) {
                           builder.append("," + d);
                        }
                     }
                     builder.append("," + curTime);
                     lines.add(builder.toString());
                  }
                  curAlgo = s.substring(0, s.length() - 1);

                  hypervolumeData = new double[4];
                  igddata = new double[4];
                  final String prefix = new File(file).getParentFile().getParent();
                  curTime = getTime(prefix, curAlgo);

               }
               if(s.trim().equals("Hypervolume:")) {
                  while((s = reader.readLine()) != null) {
                     if(s.trim().startsWith("Min:")) {
                        hypervolumeData[0] = Double.valueOf(s.split("\\:")[1]);
                     } else if(s.trim().startsWith("Max:")) {
                        hypervolumeData[3] = Double.valueOf(s.split("\\:")[1]);
                     } else if(s.trim().startsWith("Median:")) {
                        hypervolumeData[1] = Double.valueOf(s.split("\\:")[1]);
                     } else if(s.trim().startsWith("Mean:")) {
                        hypervolumeData[2] = Double.valueOf(s.split("\\:")[1]);
                        break;
                     }
                  }
               }
               if(s.trim().equals("InvertedGenerationalDistance:")) {
                  while((s = reader.readLine()) != null) {
                     if(s.trim().startsWith("Min:")) {
                        igddata[0] = Double.valueOf(s.split("\\:")[1]);
                     } else if(s.trim().startsWith("Max:")) {
                        igddata[3] = Double.valueOf(s.split("\\:")[1]);
                     } else if(s.trim().startsWith("Median:")) {
                        igddata[1] = Double.valueOf(s.split("\\:")[1]);
                     } else if(s.trim().startsWith("Mean:")) {
                        igddata[2] = Double.valueOf(s.split("\\:")[1]);
                        break;
                     }
                  }
               }
            }
            if(curAlgo != null) {
               final StringBuilder builder = new StringBuilder();
               builder.append(curAlgo);
               for(final double[] v : new double[][] { hypervolumeData, igddata }) {
                  for(final double d : v) {
                     builder.append("," + d);
                  }
               }
               builder.append("," + curTime);
               lines.add(builder.toString());
            }

            Collections.sort(lines);
            for(final String line : lines) {
               System.out.println(line);
            }
            System.out.println();
         } catch(final IOException e) {
            e.printStackTrace();
         }
      }
   }

}
