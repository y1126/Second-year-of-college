package qsap;
public class qsap {
    String id;
    String name;
    String place;

    public qsap(String id,String name,String place)
    {
        this.id=id;
        this.name=name;
        this.place=place;
    }


    public qsap(String name,String place)
    {

        this.name=name;
        this.place=place;
    }

    public void setId(String id) {
        this.id=id;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setPlace(String place) {
        this.place=place;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlace() {
        return place;
    }
}
