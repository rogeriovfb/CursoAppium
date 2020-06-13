package br.ce.rogerioballestrin.appium.page;

import org.openqa.selenium.By;

import br.ce.rogerioballestrin.appium.core.DSL;
import io.appium.java_client.MobileBy;

public class FormularioPage {
	
	private DSL dsl = new DSL();
	
	public void escreverNome(String nome) {
	    dsl.escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return dsl.obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		dsl.selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return dsl.obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCheck() {
		dsl.clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarsw() {
	    dsl.clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return dsl.ischeckedMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwMarcado() {
		return dsl.ischeckedMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void salvar() {
	    dsl.clicarPorTexto("SALVAR");
	}
	
	public String obterNomeSalvo() {
		return dsl.obterValorSalvo("12");
	}
	public String obterConsoleSalvo() {
		return dsl.obterValorSalvo("13");
	}
	public String obterSwitchSalvo() {
		return dsl.obterValorSalvo("15");
	}
	public String obterCheckboxSalvo() {
		return dsl.obterValorSalvo("16");
	}
}
	
