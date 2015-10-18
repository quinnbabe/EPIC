
/**
 * Given a number find whether the digits in the number can be used to form an
 * equation with + and '='. That is if the number is123, we can have an equation
 * of 1+2=3. But even the number 17512 also forms the equation 12+5=17.
 */
public class PlusEqualNumber {
	public static void plusEqual(int number){
		String numberString = number+"";
		
		for(int i=1;i<numberString.length()-1;i++){
			for(int j=i+1;j<numberString.length();j++){
				int[] list = new int[3];
				list[0] = Integer.parseInt(numberString.substring(0,i));
				list[1] = Integer.parseInt(numberString.substring(i,j));
				list[2] = Integer.parseInt(numberString.substring(j,numberString.length()));
				
				for(int k=0;k<2;k++){
					if(list[k]>list[k+1]){
						int tmp = list[k];
						list[k] = list[k+1];
						list[k+1] = tmp;
					}
				}
				if(list[2] == list[0]+list[1]){
					System.out.println("Find "+number+": "+ list[0] +" + "+list[1]+" = "+list[2]);
					return;
				}
				
			}
		}
		System.out.println("Not found");
	}

	public static void main(String[] args) {
		plusEqual(17512);
	}

}
