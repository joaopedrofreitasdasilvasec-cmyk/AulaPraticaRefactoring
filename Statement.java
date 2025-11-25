import java.util.Enumeration;

public abstract class Statement {

    public String value(Customer customer) {
        StringBuilder result = new StringBuilder();

        result.append(headerString(customer));

        Enumeration<Rental> rentals = customer.getRentals();
        while (rentals.hasMoreElements()) {
            Rental each = rentals.nextElement();
            result.append(eachRentalString(each));
        }

        result.append(footerString(customer));

        return result.toString();
    }

    protected abstract String headerString(Customer customer);
    protected abstract String eachRentalString(Rental rental);
    protected abstract String footerString(Customer customer);
}
