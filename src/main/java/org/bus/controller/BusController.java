package org.bus.controller;

import java.util.List;

import org.bus.model.Bus;
import org.bus.service.BusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bus")
public class BusController {
	
	@Autowired
	private BusServiceImpl busService;

	@GetMapping("/busservice")
	public String busservice(Model model) {
		Bus bus = new Bus();
		model.addAttribute("bus",bus);
		return "busfolder/busservice";
	}
	@GetMapping("/addbus")
	public String addBus(Model model) {
		Bus bus = new Bus();
		model.addAttribute("bus",bus);
		return "busfolder/addBus";
	}
	@PostMapping("/addbus")
	public String addBusProcess(@ModelAttribute("bus") Bus bus) {
		if(busService.addBus(bus)==null) {
			return "busfolder/addbusfailed";
		}else
			return "busfolder/addbussuccess";
	}
	
	
	@GetMapping("/updatebus")
	public String updateBus(Model model)
	{
		Bus bus = new Bus();
		model.addAttribute("bus", bus);
		return "busfolder/updatebus";
	}
	
	@PostMapping("/fetchbus")
	public String fetchBus(@ModelAttribute("bus")Bus bus,Model model)
	{
		bus = busService.viewBus(bus.getBusId());
		if(bus == null)
			return "busfolder/busnotfound";
		else
			model.addAttribute("bus",bus);
			return "busfolder/busupdatefound";
	}
	
	@PostMapping("/updatebusprocess")
	public String updateBusProcess(@ModelAttribute("bus")Bus bus,Model model)
	{
		Bus b = busService.updateBus(bus);
		if(b == null)
			return "busfolder/updatebusfailed";
		else
			return "busfolder/updatebussuccess";
	}
	
	
	
	@GetMapping("/deletebus")
	public String deletebus(Model model)
	{
		Bus bus = new Bus();
		model.addAttribute("bus", bus);
		return "busfolder/deletebus";
	}
	
	@PostMapping("/fetchbusfordelete")
	public String fetchBusforDelete(@ModelAttribute("bus")Bus bus,Model model)
	{
		bus = busService.viewBus(bus.getBusId());
		if(bus == null)
			return "busfolder/busnotfound1";
		else
			model.addAttribute("bus",bus);
			return "busfolder/busdeletefound";
	}
	
	@PostMapping("/deletebusprocess")
	public String deleteBusProcess(@ModelAttribute("bus")Bus bus,Model model)
	{
		Bus b = busService.deleteBus(bus.getBusId());
		if(b == null)
			return "busfolder/deletebusfailed";
		else
			return "busfolder/deletebussuccess";
	}
	
	@GetMapping("/viewbusbyid")
	public String viewBusbyid(Model model)
	{
		Bus bus = new Bus();
		model.addAttribute("bus", bus);
		return "busfolder/viewbusbyid";
	}
	
	@PostMapping("/fetchbusbyid")
	public String fetchBusbyid(@ModelAttribute("bus")Bus bus,Model model)
	{
		bus = busService.viewBus(bus.getBusId());
		if(bus == null)
			return "busfolder/busnotfound2";
		else
			model.addAttribute("bus", bus);
			return "busfolder/busbyidfound";
	}
	
	
	
	@GetMapping("/listbus")
	public String listBus(Model model) {
		List<Bus> list = busService.viewAllBus();
		
		model.addAttribute("buses",list);
		return "busfolder/listbus";
	}
	
	@GetMapping("/viewbus")
	public String viewBus(@RequestParam("busid") Integer busId, Model model) {
		
		Bus bus = busService.viewBus(busId);
		model.addAttribute("bus", bus);
		return "busfolder/busbyidfound1";
	}
	
	@GetMapping("/delbus")
	public String delbus(@RequestParam("busid") Integer busId, Model model) {
		Bus bus = busService.viewBus(busId);
		model.addAttribute("bus", bus);
		return "busfolder/busdeletefound1";
	}
	
	@PostMapping("/delbus")
	public String deleteBusfromview(@ModelAttribute("bus") Bus bus, Model model) {
		if(busService.deleteBus(bus.getBusId()) == null){
			return "busfolder/deletebusfailed1";
		}
		else
			model.addAttribute("bus", bus);
			return "busfolder/deletebussuccess1";
	}
	
	@GetMapping("/modifybus")
	public String modifybus(@RequestParam("busid") Integer busId, Model model) {
		Bus bus = busService.viewBus(busId);
		model.addAttribute("bus", bus);
			return "busfolder/busupdatefound1";
	}
	
	@PostMapping("/modifybus")
	public String modifyBusfromview(@ModelAttribute("bus") Bus bus, Model model) {
		if(busService.updateBus(bus) == null){
			return "busfolder/updatebusfailed1";
		}
		else
			model.addAttribute("bus", bus);
			return "busfolder/updatebussuccess1";
	}
	
	@GetMapping("/viewbusbytype")
	public String viewBusbyType(Model model)
	{
		Bus bus = new Bus();
		model.addAttribute("bus", bus);
		return "busfolder/viewbusbytype";
	}
	
	@PostMapping("/fetchbusbytype")
	public String fetchBusbyType(@ModelAttribute("bus")Bus bus,Model model)
	{
		List<Bus> list = busService.viewBusByType(bus.getBusType());
		if(list == null)
			return "busfolder/busnotfound3";
		else
			model.addAttribute("buses",list);
			return "busfolder/listbusbytype";
	}
	
	


}
