package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals,
 and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.*/
public class MergeIntervals {

    public static int[][] mergeIntervals(int[][] intervals){
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();

        int[] curr = intervals[0];
        for(int i = 1; i<n; i++){
            if(curr[1] >= intervals[i][0]){
                //merge
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else{
                //add to ans
                ans.add(curr);
                curr = intervals[i];
            }
        }

        ans.add(curr);

        return ans.toArray(new int[ans.size()][]);
    }

    public static void main(String args[]){
        int[][] intervals={{1,3},{8,10},{2,6},{15,18}};
        int[][] m=mergeIntervals(intervals);
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++)
                System.out.print(m[i][j] + " ");

            System.out.println();

        }
    }
}
