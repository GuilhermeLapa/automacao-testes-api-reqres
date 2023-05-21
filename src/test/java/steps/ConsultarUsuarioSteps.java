package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.ConsultarUsuarioPage;

public class ConsultarUsuarioSteps {
	@And("salvo o valor do id")
	public static void salvoOValorDoId() {
		ConsultarUsuarioPage.salvarIdUsuario();
	}
	
	@When("consulto o usuario pelo seu id")
	public static void consultoOUsuarioPeloSeuId() {
		ConsultarUsuarioPage.consultarUsuarioPorId();
	}
	
	@Given("que nao possuo id do usuario")
	public static void queNaoPossuoIdDoUsuario() {
		ConsultarUsuarioPage.inicializarIdVazio();
	}
	
	@And("que possuo valor invalido de id de usuario {string}")
	public static void quePossuoValorInvalidoDeIdDeUsuario(String valorId) {
		ConsultarUsuarioPage.inicializarId(valorId);
	}
}
