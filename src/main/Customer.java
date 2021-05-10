package main;

import main.Rental;

import java.lang.*;
import java.util.*;

public class Customer {
    private String name;
    private Vector rentals = new Vector();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental arg) {
        this.rentals.addElement(arg);
    }

    public String getName() {
        return this.name;
    }

    public String statement() {
        double totalAmount = 0;
        Enumeration rentals = this.rentals.elements();
        String stmt = "Rental Record for " + this.getName() + "\n";
        stmt = stmt + "\t" + "Title" + "\t" + "\t" + "Days" + "\t" + "Amount" + "\n";

        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            //determine amounts for each line
            //show figures for this rental
            stmt = stmt + "\t" + each.getMovie().getTitle() + "\t" + "\t" + each.getDaysRented() + "\t" + String.valueOf(each.getCharge()) + "\n";
        }
        //add footer lines
        stmt = stmt + "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
        stmt = stmt + "You earned " + String.valueOf(getTotalFrequentRenterPoints()) + " frequent renter points";
        return stmt;
    }

//    It is worth stopping to think a bit about the last refactoring. Most refactorings reduce the amount
//    of code, but this one increases it. That's because Java 1.1 requires a lot of statements to set up a
//    summing loop. Even a simple summing loop with one line of code per element needs six lines of
//    support around it. It's an idiom that is obvious to any programmer but is a lot of lines all the same.
//    The other concern with this refactoring lies in performance. The old code executed the "while"
//    loop once, the new code executes it three times. A while loop that takes a long time might impair
//    performance. Many programmers would not do this refactoring simply for this reason. But note
//    the words if and might. Until I profile I cannot tell how much time is needed for the loop to
//    calculate or whether the loop is called often enough for it to affect the overall performance of the
//    system. Don't worry about this while refactoring. When you optimize you will have to worry about
//    it, but you will then be in a much better position to do something about it, and you will have more
//    options to optimize effectively (see the discussion on page 69).

    private double getTotalCharge() {
        double result = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    private int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration enum_rentals = rentals.elements();
        while (enum_rentals.hasMoreElements()) {
            Rental each = (Rental) enum_rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

}
    