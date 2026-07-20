package com.yarukov;

import java.util.*;

public class Words {
    public static String getWord() {
        List<String> words = new ArrayList<>(Arrays.asList("кровать",
                "телевизор", "яблоко", "апельсин"));
        int wordsSize = words.size();
        int random = new Random().nextInt(wordsSize);
        return words.get(random);

    }
}
