package pages;

import core.RequestPage;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.specification.RequestSpecification;

public class EncerrarSessaoPage extends RequestPage {
	public static void encerrarSessao() {
		EncerrarSessaoPage.url= "https://reqres.in/api/logout";
		
		RequestSpecification request= RestAssured.given();
		request.baseUri(EncerrarSessaoPage.url);
		Header header= new Header("Content-Type", "application/jon");
		request.header(header);
		EncerrarSessaoPage.response= request.post();
		
		System.out.println(EncerrarSessaoPage.response.getBody().asPrettyString());
	}
}
