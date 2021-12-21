package StepDefinitions;


import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.security.Key;
import java.sql.Timestamp;

import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import gherkin.lexer.Th;
import io.cucumber.java.DataTableType;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.math3.analysis.function.Exp;
import org.apache.maven.execution.DefaultRuntimeInformation;
import org.junit.Assert;
import org.junit.runner.RunWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utils.BaseClass;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
public class stepDefinitions extends BaseClass {
    public Properties Pro;
    public WebDriverWait five;
    public WebDriverWait ten;
    public WebDriverWait fifteen;
    public WebDriverWait twenty;
    public WebDriverWait twentyfive;
    public WebDriverWait thirty;
    public WebDriverWait thirtyfive;
    public WebDriverWait fourty;
    public WebDriverWait fourtyfive;
    public WebDriverWait fifty;
    public WebDriverWait fiftyfive;
    public WebDriverWait sixty;
    public WebDriverWait sixtyfive;
    public WebDriverWait seventy;
    public WebDriverWait seventyfive;
    public WebDriverWait eighty;
    public WebDriverWait eightyfive;
    public WebDriverWait ninety;
    public WebDriverWait ninetyfive;
    public WebDriverWait onehundred;
    public WebDriverWait twohundred;
    public WebDriverWait threehundred;
    public Actions actions;


    public static sharedatastep sharedata;
    public String ReferenceNumber = "IA000000046";

    public stepDefinitions(sharedatastep sharedata) {

        stepDefinitions.sharedata = sharedata;

    }

    @Before(order = 2)
    public void method1() throws Exception {
        Pro = new Properties();
        FileInputStream fls = new FileInputStream("src\\test\\resources\\global.properties");
        Pro.load(fls);
        driver = BaseClass.getDriver();
        actions = new Actions(driver);
        five = new WebDriverWait(driver, 5);
        ten = new WebDriverWait(driver, 10);
        fifteen = new WebDriverWait(driver, 15);
        twenty = new WebDriverWait(driver, 20);
        twentyfive = new WebDriverWait(driver, 25);
        thirty = new WebDriverWait(driver, 30);
        thirtyfive = new WebDriverWait(driver, 35);
        fourty = new WebDriverWait(driver, 40);
        fourtyfive = new WebDriverWait(driver, 45);
        fifty = new WebDriverWait(driver, 50);
        fiftyfive = new WebDriverWait(driver, 55);
        sixty = new WebDriverWait(driver, 60);
        sixtyfive = new WebDriverWait(driver, 65);
        seventy = new WebDriverWait(driver, 70);
        seventyfive = new WebDriverWait(driver, 75);
        eighty = new WebDriverWait(driver, 80);
        eightyfive = new WebDriverWait(driver, 85);
        ninety = new WebDriverWait(driver, 90);
        ninetyfive = new WebDriverWait(driver, 95);
        onehundred = new WebDriverWait(driver, 100);
        twohundred = new WebDriverWait(driver, 200);
        threehundred = new WebDriverWait(driver, 300);

    }

    public void switchToFrameBackoffice() {
        WebElement frame = fourty.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe")));
        driver.switchTo().frame(frame);
    }

    @Then("Switch to default")
    public void switchToDefault() {
        driver.switchTo().defaultContent();
    }

