import java.util.ArrayList;
public class AdditiveNumber {
  
  public static void getAdditiveNo(int start, int end){
    for(int i=1;i<=end;i++){
      ArrayList<Integer> list=new ArrayList<Integer>();
      int temp1=start;
      list.add(temp1);
      int temp2=i+start;
      while(temp2<=end){
        list.add(temp2);
        int sum=temp1+temp2;
        temp1=temp2;
        temp2=sum;
      }
      if(list.size()>1&&temp1==end) System.out.println(list.toString());
    }
  }
  
  public static void main(String[] args){
    getAdditiveNo(1,21);
  }

}
