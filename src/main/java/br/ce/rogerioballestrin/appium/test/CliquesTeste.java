package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.CliquePage;
import br.ce.rogerioballestrin.appium.page.MenuPage;

public class CliquesTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private CliquePage page = new CliquePage();
	
	@Before
	public void Setup() {
		menu.acessarCliques();
	}
	
	@Test
	public void deveRealizarCliqueLongo() {
		//clique longo
		page.cliqueLongo();
		//verificar texto
		Assert.assertEquals("Clique Longo", page.obterTextoCampo());
	}
	
	@Test
	public void deveRealizarCliqueDuplo() {
		page.clicarPorTexto("Clique duplo");
		page.clicarPorTexto("Clique duplo");
		Assert.assertEquals("Duplo Clique", page.obterTextoCampo());
	}
	

}
