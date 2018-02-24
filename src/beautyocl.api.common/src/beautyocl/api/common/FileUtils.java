package beautyocl.api.common;

import java.io.IOException;
import java.net.URL;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;

public class FileUtils {
	private Class<?> context;

	// 
	//
	//
	public FileUtils(Class<?> context) {
		this.context = context;
	}
	
	/**
	 * Finds the file in the plug-in. Returns the file URL.
	 * 
	 * @param fileName
	 *            the file name
	 * @return the file URL
	 * @throws IOException
	 *             if the file doesn't exist
	 * 
	 * @generated
	 */
	public URL getFileURL(String fileName) throws IOException {
		final URL fileURL;
		if (isEclipseRunning()) {
//			URL resourceURL = Activator.class.getResource(fileName);
//			if (resourceURL != null) {
//				fileURL = FileLocator.toFileURL(resourceURL);
//			} else {
//				fileURL = null;
//			}
			fileURL = FileLocator.find(new URL(fileName));
		} else {
			fileURL = context.getResource(fileName);
		}
		if (fileURL == null) {
			throw new IOException("'" + fileName + "' not found");
		} else {
			return fileURL;
		}
	}

	/**
	 * Tests if eclipse is running.
	 * 
	 * @return <code>true</code> if eclipse is running
	 *
	 * @generated
	 */
	public static boolean isEclipseRunning() {
		try {
			return Platform.isRunning();
		} catch (Throwable exception) {
			// Assume that we aren't running.
		}
		return false;
	}
	
}
