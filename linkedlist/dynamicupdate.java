import java.util.*;
class node
{
    int value;
    node next;
    node(int value)
    {
        this.value=value;
        next=null;
    }
}
public class dynamicupdate
{   static Scanner sc;
static node head=null;

public static void main(String[] args) {
sc=new Scanner(System.in);
creation(sc.nextInt());
while (true){
    System.out.println("1.insbeg,2.insend,3.inspos,4.delbeg,5,delete_end,6,delpos");
    int val=sc.nextInt();
    if(val==7)
    break;
    switch(val){
        case 1:
            insert_at_beg();
            print();
            break;
        case 2:
            insert_at_end();
            print();
            break;
        case 3:
            insert_position();
            print();
            break;
        case 4:
            delete_beg();
            print();
            break;
        case 5:
            delete_end();
            print();
            break;
        case 6:
            del_pos();
            print();
            break;
    }
}
sc.close();

}
static void creation(int n)
{
    int i;
    node temp=null;
    for(i=0;i<n;i++)
    {
        if(head==null)
        {
            head=new node(sc.nextInt());
            temp=head;
        }
        else{
            node new1=new node(sc.nextInt());
            temp.next=new1;
            temp=new1;
        }
    }
}
static void print()
{
    node temp=head;
    while(temp!=null)
    {
        System.out.print(temp.value+" ");
        temp=temp.next;
    }
     System.out.println(" ");
}
static void insert_at_beg()
{
    node new1=new node(sc.nextInt());
    new1.next=head;
    head=new1;
   
}
static void insert_at_end()
{
    node new1=new node(sc.nextInt());
    node temp=head;
    while(temp.next!=null)
    {
        temp=temp.next;
    }
    temp.next=new1;
}
static void insert_position(){
    System.out.println("enter a number");
int i=0,a=sc.nextInt();
  System.out.println("enter a  position number");
int p=sc.nextInt();
node new1=new node(a);
node temp=head;
while(i<p-1)
{
   temp=temp.next;
   i++;
}
new1.next=temp.next;
temp.next=new1;
}
static void delete_beg()
{
    head=head.next;
   
}
static void delete_end()
{
    node temp=head;
    while(temp.next.next!=null)
    {
    temp=temp.next;
}
temp.next=null;
}
static void del_pos()
{
    node temp=head;
     System.out.println("enter a  position number");
    int i=0;
    int pos=sc.nextInt();
 
    while(i<pos-1)
    {
        temp=temp.next;
        i++;
    }
    temp.next=temp.next.next;
}
}
