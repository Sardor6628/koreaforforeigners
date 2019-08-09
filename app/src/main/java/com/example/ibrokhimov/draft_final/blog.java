package com.example.ibrokhimov.draft_final;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Ibrokhimov on 12/15/2017.
 */

public class blog {

    private String title, Description, ContactNumber,image;
    public blog(){

    }




    public blog(String title, String description, String contactNumber, String image) {
        this.title = title;
        Description = description;
        ContactNumber = contactNumber;
        this.image = image;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getContactNumber() {
        return ContactNumber;
    }

    public void setContactNumber(String contactNumber) {
        ContactNumber = contactNumber;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
