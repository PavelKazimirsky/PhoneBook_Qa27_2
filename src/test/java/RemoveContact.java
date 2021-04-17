import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContact extends TestBase{

    @BeforeMethod
    public void preconditions(){
        // Log in if necessary
        if(isElement(By.cssSelector("[href='/login']"))){
            login("Mona447233@mail.com","Mona12$447233");
        }
        // Open CONTACTS page
        wd.findElement(By.cssSelector("[href='/contacts']")).click();
    }

    @Test
    public void removeOneContact(){
        WebElement contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
        ClickAndRemove(contact);
    }

    @Test
    public void removeAllContacts(){
        WebElement contact;
        do {
            try {
                contact = wd.findElement(By.cssSelector(".contact-item_card__2SOIM"));
            } catch (Exception e) {
                // Contact element not found - nothing to remove
                return;
            }
            ClickAndRemove(contact);
            wd.navigate().refresh(); // without refresh() removes 1 or 2 items and fails...
        } while (true);
    }

    private void ClickAndRemove(WebElement contact) {
        contact.click();
        WebElement removeBtn= wd.findElement(By.cssSelector(".contact-item-detailed_card__50dTS button:last-of-type"));
        removeBtn.click();
    }

    @AfterMethod
    public void postConditions(){

    }
}
