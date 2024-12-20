package com.pages.demo.pages.elements;

import com.pages.base.BasePage;
import org.openqa.selenium.By;

import static utilities.JavaScriptUtility.scrollToElementJS;

public class WebTablesPage extends BasePage {

    private final By registrationFormText = By.xpath("//div[@id='registration-form-modal']");
    private final By registrationFirstNameField = By.id("firstName");
    private final By registrationLastNameField = By.id("lastName");
    private final By registrationEmailField = By.id("userEmail");
    private final By registrationAgeField = By.id("age");
    private final By registrationSalaryField = By.id("salary");
    private final By registrationDepartmentField = By.id("department");
    private final By submitButton = By.id("submit");
    private final By addNewRecordButton = By.id("addNewRecordButton");
    private final By searchBox = By.id("searchBox");
    private final By nextButton = By.xpath("//button[contains(.,'Next')]");
    private final By previousButton = By.xpath("//button[contains(.,'Previous')]");
    private final By noRowsFound = By.xpath("//*[@id=\"app\"]/div/div/div/div[2]/div[2]/div[3]/div[3]");

    private final By firstNamLabel = By.id("firstName-label");
    private final By lastNameLabel = By.id("lastName-label");
    private final By emailLabel = By.id("userEmail-label");
    private final By ageLabel = By.id("age-label");
    private final By salaryLabel = By.id("salary-label");
    private final By departmentLabel = By.id("department-label");

    public String getRegistrationFormText() {
        return find(registrationFormText).getText();
    }

    public void searchWithWord(String word) {
        set(searchBox, word);
    }

    public String getFirstNamLabel() {
        return find(firstNamLabel).getText();
    }

    public String getLastNameLabel() {
        return find(lastNameLabel).getText();
    }

    public String getEmailLabel() {
        return find(emailLabel).getText();
    }

    public String getAgeLabel() {
        return find(ageLabel).getText();
    }

    public String getSalaryLabel() {
        return find(salaryLabel).getText();
    }

    public String getDepartmentLabel() {
        return find(departmentLabel).getText();
    }

    public String getPlaceholderFirstName() {
        return find(registrationFirstNameField).getDomAttribute("placeholder");
    }

    public String getPlaceholderLastName() {
        return find(registrationLastNameField).getDomAttribute("placeholder");
    }

    public String getPlaceholderUserEmail() {
        return find(registrationEmailField).getDomAttribute("placeholder");
    }

    public String getPlaceholderUserAge() {
        return find(registrationAgeField).getDomAttribute("placeholder");
    }

    public String getPlaceholderUserSalary() {
        return find(registrationSalaryField).getDomAttribute("placeholder");
    }

    public String getNoRowsFound() {
        return find(noRowsFound).getText();
    }

    public void clickAddButton() {
        click(addNewRecordButton);
    }

    public void setAge(String age) {
        set(registrationAgeField, age);
    }

    public void setFirstName(String name) {
        set(registrationFirstNameField, name);
    }

    public void setEmail(String email) {
        set(registrationEmailField, email);
    }

    public void setSalary(String salary) {
        set(registrationSalaryField, salary);
    }

    public void setDepartment(String department) {
        set(registrationDepartmentField, department);
    }

    public void setLastName(String name) {
        set(registrationLastNameField, name);
    }

    public String getPlaceholderDepartment() {
        return find(registrationDepartmentField).getDomAttribute("placeholder");
    }

    public void clickSubmitButton() {
        delay(200); //TODO
        click(submitButton);
    }

    public void clickEdit(String email) {
        By edit = By.xpath("//div[text()='" + email + "']//following::span[@title='Edit']");
        scrollToElementJS(edit);
        click(edit);
    }

    public void clickDeleteByEmail(String email) {
        By delete = By.xpath("//div[text()='" + email + "']//following::span[@title='Delete']");
        scrollToElementJS(delete);
        click(delete);
    }

    public String getTableAge(String email) {
        By tableAge = By.xpath("//div[text()='" + email + "']//preceding::div[1]");
        return find(tableAge).getText();
    }

    public String getTableFirstName(String email) {
        By tableFirstName = By.xpath("//div[text()='" + email + "']//preceding::div[3]");
        return find(tableFirstName).getText();
    }

    public String getTableLastName(String email) {
        By tableLastName = By.xpath("//div[text()='" + email + "']//preceding::div[2]");
        return find(tableLastName).getText();
    }

    public String getTableEmail(String email) {
        By tableEmail = By.xpath("//div[@class='rt-td'][contains(., '" + email + "')]");
        return find(tableEmail).getText();
    }

    public String getTableSalary(String email) {
        By tableSalary = By.xpath("//div[text()='" + email + "']//following-sibling::div[1]");
        return find(tableSalary).getText();
    }

    public String getTableDepartment(String email) {
        By tableDepartment = By.xpath("//div[text()='" + email + "']//following-sibling::div[2]");
        return find(tableDepartment).getText();
    }

    public boolean checkPreviousButtonIsActive() {
        scrollToElementJS(previousButton);
        return find(previousButton).isEnabled();
    }

    public boolean checkNextButtonIsActive() {
        scrollToElementJS(previousButton);
        return find(nextButton).isEnabled();
    }

    public boolean isAllBordersRed(String color) {
        delay(500);

        boolean bordersRed = true;

        for (int i = 0; i <= 6; i++) {
            if (i == 0) {
                String str = find(registrationFirstNameField).getCssValue("border");
                String endColor = str.substring(str.length() - 18);

                if (!endColor.equals(color)) {
                    bordersRed = false;
                }
            } else if (i == 1) {
                String str = find(registrationLastNameField).getCssValue("border");
                String endColor = str.substring(str.length() - 18);

                if (!endColor.equals(color)) {
                    bordersRed = false;
                }
            } else if (i == 2) {
                String str = find(registrationEmailField).getCssValue("border");
                String endColor = str.substring(str.length() - 18);

                if (!endColor.equals(color)) {
                    bordersRed = false;
                }
            } else if (i == 3) {
                String str = find(registrationAgeField).getCssValue("border");
                String endColor = str.substring(str.length() - 18);

                if (!endColor.equals(color)) {
                    bordersRed = false;
                }
            } else if (i == 4) {
                String str = find(registrationSalaryField).getCssValue("border");
                String endColor = str.substring(str.length() - 18);

                if (!endColor.equals(color)) {
                    bordersRed = false;
                }
            } else if (i == 5) {
                String str = find(registrationDepartmentField).getCssValue("border");
                String endColor = str.substring(str.length() - 18);

                if (!endColor.equals(color)) {
                    bordersRed = false;
                }
            }
        }

        return bordersRed;
    }

    public String getSubmitButtonText() {
        return find(submitButton).getText();
    }
}
