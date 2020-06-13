package br.ce.rogerioballestrin.appium.page;

import br.ce.rogerioballestrin.appium.core.BasePage;

public class MenuPage extends BasePage{
	
	public void acessarFormulario() {
		//DriverFactory.getDriver();
		clicarPorTexto("Formulário");
	}
	
	public void acessarSplash() {
		//DriverFactory.getDriver();
		clicarPorTexto("Splash");
	}
}
