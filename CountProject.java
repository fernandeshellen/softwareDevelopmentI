import java.util.*;
import java.io.*;

public class CountProject {

    public static void main(String[] args) throws IOException{
        String filePath = "//Users//hellenfernandes//Documents//Poem//poem.txt";
    
        ArrayList<String> words = new ArrayList<String>();
        WordsCount file = new WordsCount();
    
        file.readFile(words, filePath);
        file.wordsCounter(words, filePath);
    
    }
}

