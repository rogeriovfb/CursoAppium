package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.MenuPage;
import br.ce.rogerioballestrin.appium.page.SplashPage;

public class SplashTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SplashPage page = new SplashPage();
	
	@Test
	public void DeveAguardarSplashSumir() {
		//acessar menu Splash
		menu.acessarSplash();
		
		//verificar que o Splash est� sendo exibido
		page.IsTelaSplashVisivel();
		// aguardar a sa�da do splash
		page.aguardarSplashSumir();
		// verificar que o formul�rio est� aparecendo
		Assert.assertTrue(page.existeElementoPorTexto("Formul�rio"));
	}
}
