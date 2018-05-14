import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.*;
import java.util.stream.Collectors;

public class WordFrequencyCounter {

    public static void printWordsWithFrequency(String fileName) {
        Comparator<Map.Entry<String, Integer>> comparator = Comparator.comparingInt(Map.Entry::getValue);
        List<Map.Entry<String, Integer>> words = new ArrayList<>(mapWithFrequency(fileName).entrySet());
        words.stream().sorted(comparator.reversed()).forEach(System.out::println);
    }

    private static Map<String, Integer> mapWithFrequency(String fileName) {
        if (fileName == null || fileName.isEmpty()) {
            return Collections.emptyMap();
        }
        return mapOldWay(fileName);
    }

    private static Map<String, Integer> mapOldWay(String fileName) {
        Map<String, Integer> result = new HashMap<>();
        try (FileReader fileReader = new FileReader(fileName);
             LineNumberReader lineNumberReader = new LineNumberReader(fileReader)) {
            String line;
            while ((line = lineNumberReader.readLine()) != null) {
                updateResultMap(result, line);
            }
        } catch (IOException e) {
            // replace with proper logging
            e.printStackTrace();
        }
        return result;
    }

    private static void updateResultMap(Map<String, Integer> result, String line) {
        List<String> words = Arrays.asList(line.trim().toLowerCase().split("\\s+"));
        words = removePunctuationMarks(words);
        words.forEach(w -> result.merge(w, 1, (k, v) -> ++v));
    }

    private static List<String> removePunctuationMarks(List<String> words) {
        return words.stream().
//                remove punctuation symbols
                map(w -> w.replaceAll("\\pP", ""))
                .filter(w -> !w.isEmpty())
                .collect(Collectors.toList());
    }
}
