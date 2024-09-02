public class sortCharFreq {
    public static String frequencySort(String s) {
        int freq[] = new int[123];
        char ch;
        int ascii;

        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            ascii=(int)ch;
            freq[ascii]=freq[ascii]+1;
        }
        StringBuilder ans = new StringBuilder();
        int max=0,count=0;

        for(int i=0;i<s.length();){
            max=Maximum(freq);
            count=freq[max];
            freq[max]=-1;

            while(count!=0){
                ans.append((char)max);
                i++;
                count--;
            }
        }
        return ans.toString();
    }
    private static int Maximum(int[] arr){
        int maxi=-1,index=-1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>=maxi){
                maxi=arr[i];
                index=i;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s="tree";
        String ans=frequencySort(s);
        System.out.println(ans);
    }
}
