package video;

import video.pricecode.PriceCode;

import java.util.Date;

public class DVD extends Video{

    public DVD(String title, PriceCode priceCode, Date registeredDate) {
        super(title, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 3;
    }

    @Override
    public int getDaysRentedLimit() {
        return 2;
    }
}
