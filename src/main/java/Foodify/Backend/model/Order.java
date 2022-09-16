package Foodify.Backend.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

//import java.sql.Array;
import java.util.ArrayList;
import java.util.Date;

@Document(collection="Orders")
public class Order {

    @Id
    private String Id;

    private Date datetime;
    private ArrayList details;
    private String user;

    private float price;

    private String resId;


    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getId() { return Id.toString(); }

    public void setId(String id) { Id = id; }

    public Date getDatetime() { return datetime; }

    public void setDatetime(Date datetime) { this.datetime = datetime; }

    public ArrayList getDetails() { return details; }

    public void setDetails(ArrayList details) { this.details = details; }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user.toString();
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
};
