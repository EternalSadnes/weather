package com.eternal.weatherAPP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;

import static java.util.Map.Entry.comparingByKey;
import static java.util.stream.Collectors.toMap;

public class Cities {
    private Map<String, String> cities = new LinkedHashMap<>();

    public Cities() {
        readCitiesFromFile();
    }

    private void readCitiesFromFile() {
        String PATH = "src\\main\\resources\\cities\\cities.txt";
        try (Scanner in = new Scanner(new FileInputStream(new File(PATH)));) {
            while (in.hasNextLine()) {
                String[] cityAndCode = in.nextLine().split(" ");
                if (cityAndCode.length > 2) {
                    StringJoiner stringJoiner = new StringJoiner(" ");
                    for (int i = 0; i < cityAndCode.length - 1; i++) {
                        stringJoiner.add(cityAndCode[i]);
                    }
                    cities.put(stringJoiner.toString(), cityAndCode[cityAndCode.length - 1]);
                } else
                    cities.put(cityAndCode[0], cityAndCode[1]);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        sortCitiesByAlphabet();
    }

    private void sortCitiesByAlphabet() {
        cities = cities.entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }

    public Map<String, String> getCities() {
        return cities;
    }
}
