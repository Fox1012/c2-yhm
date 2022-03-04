import java.util.LinkedList;

public class week12 {
    public static class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] str)
    {

        test1();
        test2();
        System.out.println(test3());
    }
    public static ListNode test1() {
        ListNode five=new ListNode(5);
        ListNode fore=new ListNode(4);
        ListNode three=new ListNode(3);
        ListNode tow= new ListNode(2);
        ListNode head =new ListNode(1);
        head.next=tow;
        tow.next=three;
        three.next=fore;
        fore.next=five;
        ListNode pre = null;
        ListNode curent = head;
        ListNode s=head;
        while (s!=null)
        {
            System.out.print(s.val);
            s=s.next;
        }
        System.out.println();
        while (curent != null) {
            ListNode next = curent.next;
            curent.next = pre;
            pre = curent;
            curent = next;
        }
        s=pre;
        while (s!=null)
        {
            System.out.print(s.val);
            s=s.next;
        }
        System.out.println();
        return pre;
    }
    public static ListNode test2(){
        ListNode fore1=new ListNode(4);
        ListNode fore2=new ListNode(4);
        ListNode three2=new ListNode(3);
        ListNode tow1= new ListNode(2);
        ListNode list1 =new ListNode(1);
        ListNode list2=new ListNode(1);
        list1.next=tow1;
        tow1.next=fore1;
        list2.next=three2;
        three2.next=fore2;
        ListNode prehead=new ListNode();
        ListNode pre=prehead;
        while(list1!=null&&list2!=null){
            if(list1.val>=list2.val){
                pre.next=list2;
                list2=list2.next;
            }else{
                pre.next=list1;
                list1=list1.next;
            }
            pre=pre.next;
        }
        if(list1==null){
            pre.next=list2;
        }
        if(list2==null){
            pre.next=list1;
        }
        ListNode s=prehead.next;
        while (s!=null)
        {
            System.out.print(s.val);
            s=s.next;
        }
        System.out.println();
        return prehead.next;
    }
    public static Boolean test3(){
        ListNode one=new ListNode(1);
        ListNode tow2=new ListNode(2);
        ListNode three=new ListNode(3);
        ListNode tow= new ListNode(2);
        ListNode head =new ListNode(1);
        head.next=tow;
        tow.next=three;
        three.next=tow2;
        tow2.next=one;
        LinkedList<Integer> stack = new LinkedList<Integer>();
        ListNode tmp = head;
        while(tmp != null){
            stack.push(tmp.val);
            tmp = tmp.next;
        }
        ListNode tmp2 = head;
        while(tmp2 != null){
            if(tmp2.val != stack.pop()){
                return false;
            }
            tmp2 = tmp2.next;
        }
        return true;
    }
}
