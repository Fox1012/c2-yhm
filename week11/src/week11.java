import java.util.Arrays;
import java.util.Comparator;

public class week11 {
    public static void main(String[] str)
    {
        int nums1[]={1, 2, 3, 2, 2, 2, 5, 4, 2};
        System.out.println( majorityElement(nums1));
        int nums2[]={1,0,0,0,1};
        System.out.println(canPlaceFlowers(nums2,1));
        int nums3[][]={{1,2},{2,3},{3,4},{1,3}};
        System.out.println(eraseOverlapIntervals(nums3));
    }

    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int num = 0, count = 1;
        for (int i = 0; i < flowerbed.length; ++i) {
            if (flowerbed[i] == 0) {
                ++count;
            } else {
                count = 0;
            }
            if (count == 3) {
                count = 1;
                ++num;
            }
        }
        if (count == 2) {
            ++num;
        }
        return n <= num;
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1,x=intervals[0][1];
        for(int[] interval:intervals){
            if(interval[0]>=x){
                count++;
                x=interval[1];
            }

        }
        return  intervals.length-count;
    }
}
