package com.vytrack.pages;

import com.vytrack.utilities.BrowserUtils;
import com.vytrack.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CalendarEventsPage extends BasePage {


    @FindBy(css = "[title='Create Calendar event']")
    public WebElement createCalendarEvent;

    @FindBy(css = "[class ='btn btn-link dropdown-toggle']")
    public WebElement options;

    @FindBy(css = "[type='number']")
    public WebElement pageNumber;

    @FindBy(css = "[data-toggle='dropdown'][class='btn dropdown-toggle ']")
    public WebElement viewPerPage;

    @FindBy(xpath = "//button[@data-toggle='dropdown']")
    public WebElement viewPerPage2;

    @FindBy(xpath = "//label[contains(text(),'Total of')]")
    public WebElement recordsNumber;

    @FindBy(css = "[class='grid table-hover table table-bordered table-condensed']")
    public WebElement table;

    @FindBy(xpath = "//button[@class = 'btn btn-default btn-small dropdown-toggle']/input")
    public WebElement clickAll;

    @FindBy(xpath = "//table[@class='grid table-hover table table-bordered table-condensed']//td[.='Testers meeting']/..")
    public WebElement testersMeeting;

    public int getRowNumbersOfTable() {
        BrowserUtils.waitForPageToLoad(5);
        List<WebElement> elements = Driver.get().findElements(By.cssSelector("[class='grid table-hover table table-bordered table-condensed']>tbody>tr"));
        return elements.size();
    }

    public String getRecordsNumber() {
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(recordsNumber, 5);
        String recordNumbers = recordsNumber.getText();
        String[] s = recordNumbers.split(" ");

        return s[2];
    }

    public String getPerPageNumber() {
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForVisibility(viewPerPage, 5);
        return viewPerPage.getText();
    }

    public Boolean isAllClicked() {
        Boolean flag = true;
        BrowserUtils.waitForPageToLoad(5);
        List<WebElement> elements = Driver.get().findElements(By.cssSelector("[class='grid table-hover table table-bordered table-condensed']>tbody>tr>td>input"));
        for (WebElement element : elements) {
            if (!element.isSelected()) {
                flag = false;
            }
        }
        return flag;
    }
    public  List<WebElement> getMeetingData(){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);
        List<WebElement> elements = Driver.get().findElements((By.cssSelector("[class='control-group attribute-row']>div>div")));
        return  elements;
    }
    public void navigateToSelectedEvent(String title){
        waitUntilLoaderScreenDisappear();
        BrowserUtils.waitForPageToLoad(5);
        WebElement titleC=Driver.get().findElement(By.xpath("//table[@class='grid table-hover table table-bordered table-condensed']//td[.='"+title+"']/.."));
        BrowserUtils.waitForClickablility(titleC,5);
        titleC.click();
    }
}

