package com.yarukov;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Words {
    public static String getWord() throws IOException {
        List<String> words = Files.readAllLines(Path.of("src/main/words.txt"));
        int wordsSize = words.size();
        int random = new Random().nextInt(wordsSize);
        return words.get(random);

    }
}
