package machine.emulator;

public class Memory {

	private int[] registers;
	private int nReg;

	// construct the machines memory with the amount of registers you want
	public Memory() {
		nReg = 6;
	}
	
	public Memory(int nReg) {
		this.nReg = nReg;
		registers = new int[this.nReg];
	}

	public void put(int regN, int val) {
		try {
			registers[regN] = val;
		} catch (IndexOutOfBoundsException e) {
			// lazy growth
			int[] rTemp = registers;
			int[] rNew = new int[nReg += 1];
			for (int x = 0; x < (nReg - 1); x++) {
				rNew[x] = rTemp[x];
			}
			registers = rNew;
			registers[regN] = val;
		}
	}

	public int get(int regN) {
		return registers[regN];
	}
	public int getNumReg() {
		return nReg;
	}

}
