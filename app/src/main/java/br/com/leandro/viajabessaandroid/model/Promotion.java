package br.com.leandro.viajabessaandroid.model;

/**
 * Created by leandro on 5/3/15.
 */

public class Promotion
{

    private int id;
    private String imageurl;
    private String package_descripton;
    private String package_name;
    private String title;
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getPackage_descripton() {
        return package_descripton;
    }

    public void setPackage_descripton(String package_descripton) {
        this.package_descripton = package_descripton;
    }

    public String getPackage_name() {
        return package_name;
    }

    public void setPackage_name(String package_name) {
        this.package_name = package_name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
