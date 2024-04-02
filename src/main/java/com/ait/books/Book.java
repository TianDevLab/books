package com.ait.books;
import jakarta.xml.bind.annotation.XmlRootElement;


@XmlRootElement
public class Book {

	private int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private String title;
    
    private String author;

    private String format;

    private String publicationDate;

    private String publisher;

    private String publisherURL;
    
    private String image;
    
    private String imageThumb;
    
    private String review;


	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title=title;
	}

	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author=author;
	}
	
	
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format=format;
	}


	public String getPublicationDate() {
		return publicationDate;
	}
	public void setPublicationDate(String publicationDate) {
		this.publicationDate=publicationDate;
	}

	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher=publisher;
	}

	public String getPublisherURL() {
		return publisherURL;
	}
	
	public void setPublisherURL(String publisherURL) {
		this.publisherURL=publisherURL;
	}
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image=image;
	}

	public String getReview() {
		return review;
	}
	
	public void setReview(String review) {
		this.review=review;
	}

	public String getImageThumb() {
		return imageThumb;
	}

	public void setImageThumb(String imageThumb) {
		this.imageThumb = imageThumb;
	}

}


