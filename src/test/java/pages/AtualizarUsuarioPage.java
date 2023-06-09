package pages;

import org.json.simple.JSONObject;
import core.RequestPage;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class AtualizarUsuarioPage extends RequestPage {
	public static void inicializarDadosValidosUsuario(String nome, String ocupacao) {
		AtualizarUsuarioPage.bodyRequest= null;
		AtualizarUsuarioPage.bodyRequest= new JSONObject();
		
		AtualizarUsuarioPage.bodyRequest.put("name", nome);
		AtualizarUsuarioPage.bodyRequest.put("job", ocupacao);
	}
	
	public static void atualizarUsuario() {
		AtualizarUsuarioPage.url= "https://reqres.in/api/users/";
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(AtualizarUsuarioPage.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		request.body(AtualizarUsuarioPage.bodyRequest.toJSONString());
		
		request.pathParam("id", AtualizarUsuarioPage.valorPassadoNoPath);
		AtualizarUsuarioPage.response= request.put("{id}");
	}
	
	public static void inicializarNomeUsuario(String nome) {
		AtualizarUsuarioPage.bodyRequest= null;
		AtualizarUsuarioPage.bodyRequest= new JSONObject();
		
		AtualizarUsuarioPage.bodyRequest.put("name", nome);
	}
	
	public static void inicializarOcupacaoUsuario(String ocupacao) {
		AtualizarUsuarioPage.bodyRequest= null;
		AtualizarUsuarioPage.bodyRequest= new JSONObject();
		
		AtualizarUsuarioPage.bodyRequest.put("job", ocupacao);
	}
}
