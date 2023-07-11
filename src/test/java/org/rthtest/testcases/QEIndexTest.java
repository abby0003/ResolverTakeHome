package org.rthtest.testcases;

import org.rthtest.base.QEIndexBase;
import org.rthtest.pages.QEIndexPageObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class QEIndexTest extends QEIndexBase {

    QEIndexPageObject qeIndexPage;

    public QEIndexTest() {
        super();
    }

    @Parameters("browser")
    @BeforeMethod
    public void setUp(String browser) {
        initialization(browser);
        qeIndexPage = new QEIndexPageObject();
    }

    @Test
    public void Test1() {
        Assert.assertTrue(qeIndexPage.verifyEmailInputDisplayed(),
                "Email input is not displayed on Home Page");
        Assert.assertTrue(qeIndexPage.verifyPasswordInputDisplayed(),
                "Password input is not displayed on Home Page");
        Assert.assertTrue(qeIndexPage.verifySignInButtonDisplayed(),
                "Sign In button is not displayed on Home Page");
        qeIndexPage.enterEmailField();
        qeIndexPage.enterPwdField();
    }

    @Test
    public void Test2() {
        Assert.assertEquals(qeIndexPage.getListItemsSize(),3,
                "List elements size is not equal to 3");
        Assert.assertEquals(qeIndexPage.getListItemValue(1),"List Item 2",
                "Second list item value is not equal to List Item 2");
        qeIndexPage.getListItemValue(1);
        Assert.assertEquals(qeIndexPage.getListItemBadgeValue(1), "6",
                "Second list item badge value is not equal to 6");
    }

    @Test
    public void Test3() {
        Assert.assertEquals(qeIndexPage.getSelectedValueFromDropDown(),"Option 1",
               "Default select value is not Option 1");
        qeIndexPage.clickOnDropDownButton();
        qeIndexPage.selectOptionPosition(2);
        Assert.assertEquals(qeIndexPage.getSelectedValueFromDropDown(),"Option 3",
                "Selected value is not Option 3");
    }

    @Test
    public void Test4() {
        Assert.assertTrue(qeIndexPage.checkFirstButtonTest4(),
                "First button is not enabled");
        Assert.assertFalse(qeIndexPage.checkSecondButtonTest4(),
                "Second button is is not disabled");
    }

    @Test
    public void Test5() {
        qeIndexPage.clickButtonTest5();
        Assert.assertEquals(qeIndexPage.getSuccessMessageTest5(),"You clicked a button!",
                "Success message is not displayed after clicking Test 5 button");
        Assert.assertFalse(qeIndexPage.checkButtonStatusTest5(),
                "Test5 button is not disabled");

    }

    @Test
    public void Test6() {
        Assert.assertEquals(qeIndexPage.getGridDataCellValuePosition(2,2),"Ventosanzap",
                "The grid data at position 2,2 is not Ventosanzap");

    }
        @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}
