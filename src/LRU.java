import java.util.Comparator;
import java.util.HashMap;
import java.util.Vector;
import java.util.function.Consumer;

/**
 * Least Recently Used page gets unloaded.
 */
public class LRU {
	private final int pageLock;
	private Vector<Page> pages;
	private HashMap<Page, Integer> pageLocks;
	private HashMap<Page, Integer> lastUsed;

	/**
	 * Initializing with empty arrays.
	 * Don't forget to set them all!
	 *
	 * @param pageLock set the lock to this value
	 *                 if new data loaded onto page.
	 */
	public LRU(int pageLock) {
		this.pageLock = pageLock;
		this.pages = new Vector<>();
		this.pageLocks = new HashMap<>();
		this.lastUsed = new HashMap<>();
	}

	/**
	 * Setting the pages that the algorithm handles.
	 *
	 * @param pages pages the algorithm handles.
	 */
	public void setPages(Vector<Page> pages) {
		this.pages = pages;
		pageLocks.clear();
		for (Page page : pages) {
			pageLocks.put(page, 0);
			lastUsed.put(page, 0);
		}
	}

	/**
	 * Calls an input and handles the page loading.
	 *
	 * @param input check if any pages reference this input.
	 * @return the action the LRU algorithm did. <br>
	 * "*" - did nothing, because it could do nothing. <br>
	 * "-" - successfully found the input. <br>
	 * "A" - loaded input onto A (could as well be B or C).
	 */
	public String pageCall(int input) {
		// Find page containing the data.
		for (Page page : pages) {
			if (pageLocks.get(page) == 0 && page.getData() == input) {
				useAndUpdate(page);
				// If input is negative, then we write the page and it becomes dirty.
				if (input < 0) {
					page.setDirty(true);
				}
				return "-";
			}
		}

		// Collect unlocked pages and use the last to load in data to.
		Vector<Page> unLockedPages = new Vector<>();
		for (Page page : pages) {
			if (pageLocks.get(page) == 0) {
				unLockedPages.add(page);
			}
		}
		// Sort by last used. (Ascending, last used is last.)
		unLockedPages.sort(Comparator.comparingInt((Page o) -> lastUsed.get(o)));
		// If found some available pages, write out the last used.
		if (unLockedPages.size() > 0) {
			// Load the data onto the last used page.
			unLockedPages.lastElement().setData(Math.abs(input));
			// We used the page.
			useAndUpdate(unLockedPages.lastElement());
			// Lock the new page on which the data was loaded
			pageLocks.replace(unLockedPages.lastElement(), pageLock);
			return unLockedPages.lastElement().getId();
		}

		// All pages are locked.
		return "*";
	}

	/**
	 * Resets the usage of a page and increments the time
	 * since last use for the others.
	 * @param page if not null, resets the page's time from last usage.
	 */
	public void useAndUpdate(Page page) {
		for (Page p : pages) {
			lastUsed.replace(p, (lastUsed.get(p) + 1));
		}
		if (page != null) {
			lastUsed.replace(page, 0);
		}
	}
}
