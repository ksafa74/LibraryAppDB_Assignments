package com.library.steps;

import com.library.pages.BookPage;
import com.library.utility.BrowserUtil;
import com.library.utility.DB_Util;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US05_StepDefs {

    BookPage bookPage = new BookPage();
    String actualMostPopularGenre;

    @Given("Establish the database connection")
    public void establish_the_database_connection() {

        // see Hooks class

    }

    @When("I execute query to find most popular book genre")
    public void i_execute_query_to_find_most_popular_book_genre() {

        bookPage.mostPopularBookQuery();
        actualMostPopularGenre = DB_Util.getFirstRowFirstColumn();

    }

    @Then("verify {string} is the most popular book genre.")
    public void verify_is_the_most_popular_book_genre(String expectedMostPopularBookGenre) {

        Assert.assertEquals(expectedMostPopularBookGenre,actualMostPopularGenre);



    }
}
