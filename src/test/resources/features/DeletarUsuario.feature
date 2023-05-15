# encoding iso-8859-1
@Testar
Feature: DELETE - Deletar Usuario

Scenario Outline: Validar Deletar Usuario com Sucesso
	Given que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	And crio um usuario
	And salvo o valor do id
	When deleto o usuario
	Then verifico status code 204
	Examples: 
	| username | password | email              |
	| Eve Holt | pistol   | eve.holt@reqres.in |
