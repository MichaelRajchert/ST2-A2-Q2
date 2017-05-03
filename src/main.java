import java.io.*;
import java.util.*;

/**
 * Created by MichaelRajchert on 28/04/2017.
 */
public class main {
    public static ArrayList<String> dictionary = new ArrayList<>();
    public static Hashtable<String, ArrayList<String>> validAnagram = new Hashtable<>();

    public static String inputPath = "shortwordlist.txt";
    public static String outputPath = "anagramlist.txt";
    public static void main(String[] args){
        dictionary = importDictionary(inputPath);
        produceLetterSortedWords();
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
    public static void writeFile(String path, Hashtable<String, String> hashTable, boolean appendToFile) throws IOException{
        FileWriter fileWriter = new FileWriter(path, appendToFile);
        PrintWriter printWriter = new PrintWriter(fileWriter);
        for (int i = 0; i < hashTable.size(); i++) {
            printWriter.println(hashTable.keySet().toArray()[i] + " = " + hashTable.get(hashTable.keySet().toArray()[i]));
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
                System.out.println("Adding new arraylist for: " + new String(key));
                validAnagram.put(key, new ArrayList<String>());
            }
            validAnagram.get(key).add(value);
        }
        System.out.println();
        for (String key : validAnagram.keySet()){
            System.out.println(key + ", " + validAnagram.get(key));
        }
    }
}