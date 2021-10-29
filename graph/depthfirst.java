import java.util.*;
class depthfirst{
    
    static int n;
    static int matrix[][];
    static boolean visited[];
    static int f=0,r=-1;
    static int queue[];
    static void dfs(int val){
        int i;
        visited[val]=true;
        if(visited[val]!=false)
        System.out.println(val);
        for(i=0;i<n;i++)
        {
            if(matrix[val][i]!=0 && visited[i]!= true)
            dfs(i);
        }
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
        dfs(0);
    }
}
