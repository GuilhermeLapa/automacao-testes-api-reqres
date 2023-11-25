package steps;

import io.cucumber.java.pt.Quando;
import pages.EditarUsuarioPage;

public class EditarUsuarioSteps {
	@Quando("edito os dados do usuario")
	public static void atualizoOsDadosDoUsuario() {
		EditarUsuarioPage.editarUsuario();
	}
}
