import java.util.*;
/*
 * Write a program to add the substring. 
 * eg :say you have a list {1 7 6 3 5 8 9 }
 * and user is entering a sum 16. Output should display(2-4) that is {7 6 3} 
 * cause 7+6+3=16.
 */

public class substringAddition{
	public static void main(String[] args){
		int[] list = {1, 7, 6, 3, 5, 8, 4};
		int target = 12;
		sub(list,target);
	}

	public static void sub(int[] input, int sum){
		int left=0, count=0;
		List<String> res = new ArrayList<String>();
		for(int i=0;i<input.length;i++){
			count += input[i];
			if(count==sum){
				String temp = "";
				for(int k=left;k<i;k++){
					temp += input[k]+" ";
				}
				temp += input[i];
				res.add(temp);
			}else{
				if(count>sum){ // be careful here, left shrink may result in equal to sum
					count -= input[left];
					left++;
					if(count==sum){
						String temp = "";
						for(int k=left;k<i;k++){
							temp += input[k]+" ";
						}
						temp += input[i];
						res.add("("+(left+1)+"-"+(i+1)+")  "+temp);
					}
				}
			}
		}
		for(String content:res){
			System.out.println(content);
		}
	}
}