package supports;

public class Utils {
    public static String calculateBMI(double height, double weight){
        double bmi=weight/(height*height*0.0001);
        return String.format("%.1f",bmi);
    }
}
