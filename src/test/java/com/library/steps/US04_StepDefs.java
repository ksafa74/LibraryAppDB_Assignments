package com.library.steps;

import com.library.pages.BookPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class US04_StepDefs {
    BookPage bookPage = new BookPage();


    @When("the user searches for {string} book")
    public void the_user_searches_for_book(String bookName) {

        bookPage.userSearches(bookName);


    }

    @When("the user clicks edit book button")
    public void the_user_clicks_edit_book_button() {


        bookPage.editBook(BookPage.booksName).click();

    }

    @Then("book information must match the Database")
    public void book_information_must_match_the_database() {


        Assert.assertEquals(bookPage.expectedBookInfo(BookPage.booksName), bookPage.actualBookInfo(BookPage.booksName));


    }

}
