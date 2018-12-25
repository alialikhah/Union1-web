package jsfui;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.Column;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;
import dao.entity.NewsEntity;
import service.NewsServiceLocal;
import service.SingletonServiceLocal;
import javax.faces.context.FacesContext;

@Named
@RequestScoped
public class NewsBean {

	public NewsBean() {
		// TODO Auto-generated constructor stub
	}

	@Inject
	private NewsServiceLocal newsServiceLocal;
	@Inject
	private SingletonServiceLocal singletonServiceLocal;

	private String category;
	private String title;
	private String author;
	private Date date;
	private String head;
	private String description;
	private Part imageSmall;
	private Part imageBig1;
	private boolean important;
	private boolean veryImportant;
	private boolean parvane;
	private boolean govahiname;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getHead() {
		return head;
	}

	public void setHead(String head) {
		this.head = head;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Part getImageSmall() {
		return imageSmall;
	}

	public void setImageSmall(Part imageSmall) {
		this.imageSmall = imageSmall;
	}

	public Part getImageBig1() {
		return imageBig1;
	}

	public void setImageBig1(Part imageBig1) {
		this.imageBig1 = imageBig1;
	}

	public boolean isImportant() {
		return important;
	}

	public void setImportant(boolean important) {
		this.important = important;
	}

	public boolean isVeryImportant() {
		return veryImportant;
	}

	public void setVeryImportant(boolean veryImportant) {
		this.veryImportant = veryImportant;
	}

	public boolean isParvane() {
		return parvane;
	}

	public void setParvane(boolean parvane) {
		this.parvane = parvane;
	}

	public boolean isGovahiname() {
		return govahiname;
	}

	public void setGovahiname(boolean govahiname) {
		this.govahiname = govahiname;
	}

	public void insertToNews() {
		NewsEntity newsEntity = new NewsEntity();
		newsEntity.setAuthor(author);
		newsEntity.setCategory(category);
		newsEntity.setDate(new Date());
		newsEntity.setDescription(description);
		newsEntity.setHead(head);
		newsEntity.setTitle(title);
		newsEntity.setImportant(important);
		newsEntity.setVeryImportant(veryImportant);
		newsEntity.setGovahiname(govahiname);
		newsEntity.setParvane(parvane);
		try {
			byte[] small = IOUtils.toByteArray(imageSmall.getInputStream());
			newsEntity.setImageSmall(small);
		} catch (Exception e) {
			newsEntity.setImageSmall(null);
		}
		try {
			byte[] big1 = IOUtils.toByteArray(imageBig1.getInputStream());
			newsEntity.setImageBig1(big1);
		} catch (Exception e) {
			newsEntity.setImageBig1(null);
		}
		newsServiceLocal.insertToNews(newsEntity);

	}

	public NewsEntity findNewsById(long newsId) {
		// return newsServiceLocal.findNewsById(newsId);
		NewsEntity newsEntity = new NewsEntity();
		for (NewsEntity newsEntityX : singletonServiceLocal.getNewsEntities()) {
			if (newsEntityX.getNewsId() == newsId)
				newsEntity = newsEntityX;
		}
		return newsEntity;
	}

	public List<NewsEntity> findAllNews() {
		return singletonServiceLocal.getNewsEntities();
	}
	
	public List<NewsEntity> findAllNews2(){
		return newsServiceLocal.findAllNews();
	}

	public List<NewsEntity> findAllImportant() {
		return singletonServiceLocal.getNewsEntitiesImportant();
	}

	public List<NewsEntity> findAllVeryImportant() {
		return singletonServiceLocal.getNewsEntitiesVeryImportant();
	}

	public List<NewsEntity> findAllParvane() {
		return singletonServiceLocal.getNewsEntitiesParvane();
	}

	public List<NewsEntity> findAllGovahiname() {
		return singletonServiceLocal.getNewsEntitiesGovahiname();
	}
	
	public void deleteNews(long newsId) throws IOException {
		FacesContext context = FacesContext.getCurrentInstance();
		NewsEntity newsEntity=new NewsEntity();
		newsEntity=this.findNewsById(newsId);
		newsServiceLocal.deleteNews(newsEntity);
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("addnews.xhtml");
	}

}
