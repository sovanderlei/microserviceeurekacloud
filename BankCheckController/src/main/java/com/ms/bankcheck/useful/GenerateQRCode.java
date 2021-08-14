package com.ms.bankcheck.useful;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**class Microservice  to demonstrate how to merge images and work with QRCode.
* @author Vanderlei Soares de Oliveira
* @version 0.01
* @since Release 01 
*/
public class GenerateQRCode {
 
	
	/***
	 * generate QRcode
	 * @author Vanderlei Soares de Oliveira
	 * @Date 13/08/2021
	 * @param data
	 * @param path
	 * @param h
	 * @param w
	 */
	@SuppressWarnings("deprecation")
	public static void generateQRcode(String data, String path, int h, int w){
		
		String charset = "UTF-8";
		Map<EncodeHintType, ErrorCorrectionLevel> map = new HashMap<EncodeHintType, ErrorCorrectionLevel>(); 
		map.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);

		BitMatrix matrix = null;
		try {
			matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset),
					BarcodeFormat.QR_CODE, w, h);
		} catch (UnsupportedEncodingException e) { 
			e.printStackTrace();
		} catch (WriterException e) { 
			e.printStackTrace();
		}
		try {
			MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
 
	public static void main(String args[]) throws WriterException, IOException, NotFoundException {
		String str = "THE HABIT OF PERSISTENCE IS THE HABIT OF VICTORY.";
		String path = "D:\\Programacao\\java\\ms_eureka_cloud\\Cheque_image\\Quote.png"; 
		generateQRcode(str, path, 200, 200);
		System.out.println("QR Code created successfully.");
	}

}
