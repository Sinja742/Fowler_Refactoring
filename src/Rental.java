class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return this.daysRented;
    }

    public Movie getMovie() {
        return this.movie;
    }

    public double getCharge() {
        return getMovie().getCharge(getDaysRented());
    }

    public int getFrequentRenterPoints() {
        return getMovie().getFrequentRenterPoints(getDaysRented());
    }


}