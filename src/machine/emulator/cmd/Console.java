package machine.emulator.cmd;

import java.util.ArrayList;
import java.util.Scanner;

import machine.emulator.cmd.Command.TYPE;

public class Console {
	
	private int l;
	private Scanner s;
	
	public ArrayList<Command> getInput() throws InvalidCommand {
		l = 0;
		System.out.println("Enter your program code\nType RUN on a new line to run the program\n");
		ArrayList<Command> cmds = new ArrayList<>();
		s = new Scanner(System.in);
		System.out.print(++l + "\t");
		do {
			String cmd = s.next();
			if (cmd.equals("HELP")) {
				System.out.println("Commands:\nINC n r (Increments reg n, jumps to r)");
			} else if(!cmd.equals("RUN")){
					switch (getType(cmd)) {
					case INC:
						INC i = new INC(l, s.nextInt(), s.nextInt());
						cmds.add(i);
						break;
					case HALT:
						HALT h = new HALT(l);
						cmds.add(h);
						break;
					default:
						throw new InvalidCommand("You have entered an invalid command, type " + "HELP" + " for commands");
					}
					System.out.print(++l + "\t");
			} else {
				break;
			}
		} while (s.hasNext());
		return cmds;
	}
	
	public String getProgName() {
		System.out.println("Program name: ");
		s = new Scanner(System.in);
		String h = s.next();
		return h;
	}
	
	public TYPE getType(String cmdName) {
		switch (cmdName) {
		case "INC":
			return TYPE.INC;
		case "DEB":
			return TYPE.DEB;
		case "HALT":
			return TYPE.HALT;
		}
		return TYPE.UNKNOWN;
	}

}
