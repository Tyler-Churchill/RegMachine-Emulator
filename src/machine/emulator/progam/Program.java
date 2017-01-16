package machine.emulator.progam;

import java.util.ArrayList;
import java.util.PriorityQueue;

import machine.emulator.Machine;
import machine.emulator.cmd.Command;
import machine.emulator.memory.InvalidRegister;
import machine.emulator.memory.Memory;

public class Program {

	private int j = 0;
	private String name;
	private PriorityQueue<Command> prog;

	public Program(String name, ArrayList<Command> programCommands) {
		this.name = name;
		this.prog = new PriorityQueue<>();
		for(Command c : programCommands) {
			this.prog.add(c);
		}
	}

	public void run(Memory mem) {
		while(prog.size() != 0 && prog.peek() != null) {
			try {
				this.j = prog.poll().execute(mem);
			} catch (InvalidRegister e) {
				System.out.println(e.getMessage());
				Machine.SYS_CRASH();
			}
			if(this.j == 0)
			{
				System.out.println("\nProgram ended without errors");
				return;
			}
		}
	}

	public String getName() {
		return this.name;
	}
}
