import java.util.Stack;

public class tow {
    public static void main(String[] args)
    {
        int pushed[]={1,2,3,4,5};
        int popped[]={4,5,3,2,1};
        Stack<Integer> stack=new Stack<>();
        stack.push(pushed[0]);
        int count=0;
        int counts=1;
        for(int i=0;i<pushed.length;i++)
        {
            if(count==popped.length)
                break;
            if(counts==pushed.length&&popped[count]!=stack.peek())
                break;
            if(stack.isEmpty()==false)
            {if(stack.peek()==popped[count])
            {
                i=i-1;
                stack.pop();
                count++;
                System.out.println(i);
            }
            else{
                stack.push(pushed[counts]);
                System.out.println(counts+1);
                counts++;
            }}
            else
            {
                stack.push(pushed[counts]);
                System.out.println(counts+1);
                counts++;
            }

        }
        if(stack.isEmpty())
            System.out.println("true");
        else
            System.out.println("false");
    }
}
