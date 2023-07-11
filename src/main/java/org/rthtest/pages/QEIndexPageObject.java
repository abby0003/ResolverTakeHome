package org.rthtest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.rthtest.base.QEIndexBase;

import java.time.Duration;
import java.util.List;

public class QEIndexPageObject extends QEIndexBase {

    @FindBy(id = "inputEmail")
    WebElement emailAddress;

    @FindBy(id = "inputPassword")
    WebElement passWord;

    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement loginBtn;

    //@FindBy(xpath = "//ul[@class = 'list-group']/li")
    //List<WebElement> listItems;

    @FindBy(xpath = "//li[starts-with(@class,'list-group-item')]")
    List<WebElement> listItems;
    @FindBy(xpath = "//ul[@class = 'list-group']/li/span")
    List<WebElement> listItemBadges;

    @FindBy(id = "dropdownMenuButton")
    WebElement dropDownButton;

    @FindBy(className = "dropdown-item")
    List<WebElement> dropDownOptions;

    @FindBy(xpath = "//div[@id = 'test-4-div']/button")
    List<WebElement> test4Buttons;

    @FindBy(id = "test5-button")
    WebElement test5Button;

    @FindBy(id = "test5-alert")
    WebElement test5Alert;

    @FindBy(xpath = "//div[@id = 'test-6-div']//table//tbody//td")
    List<WebElement> test6GridData;

    @FindBy(xpath = "//div[@id = 'test-6-div']//table//tbody/tr")
    List<WebElement> test6BodyRow;

    @FindBy(xpath = "//div[@id = 'test-6-div']//table//thead/tr/th")
    List<WebElement> test6GridColumn;


    //----------------------------------------

    public QEIndexPageObject() {
        PageFactory.initElements(driver, this);
    }

    public boolean verifyEmailInputDisplayed() {
        return emailAddress.isDisplayed();
    }

    public boolean verifyPasswordInputDisplayed() {
        return passWord.isDisplayed();
    }

    public boolean verifySignInButtonDisplayed() {
        return loginBtn.isDisplayed();
    }

    public void enterEmailField() {
        emailAddress.sendKeys("rthtestemail@test.com");
    }

    public void enterPwdField() {
        passWord.sendKeys("rtstest123");
    }

    public int getListItemsSize() {
        return listItems.size();
    }

    public String getListItemValue(int pos) {
        StringBuilder itemValue = new StringBuilder();
        String [] content = listItems.get(pos).getText().split(" ");
        for(int i=0;i<content.length;i++) {
            if(i == (content.length - 1)){
                break; }
            else {
                itemValue.append(content[i]);
                if(i<content.length-2){
                    itemValue.append(" ");
                }
            }
        }
        System.out.println(itemValue);
        return itemValue.toString();
    }

    public String getListItemBadgeValue(int pos) {
        return listItemBadges.get(pos).getText();
    }

    public String getSelectedValueFromDropDown() {
        //System.out.println(dropDownButton.getText());
        return dropDownButton.getText();
    }

    public void clickOnDropDownButton() {
        dropDownButton.click();
    }

    public void selectOptionPosition(int pos) {
        dropDownOptions.get(pos).click();
    }

    public boolean checkFirstButtonTest4() {
        return test4Buttons.get(0).isEnabled();
    }

    public boolean checkSecondButtonTest4() {
        return test4Buttons.get(1).isEnabled();
    }

    public void clickButtonTest5() {
        WebDriverWait test5Wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        test5Wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test5-button")));
        test5Button.click();
    }

    public String getSuccessMessageTest5() {
        return test5Alert.getText();
    }

    public boolean checkButtonStatusTest5() {
        return test5Button.isEnabled();
    }

    public String getGridDataCellValuePosition(int x, int y) {
        String [][] test6Data = new String[test6BodyRow.size()][test6GridColumn.size()];
        int row = 0,col = 0;
        for(WebElement e : test6GridData) {
            test6Data[row][col] = e.getText();
            if(col == (test6GridColumn.size()-1)){
                row++;
                col = 0;
            }
            else {
                col++;
            }
        }
        return test6Data[x][y];
    }
}
