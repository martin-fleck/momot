package at.ac.tuwien.big.moea.util;

import java.io.File;
import java.io.IOException;

public final class FileUtil {

   public static File checkDirectory(final File directory) {
      if(directory != null) {
         if(!directory.exists()) {
            System.out.println("Directory '" + directory + "' does not exist, it will be created.");
            if(!directory.mkdirs()) {
               throw new IllegalArgumentException("Could not create directory '" + directory + "'.");
            }
         }
         if(!directory.isDirectory()) {
            throw new IllegalArgumentException("File '" + directory + "' is not a directory.");
         }
      }
      return directory;
   }

   public static File checkDirectory(final String directory) {
      return checkDirectory(new File(directory));
   }

   public static File createFile(final File directory, final File file) {
      File newFile = file;
      if(directory != null && !newFile.getAbsolutePath().startsWith(directory.getAbsolutePath())) {
         newFile = new File(directory.getPath() + File.separator + file.getPath());
      }
      newFile.getParentFile().mkdirs();
      try {
         newFile.createNewFile();
      } catch(final IOException e) {
         System.err.println("Could not create file '" + newFile + "'.");
      }
      return newFile;
   }

   public static File createFile(final String directory, final String fileName) {
      return createFile(new File(directory), new File(fileName));
   }

   private FileUtil() {}
}
