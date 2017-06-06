package jp.co.aimsoft.attendance.sample.suggest.model;

/**
 * suggestの為のデータクラス
 * 
 */
public class UserNameKeyAssist {

	private String kanji;
	
	private String romaji;
	
	private String katakana;
	
	private String hiragana;

	public String getKanji() {
		return kanji;
	}

	public void setKanji(String kanji) {
		this.kanji = kanji;
	}

	public String getRomaji() {
		return romaji;
	}

	public void setRomaji(String romaji) {
		this.romaji = romaji;
	}

	public String getKatakana() {
		return katakana;
	}

	public void setKatakana(String katakana) {
		this.katakana = katakana;
	}

	public String getHiragana() {
		return hiragana;
	}

	public void setHiragana(String hiragana) {
		this.hiragana = hiragana;
	}

	/**
	 * @param kanji
	 * @param romaji
	 * @param katakana
	 * @param hiragana
	 */
	public UserNameKeyAssist(String kanji, String romaji, String katakana, String hiragana) {

		this.kanji = kanji;
		this.romaji = romaji;
		this.katakana = katakana;
		this.hiragana = hiragana;
	}
}
