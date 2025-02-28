package com.vader.sentiment.main;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.vader.sentiment.analyzer.SentimentAnalyzer;
import com.vader.sentiment.analyzer.SentimentPolarities;

public class TestMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 ArrayList<String> sentences = new ArrayList<String>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{
		        add("VADER is smart, handsome, and funny.");
		        add("VADER is smart, handsome, and funny!");
		        add("VADER is very smart, handsome, and funny.");
		        add("VADER is VERY SMART, handsome, and FUNNY.");
		        add("VADER is VERY SMART, handsome, and FUNNY!!!");
		        add("VADER is VERY SMART, really handsome, and INCREDIBLY FUNNY!!!");
		        add("The book was good.");
		        add("The book was kind of good.");
		        add("The plot was good, but the characters are uncompelling and the dialog is not great.");
		        add("A really bad, horrible book.");
		        add("At least it isn't a horrible book.");
		        add(":) and :D");
		        add("");
		        add("Today sux");
		        add("Today sux!");
		        add("Today SUX!");
		        add("Today kinda sux! But I'll get by, lol");
		        add("The book was very bad.");
		    }};

		    ArrayList<String> sentencess = new ArrayList<String>() {/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

			{
				 add("This product is a complete disaster. It broke within the first 10 minutes of use, and the customer service is non-existent. Worst purchase I’ve ever made!");
				 add("I regret buying this. The product doesn’t do what it promises, and it’s almost as if they used cheaper materials to trick you. Terrible quality. Zero stars if I could rate it that way.");
				 add("Absolute garbage! This thing barely even works, and when it does, it performs terribly. I feel scammed. If you're thinking about buying this, do yourself a favor and don’t.");
				 add("The worst product I’ve ever encountered. It’s dangerous, broke on the first use, and the company didn’t even offer a refund or replacement. I’m furious.");
				 add("this is one of the best speaker i purchased till now , it works ossome and so melodious");
				}
			};
		    for (String sentence : sentencess) {
		        System.out.println(sentence);
		        final SentimentPolarities sentimentPolarities =
					SentimentAnalyzer.getScoresFor(sentence);
		        System.out.println(sentimentPolarities);
		    }
	}

	public static void createSentiments(String[] files)
	        throws Exception {
	        for (String file : files) {
	            System.out.printf("Analyzing file %s...%n", file);
	            byte[] fileBytes = Files.readAllBytes(Paths.get(file));
	            String text = new String(fileBytes, StandardCharsets.UTF_8);
	            long startTime = System.nanoTime();
	            SentimentPolarities sp = SentimentAnalyzer.getScoresFor(text);
	            long endTime = System.nanoTime();
	            System.out.printf("%s (%,d ms)%n", sp, TimeUnit.NANOSECONDS.toMillis(endTime - startTime));
	        }
	    }
}
