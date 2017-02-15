package smallest_rectangle_enclosing_black_pixels_302;

public class Solution {
    public int minArea(char[][] image, int x, int y) {
        
        int leftmost=leftmost(image,0,y,true);
        int rightmost=rightmost(image,y,image[0].length-1,true);
        int topmost=leftmost(image,0,x,false);
        int bottommost=rightmost(image,x,image.length-1,false);
        System.out.println("leftmost"+leftmost);
         System.out.println(rightmost);
          System.out.println(topmost);
          System.out.println(bottommost);
        return (Math.abs(rightmost-leftmost)+1)*(Math.abs(topmost-bottommost)+1);
        
    }
    int leftmost(char[][] image, int min, int max, boolean horizontal) {
    int l = min, r = max;
    while (l < r) {
        int mid = l + (r - l) / 2;
        if (!hasBlack(image, mid, horizontal)) {
            l = mid + 1;
        } else {
            r = mid;
        }
    }
    return l;
}

int rightmost(char[][] image, int min, int max, boolean horizontal) {
    int l = min, r = max;
    while (l < r) {
        int mid = l + (r - l + 1) / 2;
        if (!hasBlack(image, mid, horizontal)) {
            r = mid - 1;
        } else {
            l = mid;
        }
    }
    return r;
}
boolean hasBlack(char[][] image,int mid,boolean horizontal){
    if(horizontal){
        for(int i=0;i<image.length;i++){
            if(image[i][mid]=='1') return true;
        }
    }
    else{
         for(int i=0;i<image[0].length;i++){
            if(image[mid][i]=='1') return true;
        }
    }
    return false;
}
}