package ngdemo;

import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;

public class ConstructorSampleTest {

     @Test
     public void test() {

      new MockUp<ConstructorSample>() {

            @Mock void $init() {
             System.out.println("★コンストラクタ差し替え★");
            }
      };

      new ConstructorSample();
     }
}
