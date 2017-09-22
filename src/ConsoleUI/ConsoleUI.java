package ConsoleUI;

import Model.UserDataIteration;
import Model.UserDataSecant;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class ConsoleUI {

    // Model for storing user input
    BufferedReader br;

    public ConsoleUI()
    {
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public boolean printFixedPointIterationMeniu(UserDataIteration iterationData)
    {
        System.out.println("------Fixed point iteration Method------");
        System.out.println("Enter fixed point iteration method parameters");

        try{
            System.out.println("Initial guess, the closer the better: ");
            iterationData.intial_guess = Double.parseDouble(br.readLine());

            System.out.println("Desired precision: ");
            iterationData.precision = Double.parseDouble(br.readLine());

            System.out.println("Max derivative in chosen interval: ");
            iterationData.derivative = Double.parseDouble(br.readLine());

            System.out.println("Max iteration number: ");
            iterationData.max_iteration_number = Integer.parseInt(br.readLine());

        }catch(Exception nfe){
            System.err.println("Invalid Format! Please try again :)");
            return false;
        }

        System.out.println();

        return true;
    }

    public boolean printSecantMethodMeniu(UserDataSecant dataSecant)
    {
        System.out.println("------Secant Method------");
        System.out.println("Enter secant method parameters");

        try{
            System.out.println("First guess: ");
            dataSecant.first_guess = Double.parseDouble(br.readLine());

            System.out.println("Second guess: ");
            dataSecant.second_guess = Double.parseDouble(br.readLine());

            System.out.println("Desired precesion: ");
            dataSecant.precision = Double.parseDouble(br.readLine());

            System.out.println("Max iteration number: ");
            dataSecant.max_iteration_number = Integer.parseInt(br.readLine());

        }catch(Exception nfe){
            System.err.println("Invalid Format! Please try again :)");
            return false;
        }
        return true;
    }



    public void GreetingMessage()
    {
        System.out.println();
        System.out.println("Please enter parameters, equation to be solved: x = tang(x)");
        System.out.println("-----------------------------------------------------------");
        System.out.println();
    }
}
