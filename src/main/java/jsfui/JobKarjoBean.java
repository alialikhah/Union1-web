package jsfui;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import dao.entity.JobKarjoEntity;
import service.JobKarjoServiceLocal;

@Named
@RequestScoped
public class JobKarjoBean {

	public JobKarjoBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private JobKarjoServiceLocal jobKarjoServiceLocal;

	private String karjoName;
	private String karjoSsn;
	private String karjoFather;
	private String karjoGender;
	private String karjoCityName;
	private Date karjoBirth;
	private String karjoPhone;
	private String karjoMobile;
	private String karjoEmail;
	private String karjoField;
	private String karjoMadrak;
	private String karjoMaharat;
	private String karjoNoeFaal;
	private String karjoDescription;
	private String karjoNoeHamkari;
	private Part karjoResume;
	public String getKarjoName() {
		return karjoName;
	}
	public void setKarjoName(String karjoName) {
		this.karjoName = karjoName;
	}
	public String getKarjoSsn() {
		return karjoSsn;
	}
	public void setKarjoSsn(String karjoSsn) {
		this.karjoSsn = karjoSsn;
	}
	public String getKarjoFather() {
		return karjoFather;
	}
	public void setKarjoFather(String karjoFather) {
		this.karjoFather = karjoFather;
	}
	public String getKarjoGender() {
		return karjoGender;
	}
	public void setKarjoGender(String karjoGender) {
		this.karjoGender = karjoGender;
	}
	public String getKarjoCityName() {
		return karjoCityName;
	}
	public void setKarjoCityName(String karjoCityName) {
		this.karjoCityName = karjoCityName;
	}
	public Date getKarjoBirth() {
		return karjoBirth;
	}
	public void setKarjoBirth(Date karjoBirth) {
		this.karjoBirth = karjoBirth;
	}
	public String getKarjoPhone() {
		return karjoPhone;
	}
	public void setKarjoPhone(String karjoPhone) {
		this.karjoPhone = karjoPhone;
	}
	public String getKarjoMobile() {
		return karjoMobile;
	}
	public void setKarjoMobile(String karjoMobile) {
		this.karjoMobile = karjoMobile;
	}
	public String getKarjoEmail() {
		return karjoEmail;
	}
	public void setKarjoEmail(String karjoEmail) {
		this.karjoEmail = karjoEmail;
	}
	public String getKarjoField() {
		return karjoField;
	}
	public void setKarjoField(String karjoField) {
		this.karjoField = karjoField;
	}
	public String getKarjoMadrak() {
		return karjoMadrak;
	}
	public void setKarjoMadrak(String karjoMadrak) {
		this.karjoMadrak = karjoMadrak;
	}
	public String getKarjoMaharat() {
		return karjoMaharat;
	}
	public void setKarjoMaharat(String karjoMaharat) {
		this.karjoMaharat = karjoMaharat;
	}
	public String getKarjoNoeFaal() {
		return karjoNoeFaal;
	}
	public void setKarjoNoeFaal(String karjoNoeFaal) {
		this.karjoNoeFaal = karjoNoeFaal;
	}
	public String getKarjoDescription() {
		return karjoDescription;
	}
	public void setKarjoDescription(String karjoDescription) {
		this.karjoDescription = karjoDescription;
	}
	public String getKarjoNoeHamkari() {
		return karjoNoeHamkari;
	}
	public void setKarjoNoeHamkari(String karjoNoeHamkari) {
		this.karjoNoeHamkari = karjoNoeHamkari;
	}
	public Part getKarjoResume() {
		return karjoResume;
	}
	public void setKarjoResume(Part karjoResume) {
		this.karjoResume = karjoResume;
	}
	
	public void insertToKarjoEntity() {
		JobKarjoEntity karjoEntity=new JobKarjoEntity();
		karjoEntity.setKarjoBirth(new Date());
		karjoEntity.setKarjoCityName(karjoCityName);
		karjoEntity.setKarjoDescription(karjoDescription);
		karjoEntity.setKarjoEmail(karjoEmail);
		karjoEntity.setKarjoFather(karjoFather);
		karjoEntity.setKarjoField(karjoField);
		karjoEntity.setKarjoGender(karjoGender);
		karjoEntity.setKarjoMadrak(karjoMadrak);
		karjoEntity.setKarjoMaharat(karjoMaharat);
		karjoEntity.setKarjoMobile(karjoMobile);
		karjoEntity.setKarjoName(karjoName);
		karjoEntity.setKarjoNoeFaal(karjoNoeFaal);
		karjoEntity.setKarjoNoeHamkari(karjoNoeHamkari);
		karjoEntity.setKarjoPhone(karjoPhone);
		karjoEntity.setKarjoSsn(karjoSsn);
		jobKarjoServiceLocal.insertToKarjoEntity(karjoEntity);
	}
	
}
