import java.util.Arrays;

public class RotateArray {
    public void rotateArray(int[] nums,int k){
        k%=nums.length;
        reverse(0,nums.length-1,nums);
        reverse(0,k-1,nums);
        reverse(k,nums.length-1,nums);
    }
    public void reverse(int start,int end,int[]nums){
        while(start<=end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]){
        int[] a={1,2,3,4,5,6};
        new RotateArray().rotateArray(a,3);
        Arrays.stream(a).forEach(n->System.out.println(n));
    }
}
