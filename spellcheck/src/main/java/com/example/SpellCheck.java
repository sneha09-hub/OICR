package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class SpellCheck {
    public static void main(String[] args) throws IOException {
        System.out.println("App started...");
        System.out.println("Args:"+args.length);
        
        // Expecting two arguments: document file and dictionary file
        if(args.length !=2){
            return;
        }

        String documentFile = args[0];
        String dictionaryFile = args[1];

        // Load dictionary
        Set<String> dictionary = loadDictionary(dictionaryFile);

        // Check document
        List<String> misspelled = spellChecker(dictionary,documentFile);

        if (misspelled.isEmpty()) {
            System.out.println("No invalid words found!");
        } else {
            System.out.println("Misspelled words:");
            for (String word : misspelled) {
                System.out.println(word);
            }
        }
    }

    // Check each word in the document against the dictionary
    private static List<String> spellChecker(Set<String> dictionary, String documentFile) throws IOException{
        List<String> misspelledResult = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(documentFile))){
            String line;
            while((line=br.readLine())!=null){
                // Split words on whitespace
                String[] words = line.split("\\s+");
                // Clean and check each word
                for(String word : words){
                    word = word.replaceAll("[^a-zA-Z]","").toLowerCase();
                    if(!word.isEmpty() && !dictionary.contains(word)){
                        misspelledResult.add(word);
                    }
                }
            }
        }
        return misspelledResult;

    }

    // Load dictionary words into a Set for fast lookup
    private static Set<String> loadDictionary(String dictionaryFile) {
        Set<String> dictionary = new HashSet<>();
        // Read dictionary file and populate the set
        try(BufferedReader br = new BufferedReader(new FileReader(dictionaryFile))){
            dictionary = br.lines().collect(Collectors.toSet());
        }catch(Exception e){
            throw new RuntimeException("Dictionary file failed to load",e );
        }
        return dictionary;
    }
}