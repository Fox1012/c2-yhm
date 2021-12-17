import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class three {
    public static void main(String[] args){
//        int num[]={1,2,3,2};
//        int num[]={1,1,1,1,1,1};
        int num[]={1,2,3,4,5};
        int result=0;
        Map<Integer,Integer>map=new HashMap<>();

        for(int i=0;i<num.length;i++)
        {
            if(map.containsKey(num[i]))
                map.put(num[i],map.get(num[i])+1);
            else
                map.put(num[i],1);
        }
        System.out.println(map);
        Set<Integer> s=map.keySet();
        for(int i:s)
        {
            if(map.get(i)==1)
                result+=i;
        }
        System.out.println(result);
    }

}
