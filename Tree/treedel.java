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
class treedele{
    static Node root=null;
    static Scanner sc;
    static Node minvalue(Node temp){
        while(temp.left!=null){
            temp=temp.left;
        }
        return temp;
    }
    static Node dele(Node temp,int key){
        if(temp==null)
        return temp;
        if(temp.value<key)
        temp.right=dele(temp.right,key);
        else if(temp.value>key)
        temp.left=dele(temp.left,key);
        else{
            if(temp.left==null){
                return temp.right;
            }
            else if(temp.right==null)
            return temp.left;
            Node min=minvalue(temp.right);
            temp.value=min.value;
            temp.right=dele(temp.right,min.value);
        }
        return temp;
    }
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
        System.out.print(temp.value+" ");
        if(temp.right!=null)
        print(temp.right);
       
        
    }
    public static void main(String arg[]){
        sc=new Scanner(System.in);
        int n=sc.nextInt();
        creation(n);
        print(root);
        System.out.println();
      root=dele(root,20);
        print(root);
        
        System.out.println();
        root=dele(root,30);
        print(root);
        
        System.out.println();
        root=dele(root,50);
        print(root);
    }
}
