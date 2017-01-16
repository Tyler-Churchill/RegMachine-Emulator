package machine.emulator;

import machine.emulator.cmd.Console;
import machine.emulator.cmd.InvalidCommand;
import machine.emulator.memory.Memory;
import machine.emulator.progam.Program;

public class Machine {

	private Memory mem;
	private Console console;
	private static boolean running;

	public Machine() {
		this.mem = new Memory();
		this.console = new Console();
		running = true;
	}

	public void start() {
		while (running) {
			try {
				Program p = new Program(console.getProgName(), console.getInput());
				run(p);
			} catch (InvalidCommand e) {
				System.out.println(e.getMessage());
			}
		}
	}

	public void run(Program p) {
		mem.printState();
		System.out.println("Running " + p.getName());
		p.run(mem);
		mem.printState();
	}
	
	public static void SYS_CRASH() {
		System.out.println("System crashed...");
		running = false;
	}
	
	public static void main(String args[]) {
		Machine m = new Machine();
		m.start();
	}

}
