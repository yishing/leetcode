package sqrt_69;

public class Solution {
    public int mySqrt(int x) {
        // if(num==1) return 1;
        // long t=num/2;
        // while(t*t>num){
        //     t=(t+num/t)/2;
        // }
        // return (int)t;
//       if (x == 0)
//         return 0;
//     int left = 1, right =x;
//   while(true){
//       int mid=left+(right-left)/2;
//       if(mid>x/mid) right=mid-1;
//       else{ if((mid+1)>x/(mid+1)) return mid;
//       else left=mid+1;
//   }
//     }
    if(x==0)
        return 0;
    int h=0;
    while((long)(1<<h)*(long)(1<<h)<=x){
        h++;
    }
    h--;
    long cur=(1<<h);
    int b=h-1;
    while(b>=0){
        if((long)(cur|(1<<b))*(long)(cur|(1<<b))<=x){
            cur=cur|(1<<b);
        }
        b--;
    }
    return (int)cur;

    
}
}
