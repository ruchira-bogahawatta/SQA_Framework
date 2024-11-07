package com.framework.tests;

import com.framework.pages.HomePage;
import com.framework.pages.ProductPage;
import com.framework.util.CustomDataProv;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class SearchAndFilterTest extends BaseTest {
    private HomePage homePage;
    private ProductPage productPage;

    @Test(dataProvider = "productName", dataProviderClass = CustomDataProv.class,priority = 0)
    public void searchProducts(String productName){
        Reporter.log("======Searching products from the home page======", true);
        boolean productStatus;
        homePage = new HomePage(driver);
        homePage.openPage();
        homePage.searchProducts(productName);
        productStatus = homePage.isSearchProductAvailable(productName);

        Assert.assertTrue(productStatus, "Product is not in the search results");
    }

    @Test(dataProvider = "priceFilter",  dataProviderClass = CustomDataProv.class)
    public void priceFilterTest(String category, String filteredProduct){
        boolean isFilter;
        homePage = new HomePage(driver);
        productPage = new ProductPage(driver);
        homePage.openPage();
        homePage.selectCategory(category);
        productPage.applyPriceFilter();

        isFilter = productPage.isFilterApplied(filteredProduct);
        Assert.assertTrue(isFilter, "The Filter not applied.");

    }
}
