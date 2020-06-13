package br.ce.rogerioballestrin.appium.page;

import br.ce.rogerioballestrin.appium.core.BasePage;
import br.ce.rogerioballestrin.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MenuPage extends BasePage{
	
	public void acessarFormulario() {
		DriverFactory.getDriver();
		clicarPorTexto("Formulário");
	}
}
