package Modul3Practice;

import java.util.Scanner;

public class Converter {
    Scanner input = new Scanner(System.in);
    protected double valueToM;
    protected double valueToCM;
    protected double valueToFeet;
    protected double valueToMiles;

    public void setValueToM(double valueToM){
        this.valueToM = valueToM;
    }

    public double getValueToM() {
        return valueToM;
    }

    public void setValueToCM(double valueToCM) {
        this.valueToCM = valueToCM;
    }

    public double getValueToCM() {
        return valueToCM;
    }

    public void setValueToFeet(double valueToFeet) {
        this.valueToFeet = valueToFeet;
    }

    public double getValueToFeet() {
        return valueToFeet;
    }

    public void setValueToMiles(double valueToMiles) {
        this.valueToMiles = valueToMiles;
    }

    public double getValueToMiles() {
        return valueToMiles;
    }
    
    public void valueToM(){
        System.out.print("Masukkan Yard : ");
        setValueToM(input.nextDouble());
        System.out.println("Hasil konversi : " + (getValueToM() * 0.9144));
        
    }

    public void valueToCM(){
        System.out.print("Masukkan Yard : ");
        setValueToCM(input.nextDouble());
        System.out.println("Hasil konversi : " + getValueToCM() * 91.44);
        
    }

    public void valueToFeet(){
        System.out.print("Masukkan Yard : ");
        setValueToFeet(input.nextDouble());
        System.out.println("Hasil konversi : " + getValueToFeet() * 3);
    }

    public void valueToMiles(){
        System.out.print("Masukkan Yard : ");
        setValueToMiles(input.nextDouble());
        System.out.println("Hasil konversi : " + getValueToMiles() / 1760);
    }
}
