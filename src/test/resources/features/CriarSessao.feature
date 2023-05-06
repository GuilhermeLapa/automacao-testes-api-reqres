# encoding: iso-8859-1
@Testar
Feature: POST Criar uma Sessão

Scenario Outline: Validar Obrigatoriedade Username
	Given que nao possuo username "<email>" "<password>"
	When crio uma sessao
	Then verifico status code 400
	And verifico que ha o campo "error"
	And verifico a mensagem "user not found"
	Examples: 
	| email           | password |
	| email@email.com | senha    |

Scenario Outline: Validar Obrigatoriedade Email
	Given que nao possuo email "<username>" "<password>"
	When crio uma sessao
	Then verifico status code 400
	And verifico que ha o campo "error"
	And verifico a mensagem "user not found"
	Examples: 
	| username           | password |
	| Usuario Testes     | senha    |

Scenario Outline: Validar Obrigatoriedade Password
	Given que nao possuo password "<username>" "<email>"
	When crio uma sessao
	Then verifico status code 400
	And verifico que ha o campo "error"
	And verifico a mensagem "Missing password"
	Examples: 
	| username           | email           |
	| Usuario Testes     | email@email.com |

Scenario Outline: Validar Valores de Dominio Email
	Given que possuo email invalido "<username>" "<password>" "<email>"
	When crio uma sessao
	Then verifico status code 400
	And verifico que ha o campo "error"
	And verifico a mensagem "user not found"
	Examples: 
	| username           | password | email       |
	| Usuario Testes     | senha    | \@email.com |
	| Usuario Testes     | senha    | email@email |
	| Usuario Testes     | senha    | .com        |

Scenario Outline: Validar Login Sucesso
	Given que possuo dados validos para login "<password>" "<email>"
	When crio uma sessao
	Then verifico status code 200
	And verifico que ha o campo "token"
	And salvo o token da sessao
	Examples: 
	| password | email              |
	| pistol   | eve.holt@reqres.in |
