package jp.co.aimsoft.attendance.stub.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * サンプル用JAXBDTO.
 * <p>
 * @XmlElementアノテーションを設定するとsetterを定義せずともマッピングされる。<br />
 * @XmlElementを使用しない場合、フィールド名とXMLのタグを合わせsetterを用意することでマッピングされる。<br />
 *                                                                 </p>
 */
@XmlRootElement(name = "sampleStubDto")
public class SampleStubDto {

	@XmlElement(name = "userName")
	private String userName;

	@XmlElement(name = "position")
	private String position;

	@XmlElement(name = "department")
	private String department;

	public String getUserName() {
		return userName;
	}

	public String getPosition() {
		return position;
	}

	public String getDepartment() {
		return department;
	}

}
