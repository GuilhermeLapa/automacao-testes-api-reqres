# language: pt
# encoding iso-8859-1

@Testar
Funcionalidade: POST - Encerrar Sessão

Cenário: Validar Encerrar Sessão com Sucesso
	Dado que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	E crio um usuario
	E crio uma sessao
	Quando encerro uma sessao
	Então verifico status code 200
	Exemplos: 
	| username | password | email              |
	| Eve Holt | pistol   | eve.holt@reqres.in |
