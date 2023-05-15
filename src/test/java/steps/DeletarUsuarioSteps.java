package steps;

import cucumber.api.java.en.When;
import pages.DeletarUsuarioPage;

public class DeletarUsuarioSteps {
	@When("deleto o usuario")
	public static void deletoOUsuario() {
		DeletarUsuarioPage.deletarUsuario();
	}
}
