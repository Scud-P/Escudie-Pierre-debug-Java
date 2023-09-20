package com.hemebiotech.analytics;

/**
 * The Main class is the entry point of the application. It reads symptom data from a file,
 * counts and sorts the symptoms, and writes the results to an output file.
 */

public class Main {

    /**
     * The main method of the application.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {

        String filepath = "symptoms.txt";

        ISymptomReader reader = new ReadSymptomDataFromFile(filepath);
        ISymptomWriter writer = new WriteSymptomDataToFile();
        AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

        counter.processSymptoms();
    }

}