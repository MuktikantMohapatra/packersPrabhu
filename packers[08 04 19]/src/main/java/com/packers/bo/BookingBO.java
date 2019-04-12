package com.packers.bo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity(name = "BOOKING")
public class BookingBO {
	@Override
	public String toString() {
		return "BookingBO [id=" + id + ", shiftingFrom=" + shiftingFrom + ", shiftingTo=" + shiftingTo + ", date="
				+ dates + ", custId=" + custId + "]";
	}

	@Id @GeneratedValue(generator="system-uuid")
	@GenericGenerator(name="system-uuid", strategy = "uuid")
	private String id;
	@Column(name = "SHIFTING_FROM")
	private String shiftingFrom;
	@Column(name = "SHIFTING_TO")
	private String shiftingTo;
	//@Column(name = "dates")
	private String dates; //If variable and column name are same no annotation required.
	//@Column(name ="customer_id");
	private String custId ;

	
	 @ManyToMany(fetch = FetchType.LAZY,
	            cascade = {
	                CascadeType.PERSIST,
	                CascadeType.MERGE
	            })
	    @JoinTable(name = "booking_goodslIst",
	            joinColumns = { @JoinColumn(name = "id") },
	            inverseJoinColumns = { @JoinColumn(name = "listId") })
	  private Set<DomesticGoodsList> list = new HashSet<>();
	 
	 
	 
	public String getBookingId() {
		return id;
	}

	public void setBookingId(String bookingId) {
		this.id = bookingId;
	}

	public String getShiftingFrom() {
		return shiftingFrom;
	}

	public void setShiftingFrom(String shiftingFrom) {
		this.shiftingFrom = shiftingFrom;
	}

	public String getShiftingTo() {
		return shiftingTo;
	}

	public void setShiftingTo(String shiftingTo) {
		this.shiftingTo = shiftingTo;
	}

	public String getDate() {
		return dates;
	}

	public void setDate(String date) {
		this.dates = date;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

}
