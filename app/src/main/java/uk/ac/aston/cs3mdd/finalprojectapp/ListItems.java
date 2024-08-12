package uk.ac.aston.cs3mdd.finalprojectapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class ListItems implements Comparable<ListItems>, Parcelable {

    private String name;
    private String Location;
    private int days;
    private String staying;
    private  String eating;
    private String POI;

    public ListItems(String name, String Location, int days, String staying, String eating, String POI) {
        this.name = name;
        this.Location = Location;
        this.days = days;
        this.staying = staying;
        this.eating = eating;
        this.POI = POI;
    }

    protected ListItems(Parcel in) {
        name = in.readString();
        Location = in.readString();
        days = in.readInt();
        staying = in.readString();
        eating = in.readString();
        POI = in.readString();
    }

    public static final Creator<ListItems> CREATOR = new Creator<ListItems>() {
        @Override
        public ListItems createFromParcel(Parcel in) {
            return new ListItems(in);
        }

        @Override
        public ListItems[] newArray(int size) {
            return new ListItems[size];
        }
    };


    @Override
    public int compareTo(ListItems another) {
        return this.getName().compareToIgnoreCase(another.getName());
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public int getDays() {
        return days;
    }
    public void setDays(int days) {
        this.days = days;
    }

    public String getStaying() {
        return staying;
    }
    public void setStaying(String staying) {
        this.staying = staying;
    }

    public String getEating() {
        return eating;
    }

    public void setEating(String eating) {
        this.eating = eating;
    }
    public String getPOI() {
        return POI;
    }

    public void setPOI(String POI) {
        this.POI = POI;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(Location);
        dest.writeInt(days);
    }
}
