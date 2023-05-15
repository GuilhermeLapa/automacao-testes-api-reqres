package pages;

import core.RequestPage;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class ConsultarUsuarioPage extends RequestPage {
	public static void salvarIdUsuario() {
		ConsultarUsuarioPage.valorPassadoNoPath= Integer.parseInt(ConsultarUsuarioPage.response.getBody().jsonPath().get("id").toString());
	}
	
	public static void consultarUsuarioPorId() {
		ConsultarUsuarioPage.url= "https://reqres.in/api/users/";
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(ConsultarUsuarioPage.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		request.pathParam("id", ConsultarUsuarioPage.valorPassadoNoPath);
		ConsultarUsuarioPage.response= request.get("{id}");
	}
	
	public static void inicializarIdVazio() {
		ConsultarUsuarioPage.valorPassadoNoPath= " ";
	}
	
	public static void inicializarId(Object valor) {
		if(valor instanceof Integer) {
			AtualizarUsuarioPage.valorPassadoNoPath= (Integer) valor;
		}
		else if(valor instanceof String) {
				AtualizarUsuarioPage.valorPassadoNoPath= (String) valor;
			}
	}
}
