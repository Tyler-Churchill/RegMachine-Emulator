package machine.emulator;

import java.util.ArrayList;
import java.util.Scanner;

public class Console {

	private Machine mac;
	private int l = 0;
	private Scanner s;

	public Console() {
		mac = new Machine();
	}

	public void start() {
		while(true)
			mac.run(getProgram());
	}

	private ArrayList<String> getProgram() {
		System.out.println("Enter your program code\nType RUN on a new line to run the program\n");
		ArrayList<String> lines = new ArrayList<>();
		s = new Scanner(System.in);
		System.out.print(++l + "\t");
		do {
			String cmd = s.next();
			if(!cmd.equals("RUN"))
			lines.add(s.nextLine());
			else {
				l = 0;
				return lines;
			}
			System.out.print(++l + "\t");
		} while(s.hasNext());
		return lines;
	}

	public static void main(String args[]) {
		Console c = new Console();
		c.start();
	}

}
