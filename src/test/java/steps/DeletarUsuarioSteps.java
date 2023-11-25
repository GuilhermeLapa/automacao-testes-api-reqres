package steps;

import io.cucumber.java.pt.Quando;
import pages.DeletarUsuarioPage;

public class DeletarUsuarioSteps {
	@Quando("deleto o usuario")
	public static void deletoOUsuario() {
		DeletarUsuarioPage.deletarUsuario();
	}
}
