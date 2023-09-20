package com.hemebiotech.analytics;

import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * The WriteSymptomDataToFile class implements the ISymptomWriter interface
 * to write symptom data to a file. It takes a sorted map of symptoms and their counts
 * and writes each of them on a separate line (the format being "symptom: count").
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

    /**
     * Writes symptom data to a file in the specified format.
     *
     * @param sortedSymptoms A sorted map where keys are symptoms, and values are their respective counts.
     */
    @Override
    public void writeSymptoms(Map<String, Integer> sortedSymptoms) {
        if (sortedSymptoms != null) {
            try (FileWriter writer = new FileWriter("result.out")) {

                for (Map.Entry<String, Integer> entry : sortedSymptoms.entrySet()) {
                    String symptom = entry.getKey();
                    int count = entry.getValue();
                    writer.write(symptom + ": " + count + "\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}