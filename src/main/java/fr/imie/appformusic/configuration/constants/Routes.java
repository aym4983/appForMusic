package fr.imie.appformusic.configuration.constants;

/**
 * Interface répertoriant les URL de l'applications.
 * @author Dorian
 *
 */
public interface Routes {
	
	/** Racine des resultats json */
	public String API = "/api";
	
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
	
	/** Page de gestion des lieux. */
	public String PLACE = "/places";

	/** Page d'erreur **/
	public String ERROR = "/error";
	
	/** Page de profil */
	public String PROFILE = "/profile";


}
