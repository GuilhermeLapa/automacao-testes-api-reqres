# encoding: iso-8859-1
@Testar
Feature: GET - Consultar Lista Usuarios

Scenario: Validar Consultar Lista Usuarios Sem Parametros Sucesso 
	Given que possuo usuarios cadastrados
	When consulto a lista de usuarios
	Then verifico status code 200
	And verifico que ha o campo "page"
	And verifico que ha o campo "per_page"
	And verifico que ha o campo "total"
	And verifico que ha o campo "total_pages"
	And verifico que ha o campo "data"
	And verifico no body "support" que ha o campo "url"
	And verifico no body "support" que ha o campo "text"

Scenario Outline: Validar Consultar Lista Usuarios Sucesso 
	Given que possuo usuarios cadastrados
	And informo a quantidade de usuarios <perPage>
	And informo a quantidade de paginas <page>
	When consulto a lista de usuarios
	Then verifico status code 200
	And verifico que ha o campo "page"
	And verifico o valor <page> no campo "page"
	And verifico que ha o campo "per_page"
	And verifico o valor <perPage> no campo "per_page"
	And verifico que ha o campo "total"
	And verifico o valor 12 no campo "total"
	And verifico que ha o campo "total_pages"
	And verifico o valor 6 no campo "total_pages"
	And verifico no body "$" que ha o campo "data"
	And verifico no body "data[0]" que ha o campo "id"
	And verifico o valor 5 no campo "data[0].id"
	And verifico no body "data[0]" que ha o campo "email"
	And verifico o valor "charles.morris@reqres.in" no campo "data[0].email"
	And verifico no body "data[0]" que ha o campo "first_name"
	And verifico o valor "Charles" no campo "data[0].first_name"
	And verifico no body "data[0]" que ha o campo "last_name"
	And verifico o valor "Morris" no campo "data[0].last_name"
	And verifico no body "data[0]" que ha o campo "avatar"
	And verifico o valor "https://reqres.in/img/faces/5-image.jpg" no campo "data[0].avatar"
	And verifico que ha o campo "support"
	And verifico no body "support" que ha o campo "url"
	And verifico o valor "https://reqres.in/#support-heading" no campo "support.url"
	And verifico no body "support" que ha o campo "text"
	And verifico o valor "To keep ReqRes free, contributions towards server costs are appreciated!" no campo "support.text"
	Examples: 
	| perPage | page |
	| 2       | 3    |
