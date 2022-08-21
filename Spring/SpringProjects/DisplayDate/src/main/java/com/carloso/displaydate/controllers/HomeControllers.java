package com.carloso.displaydate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeControllers {
	@RequestMapping("/")
	public String index() {
		return "index.jsp";
	}
	
	Date date = new Date();
	
	SimpleDateFormat dayNameFormat = new SimpleDateFormat("EEEE");
	SimpleDateFormat dayFormat = new SimpleDateFormat("d");
	SimpleDateFormat monthFormat = new SimpleDateFormat("MMMM");
	SimpleDateFormat yearFormat = new SimpleDateFormat("Y");
	
	
	String dayNameString = dayNameFormat.format(date);
	String dayString = dayFormat.format(date);
	String monthString = monthFormat.format(date);
	String yearString = yearFormat.format(date);
	
	static String[] suffixes =
			  //    0     1     2     3     4     5     6     7     8     9
			     { "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
			  //    10    11    12    13    14    15    16    17    18    19
			       "th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
			  //    20    21    22    23    24    25    26    27    28    29
			       "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
			  //    30    31
			       "th", "st" };
	
	int day = Integer.parseInt(dayString);
	String daySuffix = suffixes[day];
	
	String dateString = dayNameString + ", " + "the " + dayString + daySuffix + " of " + monthString + ", " + yearString;
	
	
	@RequestMapping("/date")
	public String date(Model dateModel) {
		dateModel.addAttribute("currentDate", dateString);
		return "date.jsp";
	}
	
	SimpleDateFormat timeFormat = new SimpleDateFormat("h:m a");
	
	String timeString = timeFormat.format(date);
	
	
	@RequestMapping("/time")
	public String time(Model timeModel) {
		timeModel.addAttribute("currentTime", timeString);
		return "time.jsp";
	}
}
