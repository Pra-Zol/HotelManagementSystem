public class Amenity {
    private int amenityID;
    private String name;
    private String description;
    private double price;

    // default constructur
    public Amenity() {
        this.amenityID = 0;
        this.name = "unknown";
        this.description = "unknown";
        this.price = 0.0;
    }

    // parameterized constructyr
    public Amenity(int amenityID, String name, String description, double price) {
        this.amenityID = amenityID;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    // get and set method
    public int getAmenityID() {
        return amenityID;
    }

    public void setAmenityID(int amenityID) {
        this.amenityID = amenityID;

    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // tostring method
    @Override
    public String toString() {
        return "Amenity ID: " + amenityID + ", Name: " + name + ", Description: "
                + description + ", Price: $" + price;

    }

}
