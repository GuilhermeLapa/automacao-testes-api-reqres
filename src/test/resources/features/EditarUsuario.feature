# language: pt
# encoding iso-8859-1

@Testar
Funcionalidade: PATCH - Atualizar Usuário

Cenário: Validar Atualizar Usuário com Sucesso
	Dado que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	E crio um usuario
	E salvo o valor do id
	E possuo dados validos para atualizar usuario "<novoNome>" "<job>"
	Quando edito os dados do usuario
	Então verifico status code 200
	E verifico que ha o campo "name"
	E verifico o valor "<novoNome>" no campo "name"
	E verifico que ha o campo "job"
	E verifico o valor "<job>" no campo "job"
	E verifico que ha o campo "updatedAt"
	Exemplos: 
	| username | password | email              | job           | novoNome |
	| Eve Holt | pistol   | eve.holt@reqres.in | zion resident | Morpheus |

Cenário: Validar Atualizar Usuário Apenas Nome Sucesso
	Dado que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	E crio um usuario
	E salvo o valor do id
	E possuo Nome para atualizar usuario "<novoNome>"
	Quando edito os dados do usuario
	Então verifico status code 200
	E verifico que ha o campo "name"
	E verifico o valor "<novoNome>" no campo "name"
	E verifico que ha o campo "updatedAt"
	Exemplos: 
	| username | password | email              | novoNome |
	| Eve Holt | pistol   | eve.holt@reqres.in | Morpheus |

Cenário: Validar Atualizar Usuario Apenas Ocupação Sucesso
	Dado que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	E crio um usuario
	E salvo o valor do id
	E possuo Ocupacao para atualizar usuario "<job>"
	Quando edito os dados do usuario
	Então verifico status code 200
	E verifico que ha o campo "job"
	E verifico o valor "<job>" no campo "job"
	E verifico que ha o campo "updatedAt"
	Exemplos: 
	| username | password | email              | job           |
	| Eve Holt | pistol   | eve.holt@reqres.in | zion resident |

Cenário: Validar Valores de Domínio Campo Nome
	Dado que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	E crio um usuario
	E salvo o valor do id
	E possuo Nome para atualizar usuario "<novoNome>"
	Quando edito os dados do usuario
	Então verifico status code 200
	E verifico que ha o campo "name"
	E verifico o valor "<novoNome>" no campo "name"
	E verifico que ha o campo "updatedAt"
	Exemplos: 
	| username | password | email              | novoNome    |
	| Eve Holt | pistol   | eve.holt@reqres.in | !\@$%&()_=- |

Cenário: Validar Valores de Domínio Campo Ocupação
	Dado que possuo dados validos para cadastro "<username>" "<password>" "<email>"
	E crio um usuario
	E salvo o valor do id
	E possuo Ocupacao para atualizar usuario "<job>"
	Quando edito os dados do usuario
	Então verifico status code 200
	E verifico que ha o campo "job"
	E verifico o valor "<job>" no campo "job"
	E verifico que ha o campo "updatedAt"
	Exemplos: 
	| username | password | email              | job         |
	| Eve Holt | pistol   | eve.holt@reqres.in | !\@$%&()_=- |
