public class Calculations {
    private double result = 0;
    private long fact = 1;
    public double squareRoot(final double num){
        result = Math.sqrt(num);
        return result;
    }
    public long factorial(final long num){
        for (long i = 1; i <= num; i++){
            fact = fact * i;
        }
        return fact;
    }
    public double naturalLog(final double num){
        result = Math.log(num);
        return result;
    }
    public double powerFunction(final double num1,final double num2){
        result = Math.pow(num1,num2);
        return result;
    }
}
