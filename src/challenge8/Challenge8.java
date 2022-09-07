/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * (Use Javadoc tags to document your code too.
 *
 * @Zachariah Nelson (3645888)
 *  
 *  Title:challenge4  
* 
* Semester: COP3804 - Spring 2022    
* Lecturer's Name:  Cristy Charters
*   Description of Program’s Functionality:
*   allows user to add microchips, a cat or a dog. also allows  user to adopt an animal either the oldest one in the shelter or by species.
* and allows you to view all the animals you have in the shelter
*
*/
package challenge8;

import java.text.DecimalFormat;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author zsnel
 */

public class Challenge8 {

    /**
     * @param args the command line arguments
     */
    //these are globle queues and stacks and priority queue
    public static Scanner scnr = new Scanner(System.in);
    public static Queue<Pet> cats = new LinkedList<Pet>();
    public static Queue<Pet> dogs = new LinkedList<Pet>();
    public static PriorityQueue<Pet> animals= new PriorityQueue<Pet>();
    public static Stack<Long> microChips = new Stack<Long>();
    
// main method calls the menu method that handles everything
    public static void main(String[] args) 
    {
            menu();
    }
    //creates 100 new microchips when the user needs more
    public static void pushMicroChip()
    {  
        if(!microChips.empty()){
        System.out.println("Are you sure you want to enter More MicroChips? ");
        String userInput = scnr.next();
            while(userInput.equalsIgnoreCase("yes"))
            {
                for(int i = 0; i < 100; i++)
                {
                    microChips.push(System.nanoTime());
                }
                System.out.println("you have added 100 microchips.");
                break;
            }
        }
        else 
        {
            for(int i = 0; i < 100; i++)
            {
                microChips.push(System.nanoTime());
            } 
            System.out.println("you have added 100 microchips.");
        }
    }
    //allows the user to donate a cat and put in the cats info also makes sure the user doesnt input wrong information like letters where you need numbers
   //creates a new pet and stors it in the cat queue and animal priority queue
    public static void donateCat()
    {
        DecimalFormat df = new DecimalFormat("00");
        int year = 0 ,month = 0,day = 0;
        if(microChips.empty() == true)
        {
            System.out.println("Please add more microChips");           
        }
        else
        {
            System.out.println("What is your cat name");
            String name = scnr.next();
            String species = "cat";
            boolean error = false;
            do
            {
                do
                {    
                    try 
                    {
                        System.out.println("What year was your cat year of birth? (YYYY)");
                        year = scnr.nextInt();
                        error = false;
                        while(year > 2022 || year < 2000)
                        {
                            System.out.println("Your animal can't have been born that year please enter a new year");
                            scnr.nextLine();
                            year = scnr.nextInt();
                            error = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                do
                {
                    System.out.println("What month was your cat born? (mm)");
                    try
                    {
                        month = scnr.nextInt();
                        error = false;
                        while(month < 1 || month > 12)
                        {
                            System.out.println("Please enter a valid month. ");
                            scnr.nextLine();
                            month = scnr.nextInt();
                            error = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                do  
                {
                    System.out.println("What Day was your cat born? (dd)");
                    try
                    {
                        day = scnr.nextInt();
                        error = false;
                        while (day < 1 || day > 31)
                        {
                            System.out.println("Please enter a valid day. ");
                            scnr.nextLine();
                            day = scnr.nextInt();
                            error = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                String yr = String.valueOf(year);
                String mth = df.format(month);
                String dy = df.format(day);
                String date = (yr + mth + dy);
                int dOB = Integer.parseInt(date);
                long chipNum = microChips.pop(); 
                Pet cat = new Pet(name, species, dOB, chipNum);
                cats.add(cat);
                animals.add(cat); 
            }while(error);
        }
    }
     //allows the user to donate a dog and put in the dogs info also makes sure the user doesnt input wrong information like letters where you need numbers
   //creates a new pet and stors it in the dog queue and animal priority queue
    public static void donateDog()
    {
        DecimalFormat df = new DecimalFormat("00");
        int year = 0 ,month = 0,day = 0;
        if(microChips.empty() == true)
        {
            System.out.println("Please add more microChips");           
        }
        else
        {
            System.out.println("What is your dog name");
            String name = scnr.next();
            String species = "dog";
            boolean error = false;
            do
            {
                do
                {    
                    try 
                    {
                        System.out.println("What year was your dog year of birth? (YYYY)");
                        year = scnr.nextInt();
                        error = false;
                        while(year > 2022 || year < 2000)
                        {
                            System.out.println("Your animal can't have been born that year please enter a new year");
                            scnr.nextLine();
                            year = scnr.nextInt();
                            error = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                do
                {
                    System.out.println("What month was your dog born? (mm)");
                    try
                    {
                        month = scnr.nextInt();
                        error = false;
                        while(month < 1 || month > 12)
                        {
                            System.out.println("Please enter a valid month. ");
                            scnr.nextLine();
                            month = scnr.nextInt();
                            error = false;
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                do
                {
                    System.out.println("What Day was your dog born? (dd)");
                    try
                    {
                        day = scnr.nextInt();
                        error = false;
                        while (day < 1 || day > 31)
                        {
                            System.out.println("Please enter a valid day. ");
                            scnr.nextLine();
                            day = scnr.nextInt();
                            error = false;
                    
                        }
                    }
                    catch(InputMismatchException e)
                    {
                        System.out.println("Please enter a number value");
                        scnr.nextLine();
                        error = true;
                    }
                }while(error);
                String yr = String.valueOf(year);
                String mth = df.format(month);
                String dy = df.format(day);
                String date = (yr + mth + dy);
                int dOB = Integer.parseInt(date);
                long chipNum = microChips.pop(); 
                Pet dog = new Pet(name, species, dOB, chipNum);
                dogs.add(dog);
                animals.add(dog); 
            }while(error);
        }
    }
//checks if you have cats then pulls first cat then searches for that cat in the animal shelter queue and removes it
    public static void adoptCat()
    {
        if(cats.peek() == null)
        {
            System.out.println("There are no cats to adopt");
        }
        else
        {
            Pet adoptedCat = cats.poll();
            System.out.println("the cat you addopted is " + adoptedCat);
            animals.remove(adoptedCat);
        }
    }
    //checks to see if you have dogs and then pulls first dog out then searches for the dog in the animal queue and removes it.
    public static void adoptDog()
    {
        if(dogs.peek() == null)
        {
            System.out.println("There are no dogs to adopt");
        }
        else
        {
            Pet adoptedDog = dogs.poll();
            System.out.println("The dog you addopted id " + adoptedDog);
            animals.remove(adoptedDog);  
        }
    }
    //takes the oldes animal out of the shelter then removes all dogs or cats until it finds the matching one in their queues and removes it 
    //then makes that temporary queue the dog or cat queue
    public static void adoptAnimal()
    {
        if(animals.peek() == null)
        {
            System.out.println("There are no animals in the shelter.");           
        }
        else
        {
            Pet adoptedAnimal = animals.remove();
            System.out.println("The animal you adopted is " + adoptedAnimal);
            Queue<Pet> temp = new LinkedList<Pet>();
            if(adoptedAnimal.getSpecies().equals("dog"))
            {
                while(adoptedAnimal != dogs.peek())
                {
                    temp.add(dogs.poll());
                }
                dogs = temp;
            }
            else if(adoptedAnimal.getSpecies().equals("cat"))
            {
                while(adoptedAnimal != cats.peek())
                {
                    temp.add(cats.poll());
                }
                cats = temp;
            }
        }
    }
    //shows the user what pets are in the shelter and splits them up between dogs and cats as well
    public static void showPets()
    {
        System.out.println("All the animals we have");
        System.out.println(animals);
        System.out.println("All the dogs we have");
        System.out.println(dogs);
        System.out.println("All the cats we have");
        System.out.println(cats);
    }
    //asks user what they want to do and whatever they answer goes to the switch case which calls the other methods.
    public static void menu()
    {
        int option = -1;
        do
        {
            System.out.println("What would you like to do?");
            System.out.println("0 = Add new microchip");
            System.out.println("1 = Donate a cat");
            System.out.println("2 = Donate a dog");
            System.out.println("3 = Adopt a cat");
            System.out.println("4 = Adopt a dog");
            System.out.println("5 = Adopt oldest pet");
            System.out.println("6 = Show animals");
            System.out.println("7 = Exit");
            try
            {
                option = scnr.nextInt();
                switch(option)
                {
                    case 0:
                        pushMicroChip();
                        break;
                    case 1:
                        donateCat();
                        break;
                    case 2:
                        donateDog();
                        break;
                    case 3:
                        adoptCat();
                        break;
                    case 4:
                        adoptDog();
                        break;
                    case 5:
                        adoptAnimal();
                        break;
                    case 6:
                        showPets();
                        break;
                    case 7:
                        System.out.println("Thanks for visiting!");   
                        break;
                    default:
                        System.out.println("The number needs to be between 0 and 7.");
                }
            }
            catch(InputMismatchException e)
            {
                System.out.println("Please enter a number 0 - 7");
                scnr.nextLine();
            }
        }while(option != 7 || option < 0 && option > 7);
    }
    
}
