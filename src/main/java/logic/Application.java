package logic;

import constants.VehicleType;
import dao.VehicleBrandDAO;
import dao.VehicleBrandDAOImpl;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.MainPage;
import utils.Environment;

import java.util.List;
import java.util.Map;


public class Application {

    public static void main(String[] args) {
        WebDriver driver = new Environment().getDriver(); // todo:
        BasePage basePage = new BasePage(driver);

        driver.manage().window().maximize();
        driver.get("https://auto.ria.com/");

        MainPage mainPage = basePage.getInstance(MainPage.class);

        System.out.println(" BRANDS ==============================");
        List<String> brands = mainPage.getBrands(VehicleType.WATER_TRANSPORT);
        VehicleBrandDAO vehicleBrandDAO = new VehicleBrandDAOImpl();
        vehicleBrandDAO.addVehicleBrand(brands);

//        System.out.println(" MODELS AND BRANDS ==================");
//        Map<String, String> models = mainPage.getModels(VehicleType.WATER_TRANSPORT);
//        for(Map.Entry<String, String> model : models.entrySet())
//            System.out.println(model.getKey() + " : " + model.getValue()); // It's a pairs 'model : brand'

        driver.close();
        driver.quit();
    }
}