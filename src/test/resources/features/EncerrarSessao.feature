# encoding: iso-8859-1
@Testar
Feature: POST - Encerrar Sessão

Scenario Outline: Validar Encerrar Sessao com Sucesso
	Given que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	And crio um usuario
	And crio uma sessao
	When encerro uma sessao
	Then verifico status code 200
	Examples: 
	| username | password | email              |
	| Eve Holt | pistol   | eve.holt@reqres.in |
