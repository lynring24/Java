import java.util.Scanner;

public class SortingProcessor {
	private static final int TERMINATION = 4;
	private static int choice = -1;
	private OriginalNumbers generator;

	public static void main(String[] args) {
		SortingProcessor processor = new SortingProcessor();
		processor.generator = new OriginalNumbers(200);

		processor.printAuthorInfo();
		processor.execute();
	}

	private void printAuthorInfo() {
		System.out.println("[ ID: 1515386 ]");
		System.out.println("[ Name: ������ ]");
	}

	private void execute() {
		do {
			printMenu();
			getInput();
			operate();
		} while (choice != TERMINATION);
	}

	private void printMenu() {
		System.out.println();
		System.out.println("1. Input numbers");
		System.out.println("2. Print numbers in increasing order");
		System.out.println("3. Print numbers in decreasing order");
		System.out.println("4. Quit");
		System.out.print("\n>");
	}

	private void getInput() {
		Scanner scanner = new Scanner(System.in);
		try {
			choice = scanner.nextInt();
		} catch (Exception e) {
			handleException();
		}
	}

	private void operate() {
		final int INPUT = 1;
		final int ASCENDINGORDER = 2;
		final int DESCENDINGORDER = 3;

		switch (choice) {
		case INPUT:
			// generator.getInputs();
			break;

		case ASCENDINGORDER:
			printResultWith(new AscendingSorter());
			break;

		case DESCENDINGORDER:
			printResultWith(new DescendingSorter());
			break;

		case TERMINATION:
			System.out.println("[Termination]");
			break;
		}
	}

	private void printResultWith(Sorter selectedOne) {
		Sorter sorter = selectedOne;
		sorter.sort(generator.getClone(0));
		sorter.printResult();
	}

	private void handleException() {
		System.out.println("Unappropriate inputs(Integers only)");
		choice = TERMINATION;
	}
}
