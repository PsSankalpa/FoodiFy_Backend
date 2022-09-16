package Foodify.Backend.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Document(collection="FoodMenu")

public class FoodMenu {

    @Id
	private String id;
    private String userName;
    @NotNull(message = "Food Menu Name cannot be null")
	private String foodMenuName;
	@NotNull(message = "Food Menu Description cannot be null")
	private String foodMenuDes;
	
    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

    public String getUsername() {
		return userName;
	}
	public void setUsername(String userName) {
		this.userName = userName;
	}

    public String getfoodMenuName() {
		return foodMenuName;
	}
	public void setfoodMenuName(String foodMenuName) {
		this.foodMenuName = foodMenuName;
	}

    public String getfoodMenuDes() {
		return foodMenuDes;
	}
	public void setfoodMenuDes(String foodMenuDes) {
		this.foodMenuDes = foodMenuDes;
	}
    
}
