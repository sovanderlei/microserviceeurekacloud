package com.ms.bankcheck.useful;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**class Microservice  to demonstrate how to merge images and work with QRCode.
* @author Vanderlei Soares de Oliveira
* @version 0.01
* @since Release 01 
*/
public class ReadQrCode {
 
	/***
	 * read QRcode
	 * @author Vanderlei Soares de Oliveira
	 * @Date 13/08/2021
	 * @param path
	 * @param charset
	 * @param map
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 * @throws NotFoundException
	 */
	public static String readQRcode(String path, String charset, Map<EncodeHintType, ErrorCorrectionLevel> map)
			throws FileNotFoundException, IOException, NotFoundException {
		BinaryBitmap binaryBitmap = new BinaryBitmap(
				new HybridBinarizer(new BufferedImageLuminanceSource(ImageIO.read(new FileInputStream(path)))));
		Result rslt = new MultiFormatReader().decode(binaryBitmap);
		return rslt.getText();
	}
 
	public static void main(String args[]) throws WriterException, IOException, NotFoundException { 
		String path = "D:\\Programacao\\java\\ms_eureka_cloud\\Cheque_image\\Quote.png"; 
		String charset = "UTF-8";
		Map<EncodeHintType, ErrorCorrectionLevel> hintMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>(); 
		hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
		System.out.println("Data stored in the QR Code is: \n" + readQRcode(path, charset, hintMap));
	}

}
