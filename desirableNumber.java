import java.util.*;
/*
 * A number is called 'desirable' if all the digits are strictly 
 * ascending eg: 159 as 1<5<9. You know that your rival has a strictly 
 * numeric password that is 'desirable'. Your close ally has given 
 * you the number of digits (N) in your rival's password.takes in 'N' as 
 * input and prints out all possible 'desirable' numbers that can be 
 * formed with N digits.
 */

public class desirableNumber{
	//recursive method
	public static void main(String[] args){
		generate(3);
	}

	public static void generate(int num){
		List<String> res = new ArrayList<String>();
		generate(res,0,num,"");
		for(String s:res){
			System.out.print(s+",");
		}
	}

	public static void generate(List<String> res, int pos, int num, String pre){
		if(num == 0){
			res.add(pre);
			return;
		}
		for(int i=pos;i<10;i++){
			generate(res,i+1,num-1,pre+i);
		}
	}
}