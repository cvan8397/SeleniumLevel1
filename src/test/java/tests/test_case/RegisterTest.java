package tests.test_case;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import helper.Common;
import helper.models.Register;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page_objects.HomePage;
import page_objects.RegisterPage;

import java.io.IOException;
import java.util.List;

public class RegisterTest extends TestBase {
    HomePage homePage = new HomePage();
    RegisterPage registerPage = new RegisterPage();

    @DataProvider(name = "valid-register")
    public static Object[] getValidRegisterData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<Register> registers = objectMapper.readValue(Common.readFile("src/test/java/resources/data_driven/data-register/valid-register.json"), new TypeReference<List<Register>>() {
        });
        return registers.toArray();
    }

    @Test(dataProvider = "valid-register", description = "User can create successfully with valid data")
    public void TC01(Register register) {
        homePage.gotoRegisterPage();
        Common.scrollPage();
        register.setEmail(Common.getRandomEmail());
        registerPage.createAccount(register.getEmail(), register.getPassword(), register.getConfirm(), register.getPid());
        String actualMsg = registerPage.getCreateSuccessfullyMsg();
        String expectedMsg = register.getMessage();
        Assert.assertEquals(actualMsg, expectedMsg, "Register message is not displayed as expected");
    }
}
