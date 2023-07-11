package org.rthtest.testcases;

import org.rthtest.base.QEIndexBase;
import org.rthtest.pages.QEIndexPageObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class QEIndexTest extends QEIndexBase {

    QEIndexPageObject qeIndexPage;

    public QEIndexTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
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

    @AfterMethod
    public void tearDown() {
        closeDriver();
    }
}
