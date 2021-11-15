import java.util.*;
public class Graph
{
    static Scanner sc = new Scanner(System.in);
    static LinkedList<Integer> li[];
    Graph(int nodes)
    {
        li = new LinkedList[nodes];
        int i;
        for(i=0;i<nodes;i++)
        { 
            li[i] = new LinkedList<Integer>();
        }
    }
    static void addEdge(int source, int destination)
    { 
        li[source].add(destination);
        li[destination].add(source);
    }
    static void print(){
        for(int i=0;i<li.length;i++){
            System.out.println(i+"-->"+li[i]);
        }
    }
    static void bfs(int start){
        System.out.println("bfs traversal : ");
        Queue<Integer> q = new LinkedList<Integer>();
        boolean[] visited = new boolean[li.length];
        q.add(start);
        visited[start] = true;
        while(q.size()!=0){
        int current = q.poll();
        System.out.print(current+"  ");
        for(int x:li[current]){
            if(visited[x]==false){
                q.add(x);
                visited[x] = true;
            }
        }
        }


    }
    public static void main(String[] args){
        int n;
        n = sc.nextInt();
        Graph graph = new Graph(n);
        int ne = sc.nextInt();
        for(int i=0;i<ne;i++){
            int source = sc.nextInt();
            int destination = sc.nextInt();
            addEdge(source, destination);
        }
        print();
        bfs(3);
    }
}
