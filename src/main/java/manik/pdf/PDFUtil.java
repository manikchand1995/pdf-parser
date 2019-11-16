package manik.pdf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.AccessPermission;
import org.apache.pdfbox.pdmodel.encryption.StandardProtectionPolicy;

public class PDFUtil {

	public static void deletePage(InputStream pdfInput, OutputStream pdfOutput, int[] pageNumbers) throws IOException {
		try (PDDocument document = PDDocument.load(pdfInput)) {
			for(int pageNumber : pageNumbers) {
				document.removePage(pageNumber);
			}
			document.save(pdfOutput);
		}
	}

	public static void unlock(InputStream pdfInput, OutputStream pdfOutput) throws IOException {
		try (PDDocument document = PDDocument.load(pdfInput)) {
			if( document.isEncrypted() )
			{
				AccessPermission ap = document.getCurrentAccessPermission();
				if(ap.isOwnerPermission())
				{
					document.setAllSecurityToBeRemoved(true);
					document.save(pdfOutput);
				}
				else
				{
					throw new IOException(
							"Error: You are only allowed to decrypt a document with the owner password." );
				}
			}
		}
	}

	public static void unlock(InputStream pdfInput, OutputStream pdfOutput, String password) throws IOException {
        try (PDDocument document = PDDocument.load(pdfInput, password)) {
            document.setAllSecurityToBeRemoved(true);
        } catch (IOException e){
            System.err.println("Exception while trying to read pdf document - " + e);
        }
	}

	public static void lock(InputStream pdfInput, OutputStream pdfOutput, String password) throws IOException {
		try (PDDocument document = PDDocument.load(pdfInput)) {
            AccessPermission ap = new AccessPermission();
            ap.setCanPrint(true);
            ap.setCanPrintDegraded(true);
            ap.setCanExtractContent(true);
            ap.setCanExtractForAccessibility(true);
            ap.setCanFillInForm(true);
            ap.setCanModify(true);

            StandardProtectionPolicy spp = new StandardProtectionPolicy(password, password, ap);
            spp.setEncryptionKeyLength(128);
            spp.setPreferAES(true);
            spp.setPermissions(ap);
            document.protect(spp);
            
            document.save(pdfOutput);
		}
	}


}
