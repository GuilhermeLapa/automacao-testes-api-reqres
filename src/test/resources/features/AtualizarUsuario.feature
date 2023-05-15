# encoding iso-8859-1
@Testar
Feature: PUT - Atualizar Usuario

Scenario Outline: Validar Atualizar Usuario com Sucesso
	Given que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	And crio um usuario
	And salvo o valor do id
	And possuo dados validos para atualizar usuario "<novoNome>" "<job>"
	And possuo o id do usuario
	When atualizo os dados do usuario
	Then verifico status code 200
	And verifico que ha o campo "name"
	And verifico o valor "<novoNome>" no campo "name"
	And verifico que ha o campo "job"
	And verifico o valor "<job>" no campo "job"
	And verifico que ha o campo "updatedAt"
	Examples: 
	| username | password | email              | job           | novoNome |
	| Eve Holt | pistol   | eve.holt@reqres.in | zion resident | Morpheus |

Scenario Outline: Validar Atualizar Usuario Apenas Nome Sucesso
	Given que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	And crio um usuario
	And salvo o valor do id
	And possuo Nome para atualizar usuario "<novoNome>"
	And possuo o id do usuario
	When atualizo os dados do usuario
	Then verifico status code 200
	And verifico que ha o campo "name"
	And verifico o valor "<novoNome>" no campo "name"
	And verifico que ha o campo "updatedAt"
	Examples: 
	| username | password | email              | novoNome |
	| Eve Holt | pistol   | eve.holt@reqres.in | Morpheus |

Scenario Outline: Validar Atualizar Usuario Apenas Ocupacao Sucesso
	Given que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	And crio um usuario
	And salvo o valor do id
	And possuo Ocupacao para atualizar usuario "<job>"
	And possuo o id do usuario
	When atualizo os dados do usuario
	Then verifico status code 200
	And verifico que ha o campo "job"
	And verifico o valor "<job>" no campo "job"
	And verifico que ha o campo "updatedAt"
	Examples: 
	| username | password | email              | job           |
	| Eve Holt | pistol   | eve.holt@reqres.in | zion resident |

Scenario Outline: Validar Valores de Dominio Campo Nome
	Given que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	And crio um usuario
	And salvo o valor do id
	And possuo Nome para atualizar usuario "<novoNome>"
	And possuo o id do usuario
	When atualizo os dados do usuario
	Then verifico status code 200
	And verifico que ha o campo "name"
	And verifico o valor "<novoNome>" no campo "name"
	And verifico que ha o campo "updatedAt"
	Examples: 
	| username | password | email              | novoNome    |
	| Eve Holt | pistol   | eve.holt@reqres.in | !\@$%&()_=- |

Scenario Outline: Validar Valores de Dominio Campo Ocupacao
	Given que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	And crio um usuario
	And salvo o valor do id
	And possuo Ocupacao para atualizar usuario "<job>"
	And possuo o id do usuario
	When atualizo os dados do usuario
	Then verifico status code 200
	And verifico que ha o campo "job"
	And verifico o valor "<job>" no campo "job"
	And verifico que ha o campo "updatedAt"
	Examples: 
	| username | password | email              | job         |
	| Eve Holt | pistol   | eve.holt@reqres.in | !\@$%&()_=- |
