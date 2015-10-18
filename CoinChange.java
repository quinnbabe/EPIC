/**Coin Change
 * Something cost $10.25 and the customer pays with a $20 bill, the program will
 * print out the most efficient "change-breakdown" which is 1 five, 4 ones, and
 * 3quarters. Find the minimum number of coins required to make change for a
 * given sum (given unlimited number of N different denominations coin)
 */
public class CoinChange {
	public static void coinChange(int sum, int[] coins){
		int[] check = new int[sum+1];
		for(int i=1;i<=sum;i++){
			check[i] = Integer.MAX_VALUE;
		}
		
		for(int i=1;i<=sum; i++){
			if(i-coins[0]<0){
				continue;
			}
			int min = check[i-coins[0]];
			//System.out.println(i+" "+(i-coins[0]));
			for(int j=1;j<coins.length;j++){
				if(i-coins[j]==0){
					min=0;
				}
				if(i-coins[j]>0){
					if(check[i-coins[j]]<min){
						min = check[i-coins[j]];
					}
				}
			}
			if(min<check[i]){
				check[i] = min + 1;
			}
		}
		System.out.println(check[sum]);
	}

	public static void main(String[] args) {
		int[] coins = {3,5,6,10};
		coinChange(20,coins);
	}
}
