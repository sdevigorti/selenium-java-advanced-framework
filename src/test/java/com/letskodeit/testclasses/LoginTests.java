package com.letskodeit.testclasses;


import com.letskodeit.base.BaseTest;
import com.letskodeit.base.CheckPoint;
import com.letskodeit.utilities.Constants;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTests extends BaseTest {

        @BeforeClass
        public void setUp() {

        }

        @AfterMethod
        public void afterMethod() throws InterruptedException {
            if (nav.isUserLoggedIn()) {
                nav.logout();
                nav.login();
            }
        }

        @Test(priority = 1)
        public void testLogin() {
            nav = login.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            //boolean headerResult = nav.verifyHeader();
            //boolean result = nav.verifyHeader();
            //CheckPoint.mark("test-01", headerResult, "header verification");
            boolean result = nav.isUserLoggedIn(); // there are issues with this method also
            CheckPoint.markFinal("test-01", result, "login verification");
            //Assert.assertTrue(result);
        }

        @Test(enabled = true)
        public void testInvalidLogin() {
            nav = login.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);

            boolean result = nav.isUserLoggedIn();
            Assert.assertFalse(result);
        }

    }

