package video.pricecode;

public abstract class PriceCode {
    public static final int REGULAR = 1 ;
    public static final int NEW_RELEASE =2 ;

    public abstract double getCharge(int daysRented);

    public abstract double getPoint();
}
