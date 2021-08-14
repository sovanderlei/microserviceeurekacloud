package com.ms.bankcheck.controller;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ms.bankcheck.useful.GenerateQRCode;
import com.ms.bankcheck.useful.Useful;

/**
 * class Microservice to demonstrate how to merge images and work with QRCode.
 * 
 * @author Vanderlei Soares de Oliveira
 * @version 0.01
 * @since Release 01
 */
public class CheckBkController {

	private Logger loggers = LoggerFactory.getLogger(CheckBkController.class);

	public CheckBkController(Logger loggers, String[] args) {

		this.loggers = loggers;

	}

	/**
	 * Monitoring Origin Folder
	 * @author Vanderlei Soares de Oliveira
	 * @Date 13/08/2021
	 */
	public void MonitoringOriginFolder() {

		this.loggers.info("MonitoringOriginFolder");

		while (true) {

			try {

				processFolder();

				Thread.sleep(60000);

			} catch (InterruptedException e) {
				this.loggers.error("MonitoringOriginFolder: " + e.getMessage());
			}

		}

	}

	/**
	 * process Folder
	 * @author Vanderlei Soares de Oliveira
	 * @Date 13/08/2021
	 */
	private void processFolder() {

		String pathOrigin = "D:/temp/Chequeimage/CheckOrigin/";
		String pathDestiny = "D:/temp/Chequeimage/CheckDestiny/";

		File listfile[] = null;

		try {

			listfile = Useful.listFiles(pathOrigin);

			if (listfile.length > 0) {

				for (int i = 0; i < listfile.length; i++) {
					String nameFile = listfile[i].getName();
					this.loggers.info("File from list" + nameFile);
					String nameFileQr = "QR" + Useful.getBaseName(listfile[i].getName()) + ".png";
					String dataQrCod = getDataCustomer(nameFile);
					String pathQrCod = pathOrigin + nameFileQr;
					GenerateQRCode.generateQRcode(dataQrCod, pathQrCod, 200, 200);
					this.loggers.info("Gereited File QrCode: " + nameFileQr);
					joinFiles(pathOrigin, pathDestiny, nameFile, nameFileQr);
					this.loggers.info("Join File: " + nameFile);
					Useful.deleteFile(pathOrigin + nameFile);
					Useful.deleteFile(pathOrigin + nameFileQr);
					this.loggers.info("delete File: " + nameFile + " and " + nameFileQr);

				}

			}

		} catch (Exception e) {
			this.loggers.error("processFolder: " + e.getMessage());
		}

	}

	/**
	 * get Data Customer
	 * @author Vanderlei Soares de Oliveira
	 * @Date 13/08/2021
	 */
	private String getDataCustomer(String IdCustomer) {

		// IdCustomer = get id from file and look for data of Customer

		String sText = "{\r\n" + "    \"DataCustomer\": [\r\n" + "         {\r\n"
				+ "              \"id\": \"123456789012_123456789012\",\r\n"
				+ "              \"doc\": \"1234567890\",\r\n" + "              \"name\": \"Jane Doe\",\r\n"
				+ "         }\r\n" + "    ]\r\n" + "}";

		return sText;
	}

	/**
	 * join Files
	 * @author Vanderlei Soares de Oliveira
	 * @Date 13/08/2021
	 */
	private void joinFiles(String pathOrigin, String pathDestiny, String nameFile, String nameFileQr) {

		try {

			String nameFileFinal = nameFile;

			BufferedImage _fundo = ImageIO.read(new File(pathOrigin + nameFile));
			BufferedImage _imagemqr = ImageIO.read(new File(pathOrigin + nameFileQr));
			Graphics graphicsqr = _fundo.createGraphics();
			graphicsqr.drawImage(_imagemqr, 10, 30, 100, 100, null);
			graphicsqr.dispose();
			ImageIO.write(_fundo, "PNG", new File(pathDestiny + nameFileFinal));

			_fundo = ImageIO.read(new File(pathDestiny + nameFileFinal));
			BufferedImage _imagemcontr = ImageIO.read(new File(pathOrigin + "namecontroller.png"));
			Graphics graphicsname = _fundo.createGraphics();
			graphicsname.drawImage(_imagemcontr, 110, 30, 300, 100, null);
			graphicsname.dispose();
			ImageIO.write(_fundo, "PNG", new File(pathDestiny + nameFileFinal));

		} catch (IOException e) {
			this.loggers.error("joinFiles: " + e.getMessage());
		}

	}

}
