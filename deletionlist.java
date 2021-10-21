import java.util.*;
class Node{
    int value;
    Node next;
    Node(int data){
        value=data;
        next=null;
    }
}
class deletionlist{
    static Node head=null;
    static  Scanner sc;
    static void printlist(Node val){
        while(val!=null){
            
            System.out.println(val.value);
            val=val.next;
        }
    }
    static void delete_begging(){
        head=head.next;
    }
    static void delete_middle(int pos){
        int i=0;
        Node temp=head;
        while(i<pos-1){
            temp=temp.next;    
            i++;
        }
        head.next=head.next.next;
        
    }
    static void delete_end(){
        Node temp=head;
        while(temp.next.next!=null){
            temp=temp.next;
        }
        temp.next=null;
    }
    static void dynamic(int count){
       
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
    }
    public static void main(String arg[])
    {
        System.out.println("enter the no of nodes :");
       sc=new Scanner(System.in);
        int count=sc.nextInt();
        dynamic(count);
        delete_begging();
         printlist(head);
        delete_middle(sc.nextInt());
         printlist(head);
        delete_end();
        sc.close();
        printlist(head);
    }

}
