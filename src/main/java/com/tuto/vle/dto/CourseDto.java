package com.tuto.vle.dto;

import com.tuto.vle.domain.Course;
import com.tuto.vle.util.Status;

public class CourseDto {

	private Integer id;
	private String title;
	private String image;
	private java.math.BigDecimal rating;
	private java.math.BigDecimal price;
//  private String status;

	public CourseDto(Course course) {
		this.id = course.getCourseId();
		this.title = course.getCourseName();
		this.image = course.getCourseBanner();
		this.rating = course.getRating();
		this.price = course.getPrice();
//    this.name = course.getCourseName();
//    this.status = course.getStatus() == 1 ? Status.ACTIVE.toString() : Status.DEACTIVE.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public java.math.BigDecimal getRating() {
		return rating;
	}

	public void setRating(java.math.BigDecimal rating) {
		this.rating = rating;
	}

	public java.math.BigDecimal getPrice() {
		return price;
	}

	public void setPrice(java.math.BigDecimal price) {
		this.price = price;
	}


//  public String getName() {
//    return name;
//  }
//
//  public void setName(String name) {
//    this.name = name;
//  }

//  public String getStatus() {
//    return status;
//  }
//
//  public void setStatus(String status) {
//    this.status = status;
//  }

}
