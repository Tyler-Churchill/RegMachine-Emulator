package machine.emulator.cmd;

import machine.emulator.memory.InvalidRegister;
import machine.emulator.memory.Memory;

public class INC extends Command {
	
	public INC(int j, int r1, int jr1) {
		super(j, r1, jr1);
	}
	
	@Override
	public int execute(Memory mem) throws InvalidRegister  {
		mem.set(super.getR1(), mem.get(super.getR1()) + 1);
		return super.getJr1();
	}

}
