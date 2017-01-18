package machine.emulator.progam;

import java.util.ArrayList;
import java.util.PriorityQueue;

import machine.emulator.cmd.Command;
import machine.emulator.memory.InvalidRegister;
import machine.emulator.memory.Memory;

public class Program {

	private int j = 1;
	private String name;
	private PriorityQueue<Command> prog;
	private ArrayList<Command> programCommands;

	public Program(ArrayList<Command> programCommands) {
		this.name = "~unf";
		this.programCommands = programCommands;

		this.prog = new PriorityQueue<>();
		for (Command c : programCommands) {
			this.prog.add(c);
		}
	}

	/**public void saveProgram(String programName, FileSystem fs) {
		if (fs.getFile(programName).exists()) {

		} else {
			File f = fs.createFile(programName);
			try {
				BufferedWriter writer = new BufferedWriter(new FileWriter(f));
				for (Command c : prog) {
					// .write(c.);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	} **/

	public void run(Memory mem) {
		mem.printRegNames();
		mem.printState();
		try {
			while((this.j = programCommands.get(this.j - 1).execute(mem)) != 0) {
				mem.printState();
			}
		} catch (InvalidRegister e) {
			System.out.println("[ERROR] " + e.getMessage());
		}
		
		/**while (this.j != 0 && prog.size() != 0 && prog.peek() != null) {
			try {
				this.j = prog.poll().execute(mem);
				mem.printState();
				// last command did not jump to next line in program
				if (prog.peek() != null && prog.peek().getJ() != this.j) {
						programCommands.get(this.j - 1).setJ(this.j);
						prog.offer(programCommands.get(this.j - 1));
					//	prog.remove(programCommands.get(this.j - 1));
				}
				System.out.println("si: " + prog.size());
			} catch (InvalidRegister e) {
				System.out.println(e.getMessage());
				Machine.SYS_CRASH();
			}
			if (this.j == 0) {
				System.out.println("\nProgram ended without errors");
				return;
			}
		} **/
	}

	public String getName() {
		return this.name;
	}
}
