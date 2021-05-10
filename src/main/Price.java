package main;

public interface Price {
    int getPriceCode();

    double getCharge(int daysRented);

    int getFrequentRenterPoints(int daysRented);
}