    @Then("^Verify success message \"([^\"]*)\"$")
    public void verify_success_message(String Message) throws Throwable {

        WebElement successMessage = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + Message + "')]")));
        if (successMessage.isDisplayed()) {
            System.out.println("Success message ('" + Message + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify error message \"([^\"]*)\"$")
    public void verify_error_message(String error) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        WebElement errorMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + error + "')]")));
        if (errorMessage.isDisplayed()) {
            //This will scroll the page till the element is found
            System.out.println("Error message ('" + error + "') has been displayed");
            Assert.assertTrue(true);
        } else {
            Assert.fail();
        }
    }

    @Then("^Verify no data is found in table$")
    public void verify_no_data_is_found_in_table() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        WebElement noDataXpath = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'No record(s) found.')]")));
        if (noDataXpath.isDisplayed()) {
            Assert.assertTrue("No data found in table", true);
        } else {
            Assert.assertFalse("Data found in table", false);
        }
    }

    @Given("^User navigates to the login page$")
    public void user_navigates_to_the_login_page() throws Throwable {
        driver.get(Pro.getProperty("MRA_BackOffice_URL"));
        driver.manage().window().maximize();
    }

    @When("^Enters the username \"([^\"]*)\" and password \"([^\"]*)\" to login$")
    public void enters_the_username_something_and_password_something_to_login(String username, String password) throws Throwable {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginForm:username"))).sendKeys(username);
        driver.findElement(By.id("loginForm:password")).sendKeys(password);
        driver.findElement(By.xpath("//button[span='Login']")).click();

    }

    @Then("^User logs out successfully$")
    public void user_logs_out_successfully() throws Throwable {
        driver.findElement(By.id("Logout")).click();

    }

    //---------------------------------------------------------------------Verify the Process of Assign Audit Case-----------------------------------------------------------------------------------------------//
    @Given("^Open CRM URL Module as \"([^\"]*)\"$")
    public void open_crm_url_module_as_something(String strArg1) throws Throwable {
//        driver = getDriver();
        driver.get("http://" + strArg1 + ":Passw0rd@trips-crm:5555/TripsWorkflow/main.aspx");
    }

    @And("^Close Popup Window$")
    public void close_Popup_Window() throws Throwable {

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        WebElement specificframe = (driver.findElement(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        WebDriverWait CloseWindow = new WebDriverWait(driver, 60);
        CloseWindow.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @And("^Click on Case management dropdown$")
    public void click_on_case_management_dropdown() throws Throwable {
        switch_to_frame0();
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Active Cases in Progress Overview')]"))).isDisplayed();
        switchToDefault();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"TabCS\"]/a/span")).click();
        Thread.sleep(1000);
    }

    @Then("^switch to frame0$")
    public void switch_to_frame0() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

    }

    @Then("^Click on reference number$")
    public void click_on_reference_number() {
        WebElement elementLocator = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"gridBodyTable\"]/tbody/tr/td[1]")));

        Actions actions = new Actions(driver);
        actions.doubleClick(elementLocator).perform();

        driver.switchTo().defaultContent();
    }

    @And("^wait for plan to load \"([^\"]*)\"$")
    public void wait_for_duplicate_check(String strArg1) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 200);
        driver.switchTo().defaultContent();
        Thread.sleep(3000);
        driver.switchTo().frame("contentIFrame1");
        WebElement frame = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_DebtManagementApplicationAngular")));
        driver.switchTo().frame(frame);
        WebElement DebtCaseSummary = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='" + strArg1 + "']")));
        Assert.assertTrue(DebtCaseSummary.isDisplayed());
    }

    @And("^clicks Submit button$")
    public void clicks_submit_button() throws Throwable {
        WebElement submitButton = ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/trips-app/div/app-debt-management/app-enforcement-process/div/div/form/div[4]/div/div/button")));

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        submitButton.click();

        Thread.sleep(500);
        driver.switchTo().defaultContent();
    }

    @Then("^switch to frame1$")
    public void switch_to_frame1() throws Throwable {
        driver.switchTo().defaultContent();
        WebDriverWait wait = new WebDriverWait(driver, 100);
        WebElement specificframe = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(2000);

    }

    @And("^Select Approval outcome value to Approve \"([^\"]*)\"$")
    public void select_approval_outcome_value_to_approve_something(String strArg1) throws Throwable {
        String approvalId = "header_process_tbg_" + strArg1 + "approval";
        WebElement dropDown = driver.findElement(By.id(approvalId));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Actions action = new Actions(driver);
        action.doubleClick(dropDown).perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @And("^Select Reject outcome dropdown value to Approve \"([^\"]*)\"$")
    public void select_reject_outcome_dropdown_value_to_approve_something(String strArg1) throws Throwable {
        String approvalId = "header_process_tbg_" + strArg1 + "approval";
        WebElement dropDown = driver.findElement(By.id(approvalId));
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        dropDown.click();
        Actions action = new Actions(driver);
        action.doubleClick(dropDown).perform();
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("^Enter Outcome Reason$")
    public void enter_Outcome_Reason() throws Throwable {
        Thread.sleep(2000);
        WebElement specificframe = (driver.findElement(By.id("WebResource_DebtManagementRejectionDataReferenceResource")));
        driver.switchTo().frame(specificframe);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.findElement(By.id("viewoption")).click();
        WebDriverWait ReasonValue = new WebDriverWait(driver, 60);
        ReasonValue.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"statuscode_i\"]/option[2]"))).click();

    }


    @Then("^Click on Save button$")
    public void click_on_Save_button() throws Throwable {
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_registrationapplication|NoRelationship|Form|Mscrm.Form.tbg_registrationapplication.Save")).click();
    }

    @Then("^Click on NextStage button$")
    public void click_on_NextStage_button() throws Throwable {
        Thread.sleep(6000);
        driver.findElement(By.xpath(Pro.getProperty("Individual_NextStage_Button_XPATH"))).click();
        Thread.sleep(2000);
    }


    @Then("^Click reporting > reports$")
    public void goToReportingScreen() throws Throwable {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reporting']"))).click();
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Reports']"))).click();
    }

    @Then("Switch to backoffice frame")
    public void switchToBackofficeFrame() {
        switchToFrameBackoffice();
    }

    @Then("Open CRM and close modal")
    public void openCRMAndCloseModal() {
        driver.get(Pro.getProperty("MRA_crm_url_Registration"));

        WebElement specificframe = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame__ID"))));
        driver.switchTo().frame(specificframe);
        sixty.until(ExpectedConditions.elementToBeClickable(By.id(Pro.getProperty("CRM_ExploreCrmWindow_Frame_Close_ID")))).click();
    }

    @And("Verify approval {string}")
    public void verifyApproval(String Status) throws InterruptedException {
        WebElement statusLabel = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'" + Status + "')]")));
        if (statusLabel.isDisplayed()) {
            Assert.assertTrue("Approved", true);
        } else {
            Assert.fail("Approval failed");
        }
        Thread.sleep(2000);
    }


    @And("Click on return filing and processing > Lodge return")
    public void clickOnReturnFilingAndProcessingLodgeReturn() {
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        driver.findElement(By.xpath("//a[span='Lodge Return']")).click();
    }

    @Then("Click Return document search button")
    public void clickReturnDocumentSearchButton() {
        fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:searchId"))).click();
    }

    @Then("Search for taxtype {string} for period year {string} and number {string} and tin {string}")
    public void searchForTaxtypeWithCategoryAndTaxtype(String category, String taxtype, String year, String number, String tin) throws InterruptedException {
        switchToFrameBackoffice();

        Thread.sleep(3000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:TIN"))).sendKeys(tin);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"SearchForm:ReturnType_label\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + taxtype + "')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("SearchForm:PeriodNumber")).sendKeys(number);
        Thread.sleep(1000);
        driver.findElement(By.id("SearchForm:PeriodYear")).sendKeys(year);

        driver.findElement(By.id("SearchForm:j_idt21")).click();
        switchToDefault();
    }

    @Then("Enter liability")
    public void enterLiability() throws InterruptedException {
        Thread.sleep(5000);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:id_Liability_input"))).sendKeys("9000");
    }

    @Then("Submit lodge return application")
    public void submitLodgeReturnApplication() throws InterruptedException {
        Thread.sleep(4000);
        twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:SaveLodgement"))).click();
    }

    @And("Click on return filing and processing > File return")
    public void clickOnReturnFilingAndProcessingFileReturn() throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[span='File Return']")).click();
    }

    @Then("Select return document as {string}")
    public void selectReturnDocumentAs(String taxtype) throws InterruptedException {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FormSelection:returnType\"]/div[3]"))).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[contains(text(),'" + taxtype + "')]")).click();
        driver.findElement(By.id("FormSelection:nextReturnButton")).click();
    }

    @Then("Find tax return for tin {string} with year {string} and number {string}")
    public void findTaxReturnForCategoryWithYearAndNumber(String tin, String year, String number) {

        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:tin"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:periodyear")).sendKeys(year);
        driver.findElement(By.id("SearchForm:periodnumber")).sendKeys(number);
        driver.findElement(By.id("SearchForm:j_idt42")).click();

    }

    @Then("Fill in file return details for taxtype {string}")
    public void fillInFileReturnDetailsForTaxtype(String taxtype) throws InterruptedException, AWTException {
        if (taxtype.equals("PAYE Tax Return")) {
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items:j_id5"))).click();
            switchToFrameBackoffice();
            Thread.sleep(1000);
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexbleCSVFileUpload:fileCSVFiletoUpload\"]/div[1]/span"))).click();
            Thread.sleep(3000);
            Robot rb = new Robot();

            // copying File path to Clipboard
            String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\paye.csv";
            System.out.println("The path is : " + path);
            StringSelection str = new StringSelection(path);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
            Thread.sleep(1000);

            // press Contol+V for pasting
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_V);
            // release Contol+V for pasting
            rb.keyRelease(KeyEvent.VK_CONTROL);
            rb.keyRelease(KeyEvent.VK_V);
            Thread.sleep(2000);
            // for pressing and releasing Enter
            rb.keyPress(KeyEvent.VK_ENTER);
            rb.keyRelease(KeyEvent.VK_ENTER);
            Thread.sleep(3000);
            driver.findElement(By.xpath("//*[@id=\"FlexbleCSVFileUpload:fileCSVFiletoUpload\"]/div[1]/button[1]")).click();
            fifteen.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexbleCSVFileUpload:id_filename"))).isDisplayed();
            Thread.sleep(4000);
            driver.findElement(By.id("FlexbleCSVFileUpload:btnNext")).click();
            driver.switchTo().defaultContent();
            Thread.sleep(3000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:DeclarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:DeclarantPosition")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:DeclarationDate_input")).sendKeys("01/01/2018");
