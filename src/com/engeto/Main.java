package com.engeto;

import java.text.ParseException;
import java.time.LocalDate;

public class Main {
    public static final String FILENAME = "kvetiny.txt";


    public static void main(String[] args) throws PlantExeption {
    ListPlant listOfPlant = new ListPlant();
        Plant test = new Plant ("Araucaria");
        Plant test2 = new Plant ("Muškát puget");
        test2.getWateringInfo();

    try {
        listOfPlant = ListPlant.importFromFile(FILENAME);
    }
    catch (PlantExeption e){
       System.err.println("Nepodařilo se načíst data ze souboru "+FILENAME+": "+e.getMessage());
    }

        listOfPlant.addPlant(test);
        listOfPlant.addPlant(test2);
        System.out.println(listOfPlant.toString());

        listOfPlant.removePlant(listOfPlant.getPlant(3));

        try{
            listOfPlant.exportToFile ("export.txt");
        }catch (PlantExeption e) {
            e.printStackTrace();}

        try {
            listOfPlant = ListPlant.importFromFile("export.txt");
        }
        catch (PlantExeption e){
            System.err.println("Nepodařilo se načíst data ze souboru " +e.getMessage());
        }
        System.out.println(listOfPlant.toString());

    }

}
