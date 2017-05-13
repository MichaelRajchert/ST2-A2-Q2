import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;

/**
 * Created by MichaelRajchert on 28/04/2017.
 *
 * For ST2-ASSIGNMENT2-Q2
 */
public class main {
    public static ArrayList<String> dictionary = new ArrayList<>();
    public static Hashtable<String, ArrayList<String>> validAnagram = new Hashtable<>();

    public static String inputPath = "wordlist.txt";
    public static String outputPath = "anagramlist.txt";
    public static void main(String[] args){
        dictionary = importDictionary(inputPath);
        produceLetterSortedWords();
        try {
            writeFile(outputPath, validAnagram, false);
        }
        catch (IOException e){
            System.out.println("ERROR: Failed to output to anagramlist.txt");
        }
    }
    public static ArrayList<String> importDictionary(String path){
        try {
            ArrayList<String> fileData = new ArrayList<String>();
            String lineData;
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((lineData = bufferedReader.readLine()) != null){
                fileData.add(lineData);
            }
            bufferedReader.close();
            return fileData;
        } catch (IOException e){
            System.out.print("ERROR: File not found, please input correct file path. \nError Dump: \n" + e);
        }
        return null;
    }
    public static void writeFile(String path, Hashtable<String, ArrayList<String>> hashTable, boolean appendToFile) throws IOException{
        FileWriter fileWriter = new FileWriter(path, appendToFile);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        int i = 1;
        for (String key : hashTable.keySet()){
            if (hashTable.get(key).size() > 1) {
                printWriter.println("Anagram " + i + ": " + printAsString(hashTable.get(key)));
                i++;
            }
        }
        printWriter.close();
    }

    public static void produceLetterSortedWords(){
        for (int i = 0; i < dictionary.size(); i++){
            String value = dictionary.get(i);
            char[] keyArray = value.toCharArray();
            Arrays.sort(keyArray);
            String key = new String (keyArray);
            if (!validAnagram.containsKey(key)){
                validAnagram.put(key, new ArrayList<String>());
            }
            validAnagram.get(key).add(value);
        }
    }
    public static String printAsString(ArrayList<String> input){
        return "".join(", ", input);
    }
}