#language: pt

Funcionalidade: Pagamento Pix
	como um cliente autenticado do banco
	eu quero enviar um valor via pix
	para que eu possa fazer um pagamento
	
	Contexto: Acessar conta de cliente
		Dado Acessar a página de entrada do cliente
		E Informar o numero da conta do cliente "123456-2022"
		E Informar a senha da conta do cliente "coti123"
		Quando Solicitar o acesso à conta
		Então Sistema autentica o cliente com sucesso
		
	Esquema do Cenário: Pagamento Pix com sucesso
		Dado Acessar a página de pagamento por pix
		E Selecionar o tipo de chave <tipochave>
		E Informar o valor da chave <valorchave>
		E Informar o valor a pagar "100,00"
		Quando Confirmar o pagamento
		Então Sistema realiza o pagamento com sucesso
		
	Exemplos:
		|  tipochave    |  valorchave       |
		|  "Telefone"   | "21969575900"     |
		|  "Cpf"        | "82907471015"     |
		|  "Cnpj"       | "30786241000179"  |
		|  "Email"      | "teste@gmail.com" |    