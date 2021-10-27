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
class Main{
    static Node head=null;
    static Scanner sc;
    static void delete_beg()
    {
        head.right.left=null;
        head=head.right;
    }
    static void delete_end(){
        Node temp=head;
        while(temp.right!=null)
        temp=temp.right;
        temp.left.right=null;
    }
    static void delete_middle(int pos){
        int i=0;
        Node temp=head;
        while(i<pos-1){
            temp=temp.right;
            i++;
        }
        temp.right=temp.right.right;
        temp.right.left=temp;
    }
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
    public static void main(String arg[]){
        sc=new Scanner(System.in);
        create(sc.nextInt());
        print();
        printr();
        delete_beg();
        print();
        printr();
        delete_end();
        print();
        printr();
        delete_middle(sc.nextInt());
        print();
        printr();        
        sc.close();
    }
}
