package can_I_Win_464;

import java.util.Arrays;
import java.util.HashMap;

public class Solution {
	public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if((maxChoosableInteger+1)*maxChoosableInteger/2<desiredTotal) return false;
        if(desiredTotal<=0) return true;
        int[] used=new int[maxChoosableInteger];
        HashMap<String,Boolean> map=new HashMap<String,Boolean>();
        return canWin(map,desiredTotal,maxChoosableInteger,used);
    }
    public boolean canWin(HashMap<String,Boolean> map,int desiredTotal,int maxCh,int[] used){
        if(desiredTotal<=0) return false;
        String key=Arrays.toString(used);
        if(!map.containsKey(key)){
            for(int i=0;i<maxCh;i++){
                if(used[i]==0){
                    used[i]=1;
                    if(!canWin(map,desiredTotal-(i+1),maxCh,used)){
                        map.put(key,true);
                        used[i]=0;
                        return true;
                    }
                    used[i]=0;
                }
                
            }
            map.put(key,false);
            return false;
        }
        else{
            return map.get(key);
        } 
    }
}
