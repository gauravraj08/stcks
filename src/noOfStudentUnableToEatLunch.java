public class noOfStudentUnableToEatLunch {
    static int countStudents(int[] students, int[] sandwiches) {
        int[] counts = new int[2];
        for (int i=0;i<students.length;i++) {
            counts[students[i]]++;
        }

        int remaining = sandwiches.length;
        for (int i=0;i<sandwiches.length;i++) {
            if (counts[sandwiches[i]] == 0) break;
            if (remaining-- == 0) break;
            counts[sandwiches[i]]--;
        }

        return remaining;
    }
    public static void main(String[] args) {
        int[] arr1={1,1,1,0,0,1};
        int[] arr2={1,0,0,0,1,1};
        int ans=countStudents(arr1,arr2);
        System.out.println(ans);
    }
}
