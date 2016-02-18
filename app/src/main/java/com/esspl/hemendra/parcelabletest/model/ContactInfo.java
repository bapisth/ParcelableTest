package com.esspl.hemendra.parcelabletest.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by hemendra on 18-02-2016.
 */
public class ContactInfo implements Parcelable {
    private String name;
    private String address;
    private int index;

    public ContactInfo(String name, String address, int index) {
        this.name = name;
        this.address = address;
        this.index = index;
    }

    public ContactInfo(){}

    public ContactInfo(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {

        dest.writeString(name);
        dest.writeString(address);
        dest.writeInt(index);
    }

    public static final Parcelable.Creator<ContactInfo> CREATOR = new Creator<ContactInfo>() {
        @Override
        public ContactInfo createFromParcel(Parcel source) {
            return new ContactInfo(source);
        }

        @Override
        public ContactInfo[] newArray(int size) {
            return new ContactInfo[size];
        }
    };

    public ContactInfo(Parcel parcel){
        name = parcel.readString();
        address = parcel.readString();
        index = parcel.readInt();
    }
}
