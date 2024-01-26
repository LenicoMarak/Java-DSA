package Created;
import java.util.*;
public class SpiralMatrix{
    public void  printSpiralMatrix(int[][] n){
        List<Integer> list=new ArrayList<>();
        int topRow=0,botRow=n.length-1;
        int leftCol=0,rightCol=n[0].length-1;
        while(topRow<=botRow && leftCol<=rightCol){
            for(int i=leftCol;i<=rightCol;i++){
                list.add(n[topRow][i]);
            }
            topRow+=1;
            
            for(int j=topRow;j<=botRow;j++){
                list.add(n[j][rightCol]);
            }
            rightCol-=1;
            for(int k=rightCol;k>=leftCol;k--){
                list.add(n[botRow][k]);
            }
            botRow-=1;
            for(int l=botRow;l>=topRow;l--){
                list.add(n[l][leftCol]);
            }
            leftCol+=1;
          }
          System.out.println(list);
    }
    public void printNonZero(int[][] r){
        int cur=0;
        for(int i=cur;i<r[0].length;i++){
            System.out.print("[ ");  
            for(int j=0;j<r[0].length;j++){
               if(r[i][j]==0){
                    continue;
                }
                System.out.print(r[i][j]+" ");
            }
            System.out.println("]");  
            cur++;
        }
        System.out.println();
    }
    public void checkSparseMatrix(int[][] mat){
        int indic=0;
        int non_zero=0,zero=0;
        for(int i=indic;i<mat[0].length;i++){ 
            for(int j=0;j<mat[0].length;j++){
                if(mat[i][j]==0){
                    zero++;
                }
                if(mat[i][j]>0){
                    non_zero++;
                }
            }
            indic++;
        }
        System.out.println("Number of zeros: "+zero);
        System.out.println("Number of non-zeros: "+non_zero);
    }
    public void printMatrix(int[][] m){    
        for(int i=0;i<m.length;i++){
            System.out.print("[ ");  
            for(int j=0;j<m[0].length;j++){
                System.out.print(m[i][j]+" ");
            }
            System.out.println("]");  
        }
        System.out.println();
        
    }
    public static void main(String[] args){
        Scanner scan=new Scanner(System.in);
        SpiralMatrix obj=new SpiralMatrix();
        System.out.println("Enter the size of row: ");
        int r=scan.nextInt();
        System.out.println("Enter the size of column: ");
        int c=scan.nextInt();
        int[][] matrix=new int[r][c];
        System.out.println("Take any input: ");
        for(int i=0;i<r;i++){
           for(int j=0;j<c;j++){
            matrix[i][j]=scan.nextInt();
           }
        }
        
        scan.close(); 
        obj.checkSparseMatrix(matrix);
        obj.printMatrix(matrix);
        obj.printNonZero(matrix);
        //obj.printSpiralMatrix(matrix);
    }    
}
