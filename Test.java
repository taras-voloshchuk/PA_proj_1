import static org.junit.Assert.*;
import org.junit.Test;

public class TestJava {

	@Test
	public void testExporter() {
		String textToBeExported = "Ala ma kota";
        Exporter exporter = new TextExporter(textToBeExported);
        Data exportedData = exporter.exportData();
        String exportedText = ((TextData) exportedData).text;
        System.out.println(exportedText);
        assertEquals(textToBeExported, exportedText);
        exportedData = exporter.exportData();
        exportedText = ((TextData) exportedData).text;
        textToBeExported = "";
        assertEquals(textToBeExported, exportedText);
	}
	
	@Test
	public void testImporter() {
		String textToBeImported = "Ala zgubila dolara";
        Data dataToSendToImporter = new TextData(textToBeImported);
        Importer importer = new TextImporter();
        importer.importData(dataToSendToImporter);
        String dataSavedInImporter = ((TextImporter) importer).importedText;
        assertEquals(textToBeImported, dataSavedInImporter);
	}

}

abstract class Exporter {
	
	protected TextData exportData;
	
	public Exporter() {}
	
	public TextData exportData() {
		TextData temp = new TextData(exportData);
		exportData.setText("");
		return temp;
	}
	
}

class TextExporter extends Exporter {
	
	public TextExporter(String textToBeExported) {
		exportData = new TextData(textToBeExported);
	}
	
}

abstract class Importer {

	protected String importedText;
	
	public void importData(Data dataToSendToImporter) {
		importedText = dataToSendToImporter.getText();
	}

}

class TextImporter extends Importer {
	
}

abstract class Data {

	String text;
		
	public String getText() {
		return text;
	}
	
	public void setText(String text) {
		this.text = text;
	}
	
}

class TextData extends Data {

	public TextData(String text) {
		this.text = text;
	}
	
	public TextData(TextData textData) {
		this.text = new String(textData.text);
	}

}