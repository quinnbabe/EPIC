
/**Write a program to 
 * display the advisered average for the list of numbers 
 * my omitting the three largest number in the series.
 * E.g:3,6,12,55,289,600,534,900,172. 
 * avg=(3+6+12+55+289+172)/6 
 * and eliminating534,900,600
 * 
 * */
public class AdviseredAverageNumber {
	public static void getAdviseredAverage(int[] arr){
		if(arr==null || arr.length<4){
			System.out.println("Wrong Input");
			return;
		}
		int[] max = {arr[0], arr[1], arr[2]};
		for(int i=0;i<2;i++){
			for(int j=i+1;j<3;j++){
				if(max[i]>max[j]){
					int tmp = max[i];
					max[i] = max[j];
					max[j] = tmp;
				}
			}
		}
		int sum = arr[0]+arr[1]+arr[2];
		for(int i=3;i<arr.length;i++){
			sum = sum+arr[i];
			if(arr[i]>=max[2]){
				max[0] = max[1];
				max[1] = max[2];
				max[2] = arr[i];
			}
			else if(arr[i]>=max[1]){
				max[0] = max[1];
				max[1] = arr[i];
			}else if(arr[i]>max[0]){
				max[0] = arr[i];
			}
		}
		for(int i=0;i<3;i++){
			sum = sum - max[i];
		}
		
		double average = 1.0*sum / (arr.length-3);
		System.out.println("Three Largest number are: "+ max[2] +", "+ max[1]+", "+max[0]);
		System.out.println("Advisered Average: "+average);
	
	}
	public static void main(String[] args) {
		int[] A = {3,6,12,55,289,600,534,900,172};
		getAdviseredAverage(A);

	}

}
