package br.ce.rogerioballestrin.appium;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class FormularioTeste {
	
	private AndroidDriver<MobileElement> driver;
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
	    desiredCapabilities.setCapability("platformName", "Android");
	    desiredCapabilities.setCapability("deviceName", "emulator-5554");
	    desiredCapabilities.setCapability("automationName", "uiautomator2");
	    desiredCapabilities.setCapability("appPackage", "com.ctappium");
	    desiredCapabilities.setCapability("appActivity", "com.ctappium.MainActivity");
	    
	    driver= new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	 // Selecionar formulario
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {	    
	    // Escrever Nome
	    MobileElement campoNome = driver.findElement(MobileBy.AccessibilityId("nome"));
	    campoNome.sendKeys("Rogério");
	    
	    // Checar nome escrito
	    String retorno = campoNome.getText();
	    Assert.assertEquals("Rogério", retorno);
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {	    
	    // Clicar no combo
	    driver.findElement(MobileBy.AccessibilityId("console")).click();
	    // Selecionar opção desejada
	    driver.findElement(By.xpath("//android.widget.CheckedTextView[@text='Nintendo Switch']")).click();;
	    //verificar opção selecionada
	    String retorno = driver.findElement(By.xpath("//android.widget.Spinner/android.widget.TextView")).getText();
	    Assert.assertEquals("Nintendo Switch", retorno);
	}
	
	@Test
	public void deveInteragirComSwitchCheckBox() throws MalformedURLException {	    
	    
	    // Verificar status dos elementos
	    MobileElement check = driver.findElement(By.className("android.widget.CheckBox"));
	    MobileElement sw = driver.findElement(MobileBy.AccessibilityId("switch"));
	    Assert.assertTrue(check.getAttribute("checked").equals("false"));
	    Assert.assertTrue(sw.getAttribute("checked").equals("true"));
	    //check.getAttribute("checked") retorna string true ou false
	    
	    // clicar nos elementos
	    check.click();
	    sw.click();
	    
	    // verificar estados alterados
	    Assert.assertFalse(check.getAttribute("checked").equals("false"));
	    Assert.assertFalse(sw.getAttribute("checked").equals("true"));
	}

	@After
	public void tearDown() {
		driver.quit();
	}
}
