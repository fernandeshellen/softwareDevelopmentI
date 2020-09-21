import java.util.*;
import java.io.FileInputStream;
import java.io.*;
import java.util.Collections;
import java.util.stream.Collectors;


public class WordsCount {

    public void readFile(ArrayList<String> fp, String path) {

        try {

            File file = new File(path);
            Scanner scan = new Scanner(file);

            while (scan.hasNextLine())
                fp.add(scan.nextLine());
            System.out.println("\nFile was SUCCESSFULLY read!\n");

            scan.close();

        } catch (FileNotFoundException e) {
            System.out.println("ERROR to read the file. TRY AGAIN!\n" + e);
        }
    }

    public void wordsCounter(ArrayList<String> fp, String path) throws IOException {

        FileInputStream fileInp = new FileInputStream(path);
        Scanner s = new Scanner(fileInp);

        HashMap<String, Integer> map = new HashMap<String, Integer>();

        while (s.hasNext()) {
            String nextWord = s.next().toLowerCase();

            nextWord = nextWord.replaceAll("[^a-zA-Z]", "");
            nextWord.toLowerCase();

            if (map.containsKey(nextWord)) {
                int counter = map.get(nextWord) + 1;
                map.put(nextWord, counter);
            } else {
                map.put(nextWord, 1);
            }
        }
        s.close();
        System.out.println("\n\n\n\n****WORD FREQUENCY****\n");
        for (Map.Entry<String, Integer> val : map.entrySet()) {
            System.out.println("Word: " + val.getKey() + " | Frequency: " + val.getValue() + " times");
        }

        System.out.println("\n\n\n\n****SORTED BY MOST FREQUENTLY USED WORD****\n");
        map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).collect(Collectors.toMap(
            Map.Entry::getKey,
            Map.Entry::getValue,
            (e1, e2) -> e1,
            LinkedHashMap::new
    )).forEach((a, integer) -> System.out.println(String.format("Word: %s | Frequency sorted: %s times", a, integer)));
        
    }
}
