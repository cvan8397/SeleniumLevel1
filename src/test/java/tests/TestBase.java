package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestBase {
    @BeforeMethod
    public void setup() {
    }

    @AfterMethod
    public void closePage() {
    }
}
