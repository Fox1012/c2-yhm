import java.util.ArrayList;
import java.util.List;
//二进制编码，感觉方法很好

public class task3 {
    public static void main(String[] args)
    {
        System.out.println("求子集");
        int s[]=new int[]{1,2,3};
        System.out.println(ziji(s));
       }
       static List<List<Integer>> ziji(int[] nums)
       {
           List<Integer> t=new ArrayList<Integer>();
           List<List<Integer>> ans=new ArrayList<List<Integer>>();
           int n = nums.length;
           for (int mask = 0; mask < (1 << n); ++mask) {
               t.clear();
               for (int i = 0; i < n; ++i) {
                   if ((mask & (1 << i)) != 0) {
                       t.add(nums[i]);
                   }
               }
               ans.add(new ArrayList<Integer>(t));
           }
           return ans;
       }

}
