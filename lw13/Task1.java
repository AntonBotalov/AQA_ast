import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        String[] words = {
                "яблоко", "банан", "банан", "апельсин", "груша",
                "яблоко", "слива", "ананас", "яблоко", "апельсин",
                "клубника", "банан"
        };

        Set<String> uniqueWords = new HashSet<>(Arrays.asList(words));

        System.out.println("Уникальные слова:");
        for (String word : uniqueWords) {
            System.out.println(word);
        }

        Map<String, Integer> wordCountMap = new HashMap<>();
        for (String word : words) {
            wordCountMap.put(word, wordCountMap.getOrDefault(word, 0) + 1);
        }

        System.out.println("\nКоличество вхождений каждого слова:");
        for (Map.Entry<String, Integer> entry : wordCountMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}