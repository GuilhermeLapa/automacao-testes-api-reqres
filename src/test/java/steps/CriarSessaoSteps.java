package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CriarSessaoPage;

public class CriarSessaoSteps {
	@Given("que nao possuo username {string} {string}")
	public static void queNaoPossuoUsername(String email, String password) {
		CriarSessaoPage.inicializarBodyRequestSemUsername(email, password);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Given("que nao possuo email {string} {string}")
	public static void queNaoPossuoEmail(String username, String password) {
		CriarSessaoPage.inicializarBodyRequestSemEmail(username, password);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Given("que nao possuo password {string} {string}")
	public static void queNaoPossuoPassword(String username, String email) {
		CriarSessaoPage.inicializarBodyRequestSemPassword(username, email);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Given("que possuo email invalido {string} {string} {string}")
	public static void quePossuoEmailInvalido(String username, String password, String email) {
		CriarSessaoPage.inicializarBodyRequestTodosDados(username, password, email);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Given("que possuo dados validos para login {string} {string}")
	public static void quePossuoDadosValidosParaLogin(String password, String email) {
		CriarSessaoPage.inicializarBodyRequestTodosDadosLogin(password, email);
	}
	
	@When("crio uma sessao")
	public static void crioUmaSessao() {
		CriarSessaoPage.criarSessao();
	}
	
	@Then("verifico status code {int}")
	public static void verificoStatusCode(int statusCodeEsperado) {
		CriarSessaoPage.verificarStatusCode(statusCodeEsperado);
	}
	
	@And("verifico a mensagem {string}")
	public static void verificoAMensagem(String mensagemEsperada) {
		CriarSessaoPage.inicializarMensagemEsperada(mensagemEsperada);
		CriarSessaoPage.verificarMensagem();
	}
	
	@And("verifico que ha o campo {string}")
	public static void verificoQueHaOCampo(String nomeCampo) {
		CriarSessaoPage.verificarqueExisteCampo(nomeCampo);
	}
	
	@And("salvo o token da sessao")
	public static void salvoOTokenDaSessao() {
		CriarSessaoPage.salvarToken();
	}
}
