package com.example.kpp;


import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import mockit.Mock;
import mockit.MockUp;
import mockit.Mocked;
import mockit.NonStrictExpectations;

import org.junit.Test;

public class Sample01Test {
    /** モック  */
    @SuppressWarnings("unused")
     @Mocked
     private Sample01 mockSample01;

     /**
      * {@link jp.co.net.genesis.sample.Sample01#doTest(java.lang.String[])} のためのテスト・メソッド。
      */
     @Test
     public void testDoTest() {

      new NonStrictExpectations() {{
       mockSample01.doTest(); result = "モック";
            }};

            System.out.println(mockSample01.doTest());

     }
     @Test
     public void testReturnGenesis() {
      new NonStrictExpectations() {{
          Sample01.returnGenesis(); result = "ジェニシス";
      }};
            assertThat(Sample01.returnGenesis(), is("ジェニシス"));
     }
     @Test
     public void testCreateFile() {
      new MockUp<Sample01>() {
       @Mock
       void sendMail() {
        System.out.println("ファイル削除(差し替え)");
       }
      };
      //メール送信
      Sample01 manager = new Sample01();
      manager.sendMail();
     }
}
