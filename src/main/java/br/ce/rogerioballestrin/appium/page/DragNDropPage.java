package br.ce.rogerioballestrin.appium.page;

import java.util.List;

import org.openqa.selenium.By;

import br.ce.rogerioballestrin.appium.core.BasePage;
import br.ce.rogerioballestrin.appium.core.DriverFactory;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

public class DragNDropPage extends BasePage {
	
	public void arrastar(String origem, String destino) {
		MobileElement inicio = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+origem+"']"));
		MobileElement fim = DriverFactory.getDriver().findElement(By.xpath("//*[@text='"+destino+"']"));
		
		new TouchAction(DriverFactory.getDriver())
		.longPress(inicio)
		.moveTo(fim)
		.release()
		.perform();
		

	}
	
	public String[] obterLista() {
		List<MobileElement> elements =  DriverFactory.getDriver().findElements(By.className("android.widget.TextView"));
		String[] retorno = new String[elements.size()];
		for(int i=0; i< elements.size(); i++) {
			retorno[i] = elements.get(i).getText();
			System.out.print("\"" + retorno[i] + "\", ");
		}
		return retorno;
	}

}
