package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import javax.management.openmbean.OpenDataException;

public class SetRuns {

	public static void setRuns(int TARGET_RUNS) {
		try {
		List<File> folders = new ArrayList<>();
		folders.add(new File("E:\\eclipseCRA\\workspaceCRA\\WorkshopCRA\\src"));
		folders.add(new File("E:\\eclipseCRA\\workspaceCRA\\WorkshopNRP\\src"));
		folders.add(new File("E:\\eclipseCRA\\workspaceCRA\\WorkshopScrum\\src"));
		folders.add(new File("E:\\dev\\momot\\examples\\at.ac.tuwien.big.momot.examples.refactoring\\src\\at\\ac\\tuwien\\big\\momot\\examples\\refactoring"));
		
		
		for (File folder: folders) {
			for (File subFile: folder.listFiles(x->x.getName().endsWith("momot")))  {
				List<String> strings = Files.readAllLines(subFile.toPath());
				strings.replaceAll(x->{
					if (x.trim().startsWith("nrRuns")) {
						return "   nrRuns            = "+TARGET_RUNS+"";
					}
					return x;
				});
				try {
					Files.write(subFile.toPath(), strings, StandardOpenOption.CREATE);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args) throws IOException {
		int TARGET_RUNS = 2;
		setRuns(TARGET_RUNS);

	}
	
}
