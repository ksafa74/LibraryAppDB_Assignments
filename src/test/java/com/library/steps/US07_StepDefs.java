package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.BorrowedBooksPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.*;
import org.openqa.selenium.Keys;


public class US07_StepDefs {


    BookPage bookPage = new BookPage();
    BorrowedBooksPage borrowedBooksPage = new BorrowedBooksPage();


    @And("the user navigate to {string} page")
    public void theUserNavigateToPage(String books) {

        bookPage.navigateModule(books);

    }

    @When("the user clicks Borrow Book")
    public void the_user_clicks_borrow_book() {

        bookPage.borrowBookButton.sendKeys(Keys.ENTER);

    }

    @Then("verify that book is shown in {string} page")
    public void verify_that_book_is_shown_in_page(String borrowingBook) {

        bookPage.navigateModule(borrowingBook);

        assertTrue(borrowedBooksPage.pageList().contains("OfficeHours"));

    }

    @Then("verify logged student has same book in database")
    public void verify_logged_student_has_same_book_in_database() {

        assertTrue(borrowedBooksPage.studentHasSameBookInDB());

    }


}
