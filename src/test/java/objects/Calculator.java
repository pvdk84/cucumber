package objects;

public class Calculator {

    private String addition(int x, int y) {
        int result = x + y;
        return String.valueOf(result);
    }

    private String subtraction(int x, int y) {
        int result =  x - y;
        return String.valueOf(result);

    }

    private String multiplication(int x, int y) {
        int result =  x * y;
        return String.valueOf(result);
    }

    private String division(int x, int y) {
        double answer =  (double) x / (double) y;
        return String.valueOf(answer);
    }

    private String modulo(int x, int y) {
        int answer = x % y;
        return String.valueOf(answer);
    }

    private String percentage(int x, int y) {
        double answer = ((double) y / (double) x) * 100;
        return String.valueOf(answer);
    }

    public String calculate(String function, int x, int y) {
        switch (function.toLowerCase()) {
            case "addition": return this.addition(x, y);
            case "subtraction": return this.subtraction(x, y);
            case "multiplication": return this.multiplication(x, y);
            case "division": return this.division(x, y);
            case "modulo": return this.modulo(x, y);
            case "percentage": return this.percentage(x, y);
            default: return String.format("invalid function %s", function);
        }
    }
}
