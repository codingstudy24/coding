import java.util.*;
class breathfirst{
    
    static int n;
    static int matrix[][];
    static boolean visited[];
    static int f=0,r=-1;
    static int queue[];
    static void bfs(int val){
        int i;
        if(visited[val]!=true)
        System.out.println(val);
        visited[val]=true;
        for(i=0;i<n;i++)
        if(matrix[val][i]!=0 && visited[i]==false)
        queue[++r]=i;
        if(f<=r)
        bfs(queue[f++]);   
    }
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        matrix=new int[n][n];
        visited=new boolean[n];
        queue=new int[n];
        int i;
        for(i=0;i<n;i++)
        {
            int x,y;
            x=sc.nextInt();
            y=sc.nextInt();
            matrix[x][y]=1;
            matrix[y][x]=1;
        }
        sc.close();
        bfs(0);
    }
}
