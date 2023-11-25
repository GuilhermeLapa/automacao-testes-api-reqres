package steps;

import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import pages.AtualizarUsuarioPage;

public class AtualizarUsuarioSteps {
	@E("possuo dados validos para atualizar usuario {string} {string}")
	public static void possuoDadosValidosParaAtualizarUsuario(String nome, String ocupacao) {
		AtualizarUsuarioPage.inicializarDadosValidosUsuario(nome, ocupacao);
	}
	
	@Quando("atualizo os dados do usuario")
	public static void atualizoOsDadosDoUsuario() {
		AtualizarUsuarioPage.atualizarUsuario();
	}
	
	@E("possuo Nome para atualizar usuario {string}")
	public static void possuoNomeParaAtualizarUsuario(String nome) {
		AtualizarUsuarioPage.inicializarNomeUsuario(nome);
	}
	
	@E("possuo Ocupacao para atualizar usuario {string}")
	public static void possuoOcupacaoParaAtualizarUsuario(String ocupacao) {
		AtualizarUsuarioPage.inicializarOcupacaoUsuario(ocupacao);
	}
}
