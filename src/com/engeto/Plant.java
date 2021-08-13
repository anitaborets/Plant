package com.engeto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Plant {
    String name;
    String notes;
    LocalDate planted;
    LocalDate watering;
    Integer frequencyOfWatering;

//konstrutory
    public Plant(String name, String notes, LocalDate planted, LocalDate watering, Integer frequencyOfWatering) throws PlantExeption {
        this.name = name;
        this.notes = notes;
        this.planted = planted;
        setWatering (watering);
        setFrequencyOfWatering(frequencyOfWatering);
    }
    public Plant(String name, String notes, LocalDate watering) {
        this.name = name;
        this.notes = "";
        this.watering = LocalDate.now();
    }
    public Plant(String name) {
        this.name = name;
        this.notes = "";
        this.planted = LocalDate.now();
        this.watering = LocalDate.now();
        this.frequencyOfWatering = 7;
    }
    public Plant() throws PlantExeption    {

    }
//gettery a settery
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public LocalDate getPlanted() {
        return planted;
    }

    public void setPlanted(LocalDate planted) {
        this.planted = planted;
    }

    public LocalDate getWatering() {
        return watering;
    }

    public void setWatering(LocalDate watering) throws PlantExeption{

        this.watering = watering;
        if (planted.isAfter(watering)){
            throw new PlantExeption ("Datum zalivky nemoze byt pred zasadenim rastlinky");
        }
    }

    public int getFrequencyOfWatering() {
        return frequencyOfWatering;
    }

    public void setFrequencyOfWatering(Integer frequencyOfWatering) throws PlantExeption{
        if (frequencyOfWatering <=0)
        {
            throw new PlantExeption("Frekvence zalivky je zadana nespravne: " + frequencyOfWatering);
        }
        this.frequencyOfWatering = frequencyOfWatering;
    }
//datum dalsiho zalievania
    public void getWateringInfo(){
        LocalDate recomendedWatering = watering.plusDays(frequencyOfWatering);
    System.out.println("kvetina: " + name + ". " + "Datum poslednej zalivky: " + watering + " " + "doporucim zaliat: " + " " + recomendedWatering);

    }
//toString
    @Override
    public String toString() {
        return ""
                + "Kvetina: " + name
                + "  poznamka: " + notes
                + " zasadena: " + planted
                + " Datum poslednej zalivky:  " + watering
                + "  Frekvence zalivania  " + frequencyOfWatering + "\n";
    }
}