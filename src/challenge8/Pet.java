package challenge8;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author zsnel
 */
public class Pet implements Comparable<Pet>{// implements comparable
    
    private String name, species;
    private int dOB;
    private long chipNum;

    public Pet(String name, String species, int dOB, long chipNum) {
        this.name = name;
        this.species = species;
        this.dOB = dOB;
        this.chipNum = chipNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public int getdOB() {
        return dOB;
    }

    public void setdOB(int dOB) {
        this.dOB = dOB;
    }

    public long getChipNum() {
        return chipNum;
    }

    public void setChipNum(long chipNum) {
        this.chipNum = chipNum;
    }

    @Override
    public String toString() {
        return "\nPet name = " + name + ", species = " + species + ", dOB = " + dOB + ", chipNum = " + chipNum;
    }
    
    
    public int compareTo(Pet other){
        if (this.dOB > other.dOB)
            return 1;
        else if(this.dOB < other.dOB)
            return -1;
        else 
            return this.getName().compareTo(other.getName());
        
            
    }
    
}
