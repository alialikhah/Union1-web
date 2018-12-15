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

import dao.entity.JobKarfarmaEntity;
import service.JobKarfarmaServiceLocal;

@Named
@RequestScoped
public class JobKarfarmaBean {

	public JobKarfarmaBean() {
		// TODO Auto-generated constructor stub
	}
	@Inject
	private JobKarfarmaServiceLocal jobKarfarmaServiceLocal;
	
	private String karfarmaSenf;
	private String karfarmaCompanyName;
	private String karfarmaName;
	private Date karfarmaEtebar;
	private String karfarmaJavazNum;
	private String karfarmaEmail;
	private String karfarmaSite;
	private String karfarmaPhone;
	private String karfarmaMobile;
	private String karfarmaPasokhName;
	private String karfarmaPasokhSemat;
	private String karfarmaNiroMorede;
	private String karfarmaNoeDarkhast;
	private String karfarmaTakhasosMorede;
	private String karfarmaDescription;
	private boolean taeed;
	private Part karfarmaPic;
	private String karfarmaJobCity;
	private String karfarmaJobTitle;
	private String karafarmaAddress;
	private String mizanHogog;
	public String getKarfarmaSenf() {
		return karfarmaSenf;
	}
	public void setKarfarmaSenf(String karfarmaSenf) {
		this.karfarmaSenf = karfarmaSenf;
	}
	public String getKarfarmaCompanyName() {
		return karfarmaCompanyName;
	}
	public void setKarfarmaCompanyName(String karfarmaCompanyName) {
		this.karfarmaCompanyName = karfarmaCompanyName;
	}
	public String getKarfarmaName() {
		return karfarmaName;
	}
	public void setKarfarmaName(String karfarmaName) {
		this.karfarmaName = karfarmaName;
	}
	public Date getKarfarmaEtebar() {
		return karfarmaEtebar;
	}
	public void setKarfarmaEtebar(Date karfarmaEtebar) {
		this.karfarmaEtebar = karfarmaEtebar;
	}
	public String getKarfarmaJavazNum() {
		return karfarmaJavazNum;
	}
	public void setKarfarmaJavazNum(String karfarmaJavazNum) {
		this.karfarmaJavazNum = karfarmaJavazNum;
	}
	public String getKarfarmaEmail() {
		return karfarmaEmail;
	}
	public void setKarfarmaEmail(String karfarmaEmail) {
		this.karfarmaEmail = karfarmaEmail;
	}
	public String getKarfarmaSite() {
		return karfarmaSite;
	}
	public void setKarfarmaSite(String karfarmaSite) {
		this.karfarmaSite = karfarmaSite;
	}
	public String getKarfarmaPhone() {
		return karfarmaPhone;
	}
	public void setKarfarmaPhone(String karfarmaPhone) {
		this.karfarmaPhone = karfarmaPhone;
	}
	public String getKarfarmaMobile() {
		return karfarmaMobile;
	}
	public void setKarfarmaMobile(String karfarmaMobile) {
		this.karfarmaMobile = karfarmaMobile;
	}
	public String getKarfarmaPasokhName() {
		return karfarmaPasokhName;
	}
	public void setKarfarmaPasokhName(String karfarmaPasokhName) {
		this.karfarmaPasokhName = karfarmaPasokhName;
	}
	public String getKarfarmaPasokhSemat() {
		return karfarmaPasokhSemat;
	}
	public void setKarfarmaPasokhSemat(String karfarmaPasokhSemat) {
		this.karfarmaPasokhSemat = karfarmaPasokhSemat;
	}
	public String getKarfarmaNiroMorede() {
		return karfarmaNiroMorede;
	}
	public void setKarfarmaNiroMorede(String karfarmaNiroMorede) {
		this.karfarmaNiroMorede = karfarmaNiroMorede;
	}
	public String getKarfarmaNoeDarkhast() {
		return karfarmaNoeDarkhast;
	}
	public void setKarfarmaNoeDarkhast(String karfarmaNoeDarkhast) {
		this.karfarmaNoeDarkhast = karfarmaNoeDarkhast;
	}
	public String getKarfarmaTakhasosMorede() {
		return karfarmaTakhasosMorede;
	}
	public void setKarfarmaTakhasosMorede(String karfarmaTakhasosMorede) {
		this.karfarmaTakhasosMorede = karfarmaTakhasosMorede;
	}
	public String getKarfarmaDescription() {
		return karfarmaDescription;
	}
	public void setKarfarmaDescription(String karfarmaDescription) {
		this.karfarmaDescription = karfarmaDescription;
	}
	public boolean isTaeed() {
		return taeed;
	}
	public void setTaeed(boolean taeed) {
		this.taeed = taeed;
	}
	public Part getKarfarmaPic() {
		return karfarmaPic;
	}
	public void setKarfarmaPic(Part karfarmaPic) {
		this.karfarmaPic = karfarmaPic;
	}
	
	
	
