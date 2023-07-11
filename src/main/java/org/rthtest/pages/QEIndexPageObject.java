package org.rthtest.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.rthtest.base.QEIndexBase;

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
}
