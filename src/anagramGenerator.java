/**
 * Created by MichaelRajchert on 28/04/2017.
 */
public class anagramGenerator {

    public static void controller(){
        for (int i = 0; i < main.dictionary.size(); i++){
            main.anagramMap.put(main.dictionary.get(i), generator(main.dictionary.get(i)));
        }
    }
    public static String generator(String word){
        return "".join(", " , main.SortFromDictionary(main.generatePerumation.permutation("caret")));
    }
}
