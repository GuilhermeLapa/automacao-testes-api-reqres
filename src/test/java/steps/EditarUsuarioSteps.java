package steps;

import cucumber.api.java.en.When;
import pages.EditarUsuarioPage;

public class EditarUsuarioSteps {
	@When("edito os dados do usuario")
	public static void atualizoOsDadosDoUsuario() {
		EditarUsuarioPage.editarUsuario();
	}
}
