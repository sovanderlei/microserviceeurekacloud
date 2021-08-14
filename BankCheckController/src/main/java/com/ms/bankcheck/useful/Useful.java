package com.ms.bankcheck.useful;

import java.io.File;
import java.io.FilenameFilter; 

/**class class to put the methods used in various code reuse classes.
* @author Vanderlei Soares de Oliveira
* @version 0.01
* @since Release 01 
*/
public class Useful {

	public void AttachImagens() {

	}

	/***
	 * List files in a folder
	 * @param directory
	 * @return List File
	 */
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

	/***
	 * Get Base Name not extension
	 * @param fileName
	 * @return the name not extension 
	 */
	public static String getBaseName(String fileName) {
		String fname = fileName;
		int pos = fname.lastIndexOf(".");
		if (pos > 0) {
		    fname = fname.substring(0, pos);
		}
		return fname;
	}
	
	
	/***
	 * Delete Files
	 * @param pathFile
	 */
	public static void deleteFile(String pathFile) {
		File myFile = new File(pathFile); 
		myFile.delete();
	}
	
	
	
}
