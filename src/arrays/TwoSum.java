package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

        You may assume that each input would have exactly one solution, and you may not use the same element twice.

        You can return the answer in any order.

        Example 1:

        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
        Example 2:

        Input: nums = [3,2,4], target = 6
        Output: [1,2]
        Example 3:

        Input: nums = [3,3], target = 6
        Output: [0,1]*/
public class TwoSum {

    //BruteForce approach & integer returns
    public static int[] twoSumbruteForce(int[] arr,int target){
        int[] result=new int[2];
        for (int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(i==j)
                    continue;
                if(arr[i]+arr[j]==target){
                    result[0]=arr[i];
                    result[1]=arr[j];
                    return result;
                }
            }
        }
        return result;
    }

    //Better Approach with indexes questions
    public static int[] twoSumBetter(int[] arr,int target){
        Map<Integer,Integer> resultMap=new ConcurrentHashMap<>(); //Threadsafe purpose
        int[] result=new int[2];
        for(int i=0;i<arr.length;i++){
            if(resultMap.containsKey(target-arr[i])){
                result[0]=i;
                result[1]= resultMap.get(target-arr[i]);
                return result;
            }
            else{
                resultMap.put(arr[i],i);
            }
        }
        return result;
    }
    public static void main(String args[]){
        int[] nums = {2,7,11,15}; int target = 9;
        int [] nums1 = {3,2,4}; int target1 = 6;

        int[] nums2 = {3,3} ; int target2 = 6;
        Arrays.stream(twoSumbruteForce(nums,target)).forEach(System.out::println); // Using stream print array
        System.out.println(Arrays.toString(twoSumBetter(nums,target)));

    }
}
