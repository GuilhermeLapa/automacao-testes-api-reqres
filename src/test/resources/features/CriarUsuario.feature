# language: pt
# encoding iso-8859-1

@Testar
Funcionalidade: POST Criar um Usuário

Cenário: Validar Obrigatoriedade Campo Username
	Dado que nao possuo username "<email>" "<password>"
	Quando crio um usuario
	Então verifico status code 200
	E verifico que ha o campo "id"
	E verifico o valor 4 no campo "id"
	E verifico que ha o campo "token"
	E verifico o valor "QpwL5tke4Pnpja7X4" no campo "token"
	Exemplos: 
	| email              | password |
	| eve.holt@reqres.in | pistol   |

Cenário: Validar Obrigatoriedade Campo Email
	Dado que nao possuo email "<username>" "<password>"
	Quando crio um usuario
	Então verifico status code 400
	E verifico que ha o campo "error"
	E verifico a mensagem "Note: Only defined users succeed registration"
	Exemplos: 
	| username | password |
	| Eve Holt | pistol   |

Cenário: Validar Obrigatoriedade Campo Password
	Dado que nao possuo password "<email>" "<username>"
	Quando crio um usuario
	Então verifico status code 400
	E verifico que ha o campo "error"
	E verifico a mensagem "Missing password"
	Exemplos: 
	| email              | username |
	| eve.holt@reqres.in | Eve Holt |

Cenário: Validar Erro Cadastro de Usuário Não Registrado
	Dado que possuo dados de usuario nao registrado "<username>" "<password>" "<email>"
	Quando crio um usuario
	Então verifico status code 400
	E verifico que ha o campo "error"
	E verifico a mensagem "Note: Only defined users succeed registration"
	Exemplos: 
	| username              | password     | email                     |
	| Usuario NaoRegistrado | senhaTeste   | emailTeste@emailTeste.com |

Cenário: Validar Valores de Domínio Campo Email
	Dado que possuo email invalido "<username>" "<password>" "<email>"
	Quando crio um usuario
	Então verifico status code 400
	E verifico que ha o campo "error"
	E verifico a mensagem "Note: Only defined users succeed registration"
	Exemplos: 
	| username     | password | email         |
	| Eve Holt     | senha    | \@email.com   |
	| Eve Holt     | senha    | email@email   |
	| Eve Holt     | senha    | .com          |

Cenário: Validar Criar Usuário Sucesso
	Dado que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	Quando crio um usuario
	Então verifico status code 200
	E verifico que ha o campo "id"
	E verifico o valor 4 no campo "id"
	E verifico que ha o campo "token"
	E verifico o valor "QpwL5tke4Pnpja7X4" no campo "token"
	Exemplos: 
	| username | password | email              |
	| Eve Holt | pistol   | eve.holt@reqres.in |
