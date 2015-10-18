import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


/**
 * Given a string of RGB value (rr, gg, bb) which represents in hexadecimal.
 * Compare if rr or gg or bb is the biggest, or two of those values are equal
 * and larger than the third one, or three values are equal with each other.
 */
public class RGBCompare {
	private static class Node{
		char color;
		int number;
		public Node(char c, int n){
			this.color=c;
			this.number=n;
		}
	}
	public static void rgbCompare(String str){
		int r=0;
		int g=0;
		int b=0;
		r = 16*getN(str.charAt(0))+getN(str.charAt(1));
		g = 16*getN(str.charAt(2))+getN(str.charAt(3));
		b = 16*getN(str.charAt(4))+getN(str.charAt(5));
		
		ArrayList<Node> list = new ArrayList<Node>();
		list.add(new Node('R', r));
		list.add(new Node('G', g));
		list.add(new Node('B', b));
	
		Collections.sort(list,new Comparator<Node>(){
			public int compare(Node n1, Node n2){
				return n1.number-n2.number;
			}
		});
		if(list.get(0).number==list.get(2).number){
			System.out.println("Three Equal!");
		} else if(list.get(2).number==list.get(1).number){
			System.out.println(list.get(1).color+ " and "+list.get(2).color+" is larger than "+list.get(0).color);
		}else {
			System.out.println(list.get(2).color+" is largest, second largest is "+list.get(1).color+", smallest is "+list.get(0).color+".");
		}
	}
	
	private static int getN(char c){
		if('0'<=c && c<='9'){
			return c-'0';
		}
		return c-'a'+10;
	}
	public static void main(String[] args) {
		rgbCompare("010202");
		rgbCompare("030201");
		rgbCompare("ffffff");
	}

}
