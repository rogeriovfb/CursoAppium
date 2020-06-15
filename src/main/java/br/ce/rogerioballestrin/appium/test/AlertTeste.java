package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.AlertaPage;
import br.ce.rogerioballestrin.appium.page.MenuPage;

public class AlertTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private AlertaPage page = new AlertaPage();
	
	@Before
	public void setup() {
		// acessar menu alerta
		menu.acessarAlertas();
		
	}
	
	@Test
	public void deveConfirmarAlerta() {
		// clicar em alert confirm
		page.clicarAlertaConfirm();
		//verificar os textos
		Assert.assertEquals("Info", page.obterTituloAlerta());
		Assert.assertEquals("Confirma a operação?", page.obterMensagemAlerta());
		// confirmar alerta
		page.confirmar();
		//verificar nova mensagem
		Assert.assertEquals("Confirmado", page.obterMensagemAlerta());
		//sair
		esperar(500);
		page.sair();
		
	}
	
	@Test
	public void deveClicarForaAlerta() {		
		//clicar alerta simples
		page.clicarAlertaSimples();
		//clicar fora da caixa (100,150)
		esperar(1000);
		page.clicarForaCaixa();
		//verificar que a mensagem não existe mais
		Assert.assertFalse(page.existeElementoPorTexto("Pode clicar no OK ou fora da caixa para sair"));
	}

}
