package arrays;

import java.util.Arrays;

public class MaxSubArray {
    public static int[] maxSubArraySum(int[] arr){
        int max=Integer.MIN_VALUE;
        int sum=0;
        int start=0,end=0;
        for(int i=0;i<arr.length;i++){
            sum=sum+arr[i];
            if(max<sum){
                max=sum;
                end=i;
            }
            if(sum<0){
                sum=0;
                start=i+1;
            }
        }
        int[] result=new int[end-start+1];
        for(int i=0;i<result.length;i++){
            result[i]=arr[start];
            start++;
        }
        return result;
    }

    public static void main(String args[]){
        //int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
       // int[] nums = {1};
        int[] nums={5,4,-1,7,8};
        Arrays.stream(maxSubArraySum(nums)).forEach(System.out::print);
    }}
