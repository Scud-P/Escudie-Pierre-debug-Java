package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * The ReadSymptomDataFromFile class implements the ISymptomReader interface
 * to read symptom data from a file. It reads a file containing symptom strings,
 * one per line, and returns them as a list of strings.
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

    private String filepath;

    /**
     * Constructs a ReadSymptomDataFromFile object with the specified file path.
     *
     * @param filepath A full or partial path to a file with symptom strings in it, one per line.
     */
    public ReadSymptomDataFromFile(String filepath) {
        this.filepath = filepath;
    }

    /**
     * Reads symptom data from the specified file and returns it as a list of strings.
     *
     * @return A list of symptom strings read from the file.
     */
    @Override
    public List<String> getSymptoms() {
        ArrayList<String> symptomsList = new ArrayList<>();

        if (filepath != null) {
            try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
                String line = reader.readLine();

                while (line != null) {
                    symptomsList.add(line);
                    line = reader.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return symptomsList;
    }
}
