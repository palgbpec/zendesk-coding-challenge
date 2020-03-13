package com.zendesk.service;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.zendesk.exception.TermNotPresentException;
import com.zendesk.utils.JsonUtil;
import com.zendesk.utils.SearchUtil;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SearchServiceImpl implements SearchService{

    private LinkedHashSet<String> userTerms;
    private LinkedHashSet<String> ticketTerms;
    private LinkedHashSet<String> organizationTerms;

    private static JsonUtil jsonUtil = new JsonUtil();
    private static JsonArray userJsonArray = jsonUtil.readJson("users.json");
    private static JsonArray ticketJsonArray = jsonUtil.readJson("tickets.json");
    private static JsonArray organizationJsonArray = jsonUtil.readJson("organizations.json");


    public SearchServiceImpl() {
        userTerms = SearchUtil.getTerms(userJsonArray);
        ticketTerms = SearchUtil.getTerms(ticketJsonArray);
        organizationTerms = SearchUtil.getTerms(organizationJsonArray);
    }

    public List<JsonObject> searchByUser(String term, String val) throws TermNotPresentException{
        if(!userTerms.contains(term)){
            throw new TermNotPresentException("Term " + term + " is not present in Users");
        }
        List<JsonObject> jsonObjectList = SearchUtil.search(userJsonArray, term, val);
        return jsonObjectList;
    }

    public List<JsonObject> searchByOrganization(String term, String val) throws TermNotPresentException {
        if(!organizationTerms.contains(term)){
            throw new TermNotPresentException("Term " + term + " is not present in Organizations");
        }
        List<JsonObject> jsonObjectList = SearchUtil.search(organizationJsonArray, term, val);
        return jsonObjectList;
    }

    public List<JsonObject> searchByTicket(String term, String val) throws TermNotPresentException{
        if(!ticketTerms.contains(term)){
            throw new TermNotPresentException("Term " + term + " is not present in Tickets");
        }
        List<JsonObject> jsonObjectList = SearchUtil.search(ticketJsonArray, term, val);
        return jsonObjectList;
    }

    public Set<String> getUserFields() {
        return userTerms;
    }

    public Set<String> getTicketFields() {
        return ticketTerms;
    }

    public Set<String> getOrganizationFields() {
        return organizationTerms;
    }
}
