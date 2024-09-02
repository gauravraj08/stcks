import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {


    public static int twoStacks(int maxSum, List<Integer> a, List<Integer> b) {
        // Write your code here
        //first add all element from stack 1 untill sum becomes greater than
        //or equal to targetsum
        int result=0,count1=0,count2=0,sum=0;
        for(int i=0;i<a.size();i++){
            if(sum+a.get(i)>maxSum) break;
            sum=sum+a.get(i);
            count1++;
        }
        result=count1;
        //now add elemnt from stack 2 to sum
        //if sum exceeds the target sum than remove 1 elemnt from stack 1
        for (int i=0;i<b.size();i++){
            sum=sum+b.get(i);
            count2++;
            while (sum>maxSum && count1>0){
                sum=sum-a.get(count1-1);
                count1--;
            }
            result=(sum <= maxSum) ? Math.max(count1+count2,result) : result;
        }
        return result;
    }



}

public class gameOfTwoStacks {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int g = Integer.parseInt(bufferedReader.readLine().trim());

        for (int gItr = 0; gItr < g; gItr++) {
            String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            int n = Integer.parseInt(firstMultipleInput[0]);

            int m = Integer.parseInt(firstMultipleInput[1]);

            int maxSum = Integer.parseInt(firstMultipleInput[2]);

            String[] aTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> a = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                int aItem = Integer.parseInt(aTemp[i]);
                a.add(aItem);
            }

            String[] bTemp = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> b = new ArrayList<>();

            for (int i = 0; i < m; i++) {
                int bItem = Integer.parseInt(bTemp[i]);
                b.add(bItem);
            }

            int result = Result.twoStacks(maxSum, a, b);

            bufferedWriter.write(String.valueOf(result));
            bufferedWriter.newLine();
        }

        bufferedReader.close();
        bufferedWriter.close();
    }
}

