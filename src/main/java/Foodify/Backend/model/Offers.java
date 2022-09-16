package Foodify.Backend.model;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
//@NoArgsConstructor
@Document(collection="offers")
public class Offers {
	
	@Id
	private String id;
	private String userName;
	private String name;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private String category;
	private List<String> items;
	private int discount;
	private Binary image;
	private String tempImage;
	
	
	public Offers() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}

	
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public LocalDate getStartDate() {
		return startDate;
	}


	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}


	public LocalDate getEndDate() {
		return endDate;
	}


	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public List<String> getItems() {
		return items;
	}


	public void setItems(List<String> items) {
		this.items = items;
	}


	public int getDiscount() {
		return discount;
	}


	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public Binary getImage() {
		return image;
	}


	public void setImage(Binary image) {
		this.image = image;
	}
	
	
	public String getTempImage() {
		return tempImage;
	}


	public void setTempImage(String tempImage) {
		this.tempImage = tempImage;
	}


	@Override
	public String toString() {
		return "Offers [id=" + id + ", name=" + name + ", description=" + description + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", category=" + category + ", items=" + items + ", discount=" + discount
				+ ", image=" + image + "]";
	}
	
	

}
