package jsfui;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

import dao.entity.MashahirEntity;
import dao.entity.MerchantEntity;
import service.MashahirServiceLocal;

@Named
@RequestScoped
public class MashahirBean {

	public MashahirBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private MashahirServiceLocal mashahirServiceLocal;
	private String mashahirHead1;
	private String mashahirText1;
	private String mashahirHead2;
	private String mashahirText2;
	private String mashahirHead3;
	private String mashahirText3;
	private String mashahirHead4;
	private String mashahirText4;
	private String mashahirHead5;
	private String mashahirText5;
	private Part mashahirImg1;
	private Part mashahirImg2;
	private Part mashahirImg3;
	private Part mashahirImg4;
	private Part mashahirImg5;
	private Part mashahirImg6;
	private String mashahirName;
	private String mashahirField;
	private boolean isInHead;
	private List<String> mashahirFielsds = new ArrayList<String>();

	public boolean isInHead() {
		return isInHead;
	}

	public void setInHead(boolean isInHead) {
		this.isInHead = isInHead;
	}

	public List<String> getMashahirFielsds() {
		return mashahirFielsds;
	}

	public void setMashahirFielsds(List<String> mashahirFielsds) {
		this.mashahirFielsds = mashahirFielsds;
	}

	public String getMashahirField() {
		return mashahirField;
	}

	public void setMashahirField(String mashahirField) {
		this.mashahirField = mashahirField;
	}

	public String getMashahirName() {
		return mashahirName;
	}

	public void setMashahirName(String mashahirName) {
		this.mashahirName = mashahirName;
	}

	public String getMashahirHead1() {
		return mashahirHead1;
	}

	public void setMashahirHead1(String mashahirHead1) {
		this.mashahirHead1 = mashahirHead1;
	}

	public String getMashahirText1() {
		return mashahirText1;
	}

	public void setMashahirText1(String mashahirText1) {
		this.mashahirText1 = mashahirText1;
	}

	public String getMashahirHead2() {
		return mashahirHead2;
	}

	public void setMashahirHead2(String mashahirHead2) {
		this.mashahirHead2 = mashahirHead2;
	}

	public String getMashahirText2() {
		return mashahirText2;
	}

	public void setMashahirText2(String mashahirText2) {
		this.mashahirText2 = mashahirText2;
	}

	public String getMashahirHead3() {
		return mashahirHead3;
	}

	public void setMashahirHead3(String mashahirHead3) {
		this.mashahirHead3 = mashahirHead3;
	}

	public String getMashahirText3() {
		return mashahirText3;
	}

	public void setMashahirText3(String mashahirText3) {
		this.mashahirText3 = mashahirText3;
	}

	public String getMashahirHead4() {
		return mashahirHead4;
	}

	public void setMashahirHead4(String mashahirHead4) {
		this.mashahirHead4 = mashahirHead4;
	}

	public String getMashahirText4() {
		return mashahirText4;
	}

	public void setMashahirText4(String mashahirText4) {
		this.mashahirText4 = mashahirText4;
	}

	public String getMashahirHead5() {
		return mashahirHead5;
	}

	public void setMashahirHead5(String mashahirHead5) {
		this.mashahirHead5 = mashahirHead5;
	}

	public String getMashahirText5() {
		return mashahirText5;
	}

	public void setMashahirText5(String mashahirText5) {
		this.mashahirText5 = mashahirText5;
	}

	public Part getMashahirImg1() {
		return mashahirImg1;
	}

	public void setMashahirImg1(Part mashahirImg1) {
		this.mashahirImg1 = mashahirImg1;
	}

	public Part getMashahirImg2() {
		return mashahirImg2;
	}

	public void setMashahirImg2(Part mashahirImg2) {
		this.mashahirImg2 = mashahirImg2;
	}

	public Part getMashahirImg3() {
		return mashahirImg3;
	}

	public void setMashahirImg3(Part mashahirImg3) {
		this.mashahirImg3 = mashahirImg3;
	}

	public MashahirEntity findMashahirById(long mashahirId) {
		try {
			return mashahirServiceLocal.findMashahirById(mashahirId);
		} catch (Exception e) {
			System.err.println("mashahir not find");
			return null;
		}
	}

	public Part getMashahirImg4() {
		return mashahirImg4;
	}

	public void setMashahirImg4(Part mashahirImg4) {
		this.mashahirImg4 = mashahirImg4;
	}

	public Part getMashahirImg5() {
		return mashahirImg5;
	}

	public void setMashahirImg5(Part mashahirImg5) {
		this.mashahirImg5 = mashahirImg5;
	}

	public Part getMashahirImg6() {
		return mashahirImg6;
	}

	public void setMashahirImg6(Part mashahirImg6) {
		this.mashahirImg6 = mashahirImg6;
	}

