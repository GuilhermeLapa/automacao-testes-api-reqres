package steps;

import io.cucumber.java.en.When;
import pages.EncerrarSessaoPage;

public class EncerrarSessaoSteps {
	@When("encerro uma sessao")
	public static void encerroUmaSessao() {
		EncerrarSessaoPage.encerrarSessao();
	}
}
