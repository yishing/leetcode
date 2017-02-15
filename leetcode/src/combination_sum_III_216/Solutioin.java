package combination_sum_III_216;
import java.util.List;
import java.util.ArrayList;
public class Solutioin {
	public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans=new ArrayList<List<Integer>>();
        if(n==0||k==0) return ans;
        List<Integer> list=new ArrayList<Integer>();
        backtrack(ans,list,1,n,k,n);
        return ans;
   }
   public void backtrack(List<List<Integer>> ans,List<Integer> list,int index,int target,int k,int n){
        if(k==0&&target==0){
           ans.add(new ArrayList<Integer>(list));
           return ;
       }
       if(index>9) return ;
      
       if(k<0||target<0) return;
       list.add(index);
       
       backtrack(ans,list,index+1,target-index,k-1,n);
       list.remove(list.size()-1);
        backtrack(ans,list,index+1,target,k,n);
   }
}
