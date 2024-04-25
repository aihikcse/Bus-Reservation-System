package org.bus.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Component
@Scope("Prototype")
@Table(name="reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer reservationId;
    @Column(name="reservationStatus", nullable=false)
    private String reservationStatus;
    @Column(name="reservationType", nullable=false)
    private String reservationType;
    @Column(name="reservationDate", nullable=false)
    private LocalDate reservationDate;
    @Column(name="reservationTime", nullable=false)
    private LocalTime reservationTime;
    @Column(name="source", nullable=false)
    private String source;
    @Column(name="destination", nullable=false)
    private String destination;
   
    @OneToOne(cascade=CascadeType.ALL)
    private Bus bus;
//    @OneToOne
//    private FeedBack feedback;
    public Reservation() {
    }
	public Reservation(Integer reservationId, String reservationStatus, String reservationType,
			LocalDate reservationDate, LocalTime reservationTime, String source, String destination) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.source = source;
		this.destination = destination;
	}
	

	public Reservation(Integer reservationId, String reservationStatus, String reservationType,
			LocalDate reservationDate, LocalTime reservationTime, String source, String destination, Bus bus,
			FeedBack feedback) {
		super();
		this.reservationId = reservationId;
		this.reservationStatus = reservationStatus;
		this.reservationType = reservationType;
		this.reservationDate = reservationDate;
		this.reservationTime = reservationTime;
		this.source = source;
		this.destination = destination;
		this.bus = bus;
		//this.feedback = feedback;
	}
	public Integer getReservationId() {
		return reservationId;
	}

	public void setReservationId(Integer reservationId) {
		this.reservationId = reservationId;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getReservationType() {
		return reservationType;
	}

	public void setReservationType(String reservationType) {
		this.reservationType = reservationType;
	}

	public LocalDate getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(LocalDate reservationDate) {
		this.reservationDate = reservationDate;
	}

	public LocalTime getReservationTime() {
		return reservationTime;
	}

	public void setReservationTime(LocalTime reservationTime) {
		this.reservationTime = reservationTime;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	
	public Bus getBus() {
		return bus;
	}
	public void setBus(Bus bus) {
		this.bus = bus;
	}
//	public FeedBack getFeedback() {
//		return feedback;
//	}
//	public void setFeedback(FeedBack feedback) {
//		this.feedback = feedback;
//	}
	  
}
