package com.cosmo;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        predict(2, "the");
    }

    private static void predict(int n, String nGramWord){

        List<String> filteredResult = filterNgram(n, nGramWord);

        List<Tuple<String,Double>> result = generatePredictionList(filteredResult);

        System.out.println(generateResult(result));
    }

    private static List<String> filterNgram(int n, String nGramWord){
        String text = "Mary had a little lamb its fleece was white as snow;\n" +
                "And everywhere that Mary went, the lamb was sure to go.\n" +
                "It followed her to school one day, which was against the rule;\n" +
                "It made the children laugh and play, to see a lamb at school.\n" +
                "And so the teacher turned it out, but still it lingered near,\n" +
                "And waited patiently about till Mary did appear.\n" +
                "\"Why does the lamb love Mary so?\" the eager children cry;\"Why, Mary loves the lamb, you know\" the teacher did reply.\"";

        //Create the ngrams of n based on the input text
        List<String> ngrams = Ngram.ngrams(n, text);

        //Initialize filtered result list
        List<String> filteredResult = new ArrayList<>();

        //generate the ngrams and add them to filteredResult
        for (String s:ngrams){
            if (s.split(" ")[0].equals(nGramWord)) filteredResult.add(s);
        }

        return filteredResult;
    }

    //Generate list of tuples containing the predictions
    private static List<Tuple<String,Double>> generatePredictionList(List<String> wordList){

        //~Get the total size of the list to use in computing the prediction
        double total = wordList.size();

        //Create a clean list by removing the ngramWord
        Set<String> cleanList = wordList.stream().map(v -> v.split(" ")[1]).collect(Collectors.toSet());

        //Initialize a list that will contain tuples
        List<Tuple<String,Double>> predResult = new ArrayList<>();

        //Iterate thought the clean list, comparing each word with the words in the wordList to create a total for each word occurrence
        for (String s:cleanList){

            String tempWord = "";

            int seqVal = 0;

            for (String value : wordList) {
                if (value.contains(s)) {
                    tempWord = s;
                    seqVal++;
                }
            }
            predResult.add(new Tuple<>(tempWord, seqVal/total));
        }

        return predResult;
    }

    //Generate the filtered result
    private static String generateResult(List<Tuple<String,Double>> predictions){

        //Sort the list of predations
        predictions.sort((o1, o2) -> {
            double o1y = o1.getY();
            double o2y = o2.getY();

            if (o1y > o2y) {
                return -1;
            } else if (o1y < o2y) {
                return -1;
            } else {
                return 0;
            }
        });


        //Joint the list of tuples into a string
        return predictions.stream().map(Object::toString).collect(Collectors.joining(";"));
    }
}
