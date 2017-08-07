package example;
import java.util.Scanner;
/**
 * Created by lyk on 2017/8/7.
 * Package name: example
 * Porject name: untitled1
 */
public class Prim {

    public static void prim(int n,float[][] c){
        float[] lowcost=new float[n+1];
        int[] closest=new int[n+1];//表示i到其他所有未添加进来的顶点的最短距离
        boolean[] s=new boolean[n+1];//

        //初始化
        s[1]=true;
        for(int i=2;i<=n;i++){
            lowcost[i]=c[1][i];
            closest[i]=1;
            s[i]=false;
        }
        for(int i=1;i<n;i++){//循环n-1次
            float min=Float.MAX_VALUE;
            int j=1;
            for(int k=2;k<=n;k++){
                if(lowcost[k]!=-1&&(lowcost[k]<min)&&(!s[k])){
                    min=lowcost[k];
                    j=k;
                }
            }
            System.out.println(closest[j]+", "+j);
            s[j]=true;//将j添加到S中
            //逐个更改lowcost[k],如果c[j][k]<lowcost[k]则更改lowcost[k]为最小
            for(int k=2;k<=n;k++){
                if(!s[k]&&c[j][k]!=-1){
                    if(c[j][k]<lowcost[k]||lowcost[k]==-1){
                        lowcost[k]=c[j][k];
                        closest[k]=j;
                    }
                }

            }
        }

    }
    public static void main(String[] args) {
        System.out.println("请输入图顶点的个数：");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        int n = Integer.parseInt(line);
        System.out.println("请输入图的路径长度：");
        float[][] c = new float[n+1][n+1];//下标从1开始，以下都是,不连通的用-1表示
        for(int i=0;i<n;i++){
            line =  sc.nextLine();
            String[] ds = line.split(",");
            for(int j = 0;j<ds.length;j++){
                c[i+1][j+1]=Float.parseFloat(ds[j]);
            }
        }
        System.out.println("依次构成树的边为（用两个顶点表示边）：");
        prim(n,c);
    }
}
