package fr.imie.appformusic.itests.pages;

import static org.assertj.core.api.Assertions.*;

import org.fluentlenium.core.FluentPage;
import org.fluentlenium.core.annotation.PageUrl;
import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

@PageUrl("http://localhost:8080/appForMusic/sign-in")
public class SignInPage extends FluentPage {

	@Override
	public void isAt() {
		FluentList<FluentWebElement> title = find("#title-sign-in");
		assertThat(title.get(0).getTextContent()).isEqualTo("Connexion");
	}

	
}
