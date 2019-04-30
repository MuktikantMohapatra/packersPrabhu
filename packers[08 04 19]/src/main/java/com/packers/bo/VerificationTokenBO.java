package com.packers.bo;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

//@Entity
public class VerificatinTokenBO {
	private static final int EXPIRATION = 60 * 24;
	 
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
     
    private String token;
   
   // @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
  //  @JoinColumn(nullable = false, name = "user_id")
    private User user;
     
    private Date expiryDate;
    
    private Date calculateExpiryDate(int expiryTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
      //  cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expiryTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
}
