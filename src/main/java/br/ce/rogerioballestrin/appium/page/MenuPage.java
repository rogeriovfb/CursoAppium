package br.ce.rogerioballestrin.appium.page;

import br.ce.rogerioballestrin.appium.core.DSL;

public class MenuPage {
	
	private DSL dsl = new DSL();


	public void acessarFormulario() {
		dsl.clicarPorTexto("Formulário");
	}
}
