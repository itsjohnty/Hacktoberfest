class M_Coloring
{
    // Function to determine if graph can be coloured with at most M colours
    // such that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n)
    {
        int[] colors=new int[n];
        Arrays.fill(colors,0);
        return solve(0,graph,colors,m,n);
    }
  
    private static boolean solve(int v, boolean[][] graph, int[] colors,int m, int n)
    {
        if(v==n)return true;
        
        for(int c=1;c<=m;c+=1)
        {
            if(isValid(v,c,graph,colors,n))
            {
                colors[v]=c;
                boolean res=solve(v+1,graph,colors,m,n);
                if(res)return true;
                colors[v]=0;
            }
        }
        return false;
    }
  
    private static boolean isValid(int v, int c, boolean[][] graph, int[] colors, int n)
    {
        for(int i=0;i<n;i+=1)
        {
            if(i!=v && graph[v][i]==true && colors[i]==c)return false;
        }
        return true;
    }
}
