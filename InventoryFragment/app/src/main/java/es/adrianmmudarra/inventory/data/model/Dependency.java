package es.adrianmmudarra.inventory.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.Objects;

@Entity
public class Dependency implements Parcelable {
    @Ignore
    public static final String TAG = "dependency";
    @NonNull
    private String name;
    @PrimaryKey
    @NonNull
    private String shortName;
    @NonNull
    private String description;
    @NonNull
    private String inventory;
    private String uriImage;

    @Ignore
    public Dependency() {
    }

    public Dependency(String name, String shortName, String description, String inventory, String uriImage) {
        this.name = name;
        this.shortName = shortName;
        this.description = description;
        this.inventory = inventory;
        this.uriImage = uriImage;
    }

    @Ignore
    protected Dependency(Parcel in) {
        name = in.readString();
        shortName = in.readString();
        description = in.readString();
        inventory = in.readString();
        uriImage = in.readString();
    }

    public static final Creator<Dependency> CREATOR = new Creator<Dependency>() {
        @Override
        public Dependency createFromParcel(Parcel in) {
            return new Dependency(in);
        }

        @Override
        public Dependency[] newArray(int size) {
            return new Dependency[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUriImage() {
        return uriImage;
    }

    public void setUriImage(String uriImage) {
        this.uriImage = uriImage;
    }

    public String getInventory() {
        return inventory;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return shortName;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(shortName);
        dest.writeString(description);
        dest.writeString(inventory);
        dest.writeString(uriImage);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dependency that = (Dependency) o;
        return shortName.equals(that.shortName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shortName);
    }
}
