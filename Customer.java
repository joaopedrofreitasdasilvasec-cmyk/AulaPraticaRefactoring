import java.util.Enumeration;
import java.util.Vector;

public class Customer {
   private String _name;
   private Vector _rentals = new Vector();

   public Customer (String name){
      _name = name;
   }

   public void addRental(Rental arg) {
      _rentals.addElement(arg);
   }

   public String getName (){
      return _name;
   }

   public String statement() {

     String result = "Rental Record for " + getName() + "\n";

     Enumeration rentals = _rentals.elements();
     while (rentals.hasMoreElements()) {
        Rental each = (Rental) rentals.nextElement();

        result += "\t" + each.getMovie().getTitle() + "\t" +
            String.valueOf(amountFor(each)) + "\n";
     }

     result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
     result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
              " frequent renter points";

     return result;
   }

   private double amountFor(Rental rental) {
      double thisAmount = 0;

      switch (rental.getMovie().getPriceCode()) {

         case Movie.REGULAR:
            thisAmount += 2;
            if (rental.getDaysRented() > 2)
               thisAmount += (rental.getDaysRented() - 2) * 1.5;
            break;

         case Movie.NEW_RELEASE:
            thisAmount += rental.getDaysRented() * 3;
            break;

         case Movie.CHILDRENS:
            thisAmount += 1.5;
            if (rental.getDaysRented() > 3)
               thisAmount += (rental.getDaysRented() - 3) * 1.5;
            break;
      }

      return thisAmount;
   }

   private int frequentRenterPointsFor(Rental rental) {
      if (rental.getMovie().getPriceCode() == Movie.NEW_RELEASE &&
          rental.getDaysRented() > 1)
         return 2;

      return 1;
   }

   // ⭐ Novo método (substitui totalAmount)
   private double getTotalCharge() {
      double result = 0;
      Enumeration rentals = _rentals.elements();

      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += amountFor(each);
      }
      return result;
   }

   // ⭐ Novo método (substitui frequentRenterPoints)
   private int getTotalFrequentRenterPoints() {
      int result = 0;
      Enumeration rentals = _rentals.elements();

      while (rentals.hasMoreElements()) {
         Rental each = (Rental) rentals.nextElement();
         result += frequentRenterPointsFor(each);
      }
      return result;
   }
}
