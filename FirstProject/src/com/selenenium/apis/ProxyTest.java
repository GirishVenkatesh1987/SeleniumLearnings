package com.selenenium.apis;

import java.util.Arrays;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.Proxy.ProxyType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class ProxyTest {
	
	public static void main(String[] args) {
		
		//with url
		/*In case your authentication server requires username with domain like “domainuser” you need to add double slash ‘\‘ to the Url.
		http://localdomain\\user:password@example.com*/
		WebDriver driver1 = new FirefoxDriver();
		driver1.get("http://UserName:Password@Example.com");
		//Step to craete profile manually
		//http://toolsqa.com/selenium-webdriver/custom-firefox-profile/
		
		ProfilesIni profileini = new ProfilesIni();		 
		FirefoxProfile myprofile = profileini.getProfile("profileToolsQA");		 
		driver1 = new FirefoxDriver(myprofile);
		
		String proxy = "localhost:7777";
		Proxy p =new Proxy();
		p.setHttpProxy(proxy);
		p.setFtpProxy(proxy);
		p.setSslProxy(proxy);
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(CapabilityType.PROXY, p);
		driver1 = new FirefoxDriver(cap);
		
		FirefoxProfile profile = new FirefoxProfile();
		profile.setPreference("network.proxy.type", 1);
	    profile.setPreference("network.proxy.http", "proxy.domain.example.com");
	    profile.setPreference("network.proxy.http_port", 8080);
	    profile.setPreference("network.proxy.ssl", "proxy.domain.example.com");
	    profile.setPreference("network.proxy.ssl_port", 8080);
	    driver1 = new FirefoxDriver(profile);
	    
	    FirefoxProfile profile1 = new FirefoxProfile(); 
	    profile1.setPreference("network.proxy.type", ProxyType.AUTODETECT.ordinal());
	    WebDriver driver = new FirefoxDriver(profile1);
		
	    /*0 - Direct connection (or) no proxy. 

		1 - Manual proxy configuration
		
		2 - Proxy auto-configuration (PAC).
		
		4 - Auto-detect proxy settings.
		
		5 - Use system proxy settings.*/
	    
	    //For PAC based urls
	    Proxy pacproxy = new Proxy();
	    pacproxy.setProxyType(Proxy.ProxyType.PAC);
	    pacproxy.setProxyAutoconfigUrl("http://some-server/staging.pac");
	    DesiredCapabilities capabilities = new DesiredCapabilities();
	    capabilities.setCapability(CapabilityType.PROXY, proxy);
	    
	    //In case if you have an autoconfig URL -
	    FirefoxProfile firefoxProfile = new FirefoxProfile();
        firefoxProfile.setPreference("network.proxy.type", 2);
        firefoxProfile.setPreference("network.proxy.autoconfig_url", "http://www.etc.com/wpad.dat");
        firefoxProfile.setPreference("network.proxy.no_proxies_on", "localhost");
       
        //set the WebDriver to Auto Detect Proxy
        Proxy autodetectProxy = new Proxy();
        autodetectProxy.setAutodetect(true);         
        cap = new DesiredCapabilities();
        cap.setCapability(CapabilityType.PROXY, proxy);
        
        //For Chrome
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--proxy-server=http://user:password@yourProxyServer.com:8080");
        WebDriver driver2 = new ChromeDriver(opt);
        
        DesiredCapabilities capabilities1 = DesiredCapabilities.chrome();
        capabilities1.setCapability("chrome.switches", Arrays.asList("--proxy-server=http://user:password@proxy.com:8080"));
        WebDriver driver3 = new ChromeDriver(capabilities1);
        
        opt.addArguments("--no-proxy-server");
        		


		
	}

}
