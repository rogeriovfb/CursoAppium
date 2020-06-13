package br.ce.rogerioballestrin.appium.test;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class CalculadoraXPowerTeste {

	@Test
	public void deveSomarDoisValores() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "LGK220KRKN55R0");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.android.calculator2");
	    desiredCapabilities.setCapability("appActivity", "com.android.calculator2.Calculator");
	    
	    AndroidDriver<MobileElement> driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    
	    MobileElement el1 = (MobileElement) driver.findElementByAccessibilityId("2");
	    el1.click();
	    MobileElement el2 = (MobileElement) driver.findElementByAccessibilityId("Adi��o");
	    el2.click();
	    MobileElement el3 = (MobileElement) driver.findElementByAccessibilityId("2");
	    el3.click();
	    MobileElement el4 = (MobileElement) driver.findElementByAccessibilityId("igual");
	    el4.click();
	    MobileElement el5 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.view.ViewGroup/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.ViewSwitcher/com.android.calculator2.CalculatorEditText");
	    Assert.assertEquals("2Adi��o2\nigual 4", el5.getText());
	    driver.quit();
	}
}
