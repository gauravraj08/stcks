import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class replaceWords {
    public static String replaceWords(List<String> dictionary, String sentence) {
        Set<String> dict = new HashSet<>(dictionary);
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for (String word : words) {
            if (result.length() > 0) {
                result.append(" ");
            }
            result.append(findRoot(word, dict));
        }

        return result.toString();
    }
    private static String findRoot(String word, Set<String> dict) {
        for (int i = 1; i <= word.length(); i++) {
            String prefix = word.substring(0, i);
            if (dict.contains(prefix)) {
                return prefix;
            }
        }
        return word;
    }

    public static void main(String[] args) {
        List<String> dic=new ArrayList<>();
        dic.add("cat");
        dic.add("cat");
        dic.add("cat");
        String st="the cattle was rattled by the battery";
        String ans=replaceWords(dic,st);
    }
}
