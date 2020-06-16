package br.ce.rogerioballestrin.appium.test;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.MenuPage;
import br.ce.rogerioballestrin.appium.page.WebViewPage;

public class WebViewTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private WebViewPage page = new WebViewPage();
	@Test
	public void deveFazerLogin() {
		//acessar o menu
		menu.acessarSBHibrido();
		esperar(3000);
		//preencher e-mail
		page.entrarContextoWeb();
		page.setEmail("ballestrin.rogerio@gmail.com");
		esperar(3000);
		//senha
		page.setSenha("12345678");
		//entrar
		page.entrar();
		//verificar
		Assert.assertEquals("Bem vindo, Rogério Ballestrin!", page.getMensagem());
	}
	
	@After
	public void tearDown() {
		page.sairContextoWeb();
	}

}
