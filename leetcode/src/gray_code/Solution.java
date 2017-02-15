package gray_code;

import java.util.LinkedList;
import java.util.List;

public class Solution {
	public static List<Integer> grayCode(int n) {
	    List<Integer> result = new LinkedList<>();
	    for (int i = 0; i < 1<<n; i++) {result.add(i ^ i>>1);
	    System.out.println(i ^ i>>1);}
	    return result;
	}

}
