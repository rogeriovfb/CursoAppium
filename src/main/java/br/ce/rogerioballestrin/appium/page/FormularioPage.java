package br.ce.rogerioballestrin.appium.page;

import org.openqa.selenium.By;

import br.ce.rogerioballestrin.appium.core.BasePage;
import io.appium.java_client.MobileBy;

public class FormularioPage extends BasePage{
	
	
	public void escreverNome(String nome) {
	    escrever(MobileBy.AccessibilityId("nome"), nome);
	}
	
	public String obterNome() {
		return obterTexto(MobileBy.AccessibilityId("nome"));
	}
	
	public void selecionarCombo(String valor) {
		selecionarCombo(MobileBy.AccessibilityId("console"), valor);
	}
	
	public String obterValorCombo() {
		return obterTexto(By.xpath("//android.widget.Spinner/android.widget.TextView"));
	}
	
	public void clicarCheck() {
		clicar(By.className("android.widget.CheckBox"));
	}
	
	public void clicarsw() {
	    clicar(MobileBy.AccessibilityId("switch"));
	}
	
	public boolean isCheckMarcado() {
		return ischeckedMarcado(By.className("android.widget.CheckBox"));
	}
	
	public boolean isSwMarcado() {
		return ischeckedMarcado(MobileBy.AccessibilityId("switch"));
	}
	
	public void salvar() {
	    clicarPorTexto("SALVAR");
	}
	
	public String obterNomeSalvo() {
		return obterValorSalvo("12");
	}
	public String obterConsoleSalvo() {
		return obterValorSalvo("13");
	}
	public String obterSwitchSalvo() {
		return obterValorSalvo("15");
	}
	public String obterCheckboxSalvo() {
		return obterValorSalvo("16");
	}
}
	
