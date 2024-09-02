import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class binaryCombo {
        public static void main(String[] args) {
            int n = 5;  // Change this value to generate combinations for different lengths
            int totalCombinations = (int) Math.pow(2, n);
            Set<String> combinations = new HashSet<>();

            for (int i = 0; i < totalCombinations; i++) {
                String binaryString = Integer.toBinaryString(i);

                while (binaryString.length() < n) {
                    binaryString = "0" + binaryString;
                }

                boolean flag = false;
                for(int j=1;j<binaryString.length();j++){
                    char[] c = binaryString.toCharArray();
                    if(c[j-1]=='1' && c[j]=='1'){
                        flag=true;
                    }
                }
                if(!flag) combinations.add(binaryString);
            }
            System.out.println(combinations);
            System.out.println("size: "+combinations.size());
        }

}
