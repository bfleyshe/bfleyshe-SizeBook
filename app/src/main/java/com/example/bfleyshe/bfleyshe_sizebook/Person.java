/*
 * Copyright (c) 2017. Created by bfleyshe for the purpose of CMPUT 301. May not be redistributed or used without permission.
 */

package com.example.bfleyshe.bfleyshe_sizebook;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;

/**
 * Created by bfleyshe on 2/1/17.
 */
public class Person implements Parcelable{

    private String name;
    private Date date;
    private Integer neck = 0;
    private Integer bust = 0;
    private Integer chest = 0;
    private Integer waist = 0;
    private Integer hip = 0;
    private Integer inseam = 0;
    private String comment = "None";

    /**
     * Instantiates a new Person with a Name.
     *
     * @param Name the name of the person
     */
    public Person(String Name) throws NameTooLongException{
        this.name = Name;
        setDate(new Date());
    }

    /**
     * Gets name of the person.
     *
     * @return the name of the person
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the person.
     *
     * @param name the name of the person
     */
    public void setName(String name) throws NameTooLongException{
        if (name.length() > 30) {
            throw new NameTooLongException();
        }
        this.name = name;
    }

    /**
     * Gets date.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Sets date.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets neck circumference in inches.
     *
     * @return the neck circumference in inches
     */
    public Integer getNeck() {
        return neck;
    }

    /**
     * Sets neck circumference in inches.
     *
     * @param neck measurement of circumference in inches
     */
    public void setNeck(Integer neck) {
        this.neck = neck;
    }

    /**
     * Gets bust circumference in inches.
     *
     * @return the bust circumference in inches
     */
    public Integer getBust() {
        return bust;
    }

    /**
     * Sets bust circumference in inches.
     *
     * @param bust measurement of circumference in inches
     */
    public void setBust(Integer bust) {
        this.bust = bust;
    }

    /**
     * Gets chest circumference in inches.
     *
     * @return the chest circumference in inches
     */
    public Integer getChest() {
        return chest;
    }

    /**
     * Sets chest circumference in inches.
     *
     * @param chest measurement of circumference in inches
     */
    public void setChest(Integer chest) {
        this.chest = chest;
    }

    /**
     * Gets waist measurement in inches.
     *
     * @return the waist circumference in inches
     */
    public Integer getWaist() {
        return waist;
    }

    /**
     * Sets waist circumference in inches.
     *
     * @param waist measurement of circumference in inches
     */
    public void setWaist(Integer waist) {
        this.waist = waist;
    }

    /**
     * Gets hip circumference in inches.
     *
     * @return the hip circumference in inches
     */
    public Integer getHip() {
        return hip;
    }

    /**
     * Sets hip circumference.
     *
     * @param hip measurement of circumference in inches
     */
    public void setHip(Integer hip) {
        this.hip = hip;
    }

    /**
     * Gets inseam measurement of length in inches.
     *
     * @return the inseam length in inches
     */
    public Integer getInseam() {
        return inseam;
    }

    /**
     * Sets inseam length in inches.
     *
     * @param inseam measurement of length in inches
     */
    public void setInseam(Integer inseam) {
        this.inseam = inseam;
    }

    /**
     * Gets comment about person.
     *
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets comment.
     *
     * @param comment a comment about the person
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public String toString(){
        return name;
    }


    //Passing parcel object for intent, gotten Feb 3rd, 17:27
    //http://stackoverflow.com/questions/2139134/how-to-send-an-object-from-one-android-activity-to-another-using-intents

    @Override
    public int describeContents() {
        return 0;
    }

    // write my object's data to the passed-in Parcel
    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeString(getName());
        //out.writeString(date.toString());

        out.writeInt(getNeck());
        out.writeInt(getBust());
        out.writeInt(getChest());
        out.writeInt(getWaist());
        out.writeInt(getHip());
        out.writeInt(getInseam());
        out.writeString(getComment());
    }

    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Person(Parcel in) {
        name = in.readString();/*
        DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        try {
            date = (Date)formatter.parse(in.readString());
        } catch (ParseException e) {
            e.printStackTrace();
        }*/
        neck = in.readInt();
        bust = in.readInt();
        chest = in.readInt();
        waist = in.readInt();
        hip = in.readInt();
        inseam = in.readInt();
        comment = in.readString();

    }
}
