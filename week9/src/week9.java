import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class week9 {
    public static void main(String[] args) {
        int nums1[]={5,3,6,1,12};
        int nums2[]={0,0,1,0};
        findFinalValue(nums1,3);
        maxScoreIndices(nums2);
        subStrHash("leetcode",7,20,2,0);
    }

    public static int findFinalValue(int[] nums, int original) {
        int count=nums.length;
        int flag=0;
        for(int j=0;j<count;j++)
        {
            for(int i=0;i<count;i++)
            {
                if(original==nums[i])
                {
                    flag=1;
                    break;
                }
            }
            if(flag==0)
            {
                System.out.println(original);
                return original;
            }
            original=2*original;
            flag=0;

        }
        return original;
    }
    public static List<Integer> maxScoreIndices(int[] nums) {
        int n = nums.length;
        int sum1 = 0;
        for(int num : nums) {
            if(num == 1) sum1++;
        }

        int cur0 = 0;
        int cur1 = sum1;

        int max = cur0 + cur1;
        List<Integer> res = new ArrayList<>();
        res.add(0);

        for(int i=0; i<n; i++) {
            if(nums[i] == 0) {
                cur0++;
            } else {
                cur1--;
            }
            int score = cur0 + cur1;
            if(score > max) {
                max = score;
                res = new ArrayList<>();
                res.add(i+1);
            } else if(score == max) {
                res.add(i+1);
            }
        }
        System.out.println(res);
        return res;
    }

    static int[][] mem;
    public static String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int left = 0;
        int right = k-1;
        int cal;
        mem = new int[26][s.length()];
        for(int i =0;i<26;i++){
            Arrays.fill(mem[i],-1);
        }
        while(right < s.length()){
            cal = get(s,left,right,power,modulo);
            if(cal == hashValue){
                return s.substring(left,right+1);
            }
            left++;
            right++;
        }
        return "";
    }
    public static int get(String s,int left,int right, int p,int m){
        String cur = s.substring(left,right+1);
        int res = 0;
        for(int i = 0;i<cur.length();i++){
            res = (int)((res + (get2(cur.charAt(i),i,m,p) % m)) % m);
        }
        System.out.println(res);
        return res;
    }
    public static long get2(char c, int index,int m,int p){
        if(mem[c - 'a'][index] != -1){return mem[c - 'a'][index];}
        if(index == 0){return  c - 'a' + 1;}
        long res = ((get2(c,index-1,m,p)%m) * (p%m)) % m;
        mem[c-'a'][index] = (int)res;
        System.out.println(res);
        return (int)res;
    }
}


