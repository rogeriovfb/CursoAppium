package br.ce.rogerioballestrin.appium.test;

import java.net.MalformedURLException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.DriverFactory;
import br.ce.rogerioballestrin.appium.page.FormularioPage;
import br.ce.rogerioballestrin.appium.page.MenuPage;


public class DesafioSecao3Teste {
	
	private MenuPage menu = new MenuPage();
	
	private FormularioPage page = new FormularioPage();
	
	@Before
	public void inicializarAppium() throws MalformedURLException {
		menu.acessarFormulario();
	}
	
	@Test
	public void deveSalvarFormulario() throws MalformedURLException {
	    // Escrever Nome
	    page.escreverNome("Rog�rio");
	    
	    // Clicar no combo 
	    //Selecionar op��o desejada
		page.selecionarCombo("PS4");
	    
	    //Clicar no sw e checkbox
	    page.clicarCheck();
	    page.clicarsw();
	    
	    //Clicar em salvar
	    page.salvar();
	    
	    //Verificar a��es salvas
	    Assert.assertEquals("Nome: Rog�rio", page.obterNomeSalvo());
	    Assert.assertEquals("Console: ps4", page.obterConsoleSalvo());
	    Assert.assertEquals("Switch: Off", page.obterSwitchSalvo());
	    Assert.assertEquals("Checkbox: Marcado", page.obterCheckboxSalvo());
	}
	
	@After
	public void tearDown() {
		DriverFactory.killDriver();
	}
}
