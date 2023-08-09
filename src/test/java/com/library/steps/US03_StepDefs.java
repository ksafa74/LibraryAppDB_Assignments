package com.library.steps;

import com.library.pages.BookPage;
import com.library.pages.DashBoardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US03_StepDefs {


    DashBoardPage dashBoardPage = new DashBoardPage();
    BookPage bookPage = new BookPage();

    @When("the user navigates to {string} page")
    public void the_user_navigates_to_page(String books) {

        dashBoardPage.navigateModule(books);

    }
    @When("the user clicks book categories")
    public void the_user_clicks_book_categories() {

        bookPage.mainCategoryElement.click();

    }
    @Then("verify book categories must match book_categories table from db")
    public void verify_book_categories_must_match_book_categories_table_from_db() {


        Assert.assertEquals(bookPage.expectedBookCategories(),bookPage.actualBookCategories());

    }
}
