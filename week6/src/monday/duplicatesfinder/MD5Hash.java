package monday.duplicatesfinder;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Hash {
	private static final int CHUNK_SIZE = 8192;

	// will generate same hash for duplicates, because of the Key class
	public static byte[] generateMd5(Path filePath) throws IOException,
			NoSuchAlgorithmException {
		try (BufferedInputStream is = new BufferedInputStream(
				new FileInputStream(filePath.toFile()))) {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] buffer = new byte[CHUNK_SIZE];
			int len;
			while ((len = is.read(buffer)) != -1) {
				md5.update(buffer, 0, len);
			}
			return md5.digest();
		}
	}
}