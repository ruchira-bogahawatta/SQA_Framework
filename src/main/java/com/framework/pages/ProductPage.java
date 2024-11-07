package com.framework.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends BasePage {

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@name='sort_by']")
    private WebElement sortBy;

    @FindBy(xpath = "//li//label[text() = 'M']")
    private WebElement productSize;

    @FindBy(xpath = "//button[@name = 'add']")
    private WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class = 'cart-notification__links']//a[contains(text(), 'View cart')]")
    private WebElement viewCartBtn;

    @FindBy(xpath = "//button[@class = 'js-cart-drawer-delete-btn js-cart-drawer-btn btn btn-plain btn-icon btn-small']")
    private WebElement deleteProductBtn;

    @FindBy(xpath = "//details[2][@class = 'js-details-filter filter-form__details']/summary")
    private WebElement priceFilter;

    @FindBy(xpath = "//input[@id = 'Filter-Price-LTE']")
    private WebElement priceToValue;

    @FindBy(xpath = "//input[@id = 'Filter-Price-GTE']")
    private WebElement priceFromValue;

    @FindBy(xpath = "//details[1][@class = 'js-details-filter filter-form__details']/summary")
    private WebElement availabilityFilter;

    @FindBy(xpath = "//label[@for = 'filter-Availability-2']")
    private WebElement outOfStockFilterOption;

    @FindBy(xpath = "//div[@class = 'products rw gap-unequal js-product-grid']//div[@class = 'card__media p-relative o-hidden'][position() = 1]")
    private WebElement firstProduct;

    @FindBy(xpath = " //span[text() = 'Out of stock']")
    private WebElement outOfStockMsg;


    public WebElement getProductByName(String productName) {
        String dynamicXPath = "//div[@class='card__info']//a[text()='" + productName + "']";
        return getDynamicElement(dynamicXPath);
    }

    public boolean isProductAdded(String productName) {
        String dynamicXPath = "//div[@class='cart-drawer__product-info']//a[contains(text(), '" + productName + "')]";
        WebElement dynamicElm = getDynamicElement(dynamicXPath);
        return dynamicElm != null;
    }

    public void sortBy(String visibleText) {
        click(sortBy);
        Select dropdown = new Select(sortBy);
        dropdown.selectByVisibleText(visibleText);
    }

    public void AddToCart(String productName) {
        WebElement product = getProductByName(productName);
        click(product);
        click(productSize);
        click(addToCartBtn);
        click(viewCartBtn);
    }

    public void removeItemFromCart() {
        click(deleteProductBtn);
    }

    public boolean isCartEmpty() {
        String dynamicXPath = "//div[@id='cartDrawer']//p[contains(text(), 'empty')]";
        WebElement dynamicElm = getDynamicElement(dynamicXPath);
        return dynamicElm != null;
    }

    public void applyPriceFilter() {
        click(priceFilter);
        enterText(priceToValue, "2000");
        enterText(priceFromValue, "1500");
    }

    public boolean isFilterApplied(String productName){
        String dynamicXPath = "//div[@class='card__info']//a[text()='" + productName + "']";
        WebElement dynamicElm = getDynamicElement(dynamicXPath);
        return dynamicElm != null;
    }

    public void applyOutOfStockFilter(){
    click(availabilityFilter);
    click(outOfStockFilterOption);
    }

    public void selectFirstProduct(){
        customWait(2);
        click(firstProduct);
    }

    public String getOutOfStockMsg(){
        return getText(outOfStockMsg);
    }

}
