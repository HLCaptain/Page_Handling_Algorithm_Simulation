import java.util.Scanner;
import java.util.Vector;

public class PageHandlingSimulator {
	private LRU lru;


	public PageHandlingSimulator() {
		lru = new LRU(3);
		Vector<Page> pages = new Vector<>();
		Page page = new Page("A");
		page.setData(0);
		pages.add(page);
		page = new Page("B");
		page.setData(0);
		pages.add(page);
		page = new Page("C");
		page.setData(0);
		pages.add(page);
		lru.setPages(pages);
	}

	/**
	 * Reads in the inputs, returns a string.
	 * @return references of numbers.
	 */
	Vector<Integer> getInput() {
		String line = new Scanner(System.in).nextLine();
		Vector<Integer> pageReferences = new Vector<>();
		for (String str : line.split(",")) {
			pageReferences.add(Integer.parseInt(str));
		}
		return pageReferences;
	}

	/**
	 * Reads in the page reference inputs, then outputs the simulated actions
	 * of the page handling algorithms based on LRU, with max 3 steps of page locks.
	 */
	void start() {
		// Reading in the inputs
		Vector<Integer> pageReferences = new Vector<>(getInput());


	}
}
