public class secondLargest {
    static int findMax(int arr[],int n){
        int max=arr[0];
        for(int i=1;i<n;i++){
            if(arr[i]>max)
                max=arr[i];
        }
        return max;
    }
    static int print2largest(int arr[], int n) {
        int a= findMax(arr, n);
        int b=-1;
        for(int i=0;i<n;i++){
            if(arr[i]!=a){
                b=arr[i];
                break;
            }
            else
                continue;
        }

        for(int i=1;i<n;i++){
            if(arr[i]>b && arr[i]!=a){
                b=arr[i];
            }
        }
        return b;
    }

    public static void main(String[] args) {
        int[] arr={12, 12,12,12,12,12};
        int ans=print2largest(arr,6);
    }
}
