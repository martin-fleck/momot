package at.ac.tuwien.big.momot.examples.refactoring;

import com.google.common.io.Files;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.TreeMap;

import org.eclipse.emf.ecore.EObject;

public class TargetComparer {

   private static class Spec {
      public String name;
      public File directory;

      public Spec(final String name, final File directory) {
         this.name = name;
         this.directory = directory;
      }

      public Spec(final String name, final String directory) {
         this(name, new File(directory));
      }
   }

   public static void compareTarget(final File outputCSV, final int readColumn, final Spec... specs) {
      final TreeMap<String, double[]> bestSolutions = new TreeMap<>();
      for(final Spec spec : specs) {
         for(final File f : spec.directory.listFiles()) {
            final double[] v = new double[specs.length];
            Arrays.fill(v, Double.NaN);
            bestSolutions.put(f.getName(), v);
         }
      }
      bestSolutions.forEach((k, v) -> {
         for(int i = 0; i < specs.length; ++i) {
            final Spec spec = specs[i];
            final File folder = new File(spec.directory + File.separator + k);

            if(folder.exists()) {
               final EMFCompareDistance ecd = new EMFCompareDistance(TargetStateGenerator
                     .getTargetFileName(new File("allinputs" + File.separator + folder.getName()), 0));
               final File models = new File(folder.getAbsolutePath() + File.separator + "models");
               if(models.exists()) {
                  for(final File f : models.listFiles()) {
                     if(!f.isFile()) {
                        continue;
                     }
                     try {
                        final EObject model = TargetStateGenerator.loadModel(f.getAbsolutePath());
                        final double distance = ecd.calculateDistance(model);
                        System.out.println("Calculated distance for " + f.getName() + ":  " + distance);
                        if(distance == 0.0) {
                           final String[] str = f.getName().split("\\_");
                           if(str.length > readColumn) {
                              try {
                                 final double newVal = Double.valueOf(str[readColumn]);
                                 if(Double.isFinite(v[i])) {
                                    v[i] = Math.min(v[i], newVal);
                                 } else {
                                    v[i] = newVal;
                                 }
                              } catch(final Exception e) {
                                 e.printStackTrace();
                              }
                           }
                        }
                     } catch(final Exception e) {
                        System.err.println("Could not read model " + f.getName() + ": " + e.getMessage());
                     }
                  }
               }
            }
         }
      });
      final StringBuilder ret = new StringBuilder();
      for(final Spec s : specs) {
         ret.append("," + s.name);
      }
      ret.append("\n");
      bestSolutions.forEach((k, v) -> {
         ret.append(k);
         for(final double element : v) {
            if(Double.isNaN(element)) {
               ret.append(",-");
            } else {
               ret.append("," + element);
            }
         }
         ret.append("\n");
      });
      try {
         Files.write(ret.toString().getBytes(), outputCSV);
      } catch(final IOException e) {
         e.printStackTrace();
      }

   }

   public static void main(final String[] args) {
      File generalComp = null;
      File emfComp = null;
      for(final File file : new File(".").listFiles()) {
         if(file.getName().startsWith("alloutputs-")) {
            System.out.println("Last modified: " + file.lastModified());
            if(generalComp == null || file.lastModified() > generalComp.lastModified()) {
               generalComp = file;
            }
         } else if(file.getName().startsWith("alloutputsEMF-")) {
            if(emfComp == null || file.lastModified() > emfComp.lastModified()) {
               emfComp = file;
            }
         }
      }
      compareTarget(new File("cmpResults.csv"), 1, new Spec("distance", generalComp.getName()),
            new Spec("emf", emfComp.getName()));
   }
}
