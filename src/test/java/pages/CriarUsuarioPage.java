package pages;

import org.json.simple.JSONObject;
import org.junit.Assert;
import core.RequestPage;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class CriarUsuarioPage extends RequestPage {
	public static void criarUsuario() {
		CriarUsuarioPage.url= "https://reqres.in/api/register";
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(CriarUsuarioPage.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		request.body(CriarUsuarioPage.bodyRequest.toJSONString());
		CriarUsuarioPage.response= request.post();
	}
	
	public static void inicializarBodyRequestTodosDadosCadastro(String username, String password, String email) {
		CriarSessaoPage.bodyRequest= null;
		CriarSessaoPage.bodyRequest= new JSONObject();
		CriarSessaoPage.bodyRequest.put("password", password);
		CriarSessaoPage.bodyRequest.put("email", email);
	}
	
	public static void verificarValorCampoString(String valorEsperado, String nomeCampo) {
		String valorResponse= CriarUsuarioPage.response.getBody().jsonPath().getString(nomeCampo);
		Assert.assertEquals(valorEsperado, valorResponse);
	}
	
	public static void verificarValorCampoInteiro(int valorEsperado, String nomeCampo) {
		int valorResponse= CriarUsuarioPage.response.getBody().jsonPath().getInt(nomeCampo);
		Assert.assertTrue(valorEsperado == valorResponse);
	}
}
