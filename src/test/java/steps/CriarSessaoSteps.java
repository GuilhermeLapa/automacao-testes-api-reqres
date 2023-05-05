package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.CriarSessaoPage;

public class CriarSessaoSteps {
	@Given("^que nao possuo username \"(.*?)\" \"(.*?)\"$")
	public static void queNaoPossuoUsername(String email, String password) {
		CriarSessaoPage.inicializarBodyRequestSemUsername(email, password);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Given("^que nao possuo email \"(.*?)\" \"(.*?)\"$")
	public static void queNaoPossuoEmail(String username, String password) {
		CriarSessaoPage.inicializarBodyRequestSemEmail(username, password);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Given("^que nao possuo password \"(.*?)\" \"(.*?)\"$")
	public static void queNaoPossuoPassword(String username, String email) {
		CriarSessaoPage.inicializarBodyRequestSemPassword(username, email);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Given("^que possuo email invalido \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public static void quePossuoEmailInvalido(String username, String password, String email) {
		CriarSessaoPage.inicializarBodyRequestTodosDados(username, password, email);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Given("^que possuo dados para login \"(.*?)\" \"(.*?)\" \"(.*?)\"$")
	public static void quePossuoDadosParaLogin(String username, String password, String email) {
		CriarSessaoPage.inicializarBodyRequestTodosDados(username, password, email);
	}
	
	@When("^crio uma sessao$")
	public static void crioUmaSessao() {
		CriarSessaoPage.criarSessao();
	}
	
	@Then("^verifico status code (\\d+)$")
	public static void verificoStatusCode(int statusCodeEsperado) {
		CriarSessaoPage.verificarStatusCode(statusCodeEsperado);
	}
	
	@And("^verifico a mensagem \"(.*?)\"$")
	public static void verificoAMensagem(String mensagemEsperada) {
		CriarSessaoPage.inicializarMensagemEsperada(mensagemEsperada);
		CriarSessaoPage.verificarMensagem();
	}
	
	@And("^verifico que ha o campo \"(.*?)\"$")
	public static void verificoQueHaOCampo(String nomeCampo) {
		CriarSessaoPage.verificarqueExisteCampo(nomeCampo);
	}
	
	@And("^salvo o token da sessao$")
	public static void salvoOTokenDaSessao() {
		CriarSessaoPage.salvarToken();
	}
}
