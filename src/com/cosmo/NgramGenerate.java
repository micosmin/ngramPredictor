package com.cosmo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class NgramGenerate {

    public static List<String> ngrams(int n, String str) {
        List<String> ngrams = new ArrayList<>();

        //Clean the text, by removing all non alphanumeric characters, expect \s space
        str = str.replaceAll("[^a-zA-Z0-9\\s]", " ").replaceAll("\\s+", " ");

        String[] words = Arrays.stream(str.split(" "))
                .map(String::toLowerCase)
                .collect(Collectors.toList()).toArray(String[] ::new);

        //create the ngram words based on n
        for (int i = 0; i < words.length - n + 1; i++)

            ngrams.add(concat(words, i, i+n));

        return ngrams;
    }

    //concat the words
    private static String concat(String[] words, int start, int end) {

        StringBuilder sb = new StringBuilder();

        for (int i = start; i < end; i++)

            sb.append(i > start ? " " : "").append(words[i]);

        return sb.toString();
    }

}
