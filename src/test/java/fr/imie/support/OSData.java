package fr.imie.support;

/**
 * Détection de l'OS
 * @author Loïc
 *
 */

public class OSData {

	private boolean windows;
	private boolean mac;
	private boolean linux;
	private boolean arch64bits;
	
	public OSData(){
		windows = System.getProperty("os.name").startsWith("Windows");
		mac = System.getProperty("os.name").startsWith("Mac OS X");
		linux = System.getProperty("os.name").startsWith("Linux");
		arch64bits = System.getProperty("os.arch").contains("64");
	}

	public boolean isWindows() {
		return windows;
	}

	public void setWindows(boolean windows) {
		this.windows = windows;
	}

	public boolean isMac() {
		return mac;
	}

	public void setMac(boolean mac) {
		this.mac = mac;
	}

	public boolean isLinux() {
		return linux;
	}

	public void setLinux(boolean linux) {
		this.linux = linux;
	}

	public boolean isArch64bits() {
		return arch64bits;
	}

	public void setArch64bits(boolean arch64bits) {
		this.arch64bits = arch64bits;
	}
	
}
