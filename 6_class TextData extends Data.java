class TextData extends Data {

	public TextData(String text) {
		this.text = text;
	}
	
	public TextData(TextData textData) {
		this.text = new String(textData.text);
	}

}
