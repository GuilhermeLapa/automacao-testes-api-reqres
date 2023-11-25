package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import pages.ConsultarUsuarioPage;

public class ConsultarUsuarioSteps {
	@E("salvo o valor do id")
	public static void salvoOValorDoId() {
		ConsultarUsuarioPage.salvarIdUsuario();
	}
	
	@Quando("consulto o usuario pelo seu id")
	public static void consultoOUsuarioPeloSeuId() {
		ConsultarUsuarioPage.consultarUsuarioPorId();
	}
	
	@Dado("que nao possuo id do usuario")
	public static void queNaoPossuoIdDoUsuario() {
		ConsultarUsuarioPage.inicializarIdVazio();
	}
	
	@E("que possuo valor invalido de id de usuario {string}")
	public static void quePossuoValorInvalidoDeIdDeUsuario(String valorId) {
		ConsultarUsuarioPage.inicializarId(valorId);
	}
}
