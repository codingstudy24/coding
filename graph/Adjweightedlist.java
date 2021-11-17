import java.util.*;
class node{
    ArrayList<LinkedHashMap<Integer,Integer>> var=new ArrayList<LinkedHashMap<Integer,Integer>>();
    node(int n){
        int i;
        for(i=0;i<n;i++)
        var.add(new LinkedHashMap<Integer,Integer>());
    }
}

public class bfs {
    static int vertices;
    static boolean visited[];
    static int f=0,r=-1;
    static int queue[];
    static  node mygraph;
    static void bfs(int val){
        int i;
        if(visited[val]!=true)
        System.out.println(val);
        visited[val]=true;
        for(i=0;i<vertices+1;i++)
        if(mygraph.var.get(val).containsKey(i) && visited[i]==false)
        queue[++r]=i;
        if(f<=r)
        bfs(queue[f++]);  
    }
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        vertices=sc.nextInt();
        int i;
        int edges=sc.nextInt();
        mygraph= new node(vertices+1);
        visited= new boolean[vertices+1];
        queue=new int[100];
        for(i=0;i<edges;i++)
        {
            int n,m,w;
            n=sc.nextInt();
            m=sc.nextInt();
            w=sc.nextInt();
            mygraph.var.get(m).put(n,w);
            mygraph.var.get(n).put(m,w);
            
        }
        System.out.println(mygraph.var);
        bfs(1);
    }
}
