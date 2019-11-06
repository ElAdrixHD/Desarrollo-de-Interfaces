package es.adrianmmudarra.inventory.data.model;

public class Dependency {
    private String name;
    private String shortname;
    private String description;
    private String UriImage;

    public Dependency(String name, String shortname, String description, String uriImage) {
        this.name = name;
        this.shortname = shortname;
        this.description = description;
        UriImage = uriImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortname() {
        return shortname;
    }

    public void setShortname(String shortname) {
        this.shortname = shortname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUriImage() {
        return UriImage;
    }

    public void setUriImage(String uriImage) {
        UriImage = uriImage;
    }

    @Override
    public String toString() {
        return name;
    }
}
