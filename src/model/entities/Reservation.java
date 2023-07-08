package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	public Reservation() {
		
	}
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
		if(!checkOut.after(checkIn)) {
			 throw new DomainException("Error in reservation: check-out date must be after check-in");
		 }
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() {
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	// long é uma variavel mais longa que o int
	public long duration() {
		long diff = checkOut.getTime() - checkIn.getTime();
		// converter milisegindos para dias    tem que passar o diff é o tempo que ele estava
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public void uptadeDates(Date checkIn, Date checkOut) {
		 Date now = new Date();
		 if (checkIn.before(now) || checkOut.before(now) ) {
			 throw new DomainException("Error in reservation: Reservation dates for upatdes must be future");
		 }
		 if(!checkOut.after(checkIn)) {
			 throw new DomainException("Error in reservation: check-out date must be after check-in");
		 }
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	@Override
	public String toString() {
		return "Room " + 
	roomNumber + ", check-in: "
	+ sdf.format(checkIn) + ", check-out" + sdf.format(checkOut) + ", " 
	+ duration() + " nigths";
	}
	
	
	
	

	
	
	
	
	
}
