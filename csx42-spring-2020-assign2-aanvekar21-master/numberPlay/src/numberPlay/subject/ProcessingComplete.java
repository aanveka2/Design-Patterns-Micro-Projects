package numberPlay.subject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.InvalidPathException;

public class ProcessingComplete implements FilterI {

	private static ProcessingComplete ProcComplete;

	public static ProcessingComplete getInstance()
			throws InvalidPathException, SecurityException, FileNotFoundException, IOException {
		if (null == ProcComplete) {
			ProcComplete = new ProcessingComplete();

		}
		return ProcComplete;

	}

	@Override
	public boolean check(String number) {

		return false;
	}

}
