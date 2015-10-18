import java.util.*;
/*
 * Suppose you want to do the subtraction of two numbers. Each digit of 
 * the numbers is divided and put in an array. Like A=[1,2, 3, 4, 5], 
 * B=[4, 5, 3, 5]. You should output an array C=[7, 8, 1, 0].Remember 
 * that your machine can’t hand numbers larger than 20.
 * 
 * http://www.cnblogs.com/superbo/p/4107320.html
 */

public class substractionOfTwoArrays{
	//support A<B, A=B, A>B, but A>=0 & B>=0
	public static void main(String[] agrs){
		int[] a = {1, 0, 0, 0, 0, 0};
		int[] b = {1};
		char[] c = {'2','1','2','3','4','7'};
		System.out.println(substract(a,b));
	}

	public static String substract(int[] A, int[] B){
		if(A.length < B.length){
			return "-"+substract(B,A); //if B>A, return -(B-A)
		}
		int[] res = new int[Math.max(A.length, B.length)];
		int carry = 0;
		int pointer1 = A.length-1, pointer2 = B.length-1, pointer3 = res.length-1;
		while(pointer1>=0 && pointer2>=0){
			if(A[pointer1] - carry >= B[pointer2]){ // no carry
				res[pointer3] = A[pointer1] - carry - B[pointer2];
				pointer1--;
				pointer2--;
				pointer3--;
				carry = 0;
				continue;
			}
			if(A[pointer1] - carry < B[pointer2]){ // carry
				res[pointer3] = 10 + A[pointer1] - carry - B[pointer2];
				pointer1--;
				pointer2--;
				pointer3--;
				carry = 1;
				continue;
			}
		}
		if(pointer1<0 && carry == 1){
			return "-"+substract(B,A); // B>A
		}else{
		while(pointer1>=0){
			if(A[pointer1] == 0 && carry == 1){ // still one carry and curr=0(special case)
				A[pointer1-1]--;
				carry = 0;
				res[pointer3] = 9;
				pointer1--;
				pointer3--;
			}else{
				if(carry==1){
					res[pointer3] = A[pointer1]-carry;
					carry=0;
				    pointer1--;
				    pointer3--;
				}else{
					res[pointer3] = A[pointer1];
					pointer1--;
					pointer3--;
				}
				
			}
		}
		int num = 0; //construct the num
		int pow = 1;
		for(int i=res.length-1;i>=0;i--){
			num += pow*res[i];
			pow *= 10;
		}
		return String.valueOf(num);
	}
	}
}