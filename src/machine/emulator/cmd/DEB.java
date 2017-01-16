package machine.emulator.cmd;

import machine.emulator.memory.InvalidRegister;
import machine.emulator.memory.Memory;

public class DEB extends Command {

	public DEB(int j, int r, int j1, int j2) {
		super(j, r, j1, j2);
	}
	
	@Override
	public int execute(Memory mem) throws InvalidRegister {
		if(mem.get(super.getR1()) > 0) {
			mem.set(super.getR1(), mem.get(super.getR1()) - 1);
			return super.getJr1();
		}
		return super.getJr2();
	}
}
