package machine.emulator.cmd;

import machine.emulator.memory.InvalidRegister;
import machine.emulator.memory.Memory;

public abstract class Command implements Comparable<Command> {
	
	private int j;
	private int jr1;
	private int jr2;
	private int r1;
	private int r2;
	
	public Command(int j, int r1, int jr1) {
		this.j = j;
		this.setR1(r1);	
		this.setJr1(jr1);		
	}

	public Command(int j, int jr1, int jr2, int r1, int r2) {
		this.j = j;
		this.setR1(r1);
		this.setR2(r2);
		this.setJr1(jr1);
		this.setJr2(jr2);
	}
	
	public int compareTo(Command o) {
	    return Integer.compare(this.j, o.j);
	}

	public Command() {
		this.setJr1(0);
		this.setJr2(0);
		this.setR1(0);
		this.setR2(0);
	}
	
	public int getLineNum() {
		return this.j;
	}

	// execute command and jump to given instruction number
	public abstract int execute(Memory mem) throws InvalidRegister;

	public int getJr2() {
		return jr2;
	}

	public void setJr2(int jr2) {
		this.jr2 = jr2;
	}

	public int getJr1() {
		return jr1;
	}

	public void setJr1(int jr1) {
		this.jr1 = jr1;
	}

	public int getR1() {
		return r1;
	}

	public void setR1(int r1) {
		this.r1 = r1;
	}

	public int getR2() {
		return r2;
	}

	public void setR2(int r2) {
		this.r2 = r2;
	}

	public enum TYPE {
		UNKNOWN, HALT, INC, DEB;
	};
}
