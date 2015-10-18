import java.util.ArrayList;
import java.util.HashSet;

/**Colorful Number
 * A number can be broken into different sub-sequence parts. Suppose a number
 * 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245. And this number
 * is a colorful number, since product of every digit of a sub-sequence are
 * different. That is,3 2 4 5 (3*2)=6 (2*4)=8 (4*5)=20 (3*2*4)= 24 (2*4*5)= 40.
 * But 326 is not a colorful number as it generates 3 2 6 (3*2)=6 (2*6)=12. You
 * have to write a function that tells if the given number is a colorful number
 * or not.
 */

public class ColorfulNumber{
	public static boolean isColorful(int num){
		if(num<10){
			return true;
		}
		ArrayList<Integer> list = new ArrayList<Integer>();
		while(num!=0){
			list.add(num%10);
			num = num/10;
		}
		HashSet<Integer> set = new HashSet<Integer>();
		for(int i=0;i<list.size();i++){
			for(int j=0;j<list.size()-i;j++){
				int product = 1;
				for(int k=0;k<=i;k++){//计算乘积
					product = product * list.get(j+k);
				}
				if(set.contains(product)){
					return false;
				}
				set.add(product);
			}
		}
		return true;

	}
	public static void main(String[] args){
		
		System.out.println(isColorful(128));
	}

}
