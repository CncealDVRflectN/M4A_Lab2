public class Solution {
    private static final double epsilon = 0.000001;

    public static void main(String[] args) {
        double xcur;
        double xnext = 3.75;
        int iterations = 0;
        System.out.println("abs(fDeriv(x0)): " + Math.abs(calculateFDeriv(xnext)));
        System.out.println("Выполнение условий теоремы: " + checkTheoremConditions(xnext));
        System.out.println("Начальное приближение: " + xnext);
        do {
            xcur = xnext;
            xnext = xcur - calculateF(xcur) / calculateFDeriv(xcur);
            iterations++;
        } while (Math.abs(xnext - xcur) >= epsilon);
        System.out.println("Решение: " + xnext);
        System.out.println("Невязка: " + Math.abs(calculateF(xnext)));
        System.out.println("Количество итераций: " + iterations);
    }

    private static double calculateF(double x) {
        return Math.pow(Math.E, x) + Math.log(x) - 10 * x;
    }

    private static double calculateFDeriv(double x) {
        return Math.pow(Math.E, x) + 1 / x - 10;
    }

    private static double calculateFSecondDeriv(double x) {
        return Math.pow(Math.E, x) - 1 / Math.pow(x, 2);
    }

    private static boolean checkTheoremConditions(double xApprox) {
        double h = - calculateF(xApprox) / calculateFDeriv(xApprox);
        double max = Math.max(calculateFSecondDeriv(xApprox), calculateFSecondDeriv(xApprox + 2 * h));
        System.out.println("h: " + h);
        System.out.println("M: " + max);
        return 2 * Math.abs(h) * max <= Math.abs(calculateFDeriv(xApprox));
    }
}
