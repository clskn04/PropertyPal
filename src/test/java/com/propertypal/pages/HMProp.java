package com.propertypal.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HMProp extends BasePage{


    @FindBy(xpath ="(//section[@class='search-form-ctrl'])[3]//input")
    public WebElement inputBox;

    @FindBy(xpath ="//a[@class='suggestions-location']/strong")
    public WebElement myloc;

    @FindBy(xpath ="//div[@class='search-ctrl query  suggestions-container']/section[@class='search-form-ctrl']/input[@id='query']")
    public WebElement myloc1;

    @FindBy(xpath ="(//button[@type='submit'])[3]")
    public WebElement sale;

    @FindBy(xpath ="(//button[@type='submit'])[4]")
    public WebElement rent;

    @FindBy(xpath ="//button[@mode='primary']")
    public WebElement accept;

    @FindBy(className="noresults-heading")
    public WebElement message;


    @FindBy(xpath="//span[@class='text-ib']/../../span[1]")
    public List<WebElement> adressName;

    @FindBy(xpath="//span[@class='text-ib']")
    public List<WebElement> postcode;

    @FindBy(xpath="//li[@class='paging-page']")
    public List<WebElement> rentPageNumbers;


    @FindBy(xpath="//ul[@class='paging']/li")
    public List<WebElement> rentPageNumbers1;

    @FindBy(xpath=" //li[@class='paging-page']")
    public List<WebElement> salePageNumbers;

    @FindBy(xpath="//span[@class='pgheader-currentpage']/em")
    public WebElement pgHeader;



    @FindBy(xpath="//a[@class='btn paging-next']")
    public WebElement nextButton;






}
