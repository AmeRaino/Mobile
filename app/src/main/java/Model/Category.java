package Model;

public class Category {
    private String nameCategory;
    private Integer imgCategory;
    private String backgroundCategory;

    public Category(String nameCategory, Integer imgCategory, String backgroundCategory) {
        this.nameCategory = nameCategory;
        this.imgCategory = imgCategory;
        this.backgroundCategory = backgroundCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public Integer getImgCategory() {
        return imgCategory;
    }

    public void setImgCategory(Integer imgCategory) {
        this.imgCategory = imgCategory;
    }

    public String getBackgroundCategory() {
        return backgroundCategory;
    }

    public void setBackgroundCategory(String backgroundCategory) {
        this.backgroundCategory = backgroundCategory;
    }
}
