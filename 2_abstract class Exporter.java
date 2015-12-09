abstract class Exporter {
	
	protected TextData exportData;
	
	public Exporter() {}
	
	public TextData exportData() {
		TextData temp = new TextData(exportData);
		exportData.setText("");
		return temp;
	}
	
}
