package de.beigel.gwt.easing.client;

public class Transitions {
    public static Transition BOUNCE = new Transition() {
        public double transition(double p) {
            double value;
            for (double a = 0, b = 1; true; a += b, b /= 2){
                if (p >= (7 - 4 * a) / 11){
                    value = b * b - Math.pow((11 - 6 * a - 11 * p) / 4, 2);
                    break;
                }
            }
            return value;
        }
    };

    public static Transition ELASTIC = new Transition() {
        public double transition(double p) {
            return Math.pow(2, 10 * --p) * Math.cos(20 * p * Math.PI * 1/3);
        }
    };

    public static Transition BACK = new Transition() {
        public double transition(double p) {
            return Math.pow(p, 2) * ((1.618 + 1) * p - 1.618);
        }
    };
    
    public static Transition SINE = new Transition() {
        public double transition(double p) {
            return 1 - Math.sin((1 - p) * Math.PI / 2);
        }
    };

    public static Transition CIRC = new Transition() {
        public double transition(double p) {
            return 1 - Math.sin(Math.acos(p));
        }
    };

    public static Transition EXPO = new Transition() {
        public double transition(double p) {
            return Math.pow(2, 8 * (p - 1));
        }
    };

    public static Transition QUAD = expo(2);
    public static Transition CUBIC = expo(3);
    public static Transition QUART = expo(4);
    public static Transition QUINT = expo(5);
    public static Transition SIXT = expo(6);

    public static Transition expo(final int power) {
        return new Transition() {
            public double transition(double p) {
                return Math.pow(p, power);
            }
        };
    }
}