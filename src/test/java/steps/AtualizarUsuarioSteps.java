package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import pages.AtualizarUsuarioPage;

public class AtualizarUsuarioSteps {
	@And("possuo dados validos para atualizar usuario \"(.*?)\" \"(.*?)\"")
	public static void possuoDadosValidosParaAtualizarUsuario(String nome, String ocupacao) {
		AtualizarUsuarioPage.inicializarDadosValidosUsuario(nome, ocupacao);
	}
	
	@When("atualizo os dados do usuario")
	public static void atualizoOsDadosDoUsuario() {
		AtualizarUsuarioPage.atualizarUsuario();
	}
	
	@And("possuo o id do usuario")
	public static void possuoOIdDoUsuario() {
		AtualizarUsuarioPage.inicializarIdRetornoConsulta();
	}
	
	@And("possuo Nome para atualizar usuario \"(.*?)\"")
	public static void possuoNomeParaAtualizarUsuario(String nome) {
		AtualizarUsuarioPage.inicializarNomeUsuario(nome);
	}
	
	@And("possuo Ocupacao para atualizar usuario \"(.*?)\"")
	public static void possuoOcupacaoParaAtualizarUsuario(String ocupacao) {
		AtualizarUsuarioPage.inicializarOcupacaoUsuario(ocupacao);
	}
}
