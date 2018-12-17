package e.juanluis.mvc_apidemo.data;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FlowerModel {


    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("category")
    @Expose
    private String category;

    @SerializedName("productId")
    @Expose
    private String productId;

    @SerializedName("price")
    @Expose
    private String price;

    @SerializedName("instructions")
    @Expose
    private String instructions;

    @SerializedName("photo")
    @Expose
    private String photo;

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getProductId() {
        return productId;
    }

    public String getPrice() {
        return price;
    }

    public String getInstructions(){
        return instructions;
    }

    public String getPhoto() {
        return photo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setInstructions(String introduction) {
        this.instructions = introduction;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
