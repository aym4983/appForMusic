package fr.imie.appformusic.itests.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

public class SignInPage extends HomePage {

	@Override
	public void isAt() {
		FluentList<FluentWebElement> title = find("#title-sign-in");
		assertThat(title.get(0).getTextContent()).isEqualTo("Connexion");
	}

	
}
