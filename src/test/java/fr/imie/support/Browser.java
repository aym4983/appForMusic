package fr.imie.support;

public enum Browser {
	
	/**
	 * web driver pour chrome
	 */
	Chrome(ChromeDriverFactory.class.getName()),
	Phantom(PhantomJSDriverFactory.class.getName());
	
	private String className;
	
	public String getClassName(){
		return className;
	}
	
	Browser(String classname){
		this.className = classname;
	}
}
