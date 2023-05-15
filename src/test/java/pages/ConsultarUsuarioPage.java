package pages;

import core.RequestPage;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class ConsultarUsuarioPage extends RequestPage {
	private static Object id;
	
	public static void salvarIdUsuario() {
		ConsultarUsuarioPage.id= Integer.parseInt(ConsultarUsuarioPage.response.getBody().jsonPath().get("id").toString());
	}
	
	public static void consultarUsuarioPorId() {
		ConsultarUsuarioPage.url= "https://reqres.in/api/users/";
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(ConsultarUsuarioPage.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		request.pathParam("id", ConsultarUsuarioPage.id);
		ConsultarUsuarioPage.response= request.get("{id}");
	}
	
	public static void inicializarIdVazio() {
		ConsultarUsuarioPage.id= " ";
	}
	
	public static void inicilizarIdUsuario(String id) {
		ConsultarUsuarioPage.id= id;
	}
	
	public static Object getId() {
		return ConsultarUsuarioPage.id;
	}
}
