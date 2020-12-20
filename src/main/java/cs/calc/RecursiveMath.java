package cs1302.calc;

/* Implement the Math interface using recursion here. For each method, replace
 * the throw statement with your implementation.
 */

/**
 * REPLACE ME WITH ACTUAL JAVADOC FOR THIS CLASS.
 *
 * @author AUTHOR
 */
public class RecursiveMath implements Math {

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
		if (rhs == 0) return lhs;
		return add(inc(lhs), dec(rhs));
	} // add

	public int sub(int lhs, int rhs) {
		if (rhs == 0) return lhs;
		if (rhs > lhs) return 0;
		return sub(dec(lhs), dec(rhs));
	} // sub

	public int mul(int lhs, int rhs) {
		return mul_acc(lhs, lhs, rhs);
	} // mul

	int mul_acc(int sum, int lhs, int rhs) {
		if (rhs == 0) return 0;
		if (rhs == 1) return sum;
		return mul_acc(add(sum, lhs), lhs, dec(rhs));
	}

	public int div(int lhs, int rhs) {
		return div_acc(0, lhs, rhs);
	} // div

	public	int div_acc(int counter, int lhs, int rhs) {
		if (lhs < rhs) return counter;
		return div_acc( inc(counter) , sub(lhs, rhs) , rhs);
	} 

	public int fac(int n) {

		if (n == 0) return 1;
		return n * fac(n - 1);
	} // fac

	public int pow(int lhs, int rhs) {
		return pow_acc(1, lhs, rhs);
	} // pow
	
	int pow_acc(int acc, int lhs, int rhs) {
		if (rhs == 0) return acc;
		return pow_acc(mul(acc, lhs), lhs, dec(rhs));
	}


} // RecursiveMath
