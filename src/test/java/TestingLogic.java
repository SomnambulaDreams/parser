import constants.VehicleType;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.MainPage;
import utils.Environment;

import java.util.List;


public class TestingLogic {

    private WebDriver driver = new Environment().getDriver();
    private BasePage basePage = new BasePage(driver);
    private MainPage mainPage = basePage.getInstance(MainPage.class);


    @BeforeClass
    public void openAutoRiaMainPage() {
        driver.manage().window().maximize();
        driver.get("https://auto.ria.com/");
    }


    @Test
    public void doMagic() {
        System.out.println("BRANDS ==============================");
        List<String> brands = mainPage.getBrands(VehicleType.WATER_TRANSPORT);

        for(String brand : brands)
            System.out.println(brand);

//        System.out.println(" MODELS AND BRANDS ==================");
//        Map<String, String> models = mainPage.getModels(VehicleType.WATER_TRANSPORT);
//        for(Map.Entry<String, String> model : models.entrySet())
//            System.out.println(model.getKey() + " : " + model.getValue()); // It's a pairs 'model : brand'
    }


    @AfterClass
    public void closeDriver() {
        driver.quit();
    }
}