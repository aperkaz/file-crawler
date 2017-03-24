package app;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class App {
		
    static String sourceDir;
    static String outputDir;
    static String fileType;
    static boolean copy;

    public static void main(String args[]){
        System.out.println("\n** File Crawler **");

        if(args.length == 4){
        sourceDir = args[0];
        outputDir = args[1];
        fileType = args[2];
        copy = Boolean.parseBoolean(args[3]);
        }else{
        	System.out.println("\nIncorrect parameters");
        	System.out.println("\njava -jar FileCrawler.jar sourceDir outputDir fileType copy");
        	System.exit(0);
        }
        
        System.out.println("\nSource Dir: "+sourceDir);
        System.out.println("Output Dir: "+outputDir);
        System.out.println("File Type: "+fileType);
        System.out.println("Copy files: "+copy+"\n");
        
        long startTime = System.currentTimeMillis();

        FileCrawler crawler = new FileCrawler(sourceDir, outputDir, fileType);
        crawler.crawlFiles();
        if(copy)
        	crawler.copyFiles();

        System.out.println("[ Crawling finished ]");
        
        long elapsedTime = System.currentTimeMillis() - startTime;
        System.out.println("\nRun time: "+elapsedTime+" ms");
        
    }

}
