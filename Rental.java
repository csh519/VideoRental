import video.Video;

import java.util.Date;

public class Rental {
	private Video video ;
	private RentalStatus rentalStatus ;
	private Date rentDate ;
	private Date returnDate ;

	public Rental(Video video) {
		this.video = video ;
		rentalStatus = RentalStatus.RENTED ;
		rentDate = new Date() ;
	}

	public int getPoint(int daysRented) {
		int eachPoint = 1;

		if ((getVideo().getPriceCode() == Video.NEW_RELEASE) )
			eachPoint++;

		if ( daysRented > getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty());

		return eachPoint;
	}

	public double getCharge(int daysRented) {
		double charge = 0;

		switch (getVideo().getPriceCode()) {
			case Video.REGULAR:
				charge += 2;
				if (daysRented > 2)
					charge += (daysRented - 2) * 1.5;
				break;
			case Video.NEW_RELEASE:
				charge = daysRented * 3;
				break;
		}

		return charge;
	}

	public Video getVideo() {
		return video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

	public RentalStatus getStatus() {
		return rentalStatus;
	}

	public void returnVideo() {
		if ( rentalStatus == RentalStatus.RETURNED ) {
			this.rentalStatus = RentalStatus.RETURNED;
			returnDate = new Date() ;
		}
	}
	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public int getDaysRentedLimit() {
		int limit = 0 ;
		int daysRented ;
		daysRented = getDaysRented();
		if ( daysRented <= 2) return limit ;

		return video.getDaysRentedLimit();
	}

	public int getDaysRented() {
		if (getStatus() == RentalStatus.RETURNED) { // returned video.Video
			return calcDays(returnDate, rentDate);
		} else { // not yet returned
			return calcDays(new Date(), rentDate);
		}
	}

	private int calcDays(Date from, Date to) {
		long diff = from.getTime() - to.getTime();
		return (int) (diff / (1000 * 60 * 60 * 24)) + 1;
	}
}
