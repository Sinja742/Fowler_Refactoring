package test;

import main.Movie;
import main.Rental;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RentalTest {
    public static Rental rental;
    public static Movie movie;

    @BeforeAll
    public static void setUp() {
        movie = new Movie("Stolz und Vorurteile", 1);
        rental = new Rental(movie, 70);
    }

    @Test
    void getDaysRented() {
        Assertions.assertEquals(70, rental.getDaysRented());
    }

    @Test
    void getMovie() {
        Assertions.assertEquals(movie, rental.getMovie());
    }
}
