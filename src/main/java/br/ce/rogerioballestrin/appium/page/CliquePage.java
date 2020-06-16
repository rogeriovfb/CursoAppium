package br.ce.rogerioballestrin.appium.page;

import org.openqa.selenium.By;

import br.ce.rogerioballestrin.appium.core.BasePage;
import br.ce.rogerioballestrin.appium.core.DriverFactory;
import io.appium.java_client.TouchAction;

public class CliquePage extends BasePage{
	
	public void cliqueLongo() {
		cliqueLongo(By.xpath("//*[@text='Clique Longo']"));
	}
	
	public String obterTextoCampo() {
		return DriverFactory.getDriver().findElement(By.xpath("(//android.widget.TextView)[3]")).getText();
	}
	
	

}
