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
	
	public void acessarAlertas() {
		//DriverFactory.getDriver();
		clicarPorTexto("Alertas");
	}
	
	public void acessarAbas() {
		clicarPorTexto("Abas");
	}
	
	public void acessarAccordion() {
		clicarPorTexto("Accordion");
	}
	
	public void acessarCliques() {
		clicarPorTexto("Cliques");
	}
	
	public void acessarSwipe() {
		clicarPorTexto("Swipe");
	}
	
	public void acessarSwipeList() {
		clicarPorTexto("Swipe List");
	}
	public void acessarDragNDrop() {
		clicarPorTexto("Drag and drop");
	}
}
