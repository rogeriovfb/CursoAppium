package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.CliquePage;
import br.ce.rogerioballestrin.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquePage page = new CliquePage();
	
	@Test
	public void deveRealizarCliqueLongo() {
		// acessar menu
		menu.acessarCliques();
		//clique longo
		page.cliqueLongo();
		//verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}

}
