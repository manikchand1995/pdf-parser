package manik.pdf;

import java.io.IOException;

import org.junit.Test;

public class TestFilePDFUtil {

	@Test
	public void testDeletePages() throws IOException {
		String fileName = "/home/local/ZOHOCORP/mani-5328/git/pdf-parser/src/test/resources/test.pdf";
		String outputFileName = "/home/local/ZOHOCORP/mani-5328/git/pdf-parser/src/test/resources/test_deleted.pdf";
		FilePDFUtil.deletePage(fileName, outputFileName, new int[]{1});
	}
	
	@Test
	public void testLockDocument() throws IOException {
		String fileName = "/home/local/ZOHOCORP/mani-5328/git/pdf-parser/src/test/resources/test.pdf";
		String outputFileName = "/home/local/ZOHOCORP/mani-5328/git/pdf-parser/src/test/resources/test_locked.pdf";
		FilePDFUtil.lock(fileName, outputFileName, "test");
	}
	
	@Test
	public void testUnlockDocument() throws IOException {
		String fileName = "/home/local/ZOHOCORP/mani-5328/git/pdf-parser/src/test/resources/RedactExportTest.pdf";
		String outputFileName = "/home/local/ZOHOCORP/mani-5328/git/pdf-parser/src/test/resources/RedactExportTest_unlocked.pdf";
		FilePDFUtil.unlock(fileName, outputFileName, "tseTtropxEtcadeR");
	}
	
	@Test
	public void testUnlockDocument_WithoutPassword() throws IOException {
		String fileName = "/home/local/ZOHOCORP/mani-5328/git/pdf-parser/src/test/resources/RedactExportTest.pdf";
		String outputFileName = "/home/local/ZOHOCORP/mani-5328/git/pdf-parser/src/test/resources/RedactExportTest_unlocked_withoutPass.pdf";
		FilePDFUtil.unlock(fileName, outputFileName);
	}
}
