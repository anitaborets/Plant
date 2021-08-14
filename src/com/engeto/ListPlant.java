package com.engeto;

import java.io.*;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ListPlant {
    ArrayList<Plant> listPlant = new ArrayList<>();
    public static final String DELIMITER = ";";;
    
    public void addPlant(Plant newPlant) {
        listPlant.add(newPlant);
    }

    public void removePlant(Plant plant) {
        listPlant.remove(plant);
    }

    public Plant getPlant(int index) {
        return listPlant.get(index);
    }

    public static ListPlant importFromFile(String fileName) throws PlantExeption {
        ListPlant list = new ListPlant();
        try (Scanner scanner = new Scanner(new FileInputStream(fileName))) {
            while (scanner.hasNextLine()) {
                String input = scanner.nextLine();
                String[] items = input.split(DELIMITER);

                    Plant plant = new Plant();
                    plant.setName(items[0]);
                    plant.setNotes(items[1]);
                    plant.setFrequencyOfWatering(Integer.parseInt(items[2]));
                    plant.setPlanted(LocalDate.parse(items[3]));
                    plant.setWatering(LocalDate.parse(items[4]));
                    list.addPlant(plant);

            }
        } catch (FileNotFoundException e) {
            throw new PlantExeption("Soubor nenalezen: ");
                    }

        return list;
    }

    public void exportToFile(String filename) throws PlantExeption {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))) {
            for (Plant plant : listPlant){
                writer.println(
                        plant.getName()+DELIMITER
                        +plant.getNotes()+DELIMITER
                        +plant.getFrequencyOfWatering()+DELIMITER
                        +plant.getPlanted()+DELIMITER
                        +plant.getWatering()
                );
            }
        }
        catch (FileNotFoundException e) {
            throw new PlantExeption("Soubor " + filename + " nenalezen: " + e.getLocalizedMessage());
        }
    }

    public int getNumber() {
        return listPlant.size();
    }

    @Override
    public String toString() {
        return "zoznam kvetin" +
                " :" + listPlant +
                " ";
    }
}


