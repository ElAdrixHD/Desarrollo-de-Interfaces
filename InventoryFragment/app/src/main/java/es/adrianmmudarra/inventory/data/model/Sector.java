package es.adrianmmudarra.inventory.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;
import static androidx.room.ForeignKey.RESTRICT;

@Entity(foreignKeys = @ForeignKey(entity = Dependency.class,
        parentColumns = "shortName",
        childColumns = "dependencia",
        onDelete = CASCADE))
public class Sector implements Parcelable {

    @Ignore
    public static final String TAG = "Sector";
    @NonNull
    private String name;
    @PrimaryKey
    @NonNull
    private String shortname;
    @NonNull
    private String description;
    @NonNull
    private String dependencia;
    private String uriImage;

    @Ignore
    public Sector() {
    }

    public Sector(String name, String shortname, String description, String dependencia, String uriImage) {
        this.name = name;
        this.shortname = shortname;
        this.description = description;
        this.dependencia = dependencia;
        this.uriImage = uriImage;
    }

    @Ignore
    protected Sector(Parcel in) {
        name = in.readString();
        shortname = in.readString();
        description = in.readString();
        dependencia = in.readString();
        uriImage = in.readString();
    }

    public static final Creator<Sector> CREATOR = new Creator<Sector>() {
        @Override
        public Sector createFromParcel(Parcel in) {
            return new Sector(in);
        }

        @Override
        public Sector[] newArray(int size) {
            return new Sector[size];
        }
    };

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

    public String getDependencia() {
        return dependencia;
    }

    public void setDependencia(String dependencia) {
        this.dependencia = dependencia;
    }

    public String getUriImage() {
        return uriImage;
    }

    public void setUriImage(String uriImage) {
        this.uriImage = uriImage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(shortname);
        dest.writeString(description);
        dest.writeString(dependencia);
        dest.writeString(uriImage);
    }
}
