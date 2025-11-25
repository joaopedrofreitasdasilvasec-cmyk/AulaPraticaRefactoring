public abstract class Statement {

    public String value(Customer customer) {
        StringBuilder result = new StringBuilder();

        result.append(headerString(customer));

        for (Rental rental : customer.getRentalsAsList()) {
            result.append(eachRentalString(rental));
        }

        result.append(footerString(customer));

        return result.toString();
    }

    protected abstract String headerString(Customer customer);
    protected abstract String eachRentalString(Rental rental);
    protected abstract String footerString(Customer customer);
}