//            JavascriptExecutor jse = (JavascriptExecutor) driver;
//            jse.executeScript("document.getElementById('FlexibleFormEntity:declarationDate_input').setAttribute('value', '01/01/2018')");
        }

        if (taxtype.equals("Personal Income Tax(PIT) Return")) {

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'INCOME STATEMENT')]"))).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:TabView:BusinessIncome_input")).sendKeys("100000");
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:DeclarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:DeclarantPosition")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:DeclarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("Provisional Tax(PIT) Return")) {

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:SeasonalIncom\"]/div[3]"))).click();
            Thread.sleep(1500);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(2000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:Declarant_Name"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:Declarant_Designation")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:Declaration_Date_input")).sendKeys("01/01/2018");

        }

        if (taxtype.equals("GST Return")) {

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:standardSalesExclusive_input"))).sendKeys("20000");
            driver.findElement(By.id("FlexibleFormEntity:zeroRatedSupplies_input")).sendKeys("20000000");
            driver.findElement(By.id("FlexibleFormEntity:exemptSupplies_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:relievedSuppliesExclusive_input")).sendKeys("0");
            driver.findElement(By.id("FlexibleFormEntity:InputTaxDeductible_input")).sendKeys("0");
            Thread.sleep(2000);

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:attachmentTable:j_id1"))).click();

            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexbleFormAttachment:DocType\"]/div[3]"))).click();

            fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexbleFormAttachment:DocType_1"))).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexbleFormAttachment:id_reference")).sendKeys("Attachment");
            String path = System.getProperty("user.dir") + File.separator + "src\\test\\resources\\" + File.separator + "id_doc.png";
            driver.findElement(By.id("FlexbleFormAttachment:id_attachment_input")).sendKeys(path);
            driver.findElement(By.id("FlexbleFormAttachment:Ok")).click();
            switchToDefault();
            Thread.sleep(3000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantDesignation")).sendKeys("Doctor");
            //driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("Company Income Tax(CIT) Return")) {
            Thread.sleep(3500);
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:corporateIncome\"]/div[3]"))).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//li[contains(text(),'Yes')]")).click();

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:clubsAndSocitiesIncome\"]/div[3]"))).click();
            Thread.sleep(1500);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:pensionFundIncome\"]/div[3]"))).click();
            Thread.sleep(1500);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(2500);
            fourty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:businessIncomeIs_input"))).sendKeys("100000");
            Thread.sleep(500);
            driver.findElement(By.id("FlexibleFormEntity:openingStockIs_input")).sendKeys("5");
            Thread.sleep(500);
            driver.findElement(By.id("FlexibleFormEntity:purchasesIs_input")).sendKeys("50000");
            Thread.sleep(1500);
            driver.findElement(By.id("FlexibleFormEntity:closingStockIs_input")).sendKeys("10");
            Thread.sleep(500);
            driver.findElement(By.id("FlexibleFormEntity:shareCapitalBS_input")).sendKeys("100");
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantDesignation")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("Capital Gain Tax(CGT) Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:assetBuyerName"))).sendKeys("Maxipain "+getRandom(5));
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:assetBuyerEmail")).sendKeys(getRandom(5)+"@gmail.com");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:assetBuyerContact")).sendKeys("0707445567");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:assetBuyerPostalAddress")).sendKeys("Utawala");
            Thread.sleep(700);
            driver.findElement(By.id("FlexibleFormEntity:T_Items:j_id1")).click();

            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:typeOfAsset\"]/div[3]"))).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//li[text()='Real estate (Land and Buildings)']")).click();

            Thread.sleep(3000);
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:assetNumber\"]/div[3]"))).click();
            Thread.sleep(700);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:disposalDate_input")).sendKeys("30/09/2020");
            Thread.sleep(300);
            actions.sendKeys(Keys.TAB).perform();
            driver.findElement(By.id("TestFlexibleForm:disposalValue_input")).sendKeys("9000");
            Thread.sleep(900);
            driver.findElement(By.id("TestFlexibleForm:valuationAtDisposal_input")).sendKeys("9000");
            Thread.sleep(900);
            driver.findElement(By.id("TestFlexibleForm:dateOfAcquisition_input")).sendKeys("02/09/2020");
            Thread.sleep(300);
            actions.sendKeys(Keys.TAB).perform();
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:costOfAcquisition_input")).sendKeys("9000");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();

            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'9,000.00')]"))).isDisplayed();
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantPosition")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }

        if (taxtype.equals("Dividend Tax Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items:j_id1"))).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:NID"))).sendKeys(getRandom(8));
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:entityName")).sendKeys("Maxipain "+getRandom(5));
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:Address")).sendKeys("Utawala");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id=\"TestFlexibleForm:ResidentialStatus\"]/div[3]")).click();
            Thread.sleep(1500);
            driver.findElement(By.xpath("//li[text()='Non Resident']")).click();
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:DividendAccrued_input")).sendKeys("12000");
            Thread.sleep(400);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'12,000.00')]"))).isDisplayed();
            Thread.sleep(900);
            driver.findElement(By.id("FlexibleFormEntity:DividendDeclarationDate_input")).sendKeys(Keys.ENTER);
            Thread.sleep(700);

            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantPosition")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");

        }

        if (taxtype.equals("Domestic Excise Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items_Goods:j_id1"))).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:natureOfActivity\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:productType\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);

            driver.findElement(By.id("TestFlexibleForm:openingUnits_input")).sendKeys("30");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:unitsProduced_input")).sendKeys("30");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:closingUnits_input")).sendKeys("60");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:valueOfDisposedUnits_input")).sendKeys("0");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:returnInwards_input")).sendKeys("9000");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:destructions_input")).sendKeys("9000");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:exports_input")).sendKeys("0");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:dutyFreeSupplies_input")).sendKeys("0");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:otherSpecify_input")).sendKeys("9000");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Manufacturing')]"))).isDisplayed();

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items_Raw_Materials:j_id1"))).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:unitOfMeasure\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);

            driver.findElement(By.id("TestFlexibleForm:typeOfRawMaterials")).sendKeys("Asbestos and wires");
            Thread.sleep(600);
            driver.findElement(By.id("TestFlexibleForm:openingRawMaterials_input")).sendKeys("30");
            Thread.sleep(600);
            driver.findElement(By.id("TestFlexibleForm:rawMaterialsPurchased_input")).sendKeys("30");
            Thread.sleep(600);
            driver.findElement(By.id("TestFlexibleForm:closingRawMaterials_input")).sendKeys("10");
            Thread.sleep(600);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Asbestos and wires')]"))).isDisplayed();

            Thread.sleep(2000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantPosition")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }
        if(taxtype.equals("Domestic VAT Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:tdValue1_input"))).sendKeys("3000000");
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:TIOnInpVatLocPur_Table:j_id1")).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:DateOfInvoice_input"))).sendKeys(Keys.ENTER);
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:InvoiceNumber")).sendKeys(getRandom(8));
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:TinOfSupplier")).sendKeys("C0103632");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:NameOfSupplier")).sendKeys("DR Maxipain cSHJP");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:VatOnSupplies_input")).sendKeys("7000");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'C0103632')]"))).isDisplayed();
            Thread.sleep(2000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:DeclarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:DeclarantPosition")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:DeclarationDate_input")).sendKeys("01/01/2018");
        }

        if(taxtype.equals("Fringe Benefit Tax Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:T_Items:j_id1"))).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:FringeBenefit\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:BenefitValue_input")).sendKeys("45000");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'45,000.00')]"))).isDisplayed();
            Thread.sleep(2000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantPosition")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }

        if(taxtype.equals("Non Resident Tax(NRT) Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:NRT_Items:j_id1"))).click();
            switchToBackofficeFrame();

            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"TestFlexibleForm:deductionReason\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);

            driver.findElement(By.id("TestFlexibleForm:deductionDate_input")).sendKeys(Keys.ENTER);
            Thread.sleep(900);
            driver.findElement(By.id("TestFlexibleForm:nameOfRecipient")).sendKeys("Recipient "+getRandom(5));
            Thread.sleep(900);
            driver.findElement(By.id("TestFlexibleForm:cityTown")).sendKeys("Mumbai");
            Thread.sleep(900);
            driver.findElement(By.xpath("//*[@id=\"TestFlexibleForm:country\"]/div[3]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//li[contains(text(),'Kenya')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:payingBankName")).sendKeys("Equity");
            Thread.sleep(900);
            driver.findElement(By.id("TestFlexibleForm:payingBankBranch")).sendKeys(getRandom(5));
            Thread.sleep(900);
            driver.findElement(By.id("TestFlexibleForm:payingBankName")).sendKeys("Equity");
            Thread.sleep(900);

            driver.findElement(By.xpath("//*[@id=\"TestFlexibleForm:payingBankCountry\"]/div[3]")).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);

            driver.findElement(By.id("TestFlexibleForm:recipientBankName")).sendKeys("Co-op");
            Thread.sleep(900);
            driver.findElement(By.id("TestFlexibleForm:recipientBankBranch")).sendKeys(getRandom(5));
            Thread.sleep(900);

            driver.findElement(By.xpath("//*[@id=\"TestFlexibleForm:recipientBankCountry\"]/div[3]")).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);

            driver.findElement(By.xpath("//*[@id=\"TestFlexibleForm:natureOfIncomePayable\"]/div[3]")).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:grossAmount_input")).sendKeys("3000000");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@id=\"TestFlexibleForm:typeOfNRT\"]/div[3]")).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Equity')]"))).isDisplayed();
            Thread.sleep(2000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantDesignation")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }

        if(taxtype.equals("Provisional Tax(CIT) Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:seasonalIncome\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:estChargeableIncomeValue_input")).sendKeys("0");
            Thread.sleep(1000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:declarantName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:declarantDesignation")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:declarationDate_input")).sendKeys("01/01/2018");
        }

        if(taxtype.equals("Turnover Tax(TOT) Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:totTable:j_id1"))).click();
            switchToBackofficeFrame();
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:sourceOfIncome"))).sendKeys("Services delivery");
            Thread.sleep(500);
            driver.findElement(By.xpath("//*[@id=\"TestFlexibleForm:mainIncome\"]/div[2]/span")).click();
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:description")).sendKeys("Software development");
            Thread.sleep(500);
            driver.findElement(By.id("TestFlexibleForm:amount_input")).sendKeys("1000000");
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'1,000,000.00')]"))).isDisplayed();
            Thread.sleep(2000);
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:DeclarationName"))).sendKeys("DR Margie Wambui");
            driver.findElement(By.id("FlexibleFormEntity:DeclaratDesignation")).sendKeys("Doctor");
            driver.findElement(By.id("FlexibleFormEntity:DeclarationDate_input")).sendKeys("01/01/2018");
        }
    }

    @Then("Submit file return application")
    public void submitFileReturnApplication() throws InterruptedException {
        Thread.sleep(4000);
        driver.findElement(By.id("FlexibleFormEntity:save")).click();
    }

    @And("Click on return filing and processing > Adjust return")
    public void clickOnReturnFilingAndProcessingAdjustReturn() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        driver.findElement(By.xpath("//a[span='Adjust Return']")).click();
    }

    @Then("Perform amendment for taxtype {string}")
    public void performAmendmentForTaxtype(String taxtype) throws InterruptedException {
        if (taxtype.equals("PAYE Tax Return")) {

            //nill returns
            twenty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:NilReturn\"]/div[2]/span"))).click();
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:ReasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:DeclarantName")).clear();
            driver.findElement(By.id("FlexibleFormEntity:DeclarantName")).sendKeys("DR Muthoni");

        }

        if (taxtype.equals("Personal Income Tax(PIT) Return")) {

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:ReasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:DeclarantName")).clear();
            driver.findElement(By.id("FlexibleFormEntity:DeclarantName")).sendKeys("DR Muthoni");

        }

        if (taxtype.equals("GST Return")) {

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).clear();
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).sendKeys("DR Muthoni");

        }


        if (taxtype.equals("Company Income Tax(CIT) Return")) {
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:productionCostIs_input"))).sendKeys("9000");
            Thread.sleep(1000);

            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAdjustment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

            driver.findElement(By.id("FlexibleFormEntity:declarantName")).clear();
            driver.findElement(By.id("FlexibleFormEntity:declarantName")).sendKeys("DR Muthoni");
        }

        if (taxtype.equals("Capital Gain Tax(CGT) Return")) {
            Thread.sleep(3000);
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:T_Items_data\"]/tr/td[11]"))).click();
            Thread.sleep(3000);
            driver.findElement(By.id("FlexibleFormEntity:T_Items:j_id2")).click();
            switchToBackofficeFrame();
            driver.findElement(By.id("TestFlexibleForm:disposalValue_input")).clear();
            driver.findElement(By.id("TestFlexibleForm:disposalValue_input")).sendKeys("10000");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:costOfAcquisition_input")).clear();
            driver.findElement(By.id("TestFlexibleForm:costOfAcquisition_input")).sendKeys("9000");
            Thread.sleep(4000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'9,000.00')]"))).isDisplayed();
            Thread.sleep(3000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();

        }
        if (taxtype.equals("Dividend Tax Return")) {
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:T_Items_data\"]/tr/td[7]"))).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:T_Items:j_id2")).click();
            switchToBackofficeFrame();
            WebElement dividentAccrued = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:DividendAccrued_input")));
            dividentAccrued.clear();
            dividentAccrued.sendKeys("13000");
            Thread.sleep(600);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Non Resident')]"))).isDisplayed();
            Thread.sleep(2000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }

        if (taxtype.equals("Domestic Excise Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:T_Items_Goods_data\"]/tr/td[6]"))).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:T_Items_Goods:j_id2")).click();
            switchToBackofficeFrame();
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:returnInwards_input")));
            field.clear();
            field.sendKeys("0");
            Thread.sleep(700);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Manufacturing')]"))).isDisplayed();
            Thread.sleep(2000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }

        if(taxtype.equals("Domestic VAT Return")){
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:tdValue1_input")));
            field.clear();
            field.sendKeys("3500000");
            Thread.sleep(2000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:ReasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }

        if(taxtype.equals("Fringe Benefit Tax Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:T_Items_data\"]/tr/td[3]"))).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:T_Items:j_id2")).click();
            switchToBackofficeFrame();
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:BenefitValue_input")));
            field.clear();
            field.sendKeys("50000");
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'50,000.00')]"))).isDisplayed();
            Thread.sleep(2000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }

        if(taxtype.equals("Non Resident Tax(NRT) Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:NRT_Items_data\"]/tr/td[4]"))).click();
            Thread.sleep(2000);
            driver.findElement(By.id("FlexibleFormEntity:NRT_Items:j_id2")).click();
            switchToBackofficeFrame();
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:grossAmount_input")));
            field.clear();
            field.sendKeys("3100000");
            Thread.sleep(1000);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Accrual')]"))).isDisplayed();
            Thread.sleep(2000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:ReasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }

        if(taxtype.equals("Turnover Tax(TOT) Return")){
            thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:totTable_data\"]/tr/td[2]"))).click();
            Thread.sleep(1000);
            driver.findElement(By.id("FlexibleFormEntity:totTable:j_id2")).click();
            switchToBackofficeFrame();
            WebElement field = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("TestFlexibleForm:amount_input")));
            field.clear();
            field.sendKeys("1100000");
            Thread.sleep(600);
            driver.findElement(By.id("TestFlexibleForm:Save")).click();
            switchToDefault();
            sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[contains(text(),'Software development')]"))).isDisplayed();
            Thread.sleep(2000);
            fifty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:reasonForAmendment\"]/div[3]"))).click();
            Thread.sleep(1000);
            actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
        }
    }

    @Then("Submit adjust return application")
    public void submitAdjustReturnApplication() throws InterruptedException {
        Thread.sleep(1000);
        driver.findElement(By.id("FlexibleFormEntity:save")).click();
    }

    @Then("Obtain reference number for adjust {string}")
    public void obtainReferenceNumberForAdjust(String refno) {
        String text = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + refno + "')]"))).getText();
        System.out.println(text);
        System.out.println("substring is " + text.substring(75));
        sharedatastep.Reference_number = text.substring(75);
        //Tax return has been successfully saved.The status is now pending approval. PAYER/000001429/2020

        System.out.println("Actual ARN to be used in CRM is " + sharedatastep.Reference_number);
    }

    @And("click on Returns Tax return application")
    public void clickOnReturnsTaxReturnApplication() {
        ten.until(ExpectedConditions.visibilityOfElementLocated(By.id("tbg_taxreturnapplication"))).click();
    }

    @When("enters adjust reference number in search results")
    public void entersAdjustReferenceNumberInSearchResults() {
        WebElement search = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));
        search.sendKeys(sharedatastep.Reference_number);
        //search.sendKeys("PAYER/000003143/2021");
        search.sendKeys(Keys.ENTER);
    }

    @When("enters cancel reference number in search results")
    public void entersCancelReferenceNumberInSearchResults() {
        WebElement search = twenty.until(ExpectedConditions.visibilityOfElementLocated(By.id("crmGrid_findCriteria")));
        search.sendKeys(sharedatastep.Reference_number);
        //search.sendKeys("PAYER/000003143/2021");
        search.sendKeys(Keys.ENTER);
    }

    @And("Approve adjust returns application")
    public void approveAdjustReturnsApplication() throws Throwable {

        WebElement detailsframe = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("WebResource_TaxReturnApplicationAngular")));
        driver.switchTo().frame(detailsframe);
        WebElement downloadAttach = twohundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[text()='Taxpayer Name']")));
        Assert.assertTrue(downloadAttach.isDisplayed());

        driver.switchTo().defaultContent();

        WebElement specificframe = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id(Pro.getProperty("NextStage_Frame_ID1"))));
        driver.switchTo().frame(specificframe);
        Thread.sleep(3000);

        driver.findElement(By.xpath("//div[@data-attributename='tbg_approvaloutcome']")).click();
        Actions action = new Actions(driver);
        action.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).perform();
    }

    @Then("Click on Returns Save button")
    public void clickOnReturnsSaveButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.switchTo().defaultContent();
        driver.findElement(By.id("tbg_taxreturnapplication|NoRelationship|Form|Mscrm.Form.tbg_taxreturnapplication.Save")).click();
    }


    @And("Click on return filing and processing > Cancel return")
    public void clickOnReturnFilingAndProcessingCancelReturn() {
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Return Filing and Processing']"))).click();
        driver.findElement(By.xpath("//a[span='Cancel Return']")).click();
    }

    @Then("^Select reason for cancellation as \"([^\"]*)\" \"([^\"]*)\"$")
    public void select_reason_for_cancellation(String cancellationReason, String returnType) throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 100);
        String dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";

        if (returnType.equals("CIT Return (Final)")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"FlexibleFormEntity:CITDetailsTab\"]/ul/li[6]/a"))).click();
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:CITDetailsTab:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();

        }
        if (returnType.equals("Capital Gains Tax Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();

        }
        if (returnType.equals("PAYE Tax Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:ReasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Excise Tax Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("FTT Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("GST Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Personal Income Tax(PIT) Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("PIT Return (Provisional)")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Payroll Tax Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("Rental income Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }

        if (returnType.equals("WHT (10.5% and 5.5%) Return")) {
            dropdownXpath = "//*[@id=\"FlexibleFormEntity:reasonForCancellation\"]/div[3]";
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(dropdownXpath))).click();
            Thread.sleep(2000);
            driver.findElement(By.xpath("//li[contains(text(),'" + cancellationReason + "')]")).click();
        }
    }

    @Then("^Click cancel return$")
    public void click_cancel_return() throws Throwable {

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:cancel"))).click();
    }

    @Then("^Click yes$")
    public void click_yes() throws Throwable {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("FlexibleFormEntity:j_idt32"))).click();
    }

    @Then("Obtain reference number for cancellation {string}")
    public void obtainReferenceNumberForCancellation(String refno) throws Throwable {
        String text = onehundred.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + refno + "')]"))).getText();
        System.out.println(text);
        System.out.println("substring is " + text.substring(74));
        sharedatastep.Reference_number = text.substring(74);
        //Tax return has successfully saved.The status is now pending cancellation. CGTR/000002235/2021

        System.out.println("Actual ARN to be used in CRM is " + sharedatastep.Reference_number);
    }

    @Then("Verify and obtain ARN {string}")
    public void verifyARN(String arn) {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement successMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + arn + "')]")));
        String text = successMessage.getText();
        System.out.println(text);
        System.out.println("substring is " + text.substring(55));
        ReferenceNumber = text.substring(55);
        //Returns Lodgement is Successful with Reference Number FTTR/000002727/2021
        System.out.println(ReferenceNumber);
        if (successMessage.isDisplayed()) {
            System.out.println("ARN ('" + arn + "') is valid");
            Assert.assertTrue(true);
        } else {
            Assert.fail("ARN invalid");
        }
    }

    @Then("Verify and obtain ARN for file {string}")
    public void verifyAndObtainARNForFile(String arn) {

        WebElement successMessage = sixty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'" + arn + "')]")));
        //Record successfully saved with reference number PIRP/000003248/2021
        String text = successMessage.getText();
        System.out.println(text);
        System.out.println("substring is " + text.substring(48));
        ReferenceNumber = text.substring(48);
        //Record successfully saved with reference number PAYER/000001507/2020
        System.out.println(ReferenceNumber);
        if (successMessage.isDisplayed()) {
            System.out.println("ARN ('" + arn + "') is valid");
            Assert.assertTrue(true);
        } else {
            Assert.fail("ARN invalid");
        }
    }

    @Then("go to taxpayer accounting > taxpayer account inquiry")
    public void goToTaxpayerAccountingTaxpayerAccountInquiry() {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[span='Taxpayer Accounting']"))).click();
        driver.findElement(By.xpath("//a[span='Taxpayer Account Enquiry']")).click();
    }

    @Then("Search for tin {string}")
    public void searchForTin(String tin) throws InterruptedException {
        Thread.sleep(2000);
        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id("SearchForm:accountNumber"))).sendKeys(tin);
        driver.findElement(By.id("SearchForm:j_idt42")).click();
    }

    @Then("Search for taxtype {string}")
    public void searchForTaxtype(String taxtype) throws InterruptedException {

        thirty.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:TaxTypeAccount\"]/div[3]"))).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//li[contains(text(),'" + taxtype + "')]")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("AccountEnquiry:j_idt66")).click();

    }


    @Then("Verify taxtype {string} and status {string} is shown in table for {string}")
    public void verifyTaxtypeAndStatusIsShownInTableFor(String taxtype, String status, String returnDocument) {
        WebDriverWait wait = new WebDriverWait(driver, 30);

        if (returnDocument.equals("Capital Gain Tax(CGT) Return")) {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Capital Gain Tax(CGT) Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Company Income Tax(CIT) Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Company Income Tax(CIT) Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Dividend Tax Return")) {
            // wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Dividend Tax Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Domestic Excise Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Domestic Excise Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Domestic VAT Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Domestic VAT Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Fringe Benefit Tax Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Fringe Benefit Tax Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Non Resident Tax(NRT) Return")) {
            //wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Non Resident Tax(NRT) Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("PAYE Tax Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'PAYE Tax Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Personal Income Tax(PIT) Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Personal Income Tax(PIT) Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Provisional Tax(CIT) Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Provisional Tax(CIT) Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Provisional Tax(PIT) Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Provisional Tax(PIT) Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Turnover Tax(TOT) Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Turnover Tax(TOT) Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
        if (returnDocument.equals("Withholding Tax(WHT) Return")) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"AccountEnquiry:periodicTable_data\"]/tr[1]/td[1]/div"))).click();

            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'Withholding Tax(WHT) Return')]"))).isDisplayed()) {
                System.out.println(returnDocument + " has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[contains(text(),'" + status + "')]"))).isDisplayed()) {
                System.out.println(status + " status has been displayed");
            }
            if (wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).isDisplayed()) {
                System.out.println(ReferenceNumber + " reference number has been displayed");
            }
        }
    }


    @Then("Click on case")
    public void clickOnCase() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'" + ReferenceNumber + "')]"))).click();
    }

    @Then("Verify lodgement screen has data")
    public void verifyLodgementScreenHasData() {
        WebDriverWait wait = new WebDriverWait(driver, 60);
        String tin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ReturnsLodgement:id_Tin"))).getAttribute("value");
        if (tin.isEmpty()) {
            Assert.fail("Field does not contain any data");
        } else {
            Assert.assertTrue("Field contains data", !tin.isEmpty());
        }
    }

    @Then("Verify file returns screen has data for {string}")
    public void verifyFileReturnsScreenHasData(String returnDocument) {

        String declarantNameLocator = "";

        if (returnDocument.equals("Capital Gain Tax(CGT) Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnDocument.equals("Company Income Tax(CIT) Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnDocument.equals("Dividend Tax Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnDocument.equals("Domestic Excise Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnDocument.equals("Domestic VAT Return")) {
            declarantNameLocator = "FlexibleFormEntity:DeclarantName";
        }
        if (returnDocument.equals("Fringe Benefit Tax Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnDocument.equals("Non Resident Tax(NRT) Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnDocument.equals("PAYE Tax Return")) {
            declarantNameLocator = "FlexibleFormEntity:DeclarantName";
        }
        if (returnDocument.equals("Personal Income Tax(PIT) Return")) {
            declarantNameLocator = "FlexibleFormEntity:DeclarantName";
        }
        if (returnDocument.equals("Provisional Tax(CIT) Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }
        if (returnDocument.equals("Provisional Tax(PIT) Return")) {
            declarantNameLocator = "FlexibleFormEntity:Declarant_Name";
        }
        if (returnDocument.equals("Turnover Tax(TOT) Return")) {
            declarantNameLocator = "FlexibleFormEntity:DeclarationName";
        }
        if (returnDocument.equals("Withholding Tax(WHT) Return")) {
            declarantNameLocator = "FlexibleFormEntity:declarantName";
        }


        String name = thirty.until(ExpectedConditions.visibilityOfElementLocated(By.id(declarantNameLocator))).getAttribute("value");
        if (name.isEmpty()) {
            Assert.fail("Field does not contain any data");
        } else {
            Assert.assertFalse("Field contains data", false);
        }
    }


}




