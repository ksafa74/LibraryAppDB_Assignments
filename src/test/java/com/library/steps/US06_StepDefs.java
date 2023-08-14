package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.*;

import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class US06_StepDefs {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();
    String bookName;
    String isbn;
    String year;
    String author;
    String bookCategory;


    @When("the librarian click to add book")
    public void the_librarian_click_to_add_book() {

        bookPage.addBook.click();

    }

    @When("the librarian enter book name {string}")
    public void the_librarian_enter_book_name(String bookName) {


        bookPage.bookName.sendKeys(bookName);
        this.bookName = bookName;

    }

    @When("the librarian enter ISBN {string}")
    public void the_librarian_enter_isbn(String isbn) {

        bookPage.isbn.sendKeys(isbn);
        this.isbn = isbn;

    }

    @When("the librarian enter year {string}")
    public void the_librarian_enter_year(String year) {

        bookPage.year.sendKeys(year);
        this.year = year;

    }

    @When("the librarian enter author {string}")
    public void the_librarian_enter_author(String author) {

        bookPage.author.sendKeys(author);
        this.author = author;

    }

    @When("the librarian choose the book category {string}")
    public void the_librarian_choose_the_book_category(String bookCategory) {

        Select select = new Select(bookPage.categoryDropdown);
        select.selectByVisibleText(bookCategory);
        this.bookCategory = bookCategory;

    }

    @When("the librarian click to save changes")
    public void the_librarian_click_to_save_changes() {

        bookPage.saveChanges.click();

    }

    @Then("verify {string} message is displayed")
    public void verify_message_is_displayed(String expectedMessage) {

        String actualMessage = bookPage.toastMessage.getText();
        assertTrue(actualMessage.equals(expectedMessage));

    }

    @Then("verify {string} information must match with DB")
    public void verify_information_must_match_with_db(String bookName) {

        List<String> expectedData = new ArrayList<>(Arrays.asList(this.bookName, isbn, year, author, bookCategory));

        assertEquals(expectedData, bookPage.actualData(bookName));

    }
}
