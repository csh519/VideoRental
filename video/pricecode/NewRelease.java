package video.pricecode;

public class NewRelease extends PriceCode{

    @Override
    public double getCharge(int daysRented) {
        return daysRented * 3;
    }

    @Override
    public double getPoint() {
        return 2;
    }
}
