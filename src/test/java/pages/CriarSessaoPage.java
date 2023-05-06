package pages;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.junit.Assert;
import core.RequestPage;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class CriarSessaoPage extends RequestPage {
	public static void inicializarBodyRequestSemUsername(String email, String password) {
		CriarSessaoPage.bodyRequest= null;
		CriarSessaoPage.bodyRequest= new JSONObject();
		CriarSessaoPage.bodyRequest.put("email", email);
		CriarSessaoPage.bodyRequest.put("password", password);
	}
	
	public static void inicializarBodyRequestSemEmail(String username, String password) {
		CriarSessaoPage.bodyRequest= null;
		CriarSessaoPage.bodyRequest= new JSONObject();
		CriarSessaoPage.bodyRequest.put("username", username);
		CriarSessaoPage.bodyRequest.put("password", password);
	}
	
	public static void inicializarBodyRequestSemPassword(String username, String email) {
		CriarSessaoPage.bodyRequest= null;
		CriarSessaoPage.bodyRequest= new JSONObject();
		CriarSessaoPage.bodyRequest.put("username", username);
		CriarSessaoPage.bodyRequest.put("email", email);
	}
	
	public static void inicializarBodyRequestTodosDados(String username, String password, String email) {
		CriarSessaoPage.bodyRequest= null;
		CriarSessaoPage.bodyRequest= new JSONObject();
		CriarSessaoPage.bodyRequest.put("username", username);
		CriarSessaoPage.bodyRequest.put("password", password);
		CriarSessaoPage.bodyRequest.put("email", email);
	}
	
	public static void inicializarBodyRequestTodosDadosLogin(String password, String email) {
		CriarSessaoPage.bodyRequest= null;
		CriarSessaoPage.bodyRequest= new JSONObject();
		CriarSessaoPage.bodyRequest.put("password", password);
		CriarSessaoPage.bodyRequest.put("email", email);
	}
	
	public static void criarSessao() {
		CriarSessaoPage.url= "https://reqres.in/api/login";
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(CriarSessaoPage.url);
		Header header= new Header("Content-Type", "application/json");
		request.header(header);
		request.body(CriarSessaoPage.bodyRequest.toJSONString());
		CriarSessaoPage.response=  request.post();
	}
	
	public static void verificarStatusCode(int statusCodeEsperado) {
		Assert.assertTrue(statusCodeEsperado == CriarSessaoPage.response.getStatusCode());
	}
	
	public static void verificarMensagem() {
		String mensagemResponse= CriarSessaoPage.response.getBody().jsonPath().get(CriarSessaoPage.jsonPath);
		boolean igual= false;
		
		for(String mensagem: CriarSessaoPage.mensagensEsperadas) {
			if(mensagemResponse.equals(mensagem)) {
				igual= true;
				break;
			}
		}
		
		Assert.assertTrue(igual);
	}
	
	public static void inicializarMensagemEsperada(String mensagemEsperada) {
		CriarSessaoPage.mensagensEsperadas= new ArrayList<String>();
		CriarSessaoPage.mensagensEsperadas.add(mensagemEsperada);
	}
	
	public static void verificarqueExisteCampo(String nomeCampo) {
		Assert.assertTrue(CriarSessaoPage.response.getBody().asPrettyString().toString().contains(nomeCampo));
	}
	
	public static void salvarToken() {
		CriarSessaoPage.tokenSessao= CriarSessaoPage.response.getBody().jsonPath().get("token").toString();
	}
}
