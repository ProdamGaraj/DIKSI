package org.example;

import java.util.List;

import static org.example.DivisionSorter.completeAndSortDivisions;

public class Main {
    public static void main(String[] args) {
        List<String> codes = List.of(
                "K2\\SK1\\SSK1",
                "K1\\SK2",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1",
                "K1\\SK1",
                "K2\\SK1\\SSK2",
                "K2",
                "K3\\SK1\\SSK1"
        );

        System.out.println(completeAndSortDivisions(codes));
    }
}