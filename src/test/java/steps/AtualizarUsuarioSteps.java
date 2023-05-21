package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pages.AtualizarUsuarioPage;

public class AtualizarUsuarioSteps {
	@And("possuo dados validos para atualizar usuario {string} {string}")
	public static void possuoDadosValidosParaAtualizarUsuario(String nome, String ocupacao) {
		AtualizarUsuarioPage.inicializarDadosValidosUsuario(nome, ocupacao);
	}
	
	@When("atualizo os dados do usuario")
	public static void atualizoOsDadosDoUsuario() {
		AtualizarUsuarioPage.atualizarUsuario();
	}
	
	@And("possuo Nome para atualizar usuario {string}")
	public static void possuoNomeParaAtualizarUsuario(String nome) {
		AtualizarUsuarioPage.inicializarNomeUsuario(nome);
	}
	
	@And("possuo Ocupacao para atualizar usuario {string}")
	public static void possuoOcupacaoParaAtualizarUsuario(String ocupacao) {
		AtualizarUsuarioPage.inicializarOcupacaoUsuario(ocupacao);
	}
}
