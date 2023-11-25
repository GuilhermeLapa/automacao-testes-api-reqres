package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import pages.CriarSessaoPage;

public class CriarSessaoSteps {
	@Dado("que nao possuo username {string} {string}")
	public static void queNaoPossuoUsername(String email, String password) {
		CriarSessaoPage.inicializarBodyRequestSemUsername(email, password);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Dado("que nao possuo email {string} {string}")
	public static void queNaoPossuoEmail(String username, String password) {
		CriarSessaoPage.inicializarBodyRequestSemEmail(username, password);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Dado("que nao possuo password {string} {string}")
	public static void queNaoPossuoPassword(String username, String email) {
		CriarSessaoPage.inicializarBodyRequestSemPassword(username, email);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Dado("que possuo email invalido {string} {string} {string}")
	public static void quePossuoEmailInvalido(String username, String password, String email) {
		CriarSessaoPage.inicializarBodyRequestTodosDados(username, password, email);
		CriarSessaoPage.setJsonPath("error");
	}
	
	@Dado("que possuo dados validos para login {string} {string}")
	public static void quePossuoDadosValidosParaLogin(String password, String email) {
		CriarSessaoPage.inicializarBodyRequestTodosDadosLogin(password, email);
	}
	
	@Quando("crio uma sessao")
	public static void crioUmaSessao() {
		CriarSessaoPage.criarSessao();
	}
	
	@Entao("verifico status code {int}")
	public static void verificoStatusCode(int statusCodeEsperado) {
		CriarSessaoPage.verificarStatusCode(statusCodeEsperado);
	}
	
	@E("verifico a mensagem {string}")
	public static void verificoAMensagem(String mensagemEsperada) {
		CriarSessaoPage.inicializarMensagemEsperada(mensagemEsperada);
		CriarSessaoPage.verificarMensagem();
	}
	
	@E("verifico que ha o campo {string}")
	public static void verificoQueHaOCampo(String nomeCampo) {
		CriarSessaoPage.verificarqueExisteCampo(nomeCampo);
	}
	
	@E("salvo o token da sessao")
	public static void salvoOTokenDaSessao() {
		CriarSessaoPage.salvarToken();
	}
}
