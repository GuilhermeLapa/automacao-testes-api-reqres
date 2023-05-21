# encoding: iso-8859-1
@Testar
Feature: GET - Consultar Usuario por Id

Scenario Outline: Validar Consultar Usuario por Id Sucesso
	Given que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	And crio um usuario
	And salvo o valor do id
	When consulto o usuario pelo seu id
	Then verifico status code 200
	And verifico no body "$" que ha o campo "data"
	And verifico no body "data" que ha o campo "id"
	And verifico o valor 4 no campo "data.id"
	And verifico no body "data" que ha o campo "email"
	And verifico o valor "eve.holt@reqres.in" no campo "data.email"
	And verifico no body "data" que ha o campo "first_name"
	And verifico o valor "Eve" no campo "data.first_name"
	And verifico no body "data" que ha o campo "last_name"
	And verifico o valor "Holt" no campo "data.last_name"
	And verifico no body "data" que ha o campo "avatar"
	And verifico o valor "https://reqres.in/img/faces/4-image.jpg" no campo "data.avatar"
	And verifico que ha o campo "support"
	And verifico no body "support" que ha o campo "url"
	And verifico o valor "https://reqres.in/#support-heading" no campo "support.url"
	And verifico no body "support" que ha o campo "text"
	And verifico o valor "To keep ReqRes free, contributions towards server costs are appreciated!" no campo "support.text"
	Examples: 
	| username | password | email              |
	| Eve Holt | pistol   | eve.holt@reqres.in |

Scenario: Validar Obrigatoriedade Campo Id Consultar Usuario
	Given que nao possuo id do usuario 
	When consulto o usuario pelo seu id
	Then verifico status code 404

Scenario Outline: Validar Valores de Dominio Campo Id Consultar Usuario
	Given que possuo valor invalido de id de usuario "<id>"
	When consulto o usuario pelo seu id
	Then verifico status code 404
	Examples: 
	| id          |
	| abc         |
	| !\@$%&()_=- |
