package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.MenuPage;
import br.ce.rogerioballestrin.appium.page.SwipeListPage;


public class DesafioSecao7Teste extends BaseTest {
	private MenuPage menu = new MenuPage();
	private SwipeListPage page = new SwipeListPage();

	@Test
	public void deveInteragirComSwipeList() {
		//clicar swipe list
		menu.scrollDown();
		esperar(500);
		menu.acessarSwipeList();
		//op1 para direita
		page.swipeElementRight("Opção 1");
		//clicar op1+
		page.clicarBotaoMais();
		//verificar op1+
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 1 (+)"));
		//op4 para direita
		page.swipeElementRight("Opção 4");
		//clicar op4-
		menu.clicarPorTexto("(-)");
		//verificar op4-
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 4 (-)"));
		//op5 para esquerda
		page.swipeElementLeft("Opção 5 (-)");
		//verificar op5
		Assert.assertTrue(menu.existeElementoPorTexto("Opção 5"));

	}
}
