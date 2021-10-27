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
class doublecreation{
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
    static void print(){
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.value);
            temp=temp.right;
        }
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
    }
    public static void main(String arg[]){
        sc=new Scanner(System.in);
        create(sc.nextInt());
        print();
        printr();
        sc.close();
    }
}
