package br.ce.rogerioballestrin.appium;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import br.ce.rogerioballestrin.appium.core.DSL;
import br.ce.rogerioballestrin.appium.core.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;


public class FormularioTeste {
	
	private AndroidDriver<MobileElement> driver;
	
	private DSL dsl = new DSL();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
	 // Selecionar formulario
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {	    
	    // Escrever Nome
	    dsl.escrever(MobileBy.AccessibilityId("nome"), "Rogério");
	    // Checar nome escrito
	    Assert.assertEquals("Rogério", dsl.obterTexto(MobileBy.AccessibilityId("nome")));
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {	    
	    // Clicar no combo
	    // Selecionar opção desejada
	    dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "Nintendo Switch");
	    //verificar opção selecionada
	    Assert.assertEquals("Nintendo Switch", dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView")));
	}
	
	@Test
	public void deveInteragirComSwitchCheckBox() throws MalformedURLException {
	    // Verificar status dos elementos
	    Assert.assertFalse(dsl.ischeckedMarcado(By.className("android.widget.CheckBox")));
	    Assert.assertTrue(dsl.ischeckedMarcado(MobileBy.AccessibilityId("switch")));
	    
	    // clicar nos elementos
	    dsl.clicar(By.className("android.widget.CheckBox"));;
	    dsl.clicar(MobileBy.AccessibilityId("switch"));
	    
	    // verificar estados alterados
	    Assert.assertTrue(dsl.ischeckedMarcado(By.className("android.widget.CheckBox")));
	    Assert.assertFalse(dsl.ischeckedMarcado(MobileBy.AccessibilityId("switch")));
	}

	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
}
