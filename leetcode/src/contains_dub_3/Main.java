package contains_dub_3;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A={1,3,4,5,6,7,8};
		//boolean ans=Solution.containsNearbyAlmostDuplicate(A, 4, 1);
		//System.out.println(ans);
		List<Integer> an=new ArrayList<Integer>();
		an.add(3);
		an.add(2);
		an.add(1);
		an.add(0);
		//System.out.println(an);
		an.remove(3);
	//	System.out.println(an);
		int i=4;
		int x=1;
		while(x<=i){
			i=i^x;
			x=x*2;
		}
		System.out.println(i);
		

	}

}
