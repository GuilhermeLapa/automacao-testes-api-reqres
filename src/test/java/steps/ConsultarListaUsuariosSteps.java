package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pages.ConsultarListaUsuariosPage;

public class ConsultarListaUsuariosSteps {
	@Given("que possuo usuarios cadastrados")
	public static void quePossuoUsuariosCadastrados() {
		
	}
	
	@When("consulto a lista de usuarios")
	public static void consultoAListaDeUsuarios() {
		ConsultarListaUsuariosPage.consultarListaUsuarios();
	}
	
	@And("informo a quantidade de usuarios {int}")
	public static void informoAQuantidadeDeUsuarios(Integer qtdUsuarios) {
		ConsultarListaUsuariosPage.inicializarParametroQuery("per_page", qtdUsuarios);
	}
	
	@And("informo a quantidade de paginas {int}")
	public static void informoAQuantidadeDePaginas(Integer qtdPaginas) {
		ConsultarListaUsuariosPage.inicializarParametroQuery("page", qtdPaginas);
	}
	
	@And("verifico no body {string} que ha o campo {string}")
	public static void verificoQueHaOCampo(String jsonPath, String nomeCampo) {
		ConsultarListaUsuariosPage.verificarqueExisteCampo(jsonPath, nomeCampo);
	}
}
