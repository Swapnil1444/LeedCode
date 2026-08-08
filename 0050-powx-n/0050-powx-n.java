class Solution {
    public static double myPow(double base, double exponent) {
        // Special cases
        if (Double.isNaN(base) || Double.isNaN(exponent)) {
            throw new ArithmeticException("Result is NaN");
        }
        if (exponent == 0.0) {
            return 1.0;
        }
        if (base == 1.0) {
            return 1.0;
        }
        if (base == 0.0) {
            if (exponent > 0) return 0.0;
            throw new ArithmeticException("Division by zero: 0 raised to negative exponent");
        }
        if (Double.isInfinite(exponent)) {
            if (Math.abs(base) == 1.0) {
                throw new ArithmeticException("1 raised to infinite exponent is undefined");
            }
            if (Math.abs(base) > 1.0) {
                return exponent > 0 ? Double.POSITIVE_INFINITY : 0.0;
            } else {
                return exponent > 0 ? 0.0 : Double.POSITIVE_INFINITY;
            }
        }
        if (Double.isInfinite(base)) {
            return exponent > 0 ? Double.POSITIVE_INFINITY : 0.0;
        }

        // Negative base with fractional exponent → invalid
        if (base < 0 && exponent != Math.floor(exponent)) {
            throw new ArithmeticException("Negative base with fractional exponent results in complex number");
        }

        // Main computation
        double result = Math.exp(exponent * Math.log(Math.abs(base)));
        if (base < 0 && ((long) exponent) % 2 != 0) {
            result = -result; // preserve sign for odd integer exponents
        }

        if (!Double.isFinite(result)) {
            throw new ArithmeticException("Result is not finite");
        }

        return result;
    }
   
}