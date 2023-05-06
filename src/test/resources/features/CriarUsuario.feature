# encoding: iso-8859-1
@Testar
Feature: POST Criar um Usuário

Scenario Outline: Validar Obrigatoriedade Campo Username
	Given que nao possuo username "<email>" "<password>"
	When crio um usuario
	Then verifico status code 200
	And verifico que ha o campo "id"
	And verifico o valor 4 no campo "id"
	And verifico que ha o campo "token"
	And verifico o valor "QpwL5tke4Pnpja7X4" no campo "token"
	Examples: 
	| email              | password |
	| eve.holt@reqres.in | pistol   |

Scenario Outline: Validar Obrigatoriedade Campo Email
	Given que nao possuo email "<username>" "<password>"
	When crio um usuario
	Then verifico status code 400
	And verifico que ha o campo "error"
	And verifico a mensagem "Note: Only defined users succeed registration"
	Examples: 
	| username | password |
	| Eve Holt | pistol   |

Scenario Outline: Validar Obrigatoriedade Campo Password
	Given que nao possuo password "<email>" "<username>"
	When crio um usuario
	Then verifico status code 400
	And verifico que ha o campo "error"
	And verifico a mensagem "Missing password"
	Examples: 
	| email              | username |
	| eve.holt@reqres.in | Eve Holt |

Scenario Outline: Validar Erro Cadastro de Usuário Não Registrado
	Given que possuo dados de usuario nao registrado "<username>" "<password>" "<email>"
	When crio um usuario
	Then verifico status code 400
	And verifico que ha o campo "error"
	And verifico a mensagem "Note: Only defined users succeed registration"
	Examples: 
	| username              | password     | email                     |
	| Usuario NaoRegistrado | senhaTeste   | emailTeste@emailTeste.com |

Scenario Outline: Validar Valores de Domínio Campo Email
	Given que possuo email invalido "<username>" "<password>" "<email>"
	When crio um usuario
	Then verifico status code 400
	And verifico que ha o campo "error"
	And verifico a mensagem "Note: Only defined users succeed registration"
	Examples: 
	| username     | password | email         |
	| Eve Holt     | senha    | \@email.com   |
	| Eve Holt     | senha    | email@email   |
	| Eve Holt     | senha    | .com          |

Scenario Outline: Validar Criar Usuário Sucesso
	Given que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	When crio um usuario
	Then verifico status code 200
	And verifico que ha o campo "id"
	And verifico o valor 4 no campo "id"
	And verifico que ha o campo "token"
	And verifico o valor "QpwL5tke4Pnpja7X4" no campo "token"
	Examples: 
	| username | password | email              |
	| Eve Holt | pistol   | eve.holt@reqres.in |
