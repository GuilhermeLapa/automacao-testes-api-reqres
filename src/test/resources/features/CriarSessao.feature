# language: pt
# encoding iso-8859-1

@Testar
Funcionalidade: POST Criar uma Sessão

Cenário: Validar Obrigatoriedade Username
	Dado que nao possuo username "<email>" "<password>"
	Quando crio uma sessao
	Então verifico status code 400
	E verifico que ha o campo "error"
	E verifico a mensagem "user not found"
	Exemplos: 
	| email           | password |
	| email@email.com | senha    |

Cenário: Validar Obrigatoriedade Email
	Dado que nao possuo email "<username>" "<password>"
	Quando crio uma sessao
	Então verifico status code 400
	E verifico que ha o campo "error"
	E verifico a mensagem "user not found"
	Exemplos: 
	| username           | password |
	| Usuario Testes     | senha    |

Cenário: Validar Obrigatoriedade Password
	Dado que nao possuo password "<username>" "<email>"
	Quando crio uma sessao
	Então verifico status code 400
	E verifico que ha o campo "error"
	E verifico a mensagem "Missing password"
	Exemplos: 
	| username           | email           |
	| Usuario Testes     | email@email.com |

Cenário: Validar Valores de Dominio Email
	Dado que possuo email invalido "<username>" "<password>" "<email>"
	Quando crio uma sessao
	Então verifico status code 400
	E verifico que ha o campo "error"
	E verifico a mensagem "user not found"
	Exemplos: 
	| username           | password | email       |
	| Usuario Testes     | senha    | \@email.com |
	| Usuario Testes     | senha    | email@email |
	| Usuario Testes     | senha    | .com        |

Cenário: Validar Login Sucesso
	Dado que possuo dados validos para login "<password>" "<email>"
	Quando crio uma sessao
	Então verifico status code 200
	E verifico que ha o campo "token"
	E salvo o token da sessao
	Exemplos: 
	| password | email              |
	| pistol   | eve.holt@reqres.in |
