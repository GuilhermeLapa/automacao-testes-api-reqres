package steps;

import io.cucumber.java.pt.Quando;
import pages.EncerrarSessaoPage;

public class EncerrarSessaoSteps {
	@Quando("encerro uma sessao")
	public static void encerroUmaSessao() {
		EncerrarSessaoPage.encerrarSessao();
	}
}
