package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//input[@name='customer[email]']")
    private WebElement emailField;

    @FindBy(xpath = "//input[@name='customer[password]']")
    private WebElement passwordField;

    @FindBy(xpath = "//form[@id='customer_login']//button")
    private WebElement loginButton;

    @FindBy(xpath = "//div[@class = 'clm']/h1[text()= 'My account']")
    private WebElement loginVerificationText;

    private static final String PAGE_URL = "https://pepperstreet.co/account/login";

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
    navigateTo(PAGE_URL);
    }

    public void loginUser(String username, String password){
        enterText(emailField, username);
        enterText(passwordField, password);
        click(loginButton);
    }



}
