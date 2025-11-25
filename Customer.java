import java.util.Enumeration;
import java.util.Vector;
import java.util.ArrayList;
import java.util.List;

class Customer {

    private String _name;
    private Vector _rentals = new Vector();

    public Customer(String name) {
        _name = name;
    }

    public void addRental(Rental arg) {
        _rentals.addElement(arg);
    }

    public String getName() {
        return _name;
    }

    // NECESSÁRIO PARA O TEMPLATE METHOD
    public Enumeration getRentals() {
        return _rentals.elements();
    }

    // Extra: converte Enumeration em List para usar no for-each
    public List<Rental> getRentalsAsList() {
        List<Rental> list = new ArrayList<>();
        Enumeration e = _rentals.elements();
        while (e.hasMoreElements()) {
            list.add((Rental) e.nextElement());
        }
        return list;
    }

    public double getTotalCharge() {
        double result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getCharge();
        }
        return result;
    }

    public int getTotalFrequentRenterPoints() {
        int result = 0;
        Enumeration rentals = _rentals.elements();
        while (rentals.hasMoreElements()) {
            Rental each = (Rental) rentals.nextElement();
            result += each.getFrequentRenterPoints();
        }
        return result;
    }

    // Chamadas públicas dos statements
    public String statement() {
        return new TextStatement().value(this);
    }

    public String htmlStatement() {
        return new HtmlStatement().value(this);
    }
}
