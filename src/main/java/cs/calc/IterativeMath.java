package cs1302.calc;

/* Implement the Math interface using iteration here. For each method, replace
 * the throw statement with your implementation.
 */

/**
 * REPLACE ME WITH ACTUAL JAVADOC FOR THIS CLASS.
 *
 * @author AUTHOR
 */
public class IterativeMath implements Math {

	public int inc(int n) {
		if(n>0)
			return ++n;
		else return 0;
	} // inc

	public int dec(int n) {
		if(n>0)
			return --n;
		else return 0;
	} // dec

	public int add(int lhs, int rhs) {
		while (rhs > 0) {
			lhs = inc(lhs);
			rhs = dec(rhs);
		} // while
		return lhs;
	} // add

	public int sub(int lhs, int rhs) {
		if (rhs > lhs) return 0;
		while (rhs != 0) {
			lhs = dec(lhs);
			rhs = dec(rhs);
		} // while
		return lhs;
	} // sub

	public int mul(int lhs, int rhs) {
		int sum = lhs;
		if (rhs == 0) return 0;
		while (rhs > 1) {
			sum = add(sum, lhs);
			rhs = dec(rhs);
		} // while
		return sum;
	} // mul

	public int div(int lhs, int rhs) {
		int counter = 0;
		while (lhs >= rhs) {
			lhs = sub(lhs, rhs);
			counter = inc(counter);
		} // while
		return counter;
	} 

	public int fac(int n) {

		int fac = 1;
		while (n > 0) {
			fac = fac * n;
			n = n - 1;
		}
		return fac;
	} // fac

	public int pow(int lhs, int rhs) {
		int acc = 1;
		 while (rhs > 0) {
		 acc = mul(acc, lhs);
		 rhs = pred(rhs);
		 } // while
		 return acc;
		} // pow

} // IterativeMath
