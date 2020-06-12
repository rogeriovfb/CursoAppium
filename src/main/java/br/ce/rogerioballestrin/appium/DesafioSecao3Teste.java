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


public class DesafioSecao3Teste {
	
	private AndroidDriver<MobileElement> driver;
	private DSL dsl = new DSL();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		driver = DriverFactory.getDriver();
	 // Selecionar formulario
	    driver.findElement(By.xpath("//android.widget.TextView[@text='Formulário']")).click();
	}
	
	@Test
	public void deveSalvarFormulario() throws MalformedURLException {
	    // Escrever Nome
		dsl.escrever(MobileBy.AccessibilityId("nome"), "Rogério");
	    
	    // Clicar no combo 
	    //Selecionar opção desejada
	    dsl.selecionarCombo(MobileBy.AccessibilityId("console"), "PS4");
	    
	    //Clicar no combo
	    dsl.clicar(By.className("android.widget.CheckBox"));;
	    dsl.clicar(MobileBy.AccessibilityId("switch"));
	    
	    //Clicar em salvar
	    dsl.clicar(By.xpath("//android.widget.TextView[@text='SALVAR']"));
	    
	    //Verificar ações salvas
	    Assert.assertEquals("Nome: Rogério", dsl.obterTexto(By.xpath("//android.widget.TextView[@index='12']")));
	    Assert.assertEquals("Console: ps4", dsl.obterTexto(By.xpath("//android.widget.TextView[@index='13']")));
	    Assert.assertEquals("Switch: Off", dsl.obterTexto(By.xpath("//android.widget.TextView[@index='15']")));
	    Assert.assertEquals("Checkbox: Marcado", dsl.obterTexto(By.xpath("//android.widget.TextView[@index='16']")));
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
}
