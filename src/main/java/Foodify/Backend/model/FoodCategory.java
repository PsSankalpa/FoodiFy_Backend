package Foodify.Backend.model;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.bson.types.Binary;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@Document(collection="FoodMenuCategory")
public class FoodCategory {
    
    @Id
	private String id;
    private String menuId;
	@NotNull(message = "Food Category cannot be null")
    private String foodMenuCategory;
	@NotNull(message = "Food Category Description cannot be null")
	private String foodMenuCategoryDes;
	private Binary image;
	

    public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

    public String getmenuId() {
		return menuId;
	}
	public String setmenuId(String menuId) {
		return this.menuId = menuId;
	}

    public String getfoodMenuCategory() {
		return foodMenuCategory;
	}
	public void setfoodMenuCategory(String foodMenuCategory) {
		this.foodMenuCategory = foodMenuCategory;
	}

    public String getfoodMenuCategoryDes() {
		return foodMenuCategoryDes;
	}
	public void setfoodMenuCategoryDes(String foodMenuCategoryDes) {
		this.foodMenuCategoryDes = foodMenuCategoryDes;
	}

	public Binary getImage() {
		return image;
	}
	public Binary setImage(Binary image) {
		return this.image = image;
	}
	
}
