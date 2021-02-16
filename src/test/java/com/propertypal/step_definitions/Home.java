package com.propertypal.step_definitions;

import com.propertypal.pages.HMProp;
import com.propertypal.utilities.BrowserUtils;
import com.propertypal.utilities.ConfigurationReader;
import com.propertypal.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home {
    HMProp hm= new HMProp();
    WebDriverWait wait = new WebDriverWait(Driver.get(), 15);

    @Given("the user go to home page")
    public void the_user_go_to_home_page() {

        Driver.get().manage().window().maximize();
        Driver.get().get(ConfigurationReader.get("url"));
    }

    @When("the user click on the input box")
    public void the_user_click_on_the_input_box() throws InterruptedException {

        hm.accept.click();
        hm.inputBox.click();
    }

    @When("the user click on the my location button")
    public void the_user_click_on_the_my_location_button() throws InterruptedException {

        Actions act = new Actions(Driver.get());
        act.moveToElement(hm.myloc).click().perform();

    }

    @When("the user click sale search button")
    public void the_user_click_sale_search_button() throws InterruptedException {

        hm.sale.click();

    }

    @Then("Verify {string} message displayed")
    public void verify_message_displayed(String string) {

        String expected= BrowserUtils.getElementsText(hm.message);
        Assert.assertEquals(expected,"SORRY, NO PROPERTIES FOUND");

    }

    @When("the user enters {string}")
    public void the_user_enters(String string) {

        hm.inputBox.sendKeys(string);

    }

    @Then("Verify all postcodes are {string}")
    public void verify_all_postcodes_are(String string) throws InterruptedException {

        for (int i = 0; i<hm.salePageNumbers.size(); i++) {
            for(int j=0; j<hm.postcode.size(); j++) {
                Assert.assertEquals(hm.postcode.get(j).getText(), string);
            }

            if (i<(hm.salePageNumbers.size()-1)){
                WebDriverWait wait = new WebDriverWait(Driver.get(), 15);
                wait.until(ExpectedConditions.elementToBeClickable(hm.nextButton));
                hm.nextButton.click();

            }else{
                break;
            }
        }
    }

    @Then("the user clicks rent")
    public void the_user_clicks_rent() {

        hm.rent.click();
    }

    @Then("Verify all postcodes are {string} in the rent page")
    public void verify_all_postcodes_are_in_the_rent_page(String string) throws InterruptedException {

        System.out.println("Total number of pages :" + hm.rentPageNumbers1.size());
            int sum=0;
                for (int i = 0; i<hm.rentPageNumbers1.size(); i++) {
                       for(int j=0; j<hm.postcode.size(); j++) {
                           // check all postcode existing in the current page with expected post code
                           Assert.assertEquals(string,hm.postcode.get(j).getText());
                            sum=sum+1;
                        }

                    if (i<(hm.rentPageNumbers1.size()-1)){
                        WebDriverWait wait = new WebDriverWait(Driver.get(), 15);
                        wait.until(ExpectedConditions.elementToBeClickable(hm.nextButton));
                        hm.nextButton.click();

                    }else{
                        break;
                    }

                }
                System.out.println("Total number of properties : "+sum);
                String actualResult=hm.pgHeader.getText();
                System.out.println("actualResult = " + actualResult);
                //check number of total properties found
                Assert.assertEquals(String.valueOf(sum) ,actualResult);

    }

}

