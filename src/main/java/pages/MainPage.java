package pages;

import constants.VehicleType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }


    // WEB-ELEMENTS ====================================================================================================

    @FindBy(xpath = "//*[@id='mainSearchForm']/div[1]/label[1]")
    private WebElement inactiveTab;


    @FindBy(xpath = "//*[@id='categories']")
    private WebElement typesSelect;

    @FindBy(xpath = "//*[@id='categories']/option")
    private List<WebElement> typesItems;

    @FindBy(xpath = "//*[@id='brandTooltipBrandAutocomplete-brand']/label")
    private WebElement brandsSelect;

    @FindBy(xpath = "//*[@id='brandTooltipBrandAutocomplete-brand']/span")
    private WebElement brandsSelectCloseButton;

    @FindBy(xpath = "//*[@id='brandTooltipBrandAutocomplete-brand']/ul/li[@class='list-item']")
    private List<WebElement> brandsItems;

    @FindBy(xpath = "//*[@id='brandTooltipBrandAutocomplete-model']/label")
    private WebElement modelsSelect;

    @FindBy(xpath = "//*[@id='brandTooltipBrandAutocomplete-model']/ul/li[@class='list-item']")
    private List<WebElement> modelsItems;

    @FindBy(xpath = "//*[@id='mainSearchForm']/div[3]/button")
    private WebElement searchButton;

    @FindBy(xpath = "//*[@id='mainSearchForm']/div[3]/a")
    private WebElement advancedSearchButton;


    // GETTERS =========================================================================================================


    public WebElement getInactiveTab() {
        return inactiveTab;
    }

    public WebElement getTypesSelect() {
        return typesSelect;
    }

    public List<WebElement> getTypesItems() {
        return typesItems;
    }

    public WebElement getBrandsSelect() {
        return brandsSelect;
    }

    public WebElement getBrandsSelectCloseButton() {
        return brandsSelectCloseButton;
    }

    public List<WebElement> getBrandsItems() {
        return brandsItems;
    }

    public WebElement getModelsSelect() {
        return modelsSelect;
    }

    public List<WebElement> getModelsItems() {
        return modelsItems;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getAdvancedSearchButton() {
        return advancedSearchButton;
    }


    // SCENARIOS =======================================================================================================

    public List<String> getTypes() {
        List<String> result = new LinkedList<>();

        for(WebElement item : getTypesItems()) {
            result.add(item.getText());
        }
        return result;
    }


    public List<String> getBrands(VehicleType type) {
        getTypesSelect().click();
        getTypeAsWebElement(type).click();
        getInactiveTab().click();
        getBrandsSelect().click();

        List<String> result = new LinkedList<>();

        for(WebElement item : getBrandsItems()) {
            result.add(item.getText());
        }
        return result;
    }


    public Map<String, String> getModels(VehicleType type) {
        getTypesSelect().click();
        getTypeAsWebElement(type).click();
        getInactiveTab().click();
        getBrandsSelect().click();

        Map<String, String> result = new HashMap<>();

        for(WebElement brandItem : getBrandsItems()) {
            String brand = brandItem.getText();
            brandItem.click();
            getInactiveTab().click();
            getModelsSelect().click();

            for(WebElement modelItem : getModelsItems()) {
                result.put(modelItem.getText(), brand);
            }
            getInactiveTab().click();
            getBrandsSelectCloseButton().click();
        }
        return result;
    }


    private WebElement getTypeAsWebElement(VehicleType type) {
        WebElement result = null;
        for(WebElement element : getTypesItems()) {
            if(type.value.equals(element.getText())) {
                result = element;
                break;
            }
        }
        return result;
    }
}