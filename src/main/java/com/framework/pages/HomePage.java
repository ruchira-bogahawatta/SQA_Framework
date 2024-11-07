package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage{
    private static final String PAGE_URL = "https://pepperstreet.co/";

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@id='headerCartStatus']")
    private WebElement cartIcon;

    @FindBy(xpath = "//summary[span[text()='MEN']]")
    private WebElement menCategoryBtn;

    @FindBy(xpath = "//div[@class = 'header__icon header__icon__search']/a")
    private WebElement searchBtn;

    @FindBy(xpath = "//input[@id = 'predictiveSearch_Input']")
    private WebElement searchTextBox;


    public void openPage(){
        navigateTo(PAGE_URL);
    }

    // Dynamically select the sub category
    public WebElement getSubCategoryBtn(String subcategory) {
        String dynamicXPath = "//ul[@id='menuHeaderMenuList-1']/li/a[contains(text(),'" + subcategory.toUpperCase() + "')]";
        return getDynamicElement(dynamicXPath);
    }

    public void selectCategory(String subCategory){
        click(menCategoryBtn);
        click(getSubCategoryBtn(subCategory));
    }

    public void searchProducts(String searchText){
        click(searchBtn);
        enterText(searchTextBox, searchText);
    }

    public boolean isSearchProductAvailable(String searchText){
        String dynamicXPath = "//ul[@class='search__result--list rw ls-none']//a[text() =  '" + searchText + "']";
        WebElement dynamicElm =  getDynamicElement(dynamicXPath);
        return dynamicElm != null;
    }



}
