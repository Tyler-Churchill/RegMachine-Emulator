package machine.emulator.filesystem;

import java.io.File;
import java.io.FilenameFilter;

public class FileSystem {
	private File[] files;
	private String fileLoc = "/programs/";

	public FileSystem() {
		refreshFileList();
	}

	FilenameFilter txtFilter = new FilenameFilter() {
		@Override
		public boolean accept(File dir, String name) {
			return name.toLowerCase().endsWith(".rmp");
		}
	};

	private void refreshFileList() {
		File f = new File(this.fileLoc);
		files = f.listFiles();
	}
	
	public File createFile(String name) {
		return new File(fileLoc + name + ".rmp");
	}
	
	public File getFile(String name) {
		for (File x : files) {
			if(x.getName().equals(name))
				return x;
		}
		return null;
	}

}
