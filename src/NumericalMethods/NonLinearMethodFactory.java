package NumericalMethods;

public class NonLinearMethodFactory {

    /* Fixed point iteration properties */
    // Initial guess, that user has to make
    public double intial_guess;
    // Calculated max derivative in defined interval
    public double maxDerivitive;
    // User defined precision
    public double iterationPrecision;
    // Max iteration number for iteration method, to prevent infinite loop
    public int maxIterationRepeatNumber;

    /* Secant method properties */
    // First initial guess
    public double firstGuess;
    // Second initial guess
    public double secondGuess;
    // Max iteration number
    public int maxSecantRepeatNumber;
    // User defined precision
    public double secantPrecision;

    public NonLinearMethodFactory(double initial_guess, double maxDerivitive, double iterationPrecision, int maxIterationRepeatNumber, double firstGuess, double secondGuess, int maxSecantRepeatNumber, double secantPrecision)
    {

        // Initializing Iteration method properties & preparing factory class
        this.intial_guess = initial_guess;
        this.maxDerivitive = maxDerivitive;
        this.iterationPrecision = iterationPrecision;
        this.maxIterationRepeatNumber = maxIterationRepeatNumber;

        // Initializing Secant method & preparing factory class
        this.firstGuess = firstGuess;
        this.secondGuess = secondGuess;
        this.maxSecantRepeatNumber = maxSecantRepeatNumber;
        this.secantPrecision = secantPrecision;
    }

    public NonLinearMethod getNonLinearMethod(String methodType)
    {
        if(methodType == "FixedPoint")
        {
            return new FixedPointIteration(maxDerivitive, iterationPrecision, intial_guess, maxIterationRepeatNumber);
        }
        else if(methodType == "Secant")
        {
            return new Secant(secantPrecision, firstGuess, secondGuess, maxSecantRepeatNumber);
        }
        else
        {
            return null;
        }
    }
}
