package machine.emulator;

import machine.emulator.cmd.Console;
import machine.emulator.cmd.InvalidCommand;
import machine.emulator.filesystem.FileSystem;
import machine.emulator.memory.Memory;
import machine.emulator.progam.Program;

public class Machine {
	private FileSystem fs;
	private Memory mem;
	private Console console;
	private static boolean running;

	public Machine() {
		this.mem = new Memory();
		this.fs = new FileSystem();
		this.console = new Console();
		running = true;
	}
	
	public void start() {
		while (running) {
			try {
				Program p = new Program(console.getInput());
				p.run(mem);
			} catch (InvalidCommand e) {
				System.out.println("\n" + e.getMessage());
			}
		}
	}

	public void run(Program p) {
		System.out.println("Running " + p.getName());
		p.run(mem);
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
