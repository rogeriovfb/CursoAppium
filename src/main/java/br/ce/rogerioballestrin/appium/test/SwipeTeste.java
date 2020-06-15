package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.MenuPage;

public class SwipeTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveRealizarSwipe() {
		//acessar menu
		menu.acessarSwipe();
		//verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		// swipe para direita
		menu.swipe(0.9, 0.1);
		//verificar o texto 'e veja se'
		Assert.assertTrue(menu.existeElementoPorTexto("E veja se"));
		//clicar botao direita
		menu.clicarPorTexto("›");
		//verificar o texto "Chegar até o fim"
		Assert.assertTrue(menu.existeElementoPorTexto("Chegar até o fim!"));
		// swipe esquerda
		menu.swipe(0.1, 0.9);
		// clicar botao esquerda
		menu.clicarPorTexto("‹");
		//verificar texto 'a esquerda'
		Assert.assertTrue(menu.existeElementoPorTexto("a esquerda"));
		
	}

}
