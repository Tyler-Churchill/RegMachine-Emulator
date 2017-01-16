package machine.emulator.cmd;

import machine.emulator.memory.Memory;

public class HALT extends Command {

	public HALT(int l) {
		super(l, 0, 0);
	}

	@Override
	public int execute(Memory mem) {
		return 0;
	}

}
