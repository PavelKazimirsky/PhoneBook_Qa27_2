import org.testng.annotations.Test;

public class Registration extends TestBase{

    @Test
    public void registrationTest(){
        // email = ""
        //pass=""
      int index= (int)((System.currentTimeMillis()/1000) % 10000);
      String email= "Tom" + index + "@gamil.com";
      String password = "Tom$" + index;

    }

}
