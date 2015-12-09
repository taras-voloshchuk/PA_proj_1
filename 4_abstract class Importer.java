abstract class Importer {

	protected String importedText;
	
	public void importData(Data dataToSendToImporter) {
		importedText = dataToSendToImporter.getText();
	}

}

class TextImporter extends Importer {
	
}
