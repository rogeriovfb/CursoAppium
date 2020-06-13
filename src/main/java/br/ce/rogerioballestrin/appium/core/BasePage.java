package br.ce.rogerioballestrin.appium.core;

import static br.ce.rogerioballestrin.appium.core.DriverFactory.getDriver;

import java.util.List;

import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;

public class BasePage {
	public void escrever(By by, String texto) {
	    // Escrever Nome
	    getDriver().findElement(by).sendKeys(texto);
	}
	
	public String obterTexto(By by) {
		return getDriver().findElement(by).getText();
	}
	
	public void clicarPorTexto(String texto) {
		clicar(By.xpath("//*[@text='"+texto+"']"));
	}
	
	public void selecionarCombo(By by, String valor) {
		getDriver().findElement(by).click();
		clicarPorTexto(valor);
	}
	
	public boolean ischeckedMarcado(By by) {
		return getDriver().findElement(by).getAttribute("checked").equals("true");
	    //check.getAttribute("checked") retorna string true ou false
	}
	
	public void clicar(By by) {
		getDriver().findElement(by).click();
	}
	
	public String obterValorSalvo(String index) {
		return obterTexto(By.xpath("//android.widget.TextView[@index="+index+"]"));
	}
	
	public boolean existeElementoPorTexto(String texto) {
		List<MobileElement> elementos = getDriver().findElements(By.xpath("//*[@text='"+texto+"']"));
		return elementos.size() > 0;
	}

}
