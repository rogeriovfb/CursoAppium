package br.ce.rogerioballestrin.appium.test;

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
	public void inicializarAppium() {
		menu.acessarFormulario();
	}
	
	@Test
	public void devePreencherCampoTexto() {	    
	    page.escreverNome("Rogério");
	    Assert.assertEquals("Rogério", page.obterNome());
	}
	
	@Test
	public void deveInteragirComCombo() {	    
		page.selecionarCombo("Nintendo Switch");	    
	    Assert.assertEquals("Nintendo Switch", page.obterValorCombo());
	}
	
	@Test
	public void deveInteragirComSwitchCheckBox() {
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
	
	@Test
	public void deveSalvarFormularioDemorado() {
	    // Escrever Nome
	    page.escreverNome("Rogério");
	    
	    //Selecionar opção desejada
		page.selecionarCombo("PS4");
	    
	    //Clicar no sw e checkbox
	    page.clicarCheck();
	    page.clicarsw();
	    
	    //Clicar em salvar
	    page.salvarDemorado();
	    
	    //Verificar ações salvas
	    Assert.assertEquals("Nome: Rogério", page.obterNomeSalvo());
	    Assert.assertEquals("Console: ps4", page.obterConsoleSalvo());
	    Assert.assertEquals("Switch: Off", page.obterSwitchSalvo());
	    Assert.assertEquals("Checkbox: Marcado", page.obterCheckboxSalvo());
	}
	
	public void esperar(long tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
