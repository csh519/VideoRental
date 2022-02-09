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

		eachPoint += getVideo().getPriceCode().getPoint();

		if ( daysRented > getDaysRentedLimit() )
			eachPoint -= Math.min(eachPoint, getVideo().getLateReturnPointPenalty());

		return eachPoint;
	}

	public double getCharge(int daysRented) {
		return getVideo().getPriceCode().getCharge(daysRented);
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
