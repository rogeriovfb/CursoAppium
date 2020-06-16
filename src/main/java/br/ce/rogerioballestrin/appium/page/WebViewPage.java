package br.ce.rogerioballestrin.appium.page;

import java.util.Set;

import org.openqa.selenium.By;

import br.ce.rogerioballestrin.appium.core.BasePage;
import br.ce.rogerioballestrin.appium.core.DriverFactory;

public class WebViewPage extends BasePage {
	
	public void entrarContextoWeb() {
		Set<String> contexto = DriverFactory.getDriver().getContextHandles();
		//for (String valor: contexto) {
		//	System.out.println(valor);
		//}
		DriverFactory.getDriver().context((String) contexto.toArray()[1]);
	}
	
	public void sairContextoWeb() {
		Set<String> contexto = DriverFactory.getDriver().getContextHandles();
		DriverFactory.getDriver().context((String) contexto.toArray()[0]);
	}
	
	public void setEmail(String valor) {
		DriverFactory.getDriver().findElement(By.id("email")).sendKeys(valor);
		
	}
	
	public void setSenha(String valor) {
		DriverFactory.getDriver().findElement(By.id("senha")).sendKeys(valor);	
	}
	
	public void entrar() {
		clicar(By.xpath("//button[@type='submit']"));
	}
	
	public String getMensagem() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}

}
