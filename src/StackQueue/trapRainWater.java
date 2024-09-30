package StackQueue;

public class trapRainWater {
    public static int trap(int[] height) {
        int n= height.length;
        int lMax=0,rMax=0,total=0,l=0;
        int r=n-1;

        while (l<r){
            if(height[l]<height[r]){
                if(lMax>height[l]){
                    total+=lMax-height[l];
                }
                else{
                    lMax=height[l];
                }
                l+=1;
            }
            else{
                if(rMax>height[r]){
                    total+=rMax-height[r];
                }
                else rMax=height[r];
                r-=1;
            }
        }
        return total;

    }
    public static void main(String[] args) {
        int[] arr={0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(arr));
    }
}
