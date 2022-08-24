package com.carloso.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	
	// Use only two methods - index and processMoney... prison and reset are ninja bonuses 
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	@SuppressWarnings("unchecked")
	@PostMapping("/processMoney")
	public String findGold(
			HttpSession session,
			@RequestParam(value="Farm", required=false) String Farm,
			@RequestParam(value="Cave", required=false) String Cave,
			@RequestParam(value="House", required=false) String House,
			@RequestParam(value="Quest", required=false) String Quest,
			@RequestParam(value="Spa", required=false) String Spa
			) {
		
		// Start with 0 gold.
		Integer gold = 0;
		ArrayList<String> log = new ArrayList<>();
		
		// Keep a log including the timestamp for each submission.
		SimpleDateFormat format = new SimpleDateFormat("MMMM d Y h:mm a");
		
		if (session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
			session.setAttribute("log", log);
		} else {
			gold = (Integer) session.getAttribute("gold");
			log = (ArrayList<String>) session.getAttribute("log");
		}
		
		// NINJA BONUS: Send the ninja to a debtors' prison on a second rendered page if the ninja falls too far into debt
		if( (int) session.getAttribute("gold") < -100) {
			return "redirect:/prison";
		}
		
		// farm - add 10 - 20 to gold
		if(Farm != null) {
			Integer goldFound = new Random().nextInt(11) + 10;
			gold += goldFound;	
			session.setAttribute("gold", gold);
			log.add(0, "You entered a farm and earned " + goldFound + " gold. (" + format.format(new Date()) + ")");
			return "redirect:/";
		}
		
		// cave - add 5 - 10 gold
		if(Cave != null) {
			Integer goldFound = new Random().nextInt(6) + 5;
			gold += goldFound;	
			session.setAttribute("gold", gold);
			log.add(0, "You entered a Cave and earned " + goldFound + " gold. (" + format.format(new Date()) + ")");
			return "redirect:/";
		}
		
		// house - add 2 - 5 gold
		if(House != null) {
			Integer goldFound = new Random().nextInt(4) + 2;
			gold += goldFound;	
			session.setAttribute("gold", gold);
			log.add(0, "You entered a House and earned " + goldFound + " gold. (" + format.format(new Date()) + ")");
			return "redirect:/";
		}
		
		// quest - add or remove 0 - 50 gold
		if(Quest != null) {
			Integer goldFound = new Random().nextInt(101) - 50;
			gold += goldFound;
			session.setAttribute("gold", gold);
			if(goldFound < 0) {
				log.add(0, "You failed the quest and lost " + (goldFound * -1) + " gold. (" + format.format(new Date()) + ")");
			}else {
				log.add(0, "You completed the quest and earned " + goldFound + " gold. (" + format.format(new Date()) + ")");
			}
			return "redirect:/";
		}
		
		// NINJA BONUS: Create a fifth place "spa" where the ninja loses 5-20 gold
		if(Spa != null) {
			Integer goldFound = new Random().nextInt(16) + 5;
			gold -= goldFound;	
			session.setAttribute("gold", gold);
			log.add(0, "You entered a Spa and lost " + goldFound + " gold. (" + format.format(new Date()) + ")");
			return "redirect:/";
		}
		
		return "redirect:/";

	}
	
	// NINJA BONUS: Create a reset button
	@GetMapping("/reset")
	public String reset(HttpSession session) {
		session.setAttribute("gold", 0);
		session.setAttribute("log", new ArrayList<String>());
		return "redirect:/";
	}
	
	// NINJA BONUS: Send the ninja to a debtors' prison on a second rendered page if the ninja falls too far into debt 
	@GetMapping("/prison")
	public String prison() {
		return "prison.jsp";
	}
}
