public class task2 {
    public static void main(String[] args)
    {
        System.out.println("爬楼梯");
//        System.out.println(task1.fanzhuan(5465131));
        System.out.println(palouti(20));
    }

    static int palouti(int n)
    {
        if(n==1)
            return 1;
        else if(n==2)
            return 2;
        else
            return palouti(n-2)+palouti(n-1);
    }

}
