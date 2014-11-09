package ngdemo;

import mockit.Mock;
import mockit.MockUp;

import org.junit.Test;

public class MailManagerTest {
    @Test
     public void testCreateFile() {
      new MockUp<MailManager>() {
       @Mock
       void sendMail() {
        System.out.println("ファイル削除(差し替え)");
       }
      };
      //メール送信
      MailManager manager = new MailManager();
      manager.sendMail();
     }
}
