package com.example.group_project_mobile;

public class Food {
  private  String type ;
  private  int description ;
  private  int image ;

    public Food(String type, int description, int image) {
        this.type = type;
        this.description = description;
        this.image = image;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getDescription() {
        return description;
    }

    public void setDescription(int description) {
        this.description = description;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
