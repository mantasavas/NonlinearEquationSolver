import ConsoleUI.ConsoleUI;
import Model.UserDataIteration;
import Model.UserDataSecant;
import NumericalMethods.NonLinearMethod;
import NumericalMethods.NonLinearMethodFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ConsoleUI userUI = new ConsoleUI();

        // Greeting user message
        userUI.GreetingMessage();

        // Asking user for iteration method info
        UserDataIteration userIterationData = new UserDataIteration();
        userUI.printFixedPointIterationMeniu(userIterationData);

        // Asking user for secant method info
        UserDataSecant userSecantData = new UserDataSecant();
        userUI.printSecantMethodMeniu(userSecantData);

        //Creating Numerical method factory to produce methods
        NonLinearMethodFactory nonlinerFactor = new NonLinearMethodFactory(userIterationData.intial_guess, userIterationData.derivative, userIterationData.precision, userIterationData.max_iteration_number, userSecantData.first_guess, userSecantData.second_guess, userSecantData.max_iteration_number, userSecantData.precision);

        // Calculating with the method Fixed point iteration
        NonLinearMethod fixedPoint = nonlinerFactor.getNonLinearMethod("FixedPoint");
        fixedPoint.calculate();

        // Calculating with the method Secant
        NonLinearMethod secant = nonlinerFactor.getNonLinearMethod("Secant");
        secant.calculate();
    }
}
