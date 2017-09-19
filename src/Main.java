import NumericalMethods.NonLinearMethod;
import NumericalMethods.NonLinearMethodFactory;
import com.sun.deploy.security.MSCryptoDSASignature;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter parameters of the function tan(x)");

        //Creating Numerical method factory to produce methods
        NonLinearMethodFactory nonlinerFactor = new NonLinearMethodFactory();

        // Calculating with the method Fixed point iteration
        NonLinearMethod fixedPoint = nonlinerFactor.getNonLinearMethod("FixedPoint");
        fixedPoint.calculate();

        // Calculating with the method Secant
        NonLinearMethod secant = nonlinerFactor.getNonLinearMethod("Secant");
        secant.calculate();

    }


}
