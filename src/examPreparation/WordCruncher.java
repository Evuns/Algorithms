package examPreparation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class WordCruncher {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String[] words = bf.readLine().split(", ");
        String sentence = bf.readLine();
        List<String> print = new ArrayList<>();
        boolean [] used = new boolean[words.length];

        findWords(words, sentence, 0, print, used);
    }

    private static void findWords(String[] words, String sentence, int index, List<String> print, boolean [] used) {
        if (index >= sentence.length()) {
            System.out.println(print.toString().replaceAll("[\\[\\],]", ""));
            return;
        }
        String current = "";
        for (int i = index; i < sentence.length(); i++) {
            current = current.concat(String.valueOf(sentence.charAt(i)));

            for (int j = 0; j < words.length; j++) {
                if (words[j].equals(current) && !used[j]) {
                    print.add(words[j]);
                    used[j] = true;
                    findWords(words, sentence, i + 1, print, used);
                    print.remove(print.size()-1);
                    used[j] = false;
                }
            }
        }
    }

}
