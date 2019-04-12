package com.packers.controller;

import java.security.Principal;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.packers.bo.BookingBO;
import com.packers.bo.UserDetailsBO;
import com.packers.repo.BookingRepository;
import com.packers.repo.UserDetailsRepository;
import com.packers.util.EmailUtil;
import com.packers.util.PDFGenerator;

@Controller
@RequestMapping("booking")
public class BookingController {
	@Value("com.packers.PDF.dir")
	private String PDF_FILE_PATH;

	
	@Autowired
	private EmailUtil email;

	@Autowired
	private PDFGenerator generatePDF;

	@Autowired
	private BookingRepository bookingRepository;
	@Autowired
	private UserDetailsRepository userRepository;

	@GetMapping
	public String showBookingPage(@RequestParam("id") String id ,Model model, Principal principal) {
		System.out.println(principal.getName()+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		model.addAttribute("name", principal.getName());
		model.addAttribute("id", id);
		return "booking";
		//return "booking";
	}

	@PostMapping
	public String confirmBooking(@ModelAttribute BookingBO bo,Principal principal) {
		UserDetailsBO optBO = userRepository.findByEmail(principal.getName());
		System.out.println(optBO);
		bo.setCustId(optBO.getId());
		
		System.out.println(bo);
		bookingRepository.save(bo);
		//generatePDF.generatePDF(bo, PDF_FILE_PATH + bo.getBookingId() + ".pdf");
		//email.sendBookingDetails(bo1.getEmail(), PDF_FILE_PATH + bo.getBookingId() + ".pdf");
		System.out.println("DD");
		return "ConfirmBooking";
	}
//	@RequestMapping(name="getAQuotation",method=RequestMethod.GET)
//	public String quotationHandler(@ModelAttribute ) {
//		return"";
//	}

}
