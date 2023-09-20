package com.hemebiotech.analytics;

import java.util.List;

/**
 * The ISymptomReader interface defines a contract for classes that read symptom data from a data source
 * and return it as a list of symptom strings.
 */
public interface ISymptomReader {

	/**
	 * Reads symptom data from a data source and returns it as a list of symptom strings.
	 *
	 * @return A list of symptom strings obtained from the data source.
	 */
	List<String> getSymptoms();
}