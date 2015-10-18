import java.util.*;
/*
 * Find thelargest sum contiguous sub array. The length of 
 * the returned sub array must beat least of length 2.
 */
 
 public class largestSumSubArray{
 	
 	public static void main(String[] args){
 		int[] array = {
			-2, 1, -3, 2, 5, -5, 4
		};
		find(array);
 	}
 	
 	public static void find(int[] num){
 		int maxEndingHere = num[0];
 		int max = num[0];
 		List<Integer> res = new ArrayList<Integer>();
 		String result = "";
 		for(int i=1;i<num.length;i++){
 			if(maxEndingHere+num[i]>num[i]){
 				res.add(num[i]);
 			}else{
 				res = new ArrayList<Integer>();
 				res.add(num[i]);
 			}
 			maxEndingHere = Math.max(maxEndingHere+num[i],num[i]);
 			if(maxEndingHere>max){
 				result = res.toString(); // be careful, this is pass by reference, so result and res point to the same object
 			}
 			max = Math.max(max,maxEndingHere);
 		}
 		System.out.println(result);
 	}
 	
}