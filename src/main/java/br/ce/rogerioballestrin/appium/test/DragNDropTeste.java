package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.DragNDropPage;
import br.ce.rogerioballestrin.appium.page.MenuPage;

public class DragNDropTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private DragNDropPage page = new DragNDropPage();
	
	private String[] estadoInicial = new String[] {"Esta", "� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "qualquer local desejado."};
	private String[] estadoIntermediario = new String[] {"� uma lista", "Drag em Drop!", "Fa�a um clique longo,", "e arraste para", "Esta", "qualquer local desejado."};
	private String[] estadoFinal = new String[] {"Fa�a um clique longo,", "� uma lista", "Drag em Drop!", "e arraste para", "Esta", "qualquer local desejado."};

	
	@Test
	public void deveEfetuarDragNDrop(){
		// acessar menu
		//clicar swipe list
		menu.scrollDown();
		esperar(500);
		menu.acessarDragNDrop();
		//verificar estado inicial
		esperar(1000);
		Assert.assertArrayEquals(estadoInicial, page.obterLista());
		//arrastar 'Esta' para 'e arraste para'
		page.arrastar("Esta", "e arraste para");
		//verificar estado intermedi�rio
		Assert.assertArrayEquals(estadoIntermediario, page.obterLista());
		//arrastar 'Fa�a um clique longo,' para '� uma lista'
		page.arrastar("Fa�a um clique longo,", "� uma lista");
		//verificar estado final
		Assert.assertArrayEquals(estadoFinal, page.obterLista());
	}

}
