package NumericalMethods;

import Model.Iteration;
import dnl.utils.text.table.TextTable;
import java.util.ArrayList;
import java.util.List;

public class Secant implements NonLinearMethod {
    public double precision;                // User defined allowance
    public double firstInitialGuess;        // First Initial guess
    public double secondInitialGuess;       // Second Initial guess
    public int maxIterationNumber;          // Max iteration number

    public Secant(double precision, double firstInitialGuess, double secondInitialGuess, int maxIterationNumber)
    {
        this.precision = precision;
        this.firstInitialGuess = firstInitialGuess;
        this.secondInitialGuess = secondInitialGuess;
        this.maxIterationNumber = maxIterationNumber;
    }

    @Override
    public void calculate() {

        System.out.println();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Calculating function: tan(x) - x = 0...... ");
        System.out.println("With first initial guess: x0 = " + firstInitialGuess);
        System.out.println("With second initial guess: x1 = " + secondInitialGuess);
        System.out.println("With precision: " + precision);
        System.out.println("With maximum iteration number, to prevent infinite loop: " + maxIterationNumber);
        System.out.println("----------------------------------------------------------------------------------");

        double result = 0;
        List<Iteration> iterations = new ArrayList<>();


        String[] columns = {"Iteration num.", "First guess x0", "Second guess x1", "Result", "Difference |g(x) - x|"};

        for(int x = 0; (Math.abs(secondInitialGuess - firstInitialGuess) > precision) && (x < maxIterationNumber); x++)
        {
            // f(x) = tan(x)
            result = secondInitialGuess - (((Math.tan(secondInitialGuess) - secondInitialGuess) * (secondInitialGuess- firstInitialGuess))/((Math.tan(secondInitialGuess) - secondInitialGuess) - (Math.tan(firstInitialGuess) - firstInitialGuess)));
            //result = secondInitialGuess - (((3*secondInitialGuess+Math.sin(secondInitialGuess)-Math.exp(secondInitialGuess)) * (secondInitialGuess- firstInitialGuess))/((3*secondInitialGuess+Math.sin(secondInitialGuess)-Math.exp(secondInitialGuess)) - (3*firstInitialGuess+Math.sin(firstInitialGuess)-Math.exp(firstInitialGuess))));

            Iteration iteration = new Iteration();
            iteration.result_funct = result;
            iteration.iterationNum = x + 1;
            iteration.first_guess = firstInitialGuess;
            iteration.second_guess = secondInitialGuess;
            iteration.difference = secondInitialGuess - firstInitialGuess;
            iterations.add(iteration);

            firstInitialGuess = secondInitialGuess;
            secondInitialGuess = result;

        }

        // Preparing for printing
        Object[][] data = new Object[iterations.size()][5];
        int iterNum = 0;
        for (Iteration iter : iterations){
            data[iterNum][0] = iter.iterationNum;
            data[iterNum][1] = iter.first_guess;
            data[iterNum][2] = iter.second_guess;
            data[iterNum][3] = iter.result_funct;
            data[iterNum][4] = iter.difference;
            iterNum++;
        }

        System.out.println("Final result: " + iterations.get(iterations.size() - 1).result_funct);

        TextTable tt = new TextTable(columns, data);
        tt.printTable();
    }
}
