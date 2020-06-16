package br.ce.rogerioballestrin.appium.test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.ce.rogerioballestrin.appium.core.BaseTest;
import br.ce.rogerioballestrin.appium.page.MenuPage;
import br.ce.rogerioballestrin.appium.page.seuBarriga.SBContasPage;
import br.ce.rogerioballestrin.appium.page.seuBarriga.SBHomePage;
import br.ce.rogerioballestrin.appium.page.seuBarriga.SBLoginPage;
import br.ce.rogerioballestrin.appium.page.seuBarriga.SBMenuPage;
import br.ce.rogerioballestrin.appium.page.seuBarriga.SBMovimentacaoPage;
import br.ce.rogerioballestrin.appium.page.seuBarriga.SBResumoPage;



public class SBTeste extends BaseTest {
	
	private MenuPage menu = new MenuPage();
	private SBLoginPage page = new SBLoginPage();
	private SBMenuPage menuSB = new SBMenuPage();
	private SBContasPage contas = new SBContasPage();
	private SBMovimentacaoPage mov = new SBMovimentacaoPage();
	private SBHomePage home = new SBHomePage();
	private SBResumoPage resumo = new SBResumoPage();
	
	@Before
	public void setup() {
		menu.acessarSBNativo();
		page.setEmail("rb@rb");
		page.setSenha("12345678");
		page.entrar();
	}
	
	@Test
	public void deveInserirConta() {
		//entrar em contas
		menuSB.acessarContas();
		//digitar nome conta
		contas.setConta("Conta de Teste");
		// salvar
		contas.salvar();
		// verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta adicionada com sucesso"));
	}
	
	@Test
	public void deveExcluirConta() {
		//entrar em contas
		menuSB.acessarContas();	
		// clique longo na conta
		contas.selecionarConta("123");
		//excluir
		contas.excluir();
		//verificar mensagem
		Assert.assertTrue(contas.existeElementoPorTexto("Conta excluída com sucesso"));
	}
	
	@Test
	public void deveValidarInclusaoMov() {
		menuSB.acessarMovimentacoes();
		//validar desc
		mov.salvar();
		Assert.assertTrue(contas.existeElementoPorTexto("Descrição é um campo obrigatório"));
		//validar inte
		mov.setDescricao("Desc");
		mov.salvar();
		Assert.assertTrue(contas.existeElementoPorTexto("Interessado é um campo obrigatório"));
		//validar valor
		mov.setInteressado("interess");
		mov.salvar();
		Assert.assertTrue(contas.existeElementoPorTexto("Valor é um campo obrigatório"));
		//validar conta
		mov.setValor("123");
		mov.salvar();
		Assert.assertTrue(contas.existeElementoPorTexto("Conta é um campo obrigatório"));
		//inserir com sucesso
		mov.setConta("Conta para alterar");
		mov.salvar();
		Assert.assertTrue(contas.existeElementoPorTexto("Movimentação cadastrada com sucesso"));
	}
	
	@Test
	public void deveAtualizarSaldoAoExcluirMovimentacao() {
		// verificar saldo "Conta para saldo" = 534.00
		Assert.assertEquals("534.00", home.obterSaldoConta("Conta para saldo"));
		//ir para resumo
		menuSB.acessarResumo();
		//excluir Movimentação 3
		resumo.excluirMovimentacao("Movimentacao 3, calculo saldo");
		//validar a mensagem "Movimentação removida com sucesso"
		Assert.assertTrue(resumo.existeElementoPorTexto("Movimentação removida com sucesso!"));
		//voltar home
		menuSB.acessarHome();
		//atualizar saldos
		esperar(1000);
		home.scroll(0.2, 0.9);
		//verificar saldo = -1000
		Assert.assertEquals("-1000.00",home.obterSaldoConta("Conta para saldo"));

	}

}
