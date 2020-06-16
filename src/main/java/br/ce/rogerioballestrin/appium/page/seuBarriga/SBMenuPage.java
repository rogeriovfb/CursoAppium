package br.ce.rogerioballestrin.appium.page.seuBarriga;

import br.ce.rogerioballestrin.appium.core.BasePage;

public class SBMenuPage extends BasePage {
	
	public void acessarContas() {
		clicarPorTexto("CONTAS");
	}
	
	public void acessarMovimentacoes() {
		clicarPorTexto("MOV...");	
	}
	
	public void acessarResumo() {
		clicarPorTexto("RESUMO");	
	}
	
	public void acessarHome() {
		clicarPorTexto("HOME");	
	}
}
