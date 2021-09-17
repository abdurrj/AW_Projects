public class Calculator {

    public int add(int num1, int num2){
        if (num1<0 || num2<0){
            return -1;
        }
        return num1+num2;
    }

    public int subtract(int x, int y) throws Exception {
        if (x<0||y<0){
            throw new Exception("Cannot use negative numbers in subtraction");
        }
        return x-y;
    }
}
