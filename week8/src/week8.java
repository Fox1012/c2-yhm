import java.util.Random;

public class week8 {
    static Random random = new Random();

    public static void test() {
        System.out.println(task1("abbc", "dog cat cat fish"));
        System.out.println(task2(new int[]{1, 2, 2, 3, 0}));
        for (int i = 0; i < 5; i++) {
            int target = random.nextInt(15) - 3;
            System.out.println("target:" + target + "\tresult" + task3(new int[]{0, 4, 5, 6, 8}, target));
        }
    }
    public static void main(String[] args) {
       test();
    }


    public static boolean task1(String pattern, String str)
    {
        //第一题代码
        int flag1=0;
        int flag2=0;
        int m=pattern.length();
        for(int i=0;i<pattern.length();i++)
        {
//            System.out.println(pattern.charAt(i));
            if(pattern.charAt(i)!=pattern.charAt(m-i-1)||pattern.charAt(0)==pattern.charAt(1))
                flag1=1;
        }
        //System.out.println(flag1);
        String[] list=new String[4];
        char[] s=new char[10];
        int count=0;
        int counts=0;
        for(int i=0;i<str.length();i++)
        {
            if(str.charAt(i)==' ')
            {
                String c=new String(s);
                list[counts]=c;
                //System.out.println(list[counts]);
                counts++;
                s=new char[10];
                count=0;
            }
            else if(i==str.length()-1)
            {
                s[count]=str.charAt(i);
                count++;
                String c=new String(s);
                list[counts]=c;
                //System.out.println(list[counts]);
                counts++;
                s=new char[10];
                count=0;
            }
            else
            {
                s[count]=str.charAt(i);
                count++;
            }
            //System.out.println(s);
        }
        for(int i=0;i<list.length;i++)
        {
            //System.out.println(list.length);
            if(list[0].equals(list[1]))
        {
            flag2=1;
            break;
        }
            if(list[i].equals(list[list.length-1-i]))
                flag2=0;
            else
            {
                flag2=1;
                break;
            }
        }
        //System.out.println(flag2);
        if(flag1==0&&flag2==0)
        {
            boolean res=true;
            return res;
        }
        else
        return false;
    }

    public static int task2(int[] nums) {
        //第二题代码
        int res=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<nums.length;j++)
            {
                if(j==i)
                    continue;
                if(nums[i]==nums[j])
                    res=nums[i];
            }
        }
        return res;
    }

    public static int task3(int []nums,int target){
        //第三题代码
        int res=0;
        int min=0;
        int max=nums.length;
        int flag=(min+max)/2;
        while (min<max)
        {
            if(target>nums[flag])
            {
                min=flag+1;
                flag=(min+max)/2;
            }
            else if(target<nums[flag])
            {
                max=flag-1;
                flag=(min+max)/2;
            }
            else if(target==nums[flag])
            {
                res=flag;
                break;
            }
        }
        if(min<max)
            return res;
        else
            return flag*(-1);
    }
}
