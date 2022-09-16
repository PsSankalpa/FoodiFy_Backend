package Foodify.Backend.model;

import java.nio.file.Path;
import java.time.LocalDateTime;

import java.util.List;
import java.util.Arrays;

import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//setter and getter for respective methods
//document annotation because using mongoDB 

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="restaurants")
public class Restaurant {
	
	@Id
	private String id;
	private String userId;
	private String userName;
	private String restaurantName;
	private Double rating;
	private String about;
	private String address;
	private String telephone;
	private String location;
	private String openHours;
	private LocalDateTime starttime;
	private LocalDateTime closeHour;
	private Binary logo;
	private Binary bannerImage;
	private String bImage;
	private String tempLogo;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public Double getRating() {
		return rating;
	}
	public void setRating(Double rating) {
		this.rating = rating;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getOpenHours() {
		return openHours;
	}
	public void setOpenHours(String openHours) {
		this.openHours = openHours;
	}
	public LocalDateTime getStarttime() {
		return starttime;
	}
	public void setStarttime(LocalDateTime starttime) {
		this.starttime = starttime;
	}
	public LocalDateTime getCloseHour() {
		return closeHour;
	}
	public void setCloseHour(LocalDateTime closeHour) {
		this.closeHour = closeHour;
	}
	public Binary getLogo() {
		return logo;
	}
	public void setLogo(Binary logo) {
		this.logo = logo;
	}
	public Binary getBannerImage() {
		return bannerImage;
	}
	public void setBannerImage(Binary binary) {
		this.bannerImage = binary;
	}
	public String getbImage() {
		return bImage;
	}
	public void setbImage(String bImage) {
		this.bImage = bImage;
	}
	
	public String getTempLogo() {
		return tempLogo;
	}
	public void setTempLogo(String tempLogo) {
		this.tempLogo = tempLogo;
	}
	@Override
	public String toString() {
		return "Restaurant [id=" + id + ", userId=" + userId + ", userName=" + userName + ", restaurantName="
				+ restaurantName + ", rating=" + rating + ", about=" + about + ", address=" + address + ", telephone="
				+ telephone + ", location=" + location + ", openHours=" + openHours + ", starttime=" + starttime
				+ ", closeHour=" + closeHour + ", logo=" + logo + ", bannerImage=" + bannerImage + ", bImage=" + bImage
				+ "]";
	}
	
}
