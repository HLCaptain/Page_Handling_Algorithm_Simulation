import java.util.Scanner;
import java.util.Vector;

public class PageHandlingSimulator {
	private final LRU lru;

	/**
	 * Constructor initializes 3 pages: A, B, C<br>
	 * The LRU algorithm works with max 3 unit page locks.
	 */
	public PageHandlingSimulator() {
		lru = new LRU(3);
		Vector<Page> pages = new Vector<>();
		Page page = new Page("C");
		page.setData(0);
		pages.add(page);
		page = new Page("B");
		page.setData(0);
		pages.add(page);
		page = new Page("A");
		page.setData(0);
		pages.add(page);
		lru.setPages(pages);
	}

	/**
	 * Reads in the inputs, returns a string.
	 * @return references of numbers.
	 */
	public Vector<Integer> getInput() {
		Scanner scanner = new Scanner(System.in);
		String line;
		if (scanner.hasNext()) {
			line = scanner.nextLine();
		} else return new Vector<>(); // If we did not read in anything, return with empty array.
		//while (scanner.hasNext()); // useless line, need to read all of the inputs.
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

	/**
	 * Handles inputs and outputs the solution.
	 * @param inputs references of the data (numbers)
	 */
	public void computeInputs(Vector<Integer> inputs) {
		int pageFault = 0; // counting failed data references.
		StringBuilder output = new StringBuilder();

		// Reacting to every input.
		for (Integer input : inputs) {
			String nextStep = lru.pageCall(input);
			// If not able to read in data, it failed.
			if (!nextStep.equals("-")) {
				pageFault++;
			}
			output.append(nextStep);
		}

		// Output
		System.out.println(output);
		System.out.println(pageFault);
	}
}
