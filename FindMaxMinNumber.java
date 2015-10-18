/**Find Max/Min Number:
 * Take a series of integers as input till a zero is entered. Among these given
 * integers, find the maximum of the odd numbers and the minimum of the even
 * integers (not including zero) and print them.
 */
public class FindMaxMinNumber {
	
	public static void findNumber(int[] arr){
		int maxOdd = Integer.MIN_VALUE+1;
		int minEven = Integer.MAX_VALUE-1;
		
		int position = 0;
		while(position<arr.length ){
			if(arr[position]%2==0){//even
				if(arr[position]==0){
					break;
				}
				if(arr[position]<minEven){
					minEven = arr[position];
				}
			}else{
				if(arr[position]>maxOdd){
					maxOdd = arr[position];
				}
			}
			position++;
		}
		System.out.println("MAX ODD = "+maxOdd+", MIN EVEN = "+minEven);
	}

	public static void main(String[] args) {
		int[] arr = {1,3,-4,5,2,5,-1,-3,19,100,0};
		findNumber(arr);
	}

}
