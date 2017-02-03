/*
 * Copyright (c) 2017. Created by bfleyshe for the purpose of CMPUT 301. May not be redistributed or used without permission.
 */

package com.example.bfleyshe.bfleyshe_sizebook;

import java.util.Date;

/**
 * Created by bfleyshe on 2/1/17.
 */
public class Person {

    private String name;
    private Date date;
    private Integer neck;
    private Integer bust;
    private Integer chest;
    private Integer waist;
    private Integer hip;
    private Integer inseam;
    private String comment;

    /**
     * Instantiates a new Person with a Name.
     *
     * @param Name the name of the person
     */
    public Person(String Name) throws NameTooLongException{
        this.name = Name;
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
}
