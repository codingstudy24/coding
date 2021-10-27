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
class Tree{
    static Scanner sc;
    static Node root=null;
    static void creation(int value){
        int i=0;
        Node temp=root;
        Node temp2=temp;
        for(i=0;i<value;i++){
            if(root==null){
                root=new Node(sc.nextInt());
            }
            else{
                temp=root;
                temp2=temp;
                int v=sc.nextInt();
                int count=0;
                while(temp!=null){
                    if(temp.value>v){
                    temp2=temp;
                    temp=temp.left;
                    }
                    else{
                    temp2=temp;
                    temp=temp.right;
                    }
                }
                if(v>temp2.value)
                temp2.right=new Node(v);
                else
                temp2.left=new Node(v);
            }
        }
    }
    static void print(Node temp){
        if(temp.left!=null)
        print(temp.left);
        if(temp.right!=null)
        print(temp.right);
        System.out.println(temp.value);
        
    }
    public static void main(String arg[]){
        sc=new Scanner(System.in);
        creation(sc.nextInt());
        print(root);
        sc.close();
    }
}
