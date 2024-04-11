package randomizedtest;

import edu.princeton.cs.algs4.StdRandom;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by hug.
 */
public class TestBuggyAList {
  // YOUR TESTS HERE
  public void randomizedTest(){
      AListNoResizing<Integer> L = new AListNoResizing<>();
      BuggyAList<Integer> M = new BuggyAList<>();
      int N = 5000;
      for (int i = 0; i < N; i += 1) {
          int operationNumber = StdRandom.uniform(0, 4);
          if (operationNumber == 0) {
              // addLast
              int randVal = StdRandom.uniform(0, 100);
              L.addLast(randVal);
              M.addLast(randVal);
              System.out.println("addLast(" + randVal + ")");
          } else if (operationNumber == 1) {
              // size
              int size1 = L.size();
              int size2 =M.size();
              System.out.println("L.size:" + size1+"    M.size:" + size2);
          } else if (operationNumber == 2) {
              if(L.size()>0){
                  int removed1=L.removeLast();
                  int removed2=M.removeLast();
                  assertEquals(removed1,removed2);
                  System.out.println("removed item:"+removed1);
              }
          }else if (operationNumber == 3) {
              if(L.size()>0){
                  System.out.println("getLast from L:"+L.getLast());
                  System.out.println("getLast from M:");
                  assertEquals(L.getLast(),M.getLast());
              }
          }
      }
  }

    public static void main(String[] args) {
       TestBuggyAList a =new TestBuggyAList();
       a.randomizedTest();
    }
}
