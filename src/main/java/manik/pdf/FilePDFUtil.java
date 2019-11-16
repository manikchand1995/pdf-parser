package manik.pdf;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FilePDFUtil {

	public static void deletePage(String inputFilePath, String outputFilePath, int[] pageNumbers) throws IOException {
		FileInputStream fis = new FileInputStream(inputFilePath);
		FileOutputStream fos = new FileOutputStream(outputFilePath);
		//fis.read();
		PDFUtil.deletePage(fis, fos, pageNumbers);
	}
	
	public static void lock(String inputFilePath, String outputFilePath, String password) throws IOException {
		FileInputStream fis = new FileInputStream(inputFilePath);
		FileOutputStream fos = new FileOutputStream(outputFilePath);
		//fis.read();
		PDFUtil.lock(fis, fos, password);
	}
	
	public static void unlock(String inputFilePath, String outputFilePath, String password) throws IOException {
		FileInputStream fis = new FileInputStream(inputFilePath);
		FileOutputStream fos = new FileOutputStream(outputFilePath);
		//fis.read();
		PDFUtil.unlock(fis, fos, password);
	}

	public static void unlock(String inputFilePath, String outputFilePath) throws IOException {
		FileInputStream fis = new FileInputStream(inputFilePath);
		FileOutputStream fos = new FileOutputStream(outputFilePath);
		//fis.read();
		PDFUtil.unlock(fis, fos);
	}
	
}
