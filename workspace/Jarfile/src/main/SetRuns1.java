package main;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import javax.management.openmbean.OpenDataException;

public class SetRuns1 {

	
	public static void main(String[] args) throws IOException {
		int TARGET_RUNS = 1;
		SetRuns.setRuns(TARGET_RUNS);

	}
	
}
