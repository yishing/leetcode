package set_matrix_zero;

public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return;
        boolean firstrow0=false;
        boolean firstcol0=false;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                firstcol0=true;
                break;
            }
        }
        for(int i=0;i<matrix[0].length;i++){
            if(matrix[0][i]==0){
                firstrow0=true;
                break;
            }
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][0]==0){
                for(int j=1;j<matrix[0].length;j++){
                    matrix[i][j]=0;
                }
            }
        }
        for(int j=0;j<matrix[0].length;j++){
            if(matrix[0][j]==0){
                for(int i=0;i<matrix.length;i++){
                    matrix[i][j]=0;
                }
            }
        }
        if(firstrow0){
            for(int i = 0; i < matrix[0].length; i++){
                matrix[0][i] = 0;
            }           
        }
        
        if(firstcol0){
            for(int i = 0; i < matrix.length; i++){
                matrix[i][0] = 0;
            }           
        }
    }
}
