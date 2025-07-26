package arrays;

import java.util.*;

/*Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

0 <= a, b, c, d < n
a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]*/
public class FourSum {

    //bruteforce approach
    public static List<List<Integer>> optimizeapproach(int[] arr,int target){
        Set<List<Integer>> reusltset=new HashSet<>();
        Arrays.sort(arr);
        for(int i=0;i<arr.length;i++){
            if(i>0 && arr[i]==arr[i-1]) continue;
            for(int j=i+1;j<arr.length;j++){
                if(j!=i+1 && arr[j]==arr[j-1]) continue;
                int k=j+1;
                int l=arr.length-1;
                while(k<l){
                    int sum=arr[i]+arr[j]+arr[k]+arr[l];
                    if(sum<target){
                        k++;
                    }
                    else if(sum>target){
                        l--;
                    }
                    else{
                        ArrayList<Integer> list=new ArrayList();
                        list.add(arr[i]);
                        list.add(arr[j]);
                        list.add(arr[k]);
                        list.add(arr[l]);
                        Collections.sort(list);
                        reusltset.add(list);
                        k++;
                        l--;
                        while(k<l && arr[k]==arr[k-1]) k++;
                        while(k<l && arr[l]==arr[l+1]) l--;
                    }
                }
            }
        }
        return new ArrayList<>(reusltset);
    }
    public static void main(String args[]){
        int[] arr={1,0,-1,0,-2,2};
        //Arrays.stream(bruteforceThreesome(arr).toArray()).forEach(System.out::println); // Brute force
        //Arrays.stream(betterThreesome(arr).toArray()).forEach(System.out::println); //better approach
        Arrays.stream(optimizeapproach(arr,0).toArray()).forEach(System.out::println); // optimal solution Two pointers
    }
}
