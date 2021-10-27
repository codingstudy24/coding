import java.util.*;
class Node{
    int value;
    Node left,right;
    Node(int value){
        this.value=value;
        left=null;
        right=null;
    }
}
class doublelistinsertion{
    static Node head=null;
    static Scanner sc;
    static void create(int size){
        int i;
        Node temp=null;
        for(i=0;i<size;i++)
        {
            if(head==null){
                head=new Node(sc.nextInt());
                temp=head;
            }
            else{
                Node newval=new Node(sc.nextInt());
                temp.right=newval;
                newval.left=temp;
                temp=newval;
            }
        }
        
    }
    static void insert_at_begging(){
        Node newval=new Node(sc.nextInt());
        head.left=newval;
        newval.right=head;
        head=newval;
    }
    static void insert_end(){
        Node newval=new Node(sc.nextInt());
        Node temp=head;
        while(temp.right!=null){
            temp=temp.right;
        }
        temp.right=newval;
        newval.left=temp;
    }
    static void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value);
            temp=temp.right;
        }
        System.out.println();
    }
     static void printr(){
        Node temp=head;
        while(temp.right!=null){
            temp=temp.right;
        }
        while(temp!=null){
            System.out.print(temp.value);
            temp=temp.left;
        }
        
        System.out.println();
    }
    static void insert_at_middle(){
        int pos=sc.nextInt();
        Node newval=new Node(sc.nextInt());
        int i=0;
        Node temp=head;
        while(i<pos-1){
            temp=temp.right;
            i++;
        }
        newval.right=temp.right;
        temp.right.left=newval;
        temp.right=newval;
        newval.left=temp;
        
    }
    public static void main(String arg[]){
        sc=new Scanner(System.in);
        create(sc.nextInt());
        print();
        printr();
        insert_at_begging();
         print();
        printr();
        insert_end();
         print();
        printr();
        insert_at_middle();
         print();
        printr();
        sc.close();
    }
}
