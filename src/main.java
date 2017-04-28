import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by MichaelRajchert on 28/04/2017.
 */
public class main {
    public static generateAnagram generateAnagram = new generateAnagram();
    public static permutationGenerator generatePerumation = new permutationGenerator();

    public static ArrayList<String> dictionary = new ArrayList<String>();
    public static HashMap anagramMap = new HashMap();

    public static void main(String[] args){
       /* dictionary = importDictionary("C:/Users/Michael Rajchert/Desktop/wordlist.txt");
       generateAnagram.controller(); */
        System.out.println(generatePerumation.permutationFinder("adda"));
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
}
