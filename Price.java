abstract class Price {

    public abstract double getCharge(int daysRented);

    // Versão padrão (genérica)
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
