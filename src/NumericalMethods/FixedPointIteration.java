package NumericalMethods;

import dnl.utils.text.table.*;
import Model.Iteration;
import java.util.*;

public class FixedPointIteration implements NonLinearMethod {
    public double maxDerivitive;    // Calculated max derivative in defined interval
    public double precision;        // User defined allowance
    public double initialGuess;     // Initial guess
    public int maxIterationNumber;  // Max iteration number

    public FixedPointIteration(double maxDerivative, double precision, double initialGuess, int maxIterationNumber)
    {
        this.maxDerivitive = maxDerivative;
        this.precision = precision;
        this.initialGuess = initialGuess;
        this.maxIterationNumber = maxIterationNumber;
    }

    @Override
    public void calculate() {
        System.out.println();
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("Calculating function: x = arctan(x)...... ");
        System.out.println("With initial guess: x0 = " + initialGuess);
        System.out.println("With precision: " + precision);
        System.out.println("With maximum derivative in interval [-2, 2]: " + maxDerivitive);
        System.out.println("With maximum iteration number, to prevent infinite loop: " + maxIterationNumber);
        System.out.println("----------------------------------------------------------------------------------");

        List<Iteration> iterations = new ArrayList<Iteration>();
        Iteration iteration;
        double stopConditionAfter = ((1-maxDerivitive) / maxDerivitive) * precision;
        System.out.println("Stop Condition after: " + stopConditionAfter);

        double stopConditionBefore = 100;
        double beforeResult;
        double result;

        Object[][] data = new Object[maxIterationNumber][4];
        String[] columns = {"Iteration num.", "Variable x", "Result g(x)", "Difference |g(x) - x|"};

        beforeResult = initialGuess;

        for(int x = 0; (stopConditionBefore > stopConditionAfter) && (x <= maxIterationNumber - 1); x++)
        {
            // x = arctan(x)
            result = Math.atan(beforeResult) + 2*Math.PI;
            stopConditionBefore = Math.abs(result - beforeResult);

            // Filling up the Iteration model with values
            iteration = new Iteration();
            iteration.iterationNum = x + 1;
            iteration.first_guess = beforeResult;
            iteration.result_funct = result;
            iteration.difference = stopConditionBefore;
            iterations.add(iteration);

            // Setting variable for next iteration
            beforeResult = result;
        }

        // Preparing for printing
        int iterNum = 0;
        for (Iteration iter : iterations){
            data[iterNum][0] = iter.iterationNum;
            data[iterNum][1] = iter.first_guess;
            data[iterNum][2] = iter.result_funct;
            data[iterNum][3] = iter.difference;
            iterNum++;
        }

        TextTable tt = new TextTable(columns, data);
        tt.printTable();

    }
}