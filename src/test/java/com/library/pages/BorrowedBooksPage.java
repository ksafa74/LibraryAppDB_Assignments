package com.library.pages;

import com.library.utility.DB_Util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertTrue;

public class BorrowedBooksPage extends BasePage {


    @FindBy(xpath = "//tbody//td[2]")
    public List<WebElement> allBorrowedBooksName;

    public List<String> pageList() {


        List<String> books = new ArrayList<>();

        for (WebElement element : allBorrowedBooksName) {
            books.add(element.getText());
        }
        return books;
    }
    public boolean studentHasSameBookInDB(){
        String query = "select u.full_name as userName,b.name as bookName\n" +
                "from users u join book_borrow bb on u.id = bb.user_id\n" +
                "join books b on b.id = bb.book_id\n" +
                "where u.full_name = 'Test Student 5'and b.name='OfficeHours'\n" +
                "group by b.name";

        DB_Util.runQuery(query);

        String expectedUser = DB_Util.getCellValue(1,"userName");
        String expectedBookName = DB_Util.getCellValue(1,"bookName");

        if (expectedUser.equals("Test Student 5") && expectedBookName.equals("OfficeHours")){

            return true;
        }
        return false;
    }

}
