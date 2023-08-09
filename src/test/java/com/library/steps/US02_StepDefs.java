package com.library.steps;

import com.library.pages.DashBoardPage;
import com.library.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class US02_StepDefs {

    LoginPage loginPage = new LoginPage();
    DashBoardPage dashBoardPage = new DashBoardPage();
    String actualBooksBorrowed;

    @Given("the {string} on the home page")
    public void the_on_the_home_page(String librarian) {

        loginPage.login(librarian);
    }
    @When("the librarian gets borrowed books number")
    public void the_librarian_gets_borrowed_books_number() {

        actualBooksBorrowed = dashBoardPage.borrowedBooks();
    }
    @Then("borrowed books number information must match with DB")
    public void borrowed_books_number_information_must_match_with_db() {

        Assert.assertEquals(dashBoardPage.expectedBooksBorrowed(),actualBooksBorrowed);
    }

}
