package com.hemebiotech.analytics;

import java.util.Map;

/**
 * The ISymptomWriter interface defines a contract for classes that write symptom data to a source.
 * Classes implementing this interface should be able to accept a sorted map of symptoms and their counts
 * and write them to a file.
 */

public interface ISymptomWriter {

    /**
     * Writes symptom data to a storage medium.
     *
     * @param sortedSymptoms A map where keys are symptoms, and values are their respective counts,
     *                      typically sorted in a specific order.
     */
    void writeSymptoms(Map<String, Integer> sortedSymptoms);
}