	public void insertToMashahir() throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MashahirEntity mashahirEntity2 = new MashahirEntity();
		mashahirEntity2.setMashahirHead1(mashahirHead1);
		mashahirEntity2.setMashahirHead2(mashahirHead2);
		mashahirEntity2.setMashahirHead3(mashahirHead3);
		mashahirEntity2.setMashahirHead4(mashahirHead4);
		mashahirEntity2.setMashahirHead5(mashahirHead5);
		mashahirEntity2.setMashahirText1(mashahirText1);
		mashahirEntity2.setMashahirText2(mashahirText2);
		mashahirEntity2.setMashahirText3(mashahirText3);
		mashahirEntity2.setMashahirText4(mashahirText4);
		mashahirEntity2.setMashahirText5(mashahirText5);
		byte[] imgByte1 = IOUtils.toByteArray(mashahirImg1.getInputStream());
		byte[] imgByte2 = IOUtils.toByteArray(mashahirImg2.getInputStream());
		byte[] imgByte3 = IOUtils.toByteArray(mashahirImg3.getInputStream());
		byte[] imgByte4 = IOUtils.toByteArray(mashahirImg4.getInputStream());
		byte[] imgByte5 = IOUtils.toByteArray(mashahirImg5.getInputStream());
		byte[] imgByte6 = IOUtils.toByteArray(mashahirImg6.getInputStream());
		mashahirEntity2.setMashahirPic1(imgByte1);
		mashahirEntity2.setMashahirPic2(imgByte2);
		mashahirEntity2.setMashahirPic3(imgByte3);
		mashahirEntity2.setMashahirPic4(imgByte4);
		mashahirEntity2.setMashahirPic5(imgByte5);
		mashahirEntity2.setMashahirPic6(imgByte6);
		mashahirEntity2.setMashahirName(mashahirName);
		mashahirEntity2.setPersonField(mashahirField);
		mashahirEntity2.setInHead(isInHead);
		mashahirServiceLocal.insertToMashahir(mashahirEntity2);
		context.addMessage(null, new FacesMessage("Successful"));
	}

	public List<MashahirEntity> findAllMashahir() {
		try {
			return mashahirServiceLocal.findAllMashahir();
		} catch (Exception e) {
			System.err.println("mashahir not find");
			return null;
		}
	}

	@PostConstruct
	public void init() {
		this.mashahirFielsds.add("mashahir");
		this.mashahirFielsds.add("aza");
	}

	public void deleteMerchantEntity(long mashahirId) throws IOException {
		MashahirEntity mashahirEntity = new MashahirEntity();
		try {
			mashahirEntity = mashahirServiceLocal.findMashahirById(mashahirId);
			mashahirServiceLocal.deleteMashahirEntity(mashahirEntity);
		} catch (Exception e) {
			System.err.println("mashahir not find");
		}

		FacesContext.getCurrentInstance().getExternalContext().redirect("addmashahir.xhtml");
	}

	public void updateMashahirImg1(long mashahirId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MashahirEntity mashahirEntity = new MashahirEntity();

		try {
			mashahirEntity = mashahirServiceLocal.findMashahirById(mashahirId);
			byte[] img1Byte = IOUtils.toByteArray(mashahirImg1.getInputStream());
			mashahirEntity.setMashahirPic1(img1Byte);
			mashahirServiceLocal.updateMashahir(mashahirEntity);
		} catch (Exception e) {
			System.err.println("mashahir not find");
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mashahiredit.xhtml" + "?mashahirId=" + mashahirId);
	}

	public void updateMashahirImg2(long mashahirId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MashahirEntity mashahirEntity = new MashahirEntity();

		try {
			mashahirEntity = mashahirServiceLocal.findMashahirById(mashahirId);
			byte[] img2Byte = IOUtils.toByteArray(mashahirImg2.getInputStream());
			mashahirEntity.setMashahirPic2(img2Byte);
			mashahirServiceLocal.updateMashahir(mashahirEntity);
		} catch (Exception e) {
			System.err.println("mashahir not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mashahiredit.xhtml" + "?mashahirId=" + mashahirId);
	}

	public void updateMashahirImg3(long mashahirId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MashahirEntity mashahirEntity = new MashahirEntity();

		try {
			mashahirEntity = mashahirServiceLocal.findMashahirById(mashahirId);
			byte[] img3Byte = IOUtils.toByteArray(mashahirImg3.getInputStream());
			mashahirEntity.setMashahirPic3(img3Byte);
			mashahirServiceLocal.updateMashahir(mashahirEntity);
		} catch (Exception e) {
			System.err.println("mashahir not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mashahiredit.xhtml" + "?mashahirId=" + mashahirId);
	}

	public void updateMashahirImg4(long mashahirId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MashahirEntity mashahirEntity = new MashahirEntity();

		try {
			mashahirEntity = mashahirServiceLocal.findMashahirById(mashahirId);
			byte[] img4Byte = IOUtils.toByteArray(mashahirImg4.getInputStream());
			mashahirEntity.setMashahirPic4(img4Byte);
			mashahirServiceLocal.updateMashahir(mashahirEntity);
		} catch (Exception e) {
			System.err.println("mashahir not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mashahiredit.xhtml" + "?mashahirId=" + mashahirId);
	}

	public void updateMashahirImg5(long mashahirId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MashahirEntity mashahirEntity = new MashahirEntity();

		try {
			mashahirEntity = mashahirServiceLocal.findMashahirById(mashahirId);
			byte[] img5Byte = IOUtils.toByteArray(mashahirImg5.getInputStream());
			mashahirEntity.setMashahirPic5(img5Byte);
			mashahirServiceLocal.updateMashahir(mashahirEntity);
		} catch (Exception e) {
			System.err.println("mashahir not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mashahiredit.xhtml" + "?mashahirId=" + mashahirId);
	}

	public void updateMashahirImg6(long mashahirId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		MashahirEntity mashahirEntity = new MashahirEntity();

		try {
			mashahirEntity = mashahirServiceLocal.findMashahirById(mashahirId);
			byte[] img6Byte = IOUtils.toByteArray(mashahirImg6.getInputStream());
			mashahirEntity.setMashahirPic6(img6Byte);
			mashahirServiceLocal.updateMashahir(mashahirEntity);
		} catch (Exception e) {
			System.err.println("mashahir not find");
		}

		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("mashahiredit.xhtml" + "?mashahirId=" + mashahirId);
	}

}
