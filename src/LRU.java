import java.util.HashMap;
import java.util.Vector;

/**
 * Least Recently Used page gets unloaded.
 */
public class LRU {
	private final int pageLock;
	private Vector<Page> pages;
	private HashMap<Page, Integer> pageLocks;

	public LRU(int pageLock) {
		this.pageLock = pageLock;
	}

	public void setPages(Vector<Page> pages) {
		this.pages = pages;
	}
}
