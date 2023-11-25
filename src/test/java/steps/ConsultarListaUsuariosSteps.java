package steps;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Quando;
import pages.ConsultarListaUsuariosPage;

public class ConsultarListaUsuariosSteps {
	@Dado("que possuo usuarios cadastrados")
	public static void quePossuoUsuariosCadastrados() {
		
	}
	
	@Quando("consulto a lista de usuarios")
	public static void consultoAListaDeUsuarios() {
		ConsultarListaUsuariosPage.consultarListaUsuarios();
	}
	
	@E("informo a quantidade de usuarios {int}")
	public static void informoAQuantidadeDeUsuarios(Integer qtdUsuarios) {
		ConsultarListaUsuariosPage.inicializarParametroQuery("per_page", qtdUsuarios);
	}
	
	@E("informo a quantidade de paginas {int}")
	public static void informoAQuantidadeDePaginas(Integer qtdPaginas) {
		ConsultarListaUsuariosPage.inicializarParametroQuery("page", qtdPaginas);
	}
	
	@E("verifico no body {string} que ha o campo {string}")
	public static void verificoQueHaOCampo(String jsonPath, String nomeCampo) {
		ConsultarListaUsuariosPage.verificarqueExisteCampo(jsonPath, nomeCampo);
	}
}
