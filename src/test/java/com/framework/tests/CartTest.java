package com.framework.tests;

import com.framework.pages.HomePage;
import com.framework.pages.ProductPage;
import com.framework.util.CustomDataProv;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    private HomePage homePage;
    private ProductPage productPage;

    @Test(dataProvider = "addToProductData",  dataProviderClass = CustomDataProv.class, priority = 1)
    public void addProductToCart(String category, String sortBy, String ProductName) {
        Reporter.log("======Add a product to the cart and check whether it is added======", true);

        boolean productStatus;
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);

        homePage.openPage();
        homePage.selectCategory(category);
        productPage.sortBy(sortBy);
        productPage.AddToCart(ProductName);
        productStatus = productPage.isProductAdded(ProductName);
        Assert.assertTrue(productStatus, "Product is not added to the cart");
    }


    @Test(dataProvider = "addToProductData",  dataProviderClass = CustomDataProv.class, priority = 2)
    public void removeProductFromCart(String category, String sortBy, String ProductName){
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);

        homePage.openPage();
        homePage.selectCategory(category);
        productPage.sortBy(sortBy);
        productPage.AddToCart(ProductName);
        productPage.removeItemFromCart();
        Assert.assertTrue(productPage.isCartEmpty(), "The cart is not empty.");
    }


    @Test(dataProvider = "addToProductData",  dataProviderClass = CustomDataProv.class, priority = 2)
    public void outOfStockProductAdd(String category, String sortBy, String ProductName){
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);

        homePage.openPage();
        homePage.selectCategory(category);
        productPage.applyOutOfStockFilter();
        productPage.selectFirstProduct();

        String msg = productPage.getOutOfStockMsg();
        Assert.assertEquals(msg, "Out of stock", "Out of stock indicator is not available");
    }



}
