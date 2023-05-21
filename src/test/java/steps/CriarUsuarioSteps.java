package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.CriarSessaoPage;
import pages.CriarUsuarioPage;

public class CriarUsuarioSteps {
	@When("crio um usuario")
	public static void crioUmUsuario() {
		CriarUsuarioPage.criarUsuario();
	}
	
	@Given("que possuo dados de usuario nao registrado {string} {string} {string}")
	public static void quePossuoDadosDeUsuarioNaoRegistrado(String username, String password, String email) {
		CriarSessaoPage.inicializarBodyRequestTodosDados(username, password, email);
		CriarUsuarioPage.setJsonPath("error");
	}
	
	@Given("que possuo dados validos para cadastro {string} {string} {string}")
	public static void quePossuoDadosValidosParaCadastro(String username, String password, String email) {
		CriarUsuarioPage.inicializarBodyRequestTodosDadosCadastro(username, password, email);
	}
	
	@And("verifico o valor {string} no campo {string}")
	public static void verificoOValorDoCampo(String valorEsperado, String nomeCampo) {
		CriarUsuarioPage.verificarValorCampoString(valorEsperado, nomeCampo);
	}
	
	@And("verifico o valor {int} no campo {string}")
	public static void verificoOValorDoCampo(int valorEsperado, String nomeCampo) {
		CriarUsuarioPage.verificarValorCampoInteiro(valorEsperado, nomeCampo);
	}	
}
