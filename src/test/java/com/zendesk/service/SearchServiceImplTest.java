package com.zendesk.service;


import com.zendesk.exception.TermNotPresentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;

public class SearchServiceImplTest {

    private SearchService searchService;

    @Before
    public void init() {
        searchService = new SearchServiceImpl();
    }

    @Test
    public void getSearchableFieldsUser_ValidInitialization_shouldReturnNonEmptySet(){
        Assert.assertNotNull(searchService.getUserFields());
        Assert.assertTrue(searchService.getUserFields().size() > 0);
    }

    @Test
    public void getSearchableFieldsTicket_ValidInitialization_shouldReturnNonEmptySet(){
        Assert.assertNotNull(searchService.getTicketFields());
        Assert.assertTrue(searchService.getTicketFields().size() > 0);
    }

    @Test
    public void getSearchableFieldsOrganization_ValidInitialization_shouldReturnNonEmptySet(){
         Assert.assertNotNull(searchService.getOrganizationFields());
         Assert.assertTrue(searchService.getOrganizationFields().size() > 0);
    }

    @Test
    public void testSearchUser_InvalidTerm_shouldThrowException() {
        try {
            searchService.searchByUser("invalidTerm","invalidValue");
            Assert.fail("TermNotPresentException should be thrown");
        } catch (TermNotPresentException e) {
            Assert.assertThat(e.getMessage(),is("Term invalidTerm is not present in Users"));
        }
    }

    @Test
    public void testSearchTicket_InvalidTerm_shouldThrowException() {
        try {
            searchService.searchByTicket("invalidTerm","invalidValue");
            Assert.fail("TermNotPresentException should be thrown");
        } catch (TermNotPresentException e) {
            Assert.assertThat(e.getMessage(),is("Term invalidTerm is not present in Tickets"));
        }
    }

    @Test
    public void testSearchOrganization_InvalidTerm_shouldThrowException() {
        try {
            searchService.searchByOrganization("invalidTerm","invalidValue");
            Assert.fail("TermNotPresentException should be thrown");
        } catch (TermNotPresentException e) {
            Assert.assertThat(e.getMessage(),is("Term invalidTerm is not present in Organizations"));
        }
    }
}
