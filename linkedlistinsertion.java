import java.util.*;
class Node{
    int value;
    Node next;
    Node(int data){
        value=data;
        next=null;
    }
}
class linkedlistinsertion{
    static Node head=null;
     static Scanner sc;
    static void printlist(Node val){
        while(val!=null){
            
            System.out.println(val.value);
            val=val.next;
        }
    }
    static void insertion_at_begging(Node val){
        val.next=head;
        head=val;
    }
     static void insertion_at_middle(Node val1,int pos){
         Node val=head;
         int i=0;
         while(i!=pos)
         {
             val=val.next;
             i++;
         }
         val1.next=val.next;
         val.next=val1;
         
     }
      static void insertion_at_end(Node val1){
          Node val=head;
          while(val.next!=null)
          val=val.next;
          val.next=val1;
          
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
        System.out.println("enter the value to insert :");
        insertion_at_begging(new Node(sc.nextInt()));
        System.out.println("enter the value to insert :");
        insertion_at_middle(new Node(sc.nextInt()),sc.nextInt());
        System.out.println("enter the value to insert :");
        insertion_at_end(new Node(sc.nextInt()));
        sc.close();
        printlist(head);
    }

}
