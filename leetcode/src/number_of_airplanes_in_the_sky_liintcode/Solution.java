package number_of_airplanes_in_the_sky_liintcode;

import java.util.ArrayList;
import java.util.Collections;
//import java.util.Co
import java.util.Comparator;
import java.util.List;
// Definition of Interval:
   class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
   }
 
 class SearchLine{
     public int pos;
     public int start;
     public SearchLine(int _p,int _s){
         start=_s;
         pos=_p;
     }
     public static Comparator<SearchLine> PointComparator  = new Comparator<SearchLine>(){
      public int compare(SearchLine s1, SearchLine s2){
        if(s1.pos == s2.pos) return s1.start - s2.start;
        else return s1.pos - s2.pos;
      }
    };
 }

class Solution {
    /**
     * @param intervals: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) { 
        // write your code here
       List<SearchLine> list=new ArrayList<SearchLine>();
       for(Interval i: airplanes){
           list.add(new SearchLine(i.start,1));
           list.add(new SearchLine(i.end,0));
           
       }
       Collections.sort(list,SearchLine.PointComparator );
       int count=0;
       int ans=0;
       for(SearchLine i:list){
           if(i.start==1) count++;
           else count--;
           ans=Math.max(count,ans);
       }
       return ans;
        
    }
}