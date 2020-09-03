package com.letskodeit.testclasses;

import com.letskodeit.base.BaseTest;
import com.letskodeit.base.CheckPoint;
import com.letskodeit.pageclasses.CategoryFilterPage;
import com.letskodeit.pageclasses.NavigationPage;
import com.letskodeit.pageclasses.SearchBarPage;
import com.letskodeit.utilities.Constants;
import com.letskodeit.utilities.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;


public class AllCoursesTests extends BaseTest {

    @DataProvider(name = "verifySearchCourseData")
    public Object[][] getVerifySearchCourseData(){
        Object[][] testData = ExcelUtility.getTestData("verify_search_course");
        return testData;
    }



    @BeforeClass
    public void setUp() throws InterruptedException {

        nav = login.signInWith(Constants.DEFAULT_USERNAME, Constants.DEFAULT_PASSWORD);
        Thread.sleep(10000);
        ExcelUtility.setExcelFile(Constants.EXCEL_FILE, "AllCoursesTests");
    }



    @Test(dataProvider = "verifySearchCourseData")
    public void verifySearchCourse(String courseName) {

        nav.allCourses();
        search = new SearchBarPage(driver);
        result = search.course(courseName);
        boolean searchResult = result.verifySearchResult();
        CheckPoint.markFinal("test-02", searchResult, "search course verification");
    }

    @Test(enabled=false)
    public void filterByCategory() {
        //nav = new NavigationPage(driver);
        //driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        nav.allCourses();
        category = new CategoryFilterPage(driver);
        result = category.select("Software IT");
        int count = category.findCoursesCount("Software IT");
        boolean filterResult = result.verifyFilterCourseCount(count);
        CheckPoint.markFinal("test-03", filterResult, "filter by category verification");
    }


    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
