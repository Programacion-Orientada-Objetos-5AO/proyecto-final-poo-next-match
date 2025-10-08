package ar.edu.huergo.scaputo.sbigliardi.nextmatch.dto;

public class FootballAPIDTO {
    private int id;
    private String name;
    private String country;
    private int founded;             
    private String logo;
    private String venueName;
    private String venueSurface;
    private String venueAddress;
    private String venueCity;
    private int venueCapacity;    

    public FootballAPIDTO() {}

    // Getters y setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public int getFounded() { return founded; }
    public void setFounded(int founded) { this.founded = founded; }

    public String getLogo() { return logo; }
    public void setLogo(String logo) { this.logo = logo; }

    public String getVenueName() { return venueName; }
    public void setVenueName(String venueName) { this.venueName = venueName; }

    public String getVenueSurface() { return venueSurface; }
    public void setVenueSurface(String venueSurface) { this.venueSurface = venueSurface; }

    public String getVenueAddress() { return venueAddress; }
    public void setVenueAddress(String venueAddress) { this.venueAddress = venueAddress; }

    public String getVenueCity() { return venueCity; }
    public void setVenueCity(String venueCity) { this.venueCity = venueCity; }

    public int getVenueCapacity() { return venueCapacity; }
    public void setVenueCapacity(int venueCapacity) { this.venueCapacity = venueCapacity; }
}
