package valid_number_65;

public class Solution {
    public boolean isNumber(String s) {
        s=s.trim();
        if(s==null||s.length()==0) return false;
        int i=0;
        if(s.charAt(0)=='+'){
             i++;
        }
        else  if(s.charAt(0)=='-'){
             i++;
        }
        boolean dotseen=false;
        boolean eseen=false;
        boolean havedigit=false;
        boolean numberaftere=false;
        for(;i<s.length();i++){
            if(s.charAt(i)>='0'&&s.charAt(i)<='9') {
                // continue;
                havedigit=true;
                numberaftere=true;
                continue;
            }
            else if(s.charAt(i)=='.'){
                if(dotseen||eseen) return false;
                dotseen=true;
            }
            else if(s.charAt(i)=='e'){
                 if(!havedigit||eseen) return false;
                 eseen=true;
                 numberaftere=false;
            }
            
            else if(s.charAt(i)=='+'||s.charAt(i)=='-'){
                if(i>0&&s.charAt(i-1)!='e'){
                    return false;
                }
                
            }
            else return false;
        }
        return havedigit&&numberaftere;
        
    }
}
