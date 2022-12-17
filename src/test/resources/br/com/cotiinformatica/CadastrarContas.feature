#language: pt

Funcionalidade: Cadastrar Contas
	como um usuário autenticado no sistema
  eu quero cadastrar uma conta
  para que eu possa gerenciar minhas finanças
  
  Contexto: Autenticação de usuário
  	Dado Acessar a página de autenticação de usuários
  	E Informar o nome do usuário "administrador"
  	E Informar a senha do usuário "adminadmin"
  	Quando Solicitar a realização do acesso
  	Então Sistema autentica o usuário com sucesso
  
  Esquema do Cenário: Cadastro de conta com sucesso  	
  	Dado Acessar a página de cadastro de contas
  	E Informar o nome da conta <nome>
  	E Informar o valor da conta <valor>
  	E Informar a data da conta <data>
  	Quando Solicitar a realização do cadastro da conta
  	E Confirmar a realização do cadastro
  	Então Sistema informa que a conta foi cadastrada com sucesso
  	
  Exemplos:
  	| nome        		| valor     | data         |
  	| "Conta de Luz"	| "350,00"  | "15/12/2022" |
  	| "Aluguel"       | "2000,00" | "16/12/2022" |
  	| "Salário"       | "3000,00" | "14/12/2022" |