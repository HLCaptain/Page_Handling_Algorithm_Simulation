import java.util.Scanner;
import java.util.Vector;

public class PageHandlingSimulator {
	private final LRU lru;
	private int pageFault;

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
		this.pageFault = 0;
	}

	/**
	 * Reads in the inputs, returns a string.
	 * @return references of numbers.
	 */
	public Vector<Integer> getInput() {
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
	public void start() {
		// Reading the inputs
		Vector<Integer> pageReferences = new Vector<>(getInput());

		computeInputs(pageReferences);
	}

	public void computeInputs(Vector<Integer> inputs) {
		StringBuilder output = new StringBuilder();
		for (Integer input : inputs) {
			String nextStep = lru.pageCall(input);
			// If not able to read in data, it failed.
			if (!nextStep.equals("-")) {
				pageFault++;
			}
			output.append(nextStep);
		}
		System.out.println(output);
	}
}
