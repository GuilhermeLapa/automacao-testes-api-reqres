# language: pt
# encoding iso-8859-1

@Testar
Funcionalidade: DELETE - Deletar Usuario

Cenário: Validar Deletar Usuário com Sucesso
	Dado que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	E crio um usuario
	E salvo o valor do id
	Quando deleto o usuario
	Então verifico status code 204
	Exemplos: 
	| username | password | email              |
	| Eve Holt | pistol   | eve.holt@reqres.in |
