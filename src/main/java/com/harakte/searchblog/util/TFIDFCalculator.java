package com.harakte.searchblog.util;

import java.util.List;

public class TFIDFCalculator {

    private TFIDFCalculator() {
    }

    public static double tf(List<String> doc, String word){
        if(doc == null || doc.isEmpty()){
            return 0;
        }
        double result = doc.stream()
                .filter(word::equalsIgnoreCase)
                .count();
        return result / doc.size();
    }

    public static double idf(List<List<String>> docs, String word){
        if(docs == null || docs.isEmpty()){
            return 0;
        }
        double n = docs.stream()
                .filter(doc -> doc.stream().anyMatch(word::equalsIgnoreCase))
                .count();
        if(n == 0){
            return 0;
        }
        return Math.log( docs.size() / n);
    }

    public static double tfIdf(List<String> doc, List<List<String>> docs, String word) {
        return tf(doc, word) * idf(docs, word);
    }
}
