package pacific_atlantic_water_flow_417;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {
	    public List<int[]> pacificAtlantic(int[][] matrix) {
	      List<int[]> res = new LinkedList<>();
	         if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
	            return res;
	        }
	     //   boolean[][] viested=new boolean[matrix.length][matrix[0].length];
	        boolean[][] pa=new boolean[matrix.length][matrix[0].length];
	        boolean[][] atl=new boolean[matrix.length][matrix[0].length];
	        for(int i=0;i<matrix.length;i++){
	            dfs(matrix,pa,i,0,Integer.MIN_VALUE);
	            dfs(matrix,atl,i,matrix[0].length-1,Integer.MIN_VALUE);
	        }
	         for(int i=0;i<matrix[0].length;i++){
	            dfs(matrix,pa,0,i,Integer.MIN_VALUE);
	            dfs(matrix,atl,matrix.length-1,i,Integer.MIN_VALUE);
	        }
	         for(int i=0;i<matrix.length;i++){
	        	 for(int j=0;j<matrix[0].length;j++){
	        		 if(pa[i][j]&&atl[i][j]){
	        			 res.add(new int[] {i,j});
	        		 }
	        	 }
	         }
	         return res;
	        
	    }
	     int[][] move=new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
	    public void dfs(int[][] matrix,boolean[][] visted,int i,int j,int height){
	        if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||visted[i][j]||matrix[i][j]<height) return;
	         visted[i][j]=true;
	        for(int k=0;k<4;k++){
	            int newx=i+move[k][0];
	            int newy=j+move[k][1];
	            dfs(matrix,visted,matrix[i][j],newx,newy);
	        }
	    }
	}