package machine.emulator;

import java.util.ArrayList;

public class Machine {
	
	private Memory mem;
	
	public Machine() {
		mem = new Memory();
	}

	public void run(ArrayList<String> program) {
		for(int x = 0; x < program.size(); x++) {
			// per line grab the command and the regs is question
			String [] tokens = program.get(x).split(" ");
			for(String s : tokens) {
				for(Command c : Command.values()) {
					if(s.equals(c.toString()))
						System.out.println("CMD: " + c.toString());
				}
			}
		}
		
	}
	
	public void execute(String s) {
		
			System.out.println(s);
	}
	
	public void displayState() {
		//String stateFormat = "| %-15s | %-15d |%n";
	
		System.out.println("Reg");
		for(int x = 0; x < mem.getNumReg(); x++) {
			System.out.println(x);
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= mem.getNumReg(); i++) {
			sb.append(String.format("%-10s", "Register" + i));
		} 
	}

	// TODO
	@SuppressWarnings("unused")
	private class Program {
		private final String saveLoc = "programs/";
		public boolean save() {
			return false;
		}
	}
	
	private enum Command {
		HALT(0), INC(1), DEB(2);
		private int opCode;
		private Command(int opCode) {
			this.setOpCode(opCode);
		}
		@SuppressWarnings("unused")
		public int getOpCode() {
			return opCode;
		}
		public void setOpCode(int opCode) {
			this.opCode = opCode;
		}
	};
}
