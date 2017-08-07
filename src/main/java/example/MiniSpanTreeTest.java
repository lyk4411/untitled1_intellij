package example;

/**
 * Created by lyk on 2017/8/7.
 * Package name: example
 * Porject name: untitled1
 */
public class MiniSpanTreeTest {

    static int[][] graph={
            {1000,6,1,5,1000,1000},
            {6,1000,5,1000,3,1000},
            {1,5,1000,5,6,4},
            {5,1000,5,1000,1000,2},
            {1000,3,6,1000,1000,6},
            {1000,1000,4,2,6,1000},
    };
    static int v=0;
    static int[][] tree;
    public static void main(String[] args)
    {
        MiniSpanTree miniSpanTree=new MiniSpanTree();
        miniSpanTree.input(graph, v);
        tree=miniSpanTree.getTree();
        for(int i=0; i<graph.length-1; i++){
            System.out.println("边：" + tree[i][0] + "-" + tree[i][1] + " 权：" + tree[i][2]);
        }
    }
}


class MiniSpanTree
{
    private int[][] graph;
    private int v;
    private int[][] tree;
    private boolean[] s;
    void input(int[][] graph, int v)
    {
        this.graph=graph;
        this.v=v;
        tree=new int[graph.length-1][];
        s=new boolean[graph.length];
        for(boolean i : s) i=false;
        s[v]=true;
        calculate();
    }
    void calculate()
    {
        for(int i=0; i<graph.length-1; i++){
            int[][] edge ={{0,0,1000,},};
            for(int j=0; j<graph.length; j++){
                for(int k=0; s[j]==true && k<graph.length; k++){
                    if(s[k]==false && graph[j][k]<edge[0][2]){
                        edge[0][0]=j;
                        edge[0][1]=k;
                        edge[0][2]=graph[j][k];
                    }
                }
            }
            tree[i]=edge[0];
            s[tree[i][1]]=true;
        }
    }
    int[][] getTree()
    {
        return tree;
    }
}
