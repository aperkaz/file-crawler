package app;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

public class FileCrawler {

	static private ArrayList<File> fileList;
	static private String sourceDir, outputDir, fileType;

	static boolean print = false;
	
    static InputStream inputStream;

	public FileCrawler(String sourceDir, String outputDir, String fileType) {
		FileCrawler.sourceDir = sourceDir;
		FileCrawler.outputDir = outputDir;
		FileCrawler.fileList = new ArrayList<File>();
		FileCrawler.fileType = fileType;
	}

	public void crawlFiles() {
		File files[] = new File(sourceDir).listFiles();
		traverseFolder(files);
	}

	private static void traverseFolder(File[] files) {
		if (files != null) {
			for (File file : files) {
				if (file.isDirectory()) {
					traverseFolder(file.listFiles());
				} else {
					String[] type = file.getName().toString().split("\\.(?=[^\\.]+$)");
					if (type.length > 1) {
						if (type[1].equals(fileType)) {
							fileList.add(file);
						}
					}
				}
			}
		}
	}

	public void copyFiles() {
		for (File file : fileList) {
			try {
				FileUtils.copyFile(file, new File(outputDir + "\\" + file.getName()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	
}
