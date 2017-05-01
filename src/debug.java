import java.util.HashMap;

/**
 * Created by MikesComputer on 1/05/2017.
 */
public class debug {
    public static void printHashTable(HashMap<String, String> hashTable){
        for (int i  = 0; i < hashTable.size(); i++){
            System.out.println(hashTable.keySet().toArray()[i] + " = " + hashTable.get(hashTable.keySet().toArray()[i]));
        }
    }
}
