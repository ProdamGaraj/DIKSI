package org.example;

import java.util.*;

public class DivisionSorter {

    public static List<String> completeAndSortDivisions(List<String> codes) {

        Set<String> completeCodes = new HashSet<>(codes);
        for (String code : codes) {
            String[] parts = code.split("\\\\");
            for (int i = 1; i < parts.length; i++) {
                String subCode = String.join("\\", Arrays.copyOfRange(parts, 0, i));
                completeCodes.add(subCode);
            }
        }


        List<String> sortedCodes = new ArrayList<>(completeCodes);
        sortedCodes.sort((a, b) -> {
            List<String> partsA = Arrays.asList(a.split("\\\\"));
            List<String> partsB = Arrays.asList(b.split("\\\\"));


            String mainA = partsA.get(0);
            String mainB = partsB.get(0);
            int mainCompare = mainB.compareTo(mainA);
            if (mainCompare != 0) {
                return mainCompare;
            }

            int minLength = Math.min(partsA.size(), partsB.size());
            for (int i = 1; i < minLength; i++) {
                String partA = partsA.get(i);
                String partB = partsB.get(i);

                if (isNumeric(partA) && isNumeric(partB)) {
                    int numA = Integer.parseInt(partA);
                    int numB = Integer.parseInt(partB);
                    if (numA != numB) {
                        return Integer.compare(numA, numB);
                    }
                } else {
                    int cmp = partA.compareTo(partB);
                    if (cmp != 0) {
                        return cmp;
                    }
                }
            }
            return Integer.compare(partsA.size(), partsB.size());
        });

        return sortedCodes;
    }

    private static boolean isNumeric(String str) {
        return str.matches("\\d+");
    }
}