	public String getKarfarmaJobCity() {
		return karfarmaJobCity;
	}
	public void setKarfarmaJobCity(String karfarmaJobCity) {
		this.karfarmaJobCity = karfarmaJobCity;
	}
	public String getKarfarmaJobTitle() {
		return karfarmaJobTitle;
	}
	public void setKarfarmaJobTitle(String karfarmaJobTitle) {
		this.karfarmaJobTitle = karfarmaJobTitle;
	}

	public String getKarafarmaAddress() {
		return karafarmaAddress;
	}
	public void setKarafarmaAddress(String karafarmaAddress) {
		this.karafarmaAddress = karafarmaAddress;
	}

	public String getMizanHogog() {
		return mizanHogog;
	}
	public void setMizanHogog(String mizanHogog) {
		this.mizanHogog = mizanHogog;
	}
	public void insertToKarfarma() {
		FacesContext context = FacesContext.getCurrentInstance();
		JobKarfarmaEntity jobKarfarmaEntity=new JobKarfarmaEntity();
		jobKarfarmaEntity.setKarfarmaCompanyName(karfarmaCompanyName);
		jobKarfarmaEntity.setKarfarmaDescription(karfarmaDescription);
		jobKarfarmaEntity.setKarfarmaEmail(karfarmaEmail);
		jobKarfarmaEntity.setKarfarmaEtebar(new Date());
		jobKarfarmaEntity.setKarfarmaJavazNum(karfarmaJavazNum);
		jobKarfarmaEntity.setKarfarmaMobile(karfarmaMobile);
		jobKarfarmaEntity.setKarfarmaName(karfarmaName);
		jobKarfarmaEntity.setKarfarmaNiroMorede(karfarmaNiroMorede);
		jobKarfarmaEntity.setKarfarmaNoeDarkhast(karfarmaNoeDarkhast);
		jobKarfarmaEntity.setKarfarmaPasokhName(karfarmaPasokhName);
		jobKarfarmaEntity.setKarfarmaPasokhSemat(karfarmaPasokhSemat);
		jobKarfarmaEntity.setKarfarmaPhone(karfarmaPhone);
		jobKarfarmaEntity.setKarfarmaSenf(karfarmaSenf);
		jobKarfarmaEntity.setKarfarmaSite(karfarmaSite);
		jobKarfarmaEntity.setKarfarmaTakhasosMorede(karfarmaTakhasosMorede);
		jobKarfarmaEntity.setTaeed(false);
		jobKarfarmaEntity.setKarfarmaJobCity(karfarmaJobCity);
		jobKarfarmaEntity.setKarfarmaJobTitle(karfarmaJobTitle);
		jobKarfarmaEntity.setKarafarmaAddress(karafarmaAddress);
		jobKarfarmaEntity.setMizanHogog(mizanHogog);
		jobKarfarmaServiceLocal.insertToKarfarmaEntity(jobKarfarmaEntity);
		context.addMessage(null, new FacesMessage("با موفقیت ثبت گردید."));
		this.setKarafarmaAddress("");
		this.setKarfarmaCompanyName("");
		this.setKarfarmaDescription("");
		this.setKarfarmaEmail("");
		this.setKarfarmaJavazNum("");
		this.setKarfarmaJobCity("");
		this.setKarfarmaJobTitle("");
		this.setKarfarmaMobile("");
		this.setKarfarmaName("");
		this.setKarfarmaNiroMorede("");
		this.setKarfarmaNoeDarkhast("");
		this.setKarfarmaPasokhName("");
		this.setKarfarmaTakhasosMorede("");
		this.setKarfarmaPasokhSemat("");
		this.setKarfarmaPhone("");
		this.setKarfarmaSenf("");
		this.setMizanHogog("");
		this.setKarfarmaSite("");
	}
	
    
	public List<JobKarfarmaEntity> findAllKarfarma(){
		return jobKarfarmaServiceLocal.findAllKarfarma();
	}
	
	public JobKarfarmaEntity findKarfarmaById(long jobId) {
		return jobKarfarmaServiceLocal.findKarfarmaById(jobId);
	}
	
    public void updateKarfarma(long jobId) throws IOException {
    	FacesContext context = FacesContext.getCurrentInstance();
    	JobKarfarmaEntity jobKarfarmaEntity=new JobKarfarmaEntity();
    	jobKarfarmaEntity=jobKarfarmaServiceLocal.findKarfarmaById(jobId);
    	jobKarfarmaEntity.setTaeed(taeed);
    	jobKarfarmaServiceLocal.updateKarfarma(jobKarfarmaEntity);
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("karfarmaedit.xhtml" + "?karfarma=" + jobId);
    }
    
  
    public void deleteKarfarma(long karafarmaId) throws IOException{
    	JobKarfarmaEntity jobKarfarmaEntity=new JobKarfarmaEntity();
    	jobKarfarmaEntity=jobKarfarmaServiceLocal.findKarfarmaById(karafarmaId);
    	jobKarfarmaServiceLocal.deleteKarfarma(jobKarfarmaEntity);
    	FacesContext.getCurrentInstance().getExternalContext().redirect("karfarmaview.xhtml");
    }
	
}
