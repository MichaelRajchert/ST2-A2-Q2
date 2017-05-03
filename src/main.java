import java.io.*;
import java.util.*;

/**
 * Created by MichaelRajchert on 28/04/2017.
 */
public class main {
    public static permutationGenerator generatePermutation = new permutationGenerator();
    public static debug debug = new debug();

    public static ArrayList<String> dictionary = new ArrayList<String>();
    public static Hashtable anagramMap = new Hashtable();

    public static void main(String[] args){
        System.out.println("**START**");
        dictionary = importDictionary("shortwordlist.txt");
        anagramSetGenerator();
        try {
            writeFile("anagramlist.txt", anagramMap, false);
        } catch (IOException e){
            System.out.println("ERROR: Unable to locate output file. \n -------------Error dump------------- \n" + e);
        }
        System.out.println("**END**");
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

    public static ArrayList<String> SortFromDictionary(ArrayList<String> array){
        ArrayList<String> outputArray = new ArrayList<String>();
        for (int i = 0; i < array.size(); i++){
            try {
                if (dictionary.contains(array.get(i)) == true){
                    if (outputArray.contains(array.get(i)) == false) {
                        outputArray.add(array.get(i));
                    }
                }
            } catch(Exception e) {
                Collections.sort(outputArray);
                return outputArray;
            }
        }
        Collections.sort(outputArray);
        return outputArray;
    }

    public static void anagramSetGenerator(){
        for (int i = 0; i < main.dictionary.size(); i++) {
            String output = "";
            ArrayList<String> permutation = SortFromDictionary(generatePermutation.permutation(dictionary.get(i)));
            output = output.join(", ", permutation);
            anagramMap.put(dictionary.get(i), output);
        }
    }
}