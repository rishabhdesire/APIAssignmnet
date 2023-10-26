package pojo;

public class CreateBookingResponse {

	private String bookingid;
	public String getBookingid() {
		return bookingid;
	}
	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}
	public CreateBooking getBooking() {
		return booking;
	}
	public void setBooking(CreateBooking booking) {
		this.booking = booking;
	}
	private CreateBooking booking;

}
