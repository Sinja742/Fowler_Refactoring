package test;

import main.Movie;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MovieTest {
    public static Movie movie;
    public static Movie movie2;

    @BeforeAll
    public static void setUp() {
        movie = new Movie("Spiderman far from home", 0);
        movie2 = new Movie("Spiderman homecoming", 1);
    }

    @Test
    void getPriceCode() {
        Assertions.assertEquals(0, movie.getPriceCode());
        Assertions.assertEquals(1, movie2.getPriceCode());
    }

    @Test
    void getTitle() {
        Assertions.assertEquals("Spiderman far from home", movie.getTitle());
        Assertions.assertEquals("Spiderman homecoming", movie2.getTitle());
    }
}
