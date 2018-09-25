package leetcode;

/**
 * Created by lyk on 2018-9-25.
 * Package name: leetcode
 * Porject name: untitled1
 */
public class ScoreAfterFlippingMatrix {
    public int matrixScore(int[][] A) {

        this.moveLine(A);
        this.moveColumn(A);
        return this.countResult(A);

    }


    public int countResult(int[][] A){
        int i,j,index,count,result=0;
        for(i=0;i<A.length;i++){
            count=0;
            j=A[0].length-1;
            while(j>=0){
                index=0;
                while(index<count){
                    A[i][j]=A[i][j]*2;
                    index++;
                }
                result=result+A[i][j];
                count++;
                j--;
            }
        }
        return result;
    }


    public void moveColumn(int[][] A){     //返回所有行二进制数之和
        int i,j,zeroCount,oneCount;
        for(j=0;j<A[0].length;j++){
            zeroCount=0;
            oneCount=0;
            for(i=0;i<A.length;i++){
                switch(A[i][j]){
                    case 0:
                        zeroCount++;
                        break;
                    case 1:
                        oneCount++;
                        break;
                    default:break;
                }
            }
            if(zeroCount>oneCount){     //在矩阵中进列行移动
                i=0;
                while(i<A.length){
                    if(A[i][j]==0){
                        A[i][j]=1;
                    }else{
                        A[i][j]=0;
                    }
                    i++;
                }
            }
        }
    }


    public void moveLine(int[][] A){    //在矩阵中进行行移动
        int i,j;
        for(i=0;i<A.length;i++){
            if(A[i][0]==0){
                for(j=0;j<A[0].length;j++){
                    if(A[i][j]==0){
                        A[i][j]=1;
                    }else{
                        A[i][j]=0;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ScoreAfterFlippingMatrix safm = new ScoreAfterFlippingMatrix();
        int[][] a = new int[][]{
                {0,0,1,1},
                {1,0,1,0},
                {1,1,0,0}
        };
        System.out.println(safm.matrixScore(a));
    }
}
