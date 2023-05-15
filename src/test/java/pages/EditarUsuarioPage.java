package pages;

import core.RequestPage;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class EditarUsuarioPage extends RequestPage {
	public static void editarUsuario() {
		EditarUsuarioPage.url= "https://reqres.in/api/users/";
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(EditarUsuarioPage.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		request.body(EditarUsuarioPage.bodyRequest.toJSONString());
		
		request.pathParam("id", AtualizarUsuarioPage.valorPassadoNoPath);
		EditarUsuarioPage.response= request.patch("{id}");
	}
}
