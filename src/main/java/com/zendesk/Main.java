package com.zendesk;


import com.zendesk.application.Console;
import com.zendesk.exception.TermNotPresentException;
import com.zendesk.service.SearchService;
import com.zendesk.service.SearchServiceImpl;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        SearchService zendeskSearch = new SearchServiceImpl();
        Console.displayWelcomeScreen();
        String choice;
        Scanner scan = new Scanner(System.in).useDelimiter("\n");
        ;
        do {
            Console.displayMainOptions();
            choice = scan.next();
            switch (choice) {
                case Console.SEARCH:
                    do {
                        Console.displaySearchOptions();
                        choice = scan.next();
                        switch (choice) {
                            case Console.SEARCH_USERS:
                            case Console.SEARCH_TICKETS:
                            case Console.SEARCH_ORGANIZATIONS:
                                System.out.println("Enter search term");
                                String term = scan.next();
                                System.out.println("Enter search value");
                                String value = scan.next();
                                try {
                                    if (choice.equals(Console.SEARCH_USERS)) {
                                        Console.displayResults(zendeskSearch.searchByUser(term, value));
                                    } else if (choice.equals(Console.SEARCH_TICKETS)) {
                                        Console.displayResults(zendeskSearch.searchByTicket(term, value));
                                    } else if (choice.equals(Console.SEARCH_ORGANIZATIONS)) {
                                        Console.displayResults(zendeskSearch.searchByOrganization(term, value));
                                    }
                                } catch (TermNotPresentException e) {
                                    System.out.println(e.getMessage());
                                }
                                break;
                            case Console.EXIT:
                                break;
                            case Console.QUIT:
                                Console.displayClosingMessage();
                                System.exit(1);
                            default:
                                System.out.println("Please enter a valid option.\n");
                                break;
                        }
                    } while (!choice.equals(Console.EXIT));
                    break;
                case Console.LIST_FIELDS:
                    Console.displaySearchableFields("Users", zendeskSearch.getUserFields());
                    Console.displaySearchableFields("Tickets", zendeskSearch.getTicketFields());
                    Console.displaySearchableFields("Organizations", zendeskSearch.getOrganizationFields());
                    break;
                case Console.QUIT:
                    Console.displayClosingMessage();
                    System.exit(1);
                default:
                    System.out.println("Please enter a valid option.\n");
                    break;
            }
        } while (!choice.equals(Console.QUIT));

    }
}
