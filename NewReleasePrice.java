class NewReleasePrice extends Price {

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    // Regra especial
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return (daysRented > 1) ? 2 : 1;
    }
}
