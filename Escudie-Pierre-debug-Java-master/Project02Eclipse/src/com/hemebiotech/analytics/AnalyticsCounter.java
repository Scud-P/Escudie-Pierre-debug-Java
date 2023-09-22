package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * The AnalyticsCounter class provides methods for counting and sorting symptoms.
 * It takes a list of symptoms and returns a map with symptom counts.
 * It then sorts the symptoms alphabetically.
 */

public class AnalyticsCounter {

    private final ISymptomReader reader;
    private final ISymptomWriter writer;

    /**
     * Constructs an AnalyticsCounter object.
     *
     * @param reader An ISymptomReader implementation for reading symptoms from a file.
     * @param writer An ISymptomWriter implementation for writing symptoms to a file.
     */

    public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
        this.reader = reader;
        this.writer = writer;
    }

    /**
     * Retrieves the liscct of symptoms from the configured data source.
     *
     * @return A list of symptoms read from the data source.
     */

    public List<String> getSymptoms() {
        return reader.getSymptoms();
    }

    /**
     * Counts the occurrences of symptoms in a list.
     *
     * @param symptomsList A list of symptoms to be counted.
     * @return A HashMap where keys are symptoms, and values are their respective counts.
     */

    public Map<String, Integer> countSymptoms(List<String> symptomsList) {
        Map<String, Integer> countedSymptoms = new HashMap<>();

        if (symptomsList != null && !symptomsList.isEmpty()) {

            for (String symptom : symptomsList) {
                if (symptom != null && !symptom.isEmpty()) {
                    countedSymptoms.put(symptom, countedSymptoms.getOrDefault(symptom, 0) + 1);
                }
            }
        }
        return countedSymptoms;
    }

    /**
     * Sorts a map of symptoms alphabetically.
     *
     * @param countedSymptoms A map where keys are symptoms, and values are their respective counts.
     * @return A sorted TreeMap of symptoms and their counts.
     */

    public Map<String, Integer> sortSymptoms(Map<String, Integer> countedSymptoms) {
        if (countedSymptoms == null || countedSymptoms.isEmpty() ) {
            return new TreeMap<>();
        }
        return new TreeMap<>(countedSymptoms);
    }

    /**
     * Writes the sorted symptoms to the configured output destination.
     *
     * @param sortedSymptoms A sorted map of symptoms and their counts.
     */

    public void writeSymptoms(Map<String, Integer> sortedSymptoms) {
        if(sortedSymptoms != null && !sortedSymptoms.isEmpty()) {
            writer.writeSymptoms(sortedSymptoms);
        }
    }

    /**
     * Processes the symptoms by reading them from a data source, counting their occurrences,
     * sorting them alphabetically, and writing the results to an output destination.
     * Method to be used in main
     */

    public void processSymptoms() {
        List<String> symptomsList = getSymptoms();
        Map<String, Integer> countedSymptoms = countSymptoms(symptomsList);
        Map<String, Integer> sortedSymptoms = sortSymptoms(countedSymptoms);
        writeSymptoms(sortedSymptoms);
    }
}