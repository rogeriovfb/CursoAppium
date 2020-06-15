package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.MenuPage;

public class opcaoEscondidaTeste extends BaseTest{
	
	private MenuPage menu = new MenuPage();
	
	@Test
	public void deveEncontrarOpcaoEscondida() {
		//scroll down
		menu.scroll(0.9, 0.1);
		// clicar menu
		menu.clicarPorTexto("Opção bem escondida");
		// verificar mensagem
		Assert.assertEquals("Você achou essa opção", menu.obterMensagemAlerta());
		//sair
		menu.clicarPorTexto("OK");
	}
}
