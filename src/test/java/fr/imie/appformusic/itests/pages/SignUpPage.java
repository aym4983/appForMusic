package fr.imie.appformusic.itests.pages;

import static org.assertj.core.api.Assertions.assertThat;

import org.fluentlenium.core.domain.FluentList;
import org.fluentlenium.core.domain.FluentWebElement;

public class SignUpPage extends HomePage {

	public void isAt(){
		FluentList<FluentWebElement> title = find("#title-sign-up");
		assertThat(title.get(0).getTextContent()).isEqualTo("Inscription");
	}
	
	public void setUsername(String username){
		fill("#signup-username").with(username);
	}
	
	public void setEmail(String email){
		fill("#signup-email").with(email);
	}
	
	public void setPassword(String pwd){
		fill("#signup-password").with(pwd);
	}
	
	public void setPasswordConfirm(String pwd){
		fill("#signup-password-confirm").with(pwd);
	}
	
	public void submitForm(){
		find("#submit").click();
	}
	
}
