package pages;

import java.util.HashMap;
import org.junit.Assert;
import core.RequestPage;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class ConsultarListaUsuariosPage extends RequestPage {
	public static void consultarListaUsuarios() {
		ConsultarListaUsuariosPage.url= "https://reqres.in/api/users";
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(ConsultarListaUsuariosPage.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		
		if((ConsultarListaUsuariosPage.parametrosQuery != null) && (!ConsultarListaUsuariosPage.parametrosQuery.isEmpty())) {
			request.queryParam("page", ConsultarListaUsuariosPage.parametrosQuery.get("page"));
			request.queryParam("per_page", ConsultarListaUsuariosPage.parametrosQuery.get("per_page"));
		}
		
		ConsultarListaUsuariosPage.response= request.get();
	}
	
	public static void inicializarParametroQuery(String jsonPath, Object valor) {
		if(ConsultarListaUsuariosPage.parametrosQuery == null) {
			ConsultarListaUsuariosPage.parametrosQuery= new HashMap<String, Object>();
		}
		
		ConsultarListaUsuariosPage.parametrosQuery.put(jsonPath, valor);
	}
	
	public static void inicializarQtdPaginasConsulta(int qtdPaginas) {
		ConsultarListaUsuariosPage.parametrosQuery.put("page", qtdPaginas);
	}
	
	public static void verificarqueExisteCampo(String jsonPath, String nomeCampo) {
		Assert.assertTrue(CriarSessaoPage.response.getBody().jsonPath().get(jsonPath).toString().contains(nomeCampo));
	}
}
