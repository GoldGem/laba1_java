public class Integral {
    private double area;
    private double h;

    public Integral() {
        this.area = 0;
        this.h = 0.001;
    }

    public double calculate(double a, double b, Function function) {
        for (int i = 0; i < (b - a) / this.h; i++) {
            this.area += this.h * (0.5 * (function.func(a + i * this.h) + function.func(a + (i + 1) * this.h)));
        }
        return this.area;
    }

}
