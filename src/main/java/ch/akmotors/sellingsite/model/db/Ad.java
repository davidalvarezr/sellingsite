package ch.akmotors.sellingsite.model.db;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
public class Ad {
    @Id
    private String id;
    @TextIndexed // --> To use the search
    private String title;
    @TextIndexed
    private String description;
    private Date publicationDate;
    private int priceCHF; // CHF
    private String[] images;
    private int imageNb;
    private boolean deleted = false;
    private boolean sold = false;

    // Only one of them can exist others must be null
    private Car car;
    private TwoWheelers twoWheelers;
    private Bike bike;

    public Ad(String id, String title, String description, int priceCHF, int imageNb, Car car, TwoWheelers twoWheelers, Bike bike) throws Exception {
        this.id = id;
        this.title = title;
        this.description = description;
        this.priceCHF = priceCHF;
        this.imageNb = imageNb;
        this.car = car;
        this.twoWheelers = twoWheelers;
        this.bike = bike;

        checkConsistency();
    }

    /**
     * Check whether only one type of vehicle is given
     *
     * @throws Exception
     */
    private void checkConsistency() throws Exception {
        int counter = 0;
        if (car != null) ++counter;
        if (twoWheelers != null) ++counter;
        if (bike != null) ++counter;

        if (counter == 0) throw new Exception("Must have one vehicle in the ad, zero given");
        if (counter > 1) throw new Exception("Must have one vehicle in the ad, " + counter + " given");
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Date publicationDate) {
        this.publicationDate = publicationDate;
    }

    public int getPriceCHF() {
        return priceCHF;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }

    public int getImageNb() {
        return imageNb;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public Car getCar() {
        return car;
    }

    public TwoWheelers getTwoWheelers() {
        return twoWheelers;
    }

    public Bike getBike() {
        return bike;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }
}
