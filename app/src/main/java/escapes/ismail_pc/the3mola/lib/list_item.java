package escapes.ismail_pc.the3mola.lib;

/**
 * Created by ismail on 10/22/2015.
 */
public class list_item {

    private  String title="";
    private  String des="";
    private  String image="";
    private String id="";


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


    public String getID() {
        return id;
    }

    public void setID(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.title;
    }

}
