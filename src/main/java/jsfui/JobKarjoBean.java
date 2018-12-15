package jsfui;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.Part;

import dao.entity.JobKarjoEntity;
import dao.entity.MerchantEntity;
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
	private String karjoBirth;
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
	private boolean show;

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

	public String getKarjoBirth() {
		return karjoBirth;
	}

	public void setKarjoBirth(String karjoBirth) {
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

	public boolean isShow() {
		return show;
	}

	public void setShow(boolean show) {
		this.show = show;
	}

	public void insertToKarjoEntity() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		JobKarjoEntity karjoEntity = new JobKarjoEntity();
		karjoEntity.setKarjoBirth(karjoBirth);
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
		context.addMessage(null, new FacesMessage("با موفقیت ثبت گردید."));
		this.setKarjoCityName("");
		this.setKarjoDescription("");
		this.setKarjoEmail("");
		this.setKarjoFather("");
		this.setKarjoField("");
		this.setKarjoGender(null);
		this.setKarjoMadrak("");
		this.setKarjoMaharat("");
		this.setKarjoMobile("");
		this.setKarjoName("");
		this.setKarjoNoeFaal("");
		this.setKarjoNoeHamkari("");
		this.setKarjoPhone("");
		this.setKarjoSsn("");
		this.setKarjoBirth("");

	}

	public List<JobKarjoEntity> findAllKarjo() {
		return jobKarjoServiceLocal.findAllKarjo();
	}

	public JobKarjoEntity findKarjoById(long karjoId) {
		return jobKarjoServiceLocal.findKarjoById(karjoId);
	}

	public void deleteKarjo(long karjoId) throws IOException {
		JobKarjoEntity jobKarjoEntity = new JobKarjoEntity();
		jobKarjoEntity = jobKarjoServiceLocal.findKarjoById(karjoId);
		jobKarjoServiceLocal.deleteKarjo(jobKarjoEntity);
		FacesContext.getCurrentInstance().getExternalContext().redirect("karjoview.xhtml");
	}
	
	
	public void updateKarjo(long karjoId) throws IOException {
		JobKarjoEntity karjoEntity=new JobKarjoEntity();
		karjoEntity=jobKarjoServiceLocal.findKarjoById(karjoId);
		karjoEntity.setShow(show);
		jobKarjoServiceLocal.updateKarjo(karjoEntity);
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("karjoedit.xhtml" + "?karjoId=" + karjoId);
	}

}
