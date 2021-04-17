import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTest extends TestBase{

    @BeforeMethod
    public void preconditions(){
        if(isElement(By.cssSelector("[href='/login']"))){
            login("Mona447233@mail.com","Mona12$447233");
        }
    }

    @Test(invocationCount = 3)
    public void addContact(){
        int index=(int)((System.currentTimeMillis()/1000) % 10000);
        wd.findElement(By.cssSelector("[href='/add']")).click();

        fillByLocator(By.cssSelector("[placeholder='Name']"),"Lola"+index);
        fillByLocator(By.cssSelector("[placeholder='Last Name']"),"Now"+index);
        fillByLocator(By.cssSelector("[placeholder='Phone']"),"9876"+index);
        fillByLocator(By.cssSelector("[placeholder='email']"),"Lola"+index+"@mail.ru");
        fillByLocator(By.cssSelector("[placeholder='Address']"),"Haifa/"+index);
        fillByLocator(By.cssSelector("[placeholder='description']"),"university friend");

        wd.findElement(By.cssSelector(".add_form__2rsm2 button")).click();
        pause(1500);

    }
    @AfterMethod
    public void postconditions(){
wd.findElement(By.cssSelector("button")).click();
    }
}
