import java.util.List;

public class VRBackend {

    public static String getReport(Customer customer) {
        StringBuilder result = new StringBuilder(genHeader(customer));

        List<Rental> rentals = customer.getRentals();

        double totalCharge = 0;
        int totalPoint = 0;

        for (Rental each : rentals) {
            int daysRented = each.getDaysRented();
            double eachCharge = each.getCharge(daysRented);
            int eachPoint = each.getPoint(daysRented);

            result.append(genRentResult(each, daysRented, eachCharge, eachPoint));

            totalCharge += eachCharge;
            totalPoint += eachPoint ;
        }

        result.append(genTotalResult(totalCharge, totalPoint));

        popupCouponMessage(totalPoint);
        return result.toString();
    }

    private static void popupCouponMessage(int totalPoint) {
        if ( totalPoint >= 10 ) {
            System.out.println("Congrat! You earned one free coupon");
        }
        if ( totalPoint >= 30 ) {
            System.out.println("Congrat! You earned two free coupon");
        }
    }

    private static String genHeader(Customer customer) {
        return "Customer Report for " + customer.getName() + "\n";
    }

    private static String genTotalResult(double totalCharge, int totalPoint) {
        return "Total charge: " + totalCharge + "\tTotal Point:" + totalPoint + "\n";
    }

    private static String genRentResult(Rental each, int daysRented, double eachCharge, int eachPoint) {
        return "\t" + each.getVideo().getTitle() + "\tDays rented: " + daysRented + "\tCharge: " + eachCharge
                + "\tPoint: " + eachPoint + "\n";
    }

}
