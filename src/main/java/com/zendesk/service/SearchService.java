package com.zendesk.service;

import com.google.gson.JsonObject;
import com.zendesk.exception.TermNotPresentException;
import java.util.List;
import java.util.Set;

/**
 *
 *  Service defining methods to search
 *  user, tickets and organizations
 *
 */
public interface SearchService {


    List<JsonObject> searchByUser(String term, String val) throws TermNotPresentException;


    List<JsonObject> searchByOrganization(String term, String val) throws TermNotPresentException;


    List<JsonObject> searchByTicket(String term, String val) throws TermNotPresentException;

    /**
     *
     * @return {@link Set} containing searchable user fields
     */
    Set<String> getUserFields();

    /**
     *
     * @return {@link Set} containing searchable ticket fields
     */
    Set<String> getTicketFields();

    /**
     *
     * @return {@link Set} containing searchable organization fields
     */
    Set<String> getOrganizationFields();
}
