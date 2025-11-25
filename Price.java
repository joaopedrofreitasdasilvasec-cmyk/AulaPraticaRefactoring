abstract class Price {

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        // Código extraído de Movie
        if (this instanceof NewReleasePrice && daysRented > 1)
            return 2;
        return 1;
    }
}
