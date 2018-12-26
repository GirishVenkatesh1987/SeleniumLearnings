package com.selenenium.apis;

import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserCertifcateTest {

	public static void main(String[] args) {
		//Firefox
		ProfilesIni prof = new ProfilesIni()	;			
		FirefoxProfile ffProfile= prof.getProfile ("myProfile");
		ffProfile.setAcceptUntrustedCertificates(true);
		ffProfile.setAssumeUntrustedCertificateIssuer(false);
		
		//chrmoe
		DesiredCapabilities chromeCap = DesiredCapabilities.chrome();
		chromeCap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		
		//ie
		DesiredCapabilities iecap = new DesiredCapabilities();
		iecap.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	}
}
