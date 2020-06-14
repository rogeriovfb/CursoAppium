package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.FormularioPage;
import br.ce.rogerioballestrin.appium.page.MenuPage;
import io.appium.java_client.MobileBy;


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
	
	@Test
	public void deveAlterarData() {
		page.clicarPorTexto("01/01/2000");
		page.clicarPorTexto("20");
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("20/2/2000"));
	}
	
	@Test
	public void deveAlterarHora() {
		page.clicarPorTexto("06:00");
		page.clicar(MobileBy.AccessibilityId("10"));
		page.clicar(MobileBy.AccessibilityId("40"));
		page.clicarPorTexto("OK");
		Assert.assertTrue(page.existeElementoPorTexto("10:40"));
	}
	
	@Test
	public void deveInteragirComSeekbar() {
		//clicar no seekbar
		page.clicarSeekBar(0.50);
		//salvar
		page.salvar();
		//obter o valor
		Assert.assertEquals("Slider: 50", page.obterSliderSalvo());
	}
}
