package Modul3Practice;

import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
    Converter Converter = new Converter();

    int choose;
    private double value;

    public void setValue(double value) {
        this.value = value;
    }

    public double getValue(){
        return this.value;
    }
    public void Menu(){
        System.out.println("Yard Converter to M, CM, Feet, and Miles");
        System.out.println("1. Yard to M");
        System.out.println("2. Yard to CM");
        System.out.println("3. Yard to Feet");
        System.out.println("4. Yard to Miles");
        System.out.print("Pilih menu : ");
        choose = input.nextInt();

        switch (choose) {
            case 1 :
                Converter.valueToM();
                break;
            case 2 :
                Converter.valueToCM();
                break;
            case 3 :
                Converter.valueToFeet();
                break;
            case 4 :
                Converter.valueToMiles();
        }
    }
    public static void main (String[]args) {
        Main summon = new Main();

        summon.Menu();
    }
}