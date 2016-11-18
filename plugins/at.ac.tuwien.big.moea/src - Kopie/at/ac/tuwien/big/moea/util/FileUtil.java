package at.ac.tuwien.big.moea.util;

import java.io.File;
import java.io.IOException;

public class FileUtil {
	public static File checkDirectory(String directory) {
		return checkDirectory(new File(directory));
	}
	
	public static File checkDirectory(File directory) {
		if(directory != null) {
			if(!directory.exists()) {
				System.out.println("Directory '" + directory + "' does not exist, it will be created.");
				if(!directory.mkdirs())
					throw new IllegalArgumentException("Could not create directory '" + directory + "'.");
			}
			if(!directory.isDirectory())
				throw new IllegalArgumentException("File '" + directory + "' is not a directory.");
		}
		return directory;
	}
	
	public static File createFile(String directory, String fileName) {
		return createFile(new File(directory), new File(fileName));
	}
	
	public static File createFile(File directory, File file) {
		File newFile = file;
		if(directory != null && !newFile.getAbsolutePath().startsWith(directory.getAbsolutePath()))
			newFile = new File(directory.getPath() + File.separator + file.getPath());
		newFile.getParentFile().mkdirs();
		try {
			newFile.createNewFile();				
		} catch (IOException e) {
			System.err.println("Could not create file '" + newFile + "'.");
		}
		return newFile;
	}
}
