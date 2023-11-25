# language: pt
# encoding iso-8859-1

@Testar
Funcionalidade: GET - Consultar Usuario por Id

Cenário: Validar Consultar Usuario por Id Sucesso
	Dado que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	E crio um usuario
	E salvo o valor do id
	Quando consulto o usuario pelo seu id
	Então verifico status code 200
	E verifico no body "$" que ha o campo "data"
	E verifico no body "data" que ha o campo "id"
	E verifico o valor 4 no campo "data.id"
	E verifico no body "data" que ha o campo "email"
	E verifico o valor "eve.holt@reqres.in" no campo "data.email"
	E verifico no body "data" que ha o campo "first_name"
	E verifico o valor "Eve" no campo "data.first_name"
	E verifico no body "data" que ha o campo "last_name"
	E verifico o valor "Holt" no campo "data.last_name"
	E verifico no body "data" que ha o campo "avatar"
	E verifico o valor "https://reqres.in/img/faces/4-image.jpg" no campo "data.avatar"
	E verifico que ha o campo "support"
	E verifico no body "support" que ha o campo "url"
	E verifico o valor "https://reqres.in/#support-heading" no campo "support.url"
	E verifico no body "support" que ha o campo "text"
	E verifico o valor "To keep ReqRes free, contributions towards server costs are appreciated!" no campo "support.text"
	Exemplos: 
	| username | password | email              |
	| Eve Holt | pistol   | eve.holt@reqres.in |

Cenário: Validar Obrigatoriedade Campo Id Consultar Usuario
	Dado que nao possuo id do usuario 
	Quando consulto o usuario pelo seu id
	Então verifico status code 404

Cenário: Validar Valores de Dominio Campo Id Consultar Usuario
	Dado que possuo valor invalido de id de usuario "<id>"
	Quando consulto o usuario pelo seu id
	Então verifico status code 404
	Exemplos: 
	| id          |
	| abc         |
	| !\@$%&()_=- |
