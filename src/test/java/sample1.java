
import com.microsoft.playwright.*;
import com.microsoft.playwright.options.AriaRole;
import com.microsoft.playwright.options.LoadState;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;
public class sample1
{
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

              Page page = browser.newPage();
//            page.waitForLoadState();
//            page.waitForLoadState(LoadState.LOAD);

            page.navigate("https://qa-www.lufthansa.com/de/en/homepage");
            //page.navigate("https://qa-www.austrian.com/de/en/homepage");
            page.locator("//button[@id='cm-acceptAll']").click();   // pop up handled
            page.locator("//span[text()='Login']").click();         // click on login at top portion
            page.locator("(//span[text()='Register for Travel ID'])[1]").click(); // click Register for Travel ID
            //page.waitForLoadState();
            page.locator("//input[@id='id-email-textfield']").fill("oneidbasic6752@yopmail.com"); // email
            page.locator("//input[@type='password']").fill("Test@123");    // password
            page.locator("//button[@name='createAccount_next']").click();       // login button
            page.locator("//span[text()='Connect later']").click();             // for basic click connect later
            page.locator("//input[@name='firstName']").fill("Kiya");      // Enter firstname
            page.locator("//input[@name='lastName']").fill("Arya");       // Enter lastname
            page.locator("//input[@name='birthday']").fill("01");         // Enter date
            page.locator("//input[@name='birthmonth']").fill("01");       // Enter month
            page.locator("//input[@name='birthyear']").fill("1991");      // Enter year
            page.locator("//button[@name='personalInformation_next']").click(); // Click on continue after filling deatils
            page.locator("(//label[text()='Yes, I give my consent.'])[2]").click();//radio consent
            page.locator("//span[text()='Confirm and continue']").click();      // Click confirm & continue
             page.waitForLoadState();
            page.waitForLoadState(LoadState.LOAD);
            page.waitForTimeout(7000);

            Page page1 = browser.newPage();
            page1.navigate("https://yopmail.com/en/");   // Go to yopmail
            page1.locator("//input[@id='login']").fill("oneidbasic246@yopmail.com");     // Enter id
            page1.locator("//i[@class='material-icons-outlined f36']").click();
            page1.waitForLoadState();
            page1.waitForLoadState(LoadState.LOAD);
            page1.locator("//*[@id=\"mail\"]/div/table/tbody/tr/td[1]/table/tbody/tr[2]/td/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/span/text()[3]").textContent();
           // page1.getByRole('link').allTextContents();
            page.waitForTimeout(5000);

        }
    }
}

