package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import pages.CriarSessaoPage;
import pages.CriarUsuarioPage;

public class CriarUsuarioSteps {
	@Quando("crio um usuario")
	public static void crioUmUsuario() {
		CriarUsuarioPage.criarUsuario();
	}
	
	@Dado("que possuo dados de usuario nao registrado {string} {string} {string}")
	public static void quePossuoDadosDeUsuarioNaoRegistrado(String username, String password, String email) {
		CriarSessaoPage.inicializarBodyRequestTodosDados(username, password, email);
		CriarUsuarioPage.setJsonPath("error");
	}
	
	@Dado("que possuo dados validos para cadastro {string} {string} {string}")
	public static void quePossuoDadosValidosParaCadastro(String username, String password, String email) {
		CriarUsuarioPage.inicializarBodyRequestTodosDadosCadastro(username, password, email);
	}
	
	@E("verifico o valor {string} no campo {string}")
	public static void verificoOValorDoCampo(String valorEsperado, String nomeCampo) {
		CriarUsuarioPage.verificarValorCampoString(valorEsperado, nomeCampo);
	}
	
	@E("verifico o valor {int} no campo {string}")
	public static void verificoOValorDoCampo(int valorEsperado, String nomeCampo) {
		CriarUsuarioPage.verificarValorCampoInteiro(valorEsperado, nomeCampo);
	}	
}
