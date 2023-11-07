package mk.finki.ukim.museumapp.PipeAndFilter.model;

import lombok.Data;

//MUSEUM CLASS
@Data
public
class Museum {
    @Override
    public String toString() {
        return "Museum{" +
                "name='" + name + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", street='" + street + '\'' +
                ", email='" + email + '\'' +
                ", internetAccess='" + internetAccess + '\'' +
                ", wikidata='" + wikidata + '\'' +
                ", openingHours='" + openingHours + '\'' +
                ", phone='" + phone + '\'' +
                ", fee='" + fee + '\'' +
                ", charge='" + charge + '\'' +
                ", website='" + website + '\'' +
                '}';
    }

    private String name;
    private double latitude;
    private double longitude;
    private String street;
    private String email;
    private String internetAccess;
    private String wikidata;
    private String openingHours;
    private String phone;
    private String fee;
    private String charge;
    private String website;

    public Museum(
            String name,
            double latitude,
            double longitude,
            String street,
            String email,
            String internetAccess,
            String wikidata,
            String openingHours,
            String phone,
            String fee,
            String charge,
            String website
    ) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.email = email;
        this.internetAccess = internetAccess;
        this.wikidata = wikidata;
        this.openingHours = openingHours;
        this.phone = phone;
        this.fee = fee;
        this.charge = charge;
        this.website = website;
    }

}
