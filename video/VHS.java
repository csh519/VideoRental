package video;

import java.util.Date;

public class VHS extends Video{

    public VHS(String title, int priceCode, Date registeredDate) {
        super(title, Video.VHS, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 1;
    }

    @Override
    public int getDaysRentedLimit() {
        return 5;
    }
}
