package pages;

import core.RequestPage;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class DeletarUsuarioPage extends RequestPage {
	public static void deletarUsuario() {
		DeletarUsuarioPage.url= "https://reqres.in/api/users/";
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(DeletarUsuarioPage.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		request.pathParam("id", DeletarUsuarioPage.valorPassadoNoPath);
		DeletarUsuarioPage.response= request.delete("{id}");
	}
}
