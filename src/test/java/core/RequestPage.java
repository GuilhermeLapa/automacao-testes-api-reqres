package core;

import java.util.ArrayList;
import java.util.HashMap;
import org.json.simple.JSONObject;
import io.restassured.response.Response;

public class RequestPage {
	protected static String url;
	protected static Response response;
	protected static JSONObject bodyRequest;
	protected static JSONObject bodyResponse;
	protected static ArrayList<String> mensagensEsperadas;
	protected static String jsonPath;
	protected static String tokenSessao;
	protected static HashMap<String, Object> parametrosQuery;
	
	public static void setJsonPath(String jsonPath) {
		RequestPage.jsonPath= jsonPath;
	}
}
