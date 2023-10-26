package resources;

import pojo.CheckInOutDates;
import pojo.CreateBooking;

public class TestDataBuild {

	public CreateBooking createBookingPayLoad(String fn, String ln)
	{
		CheckInOutDates dates = new CheckInOutDates();
		dates.setCheckin("2018-01-01");
		dates.setCheckout("2019-01-01");
				
		CreateBooking createBookingRequest = new CreateBooking();
		createBookingRequest.setFirstname(fn);
		createBookingRequest.setLastname(ln);
		createBookingRequest.setTotalprice(1000);
		createBookingRequest.setDepositpaid(true);
		createBookingRequest.setBookingdates(dates);
		
		return createBookingRequest;
	}
}
