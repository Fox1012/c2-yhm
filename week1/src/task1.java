public class task1 {
    public static void main(String[] args)
    {
        System.out.println("整数反转");
        System.out.println(fanzhuan(5465131));
    }
    //迭代完成的
    static int fanzhuan(int x)
    {
        int res = 0;
        while(x!=0) {
            int tmp = x%10;
            if (res>214748364 || (res==214748364 && tmp>7)) {
                return 0;
            }
            if (res<-214748364 || (res==-214748364 && tmp<-8)) {
                return 0;
            }
            res = res*10 + tmp;
            x /= 10;
        }
        return res;
    }
}

