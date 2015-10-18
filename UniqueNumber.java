import java.util.List;
import java.util.ArrayList;
import java.util.HashSet;

public class UniqueNumber {
  public static List<Integer> getUnique(List<Integer> mylist){
    HashSet<Integer> myset=new HashSet<Integer>();
    for(int i=0;i<mylist.size();i++){
      if(!myset.contains(mylist.get(i))){
        myset.add(mylist.get(i));
      }
      else{
        mylist.remove(i);
        i--;
      }
    }
    return mylist;
  }
  
  public static void main(String[] args){
    List<Integer> mylist=new ArrayList<Integer>();
    mylist.add(1);
    mylist.add(1);
    mylist.add(3);
    mylist.add(2);
    mylist.add(5);
    mylist.add(1);
    mylist.add(5);
    mylist.add(2);
    System.out.println(getUnique(mylist));
  }

}
