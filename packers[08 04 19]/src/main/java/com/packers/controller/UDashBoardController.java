package com.packers.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.packers.bo.BookingBO;
import com.packers.bo.UserDetailsBO;
import com.packers.repo.BookingRepository;
import com.packers.repo.UserDetailsRepository;

@Controller
public class UDashBoardController {
	@Autowired
	private UserDetailsRepository userRepository;
	@Autowired
	private BookingRepository bookingRepository;
	@RequestMapping(value = "payOnline", method = RequestMethod.GET)
	public String payOnline(Model model) {
		
		return "TxnTest";
	}
	
	@RequestMapping(value = "bookHistory", method = RequestMethod.GET)
	public String bookHistory(Principal principal) {
		UserDetailsBO detailsBO = userRepository.findByEmail(principal.getName());
		ArrayList<BookingBO> list =bookingRepository.findAllByCustId(detailsBO.getId());
		Iterator<BookingBO> it= list.iterator();
		System.out.println(detailsBO+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		while(it.hasNext()) {
			System.out.println(it.next()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		}
		return "booking";
	}
	
	/*@RequestMapping(value="processHtml",method=RequestMethod.GET)
	public String htmlToPdf() {
		try {
			PDFGenerator.generatePDFFromHTML("C:\\Users\\D\\Desktop\\Packers 08 04 19\\Packers-master\\Packers\\src\\main\\webapp\\quotation.html", "e://test.pdf");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "userDashBoard";
	}*/
	
	
	
}
