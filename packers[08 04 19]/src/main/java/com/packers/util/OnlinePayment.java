
package com.packers.util;

import java.util.TreeMap;


import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

//import com.paytm.pg.merchant.CheckSumServiceHelper;
@Component
public class OnlinePayment {
	String merchantMid = "lNvCLO02480545533151";
	// Key in your staging and production MID available in your dashboard
	String merchantKey = "pKFGczKItwB0@@d3";
	// Key in your staging and production merchant key available in your dashboard
	String orderId = "order1";
	String channelId = "WEB";
	String custId = "cust123";
	String mobileNo = "9853270680";
	String email = "username@emailprovider.com";
	String txnAmount = "100.12";
	String website = "WEBSTAGING";
	// This is the staging value. Production value is available in your dashboard
	String industryTypeId = "Retail";
	// This is the staging value. Production value is available in your dashboard
	String callbackUrl = "http://localhost:8090/packers/page>";
	TreeMap<String, String> paytmParams = new TreeMap<String, String>();
	
	public String handler(Model model) throws Exception {

		paytmParams.put("MID",merchantMid);
		paytmParams.put("ORDER_ID",orderId);
		paytmParams.put("CHANNEL_ID",channelId);
		paytmParams.put("CUST_ID",custId);
		paytmParams.put("MOBILE_NO",mobileNo);
		paytmParams.put("EMAIL",email);
		paytmParams.put("TXN_AMOUNT",txnAmount);
		paytmParams.put("WEBSITE",website);
		paytmParams.put("INDUSTRY_TYPE_ID",industryTypeId);
		paytmParams.put("CALLBACK_URL", callbackUrl);
	//	String paytmCheckSum = CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum(merchantKey, paytmParams);
	//	model.addAttribute("paytmCheckSum",paytmCheckSum);
		return "";
	}

}
