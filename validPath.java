class Solution {
    static class Edge{
        int src;
        int dest;

        public Edge(int s,int d){
            this.src=s;
            this.dest=d;
        }
    }

    public boolean validPathUtil(List<Edge> graph[],int src,int dest,boolean vis[]){
        if(src==dest){
            return true;
        }
        vis[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!vis[e.dest]&&validPathUtil(graph,e.dest,dest,vis)){
                return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<Edge> graph[]=new ArrayList[n];
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
        for(int[] e:edges){
            graph[e[0]].add(new Edge(e[0],e[1]));
            graph[e[1]].add(new Edge(e[1],e[0]));
        }
        if(source==destination){
            return true;
        }
        return validPathUtil(graph,source,destination,vis);
    }
}
