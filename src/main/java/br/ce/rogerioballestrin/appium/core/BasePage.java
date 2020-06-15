package br.ce.rogerioballestrin.appium.core;

import static br.ce.rogerioballestrin.appium.core.DriverFactory.getDriver;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

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
	
	public String obterTituloAlerta() {
		return obterTexto(By.id("android:id/alertTitle"));
	}
	
	public String obterMensagemAlerta() {
		return obterTexto(By.id("android:id/message"));
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
	
	public void tap(int x, int y) {
		new TouchAction(DriverFactory.getDriver()).tap(x, y).perform();
	}
	
	public void scroll(double inicio, double fim) {
		Dimension tamanho = DriverFactory.getDriver().manage().window().getSize();
		int x = tamanho.width / 2;
		int yInicial = (int) (tamanho.height*inicio);
		int yFinal = (int) (tamanho.height*fim);
		new TouchAction(DriverFactory.getDriver())
			.press(x, yInicial)
			.waitAction(Duration.ofMillis(500))
			.moveTo(x, yFinal)
			.release().perform();
	}
	
	public void swipe(double inicio, double fim) {
		Dimension tamanho = DriverFactory.getDriver().manage().window().getSize();
		int y = tamanho.height / 2;
		int start_x = (int) (tamanho.width * inicio);
		int end_x = (int) (tamanho.width * fim);
		new TouchAction(DriverFactory.getDriver())
			.press(start_x, y)
			.waitAction(Duration.ofMillis(500))
			.moveTo(end_x, y)
			.release().perform();
	}

}
