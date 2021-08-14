package com.ms.bankcheck.useful;

import java.io.File;
import java.io.FilenameFilter; 

public class Useful {

	public void AttachImagens() {

	}

	public static File[] listFiles(String directory) {
		File[] files = null;
		try {
			File fileTemp = new File(directory);
			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File fileTemp, String name) {
					boolean breturn = false;
					if (!name.contains("namecontroller")) {
						if (name.endsWith(".png") || name.endsWith(".jpg")) {
							breturn = true;
						}
					}
					return breturn;
				}
			};
			files = fileTemp.listFiles(filter);
			// System.out.println("Files are:");
			// for (int i = 0; i < files.length; i++) {
			// System.out.println(files[i].getName());
			// }

		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return files;
	}

	public static String getBaseName(String fileName) {
		String fname = fileName;
		int pos = fname.lastIndexOf(".");
		if (pos > 0) {
		    fname = fname.substring(0, pos);
		}
		return fname;
	}
	
	public static void deleteFile(String pathFile) {
		File myFile = new File(pathFile); 
		myFile.delete();
	}
	
	
	
}
