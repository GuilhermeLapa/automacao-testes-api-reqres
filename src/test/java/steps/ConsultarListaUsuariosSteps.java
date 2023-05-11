package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pages.ConsultarListaUsuariosPage;

public class ConsultarListaUsuariosSteps {
	@Given("que possuo usuarios cadastrados")
	public static void quePossuoUsuariosCadastrados() {
		
	}
	
	@When("consulto a lista de usuarios")
	public static void consultoAListaDeUsuarios() {
		ConsultarListaUsuariosPage.consultarListaUsuarios();
	}
	
	@And("^informo a quantidade de usuarios (\\d+)$")
	public static void informoAQuantidadeDeUsuarios(Integer qtdUsuarios) {
		ConsultarListaUsuariosPage.inicializarParametroQuery("per_page", qtdUsuarios);
	}
	
	@And("^informo a quantidade de paginas (\\d+)$")
	public static void informoAQuantidadeDePaginas(Integer qtdPaginas) {
		ConsultarListaUsuariosPage.inicializarParametroQuery("page", qtdPaginas);
	}
	
	@And("^verifico no body \"(.*?)\" que ha o campo \"(.*?)\"$")
	public static void verificoQueHaOCampo(String jsonPath, String nomeCampo) {
		ConsultarListaUsuariosPage.verificarqueExisteCampo(jsonPath, nomeCampo);
	}
}
