import java.util.Date;

public class DVD extends Video{

    public DVD(String title, int priceCode, Date registeredDate) {
        super(title, Video.DVD, priceCode, registeredDate);
    }

    @Override
    public int getLateReturnPointPenalty() {
        return 3;
    }
}