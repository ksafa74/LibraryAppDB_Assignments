package com.library.pages;



import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import com.library.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class BookPage extends BasePage {



    @FindBy(xpath = "//table/tbody/tr")
    public List<WebElement> allRows;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement search;

    @FindBy(id = "book_categories")
    public WebElement mainCategoryElement;

    @FindBy(name = "name")
    public WebElement bookName;


    @FindBy(xpath = "(//input[@type='text'])[4]")
    public WebElement author;

    @FindBy(xpath = "//div[@class='portlet-title']//a")
    public WebElement addBook;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement saveChanges;

    @FindBy(xpath = "//div[@class='toast-message']")
    public WebElement toastMessage;

    @FindBy(name = "year")
    public WebElement year;

    @FindBy(name = "isbn")
    public WebElement isbn;

    @FindBy(id = "book_group_id")
    public WebElement categoryDropdown;


    @FindBy(id = "description")
    public WebElement description;


    public WebElement editBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public WebElement borrowBook(String book) {
        String xpath = "//td[3][.='" + book + "']/../td/a";
        return Driver.getDriver().findElement(By.xpath(xpath));
    }

    public List<String> actualBookCategories() {

        List<String> actualBookCategories = new ArrayList<>();

        Select select = new Select(mainCategoryElement);

        List<WebElement> list = select.getOptions();

        for (int i = 1; i <= list.size() - 1; i++) {

            actualBookCategories.add(list.get(i).getText());
        }

        System.out.println("actualBookCategories = " + actualBookCategories);

        return actualBookCategories;
    }

    public List<String> expectedBookCategories() {

        DB_Util.runQuery("select name from book_categories");

        List<String> expectedBookCategories = DB_Util.getColumnDataAsList("name");

        System.out.println("expectedBookCategories = " + expectedBookCategories);

        return expectedBookCategories;
    }

    public List<String> actualBookInfo(String bookName){

        List<String> actualBookInfo = new ArrayList<>();

        actualBookInfo = BrowserUtil.getElementsText(Driver.getDriver().findElements(By.xpath("//tbody/tr/td[.='"+bookName+"']/../td")));

        actualBookInfo.remove(0);
        actualBookInfo.remove(actualBookInfo.size()-1);

        System.out.println("actualBookInfo = " + actualBookInfo);

        return actualBookInfo;

    }
    public List<String> expectedBookInfo(String bookName){

        DB_Util.runQuery("select isbn,books.name,author,book_categories.name,year\n" +
                "from books join book_categories on books.book_category_id = book_categories.id\n" +
                "where  books.name = '"+bookName+"'");
        List<String> expectedBookInfo = DB_Util.getRowDataAsList(1);

        System.out.println("expectedBookInfo = " + expectedBookInfo);

        return expectedBookInfo;
    }



}
