# language: pt
# encoding iso-8859-1

@Testar
Funcionalidade: GET - Consultar Lista Usuários

Cenário: Validar Consultar Lista Usuarios Sem Parametros Sucesso
	Dado que possuo usuarios cadastrados
	Quando consulto a lista de usuarios
	Então verifico status code 200
	E verifico que ha o campo "page"
	E verifico que ha o campo "per_page"
	E verifico que ha o campo "total"
	E verifico que ha o campo "total_pages"
	E verifico que ha o campo "data"
	E verifico no body "support" que ha o campo "url"
	E verifico no body "support" que ha o campo "text"

Cenário: Validar Consultar Lista Usuarios Sucesso
	Dado que possuo usuarios cadastrados
	E informo a quantidade de usuarios <perPage>
	E informo a quantidade de paginas <page>
	Quando consulto a lista de usuarios
	Então verifico status code 200
	E verifico que ha o campo "page"
	E verifico o valor <page> no campo "page"
	E verifico que ha o campo "per_page"
	E verifico o valor <perPage> no campo "per_page"
	E verifico que ha o campo "total"
	E verifico o valor 12 no campo "total"
	E verifico que ha o campo "total_pages"
	E verifico o valor 6 no campo "total_pages"
	E verifico no body "$" que ha o campo "data"
	E verifico no body "data[0]" que ha o campo "id"
	E verifico o valor 5 no campo "data[0].id"
	E verifico no body "data[0]" que ha o campo "email"
	E verifico o valor "charles.morris@reqres.in" no campo "data[0].email"
	E verifico no body "data[0]" que ha o campo "first_name"
	E verifico o valor "Charles" no campo "data[0].first_name"
	E verifico no body "data[0]" que ha o campo "last_name"
	E verifico o valor "Morris" no campo "data[0].last_name"
	E verifico no body "data[0]" que ha o campo "avatar"
	E verifico o valor "https://reqres.in/img/faces/5-image.jpg" no campo "data[0].avatar"
	E verifico que ha o campo "support"
	E verifico no body "support" que ha o campo "url"
	E verifico o valor "https://reqres.in/#support-heading" no campo "support.url"
	E verifico no body "support" que ha o campo "text"
	E verifico o valor "To keep ReqRes free, contributions towards server costs are appreciated!" no campo "support.text"
	Exemplos: 
	| perPage | page |
	| 2       | 3    |
