package org.bus.controller;

import java.util.List;

import org.bus.model.Reservation;
import org.bus.model.*;
import org.bus.service.IBusService;
import org.bus.service.IReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	private IReservationService ReservationService;
	
	@Autowired
	private IBusService BusService;
	
	@GetMapping("/reservationservice")
	public String reservationService(Model model) {
			
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
		return "reservationfolder/reservationService";
	}
	
	@GetMapping("/addreservation")
	public String addReservation(Model model) {
			
		Reservation reservation = new Reservation();
		reservation.setBus(new Bus());
		model.addAttribute("reservation", reservation);
		return "reservationfolder/addreservation";
	}
	
	
	@PostMapping("/addreservation")
	public String addReservationProcess(@ModelAttribute("reservation") Reservation reservation) {
		if(ReservationService.addReservation(reservation)==null) {
			return "reservationfolderaddfailed";
		}else
			return "reservationfolder/addsuccess";
	}
	
	@GetMapping("/modifyreservation")
	public String modifyReservation(Model model)
	{
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
		return "reservationfolder/modifyreservation";
	}
	
	@PostMapping("/fetchreservation")
	public String fetchReservation(@ModelAttribute("reservation")Reservation reservation,Model model)
	{
		reservation = ReservationService.viewReservation(reservation.getReservationId());
		if(reservation == null)
			return "reservationfolder/reservationnotfound";
		else
			model.addAttribute("reservation",reservation);
			return "reservationfolder/reservationmodifyfound";
	}
	
	@PostMapping("/modifyreservationprocess")
	public String modifyActivityProcess(@ModelAttribute("reservation")Reservation reservation,Model model)
	{
		Reservation res = ReservationService.updateReservation(reservation);
		if(res == null)
			return "reservationfolder/modifyfailed";
		else
			return "reservationfolder/modifysuccess";
	}
	
	@GetMapping("/deletereservation")
	public String deleteReservation(Model model)
	{
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
		return "reservationfolder/deletereservation";
	}
	
	@PostMapping("/fetchreservationfordelete")
	public String fetchReservationforDelete(@ModelAttribute("reservation")Reservation reservation,Model model)
	{
		reservation = ReservationService.viewReservation(reservation.getReservationId());
		if(reservation == null)
			return "reservationfolder/reservationnotfound";
		else
			model.addAttribute("reservation",reservation);
			return "reservationfolder/reservationdeletefound";
	}
	
	@PostMapping("/deletereservationprocess")
	public String deleteReservationProcess(@ModelAttribute("reservation")Reservation reservation,Model model)
	{
		Reservation res = ReservationService.deleteReservation(reservation.getReservationId());
		if(res == null)
			return "reservationfolder/deletefailed";
		else
			return "reservationfolder/deletesuccess";
	}
	
	@GetMapping("/viewreservationbyid")
	public String viewReservationbyid(Model model)
	{
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
		return "reservationfolder/viewreservationbyid";
	}
	
	@PostMapping("/fetchreservationbyid")
	public String fetchReservationbyid(@ModelAttribute("reservation")Reservation reservation,Model model)
	{
		reservation = ReservationService.viewReservation(reservation.getReservationId());
		if(reservation == null)
			return "reservationfolder/reservationnotfound";
		else
			model.addAttribute("reservation", reservation);
			return "reservationfolder/reservationbyidfound";
	}
	
	@GetMapping("/listreservation")
	public String listReservation(Model model) {
		List<Reservation> list = ReservationService.viewAllReservation();
		
		model.addAttribute("reservations",list);
		return "reservationfolder/listreservation";
	}
	
	@GetMapping("/viewreservation")
	public String viewReservation(@RequestParam("reservationid") Integer reservationId, Model model) {
		
		Reservation reservation = ReservationService.viewReservation(reservationId);
		model.addAttribute("reservation", reservation);
		return "reservationfolder/viewreservation";
	}
	
	@GetMapping("/delreservation")
	public String delRoute(@RequestParam("reservationid") Integer reservationId, Model model) {
		Reservation reservation = ReservationService.viewReservation(reservationId);
		if( reservation == null){
			return "reservationfolder/reservationnotfound";
		}
		else
			model.addAttribute("reservation", reservation);
			return "reservationfolder/reservationfoundtodelete";
	}
	
	@PostMapping("/delreservation")
	public String deleteReservationfromview(@ModelAttribute("reservation") Reservation reservation, Model model) {
		if(ReservationService.deleteReservation(reservation.getReservationId()) == null){
			return "reservationfolder/deletefailed";
		}
		else
			model.addAttribute("reservation", reservation);
			return "reservationfolder/deletesuccess";
	}
	
	@GetMapping("/viewreservationbydate")
	public String viewReservationbyDate(Model model)
	{
		Reservation reservation = new Reservation();
		model.addAttribute("reservation", reservation);
		return "reservationfolder/viewreservationbytype";
	}
	
	@PostMapping("/fetchreservationbydate")
	public String fetchReservationbyDate(@ModelAttribute("reservation")Reservation reservation,Model model)
	{
		if(ReservationService.getAllReservation(reservation.getReservationDate()) == null)
			return "reservationfolder/reservationnotfound";
		else
			model.addAttribute("reservation", reservation);
			return "reservationfolder/reservationbytypefound";
	}
	
	@GetMapping("/addreservationfrombutton")
	public String addReservationfromButton(@RequestParam("busid") Integer busId ,Model model) {
		
		Reservation reservation = new Reservation();
		Bus bus = BusService.viewBus(busId);
		reservation.setBus(bus);
		model.addAttribute("reservation", reservation);
		return "reservationfolder/addreservation";
	}
	
	
	@PostMapping("/addreservationfrombutton")
	public String addReservationProcessfromButton(@ModelAttribute("reservation") Reservation reservation) {
		if(ReservationService.addReservation(reservation)==null) {
			return "reservationfolderaddfailed";
		}else
			return "reservationfolder/addsuccess";
	}
	
}