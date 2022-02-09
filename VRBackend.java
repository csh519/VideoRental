import java.util.List;

public class VRBackend {

    public static String getReport(Customer customer) {
        String result = "Customer Report for " + customer.getName() + "\n";

        List<Rental> rentals = customer.getRentals();

        double totalCharge = 0;
        int totalPoint = 0;

        for (Rental each : rentals) {
            int daysRented = each.getDaysRented();
            double eachCharge = each.getCharge(daysRented);
            int eachPoint = each.getPoint(daysRented);

            result += "\t" + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
                    + "\tPoint: " + eachPoint + "\n";

            totalCharge += eachCharge;
            totalPoint += eachPoint ;
        }

        result += "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";


        if ( totalPoint >= 10 ) {
            System.out.println("Congrat! You earned one free coupon");
        }
        if ( totalPoint >= 30 ) {
            System.out.println("Congrat! You earned two free coupon");
        }
        return result ;
    }

}
