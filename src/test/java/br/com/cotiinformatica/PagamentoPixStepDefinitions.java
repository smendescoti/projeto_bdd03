package br.com.cotiinformatica;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;

public class PagamentoPixStepDefinitions {

	@Dado("Acessar a página de entrada do cliente")
	public void acessar_a_pagina_de_entrada_do_cliente() {
		// TODO
	}

	@Dado("Informar o numero da conta do cliente {string}")
	public void informar_o_numero_da_conta_do_cliente(String numero) {
		// TODO
	}

	@Dado("Informar a senha da conta do cliente {string}")
	public void informar_a_senha_da_conta_do_cliente(String senha) {
		// TODO
	}

	@Quando("Solicitar o acesso à conta")
	public void solicitar_o_acesso_a_conta() {
		// TODO
	}

	@Entao("Sistema autentica o cliente com sucesso")
	public void sistema_autentica_o_cliente_com_sucesso() {
		// TODO
	}

	@Dado("Acessar a página de pagamento por pix")
	public void acessar_a_pagina_de_pagamento_por_pix() {
		// TODO
	}

	@Dado("Selecionar o tipo de chave {string}")
	public void selecionar_o_tipo_de_chave(String tipoChave) {
		// TODO
	}

	@Dado("Informar o valor da chave {string}")
	public void informar_o_valor_da_chave(String valorChave) {
		// TODO
	}

	@Dado("Informar o valor a pagar {string}")
	public void informar_o_valor_a_pagar(String valorPagar) {
		// TODO
	}

	@Quando("Confirmar o pagamento")
	public void confirmar_o_pagamento() {
		// TODO
	}

	@Entao("Sistema realiza o pagamento com sucesso")
	public void sistema_realiza_o_pagamento_com_sucesso() {
		// TODO
	}
}
