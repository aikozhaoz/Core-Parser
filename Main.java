class Main {
	public static void main(String[] args) {
		// Initialize the scanner with the input file
		Scanner S = new Scanner(args[0]);
		Prog root = new Prog();
		root.parse(S);

		root.semantic();

		root.print(1);
	}
}