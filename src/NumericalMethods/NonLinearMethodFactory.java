package NumericalMethods;

public class NonLinearMethodFactory {
    public NonLinearMethod getNonLinearMethod(String methodType)
    {
        if(methodType == "FixedPoint")
        {
            return new FixedPointIteration();
        }
        else if(methodType == "Secant")
        {
            return new Secant();
        }
        else
        {
            return null;
        }
    }
}
