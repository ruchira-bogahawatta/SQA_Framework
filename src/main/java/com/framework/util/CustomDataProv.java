package com.framework.util;


import org.testng.annotations.DataProvider;

public class CustomDataProv {
    @DataProvider(name = "loginCredentials")
    public Object[][] getData() {
        return new Object[][]{
                {"geyana8544@inikale.com", "SamWin123", "https://pepperstreet.co/account"},
        };
    }

    @DataProvider(name = "addToProductData")
    public Object[][] getProductData() {
        return new Object[][]{{"shop all", "Best selling", "Project Pepper Tee"}};
    }

    @DataProvider(name = "productName")
    public Object[][] getProductName() {
        return new Object[][]{
                {"Project Pepper Tee"}
        };
    }

    @DataProvider(name = "priceFilter")
    public Object[][] getProductCategory() {
        return new Object[][]{
                {"shop all", "Reversible Printed Bucket Hat"}
        };
    }

}


