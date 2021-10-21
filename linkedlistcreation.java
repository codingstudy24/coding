import java.util.*;
class Node{
    int value;
    Node next;
    Node(int data){
        value=data;
        next=null;
    }
}
class linkedlistcreation{
    static Node head=null;
    static void printlist(Node val){
        while(val!=null){
            
            System.out.println(val.value);
            val=val.next;
        }
    }
    static void dynamic(int count){
        Scanner sc=new Scanner(System.in);
        Node temp=null;
        int i;
        for(i=0;i<count;i++)
        if(head==null){
            head=new Node(sc.nextInt());
            temp=head;
        }
        else{
            Node var=new Node(sc.nextInt());
            temp.next=var;
            temp=var;
        }
        sc.close();
    }
    public static void main(String arg[])
    {
        System.out.println("enter the no of nodes :");
        Scanner sc=new Scanner(System.in);
        int count=sc.nextInt();
        dynamic(count);
        sc.close();
        printlist(head);
    }

}
