package br.ce.rogerioballestrin.appium.test;

import java.net.MalformedURLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.FormularioPage;
import br.ce.rogerioballestrin.appium.page.MenuPage;


public class FormularioTeste extends BaseTest{
	private MenuPage menu = new MenuPage();
	private FormularioPage page = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}
	
	@Test
	public void devePreencherCampoTexto() throws MalformedURLException {	    
	    page.escreverNome("Rogério");
	    Assert.assertEquals("Rogério", page.obterNome());
	}
	
	@Test
	public void deveInteragirComCombo() throws MalformedURLException {	    
		page.selecionarCombo("Nintendo Switch");	    
	    Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}
	
	@Test
	public void deveInteragirComSwitchCheckBox() throws MalformedURLException {
	    // Verificar status dos elementos
	    Assert.assertFalse(page.isCheckMarcado());
	    Assert.assertTrue(page.isSwMarcado());
	    // clicar nos elementos
	    page.clicarCheck();
	    page.clicarsw();
	    // verificar estados alterados
	    Assert.assertTrue(page.isCheckMarcado());
	    Assert.assertFalse(page.isSwMarcado());
	}
}
