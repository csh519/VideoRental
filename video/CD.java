package video;

import video.pricecode.PriceCode;

import java.util.Date;

public class CD extends Video {
    public CD(String title, PriceCode priceCode, Date registeredDate) {
        super(title, Video.CD, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 2;
    }

    @Override
    public int getDaysRentedLimit() {
        return 3;
    }
}
