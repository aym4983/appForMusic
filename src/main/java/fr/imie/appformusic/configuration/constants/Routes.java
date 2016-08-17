package fr.imie.appformusic.configuration.constants;

/**
 * Interface répertoriant les URL de l'applications.
 * @author Dorian
 *
 */
public interface Routes {
	
	/** URL d'accueil du site. */
	public String HOME = "/";
	/** URL de connexion. */
	public String SIGNIN = "/sign-in";

	/** URL d'inscription. */
	public String SIGNUP = "/sign-up";

	/** URL de désinscription. */
	public String SIGNOUT = "/sign-out";
	
	/** URL de recherche */
	public String SEARCH = "/search";
	
	/** Page de recherche */
	public String SEARCH_ALL = "/search/all";
	
	/** URL du calendrier. */
	public String CALENDAR = "/calendar";

	/** Page d'erreur **/
	public String ERROR = "/error";


}
