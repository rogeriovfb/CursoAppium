package br.ce.rogerioballestrin.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class DesafioSecao3Teste {

	@Test
	public void deveSalvarFormulario() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.ctappium");
	    desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
	    
	    AndroidDriver<MobileElement> driver= new AndroidDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	    
	    // Selecionar formulario
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	    
	    // Escrever Nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Rogério");
	    
	    // Clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    
	    //Selecionar opção desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='PS4']")).click();;
	    
	    //Clicar no combo
	    driver.findElement(By.className("android.widget.CheckBox")).click();;
	    driver.findElement(MobileBy.AccessibilityId("switch")).click();
	    
	    //Clicar em salvar
	    driver.findElement(By.xpath("//android.widget.TextView[@text='SALVAR']")).click();
	    
	    //Verificar ações salvas
	    String nome = driver.findElement(By.xpath("//android.widget.TextView[@index='12']")).getText();
	    String console = driver.findElement(By.xpath("//android.widget.TextView[@index='13']")).getText();
	    String sw = driver.findElement(By.xpath("//android.widget.TextView[@index='15']")).getText();
	    String checkbox = driver.findElement(By.xpath("//android.widget.TextView[@index='16']")).getText();
	    Assert.assertEquals("Nome: Rogério", nome);
	    Assert.assertEquals("Console: ps4", console);
	    Assert.assertEquals("Switch: Off", sw);
	    Assert.assertEquals("Checkbox: Marcado", checkbox);

	    
	    driver.quit();
	}
}
