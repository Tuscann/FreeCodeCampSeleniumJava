package demoqa.pages.widgets;

import demoqa.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static utilities.DropDownUtility.*;
import static utilities.JavaScriptUtility.scrollToElementJS;

public class SelectMenuPage extends BasePage {

    private final By selectValue = By.id("react-select-2-input");
    private final By selectOne = By.id("react-select-3-input");
    private final By oldStyle = By.id("oldSelectMenu");
    private final By standardMultiSelect = By.id("cars");

    private final By selectMenuLabel = By.xpath("//h1[@class='text-center'][contains(.,'Select Menu')]");
    private final By selectedValueLabel = By.xpath("//div[@class='col-md-6 col-sm-12'][contains(.,'Select Value')]");
    private final By selectedValuePlaceholder = By.xpath("//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select Option')]");
    private final By selectDropDown = By.xpath("//div[@class=' css-1hwfws3'][contains(.,'Select...')]");

    private final By multiSelectDropDown = By.xpath("(//div[contains(@class,' css-1wa3eu0-placeholder')])[3]");
    private final By multiSelectDropDown2 = By.xpath("//div[contains(@class,' css-2b097c-container')]");


    private final By selectedOne = By.xpath("(//div[contains(@class,' css-1hwfws3')])[2]");
    private final By selectedValue = By.xpath("(//div[contains(@class,' css-1uccc91-singleValue')])[1]");
    private final By selectTitleLabel = By.xpath("//div[@class='col-md-6 col-sm-12'][contains(.,'Select One')]");
    private final By expectedSelectTitlePlaceholder = By.xpath("//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select Title')]");
    private final By oldStyleSelectMenuLabel = By.xpath("//div[@class='col-md-6 col-sm-12'][contains(.,'Old Style Select Menu')]");
    private final By oldStyleSelectMenuPlaceholder = By.xpath("//*[@id=\"oldSelectMenu\"]/option[1]");

    private final By expectedMultiselectDropdownLabel = By.xpath("//b[contains(.,'Multiselect drop down')]");
    private final By expectedMultiselectDropdownPlaceholder = By.xpath("//div[@class=' css-1wa3eu0-placeholder'][contains(.,'Select...')]");
    private final By expectedStandardMultiSelectLabel = By.xpath("//b[contains(.,'Standard multi select')]");

    public SelectMenuPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSelectedSelectOne() {
        return find(selectedOne).getText();
    }

    public String getSelectedValue() {
        return find(selectedValue).getText();
    }

    public String getSelectMenuText() {
        return find(selectMenuLabel).getText();
    }

    public String getSelectedValueLabelText() {
        return find(selectedValueLabel).getText();
    }

    public String getSelectedValuePlaceholder() {
        return find(selectedValuePlaceholder).getText();
    }

    public String getSelectTitleLabel() {
        return find(selectTitleLabel).getText();
    }

    public String getSelectTitlePlaceholder() {
        return find(expectedSelectTitlePlaceholder).getText();
    }

    public String getOldStyleSelectMenuLabel() {
        return find(oldStyleSelectMenuLabel).getText();
    }

    public String getOldStyleSelectMenuPlaceholder() {
        return find(oldStyleSelectMenuPlaceholder).getText();
    }

    public String getMultiselectDropdownLabel() {
        return find(expectedMultiselectDropdownLabel).getText();
    }

    public String getMultiselectDropdownPlaceholder() {
        return find(expectedMultiselectDropdownPlaceholder).getText();
    }

    public String getStandardMultiSelectLabel() {
        return find(expectedStandardMultiSelectLabel).getText();
    }

    public String getStandardMultiSelect() {
        return find(standardMultiSelect).getText();
    }

    public List<String> getAllSelectedStandardMultiOptions() {
        return getAllSelectedOptions(standardMultiSelect);
    }

    public void selectSelectOne(String option) {
        find(selectOne).sendKeys(option);
        find(selectOne).sendKeys("" + Keys.ENTER);
    }

    public void multiSelectOne(String color) {


        WebElement selectMyElement = driver.findElement(selectDropDown);
        selectMyElement.click();

        Actions keyDown = new Actions(driver);
        keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN)).perform();


//        WebElement dropdown = driver.findElement(selectDropDown);
//        dropdown.click();
////      find(multiSelectDropDown).click();
//
//        Select selectElement = new Select(dropdown);
//        selectElement.selectByValue(color);
//
//        dropdown.sendKeys(color); // Type the option text
//        dropdown.sendKeys(Keys.ENTER); // Select the option
//        scrollToElementJS(multiSelectDropDown);

//        find(multiSelectDropDown).sendKeys(color);
//        find(multiSelectDropDown).sendKeys("" + Keys.ENTER);


//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(6));
//        wait.until(ExpectedConditions.visibilityOfElementLocated(multiSelectDropDown))
//                .sendKeys(color);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(multiSelectDropDown))
//                .sendKeys(Keys.chord("" + Keys.ENTER));
//
        String x = "12";
    }

    public void selectSelectValue(String option) {
        find(selectValue).sendKeys(option);
        find(selectValue).sendKeys("" + Keys.ENTER);
    }

    public void selectOldStyleSelectMenuByText(String text) {
        WebElement selectElement = driver.findElement(oldStyle);
        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText(text);
    }

    public String getOldStyleSelectMenuSelectedValue() {
        Select dropdown = new Select(driver.findElement(oldStyle));
        WebElement selectedOption = dropdown.getFirstSelectedOption();

        return selectedOption.getText();
    }

    public void selectStandardMultiByText(String text) {
        scrollToElementJS(standardMultiSelect);
        selectByVisibleText(standardMultiSelect, text);
    }

    public void selectStandardMultiByIndex(int index) {
        scrollToElementJS(standardMultiSelect);
        selectByIndex(standardMultiSelect, index);
    }

    public void deselectStandardMulti(String value) {
        scrollToElementJS(standardMultiSelect);
        deselectByValue(standardMultiSelect, value);
    }
}
