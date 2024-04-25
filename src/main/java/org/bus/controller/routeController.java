package org.bus.controller;
import java.util.List;

import org.bus.model.Route;
import org.bus.service.IRouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/route")
public class routeController {

	@Autowired
	private IRouteService routeservice;
	@GetMapping("/routeservice")
	public String routeService(Model model) {
		Route route = new Route();
		model.addAttribute("route", route);
		return "routefolder/routeService";
	}
	@GetMapping("/addroute1")
	public String addRoute1(Model model){
		Route route = new Route();
		model.addAttribute("route", route);
		return "routefolder/addroute1";
	}
	@PostMapping("/addrouteprocess")
	public String addRouteProcess(@ModelAttribute("route") Route route){
		Route busRoute = routeservice.addRoute(route);
		if( busRoute == null){
			return "routefolder/addunseccess";
		}
		else
			return "routefolder/addroutesuccess";
	}
	@GetMapping("/updateroute")
	public String updateRoute(Model model) {
		Route route = new Route();
		model.addAttribute("route", route);
		return "routefolder/updateroute";
	}
	@PostMapping("/fetchroute")
	public String fetchRoute(@ModelAttribute("route") Route route, Model model) {
		route = routeservice.viewRoute(route.getRouteId());
		if( route == null){
			return "routefolder/routenotfound";
		}
		else
			model.addAttribute("route", route);
			return "routefolder/routefound";
		
	}
	@PostMapping("/updaterouteprocess")
	public String updateRouteprocess(@ModelAttribute("route") Route route, Model model) {
		if(routeservice.updateRoute(route) == null){
			return "routefolder/addunsuccess";
		}
		else
//			model.addAttribute("route", route);
			return "routefolder/updatesuccess";
	}
	@GetMapping("/deleteroute")
	public String deleteRoute(Model model) {
		Route route = new Route();
		model.addAttribute("route", route);
		return "routefolder/deleteroute";
	}
	@PostMapping("/fetchroutefordelete")
	public String fetchRouteForDelete(@ModelAttribute("route") Route route, Model model) {
		route = routeservice.viewRoute(route.getRouteId());
		if( route == null){
			return "routefolder/routenotfound2";
		}
		else
			model.addAttribute("route", route);
			return "routefolder/routefound1";
	}
	@PostMapping("/deleterouteprocess")
	public String deleteRouteprocess(@ModelAttribute("route") Route route, Model model) {
		if(routeservice.deleteRoute(route.getRouteId()) == null){
			return "routefolder/deletefailed";
		}
		else
			model.addAttribute("route", route);
			return "routefolder/deleted";
	}
	@GetMapping("/viewroute")
	public String viewRoute(Model model) {
		Route route = new Route();
		model.addAttribute("route", route);
		return "routefolder/viewroute";
	}
	@PostMapping("/viewrouteprocess")
	public String viewRouteProcess(@ModelAttribute("route") Route route, Model model) {
		route = routeservice.viewRoute(route.getRouteId());
		if( route == null){
			return "routefolder/routenotfound3";
		}
		else
			model.addAttribute("route", route);
			return "routefolder/routefound2";
	}
	@GetMapping("/listroute")
	public String listRoute(Model model) {
		List<Route> listroute = routeservice.viewAllRoute();
		model.addAttribute("routes", listroute);
		return "routefolder/listroute";
	}
	@GetMapping("/viewbutton")
	public String viewButton(@RequestParam("routeId") Integer routeId, Model model) {
		Route route = routeservice.viewRoute(routeId);
		model.addAttribute("route", route);
		return "routefolder/viewbutton";
	}
	@GetMapping("/delroute")
	public String delRoute(@RequestParam("routeId") Integer routeId, Model model) {
		Route route = routeservice.viewRoute(routeId);
		if( route == null){
			return "routefolder/routenotfoundfordelete";
		}
		else
			model.addAttribute("route", route);
			return "routefolder/routefoundtodelete";
	}
	@PostMapping("/delete")
	public String deleteRoutefromview(@ModelAttribute("route") Route route, Model model) {
		if(routeservice.deleteRoute(route.getRouteId()) == null){
			return "routefolder/deletefailed";
		}
		else
			model.addAttribute("route", route);
			return "routefolder/deleted1";
	}
	@GetMapping("/updaterouteforbuttton")
	public String fetchRouteforupdate(@RequestParam("routeId") Integer routeId, Model model) {
		Route route = routeservice.viewRoute(routeId);
		if( route == null){
			return "routefolder/routenotfound";
		}
		else
			model.addAttribute("route", route);
			return "routefolder/routefound4";
		
	}
	@PostMapping("/updaterouteprocess1")
	public String updateRouteprocessforButton(@ModelAttribute("route") Route route, Model model) {
		if( routeservice.updateRoute(route) == null){
			return "routefolder/addunsuccess";
		}
		else
//			model.addAttribute("route", route);
			return "routefolder/updatesuccess1";
	}
}
