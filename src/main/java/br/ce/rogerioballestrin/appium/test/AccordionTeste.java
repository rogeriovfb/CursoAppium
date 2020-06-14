package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.AccordionPage;
import br.ce.rogerioballestrin.appium.page.MenuPage;

public class AccordionTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AccordionPage page = new AccordionPage();
	
	@Test
	public void deveInteragirComAccordion() {
		//acessar menu
		menu.acessarAccordion();
		//clicar op 1
		page.selecionarOp1();
		//verificar texto op 1
		esperar(1000);
		Assert.assertEquals("Esta é a descrição da opção 1", page.obterValorOp1());
	}

}
