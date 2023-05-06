package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.CriarSessaoPage;
import pages.CriarUsuarioPage;

public class CriarUsuarioSteps {
	@When("^crio um usuario$")
	public static void crioUmUsuario() {
		CriarUsuarioPage.criarUsuario();
	}
	
	@Given("^que possuo dados de usuario nao registrado \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public static void quePossuoDadosDeUsuarioNaoRegistrado(String username, String password, String email) {
		CriarSessaoPage.inicializarBodyRequestTodosDados(username, password, email);
		CriarUsuarioPage.setJsonPath("error");
	}
	
	@Given("^que possuo dados validos para cadastro \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public static void quePossuoDadosValidosParaCadastro(String username, String password, String email) {
		CriarUsuarioPage.inicializarBodyRequestTodosDadosCadastro(username, password, email);
	}
	
	@And("^verifico o valor \"(.*?)\" no campo \"(.*?)\"$")
	public static void verificoOValorDoCampo(String valorEsperado, String nomeCampo) {
		CriarUsuarioPage.verificarValorCampoString(valorEsperado, nomeCampo);
	}
	
	@And("^verifico o valor (\\d+) no campo \"(.*?)\"$")
	public static void verificoOValorDoCampo(int valorEsperado, String nomeCampo) {
		CriarUsuarioPage.verificarValorCampoInteiro(valorEsperado, nomeCampo);
	}	
}
