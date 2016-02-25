package com.boyko.filemanager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
	private static List<String> con = new ArrayList<>();

	public static String[] readFile() throws FileNotFoundException {
		Scanner inFile1 = new Scanner(new File("snimki"));
		StringBuilder sb = new StringBuilder();
		while (inFile1.hasNext()) {
			sb.append(inFile1.nextLine());
		}
		inFile1.close();
		return sb.toString().split(",");
	}

	public static void main(String[] args) throws IOException {
		walk("/home/boyko/Desktop/snimki");
	}

	public static void walk(String path) throws IOException {

		File root = new File(path);
		File[] list = root.listFiles();

		if (list == null)
			return;

		for (File f : list) {
			if (f.isDirectory()) {
				walk(f.getAbsolutePath());
				// System.out.println("Dir:" + f.getAbsoluteFile());
			} else {
				String name = "";
				String name2 = "";
				String[] nomera = readFile();
				// List<String> l = Arrays.asList(nomera);
				if (f.getName().length() > 9) {
					name = f.getName().substring(f.getName().length() - 7, f.getName().length() - 4);
					name2 = f.getName().substring(f.getName().length() - 8, f.getName().length() - 4);

				}
				for (int i = 0; i < nomera.length; i++) {
					if ((name.equals(nomera[i]) || name2.equals(nomera[i]))) {
						if (!con.contains(nomera[i])) {
							Files.copy(f.toPath(), new File("pics/" + f.getName()).toPath());
							con.add(name);
							con.add(name2);
						}
					}
				}

			}
		}
	}

	public static void copyFile(String dir, String name) {
		File oldFile = new File(dir, name);
		File newFile = new File("pics", name);

		try {
			FileInputStream fis = new FileInputStream(oldFile);
			FileOutputStream fos = new FileOutputStream(newFile);

			try {
				int currentByte = fis.read();
				while (currentByte != -1) {
					fos.write(currentByte);
					currentByte = fis.read();
				}
			} catch (IOException exception) {
				System.err.println("IOException occurred!");
				exception.printStackTrace();
			} finally {
				fis.close();
				fos.close();
				System.out.println("Copied file!");
			}
		} catch (IOException exception) {
			System.err.println("Problems with files!");
			exception.printStackTrace();
		}
	}
}
