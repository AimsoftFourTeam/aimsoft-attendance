package jp.co.aimsoft.attendance.stub.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "sampleStubDtos")
public class SampleStubDtos {

	@XmlElement(name = "sampleStubDto")
	private List<SampleStubDto> sampleStubDtoList;

	public List<SampleStubDto> getSampleStubDtoList() {
		return sampleStubDtoList;
	}

}
