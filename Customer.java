import java.util.Vector;
import java.util.Enumeration;

public class Customer {
    private String name;
    private Vector<Rental> rentals = new Vector<>();

    public Customer(String name) {
        this.name = name;
    }

    public void addRental(Rental rental) {
        rentals.addElement(rental);
    }

    public String getName() {
        return name;
    }

    public Enumeration<Rental> getRentals() {
        return rentals.elements();
    }

    public double getTotalCharge() {
        double total = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements())
            total += rentals.nextElement().getCharge();
        return total;
    }

    public int getTotalFrequentRenterPoints() {
        int total = 0;
        Enumeration<Rental> rentals = this.rentals.elements();
        while (rentals.hasMoreElements())
            total += rentals.nextElement().getFrequentRenterPoints();
        return total;
    }

    public String statement() {
        return new TextStatement().value(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }
}
