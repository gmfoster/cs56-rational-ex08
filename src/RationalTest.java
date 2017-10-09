import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class RationalTest {

    private Rational r_5_15;
    private Rational r_24_6;
    private Rational r_3_7;  
    private Rational r_13_4;
    private Rational r_20_25;
    private Rational r_25_20;
    private Rational r_0_1; 
    
    @Before public void setUp() {
	r_5_15 = new Rational(5,15);
	r_24_6 = new Rational(24,6);
	r_3_7  = new Rational(3,7);
	r_13_4 = new Rational(13,4);
	r_20_25 = new Rational(20,25);
	r_25_20 = new Rational(25,20);
	r_0_1 = new Rational(0,1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_denom_zero() {
	Rational r = new Rational(1,0);
    }
    
    @Test
    public void test_getNumerator_20_25() {
	assertEquals(4, r_20_25.getNumerator());
    }
    
    @Test
    public void test_getNumerator_13_4() {
	assertEquals(13, r_13_4.getNumerator());
    }
    
    @Test
    public void test_getDenominator_20_25() {
	assertEquals(5, r_20_25.getDenominator());
    }
    
    @Test
    public void test_getDenominator_13_4() {
	assertEquals(4, r_13_4.getDenominator());
    }

    @Test
    public void test_toString_5_15() {
	assertEquals("1/3",r_5_15.toString());
    }

    @Test
    public void test_toString_24_6() {
	assertEquals("4",r_24_6.toString());
    }

    @Test
    public void test_toString_3_7() {
	assertEquals("3/7",r_3_7.toString());
    }
    
    @Test
    public void test_toString_20_25() {
	assertEquals("4/5",r_20_25.toString());
    }

    @Test
    public void test_toString_0_1() {
	assertEquals("0",r_0_1.toString());
    }

    @Test
    public void test_gcd_5_15() {
	assertEquals(5, Rational.gcd(5,15));
    }

    @Test
    public void test_gcd_15_5() {
	assertEquals(5, Rational.gcd(15,5));
    }

    @Test
    public void test_gcd_24_6() {
	assertEquals(6, Rational.gcd(24,6));
    }

    @Test
    public void test_gcd_17_5() {
	assertEquals(1, Rational.gcd(17,5));
    }
    
    @Test
    public void test_gcd_1_1() {
	assertEquals(1, Rational.gcd(1,1));
    }

    @Test
    public void test_gcd_20_25() {
	assertEquals(5, Rational.gcd(20,25));
    }

    @Test
    public void test_rational_m10_m5() {
	Rational r = new Rational(-10,-5);
	assertEquals("2",r.toString());
    }

    @Test
    public void test_rational_m5_6() {
	Rational r = new Rational(-5,6);
	assertEquals("-5/6",r.toString());
    }

    @Test
    public void test_rational_7_m8() {
	Rational r = new Rational(7,-8);
	assertEquals("-7/8",r.toString());
    }

    @Test
    public void test_r_5_15_times_r_3_7() {
	Rational r = r_5_15.times(r_3_7);
	assertEquals("1/7",r.toString());
    }

    @Test
    public void test_r_3_7_times_r_13_4() {
	Rational r = r_3_7.times(r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_r_m3_1_times_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = r_m3_1.times(r_1_m3);
	assertEquals("1",r.toString());
    }

   @Test
    public void test_product_of_r_5_15_and_r_3_7() {
       Rational r = Rational.product(r_5_15,r_3_7);
       assertEquals("1/7",r.toString());
    }

    @Test
    public void test_product_of_r_3_7_and_r_13_4() {
	Rational r = Rational.product(r_3_7,r_13_4);
	assertEquals("39/28",r.toString());
    }

    @Test
    public void test_product_of_r_m3_1_and_1_m3() {
	Rational r_m3_1 = new Rational(-3,1);
	Rational r_1_m3 = new Rational(1,-3);
	Rational r = Rational.product(r_m3_1,r_1_m3);
	assertEquals("1",r.toString());
    }

    @Test
    public void test_lcm_of_21_and_6() {
	assertEquals(42, Rational.lcm(21,6));
    }

    @Test
    public void test_lcm_of_100_and_40() {
	assertEquals(200, Rational.lcm(100,40));
    }

    @Test
    public void test_lcm_of_621_and_234() {
	assertEquals(16146, Rational.lcm(621,234));
    }

    @Test
    public void test_plus_r_5_15_and_r_5_14() {
	Rational r_5_14 = new Rational(5,14);
	Rational ans = new Rational(29,42);
	assertEquals(ans.toString(), r_5_15.plus(r_5_14).toString());
    }

    @Test
    public void test_plus_r_24_6_and_r_18_10() {
	Rational r_18_10 = new Rational(18,10);
	Rational ans = new Rational(29,5);
	assertEquals(ans.toString(), r_24_6.plus(r_18_10).toString());
    }

    @Test
    public void test_plus_r_0_1_and_r_6_15() {
	Rational r_6_15 = new Rational(6,15);
	Rational ans = new Rational(6,15);
	assertEquals(ans.toString(), r_0_1.plus(r_6_15).toString());
    } 

    @Test
    public void test_sum_r_5_15_and_r_24_6() {
	Rational ans = new Rational(13,3);
	assertEquals(ans.toString(), Rational.sum(r_5_15, r_24_6).toString());
    }

    @Test
    public void test_sum_r_0_1_and_r_13_4() {
	Rational ans = new Rational(13,4);
	assertEquals(ans.toString(), Rational.sum(r_0_1, r_13_4).toString());
    }

    @Test
    public void test_sum_r_3_7_and_r_20_25() {
	Rational ans = new Rational(43,35);
	assertEquals(ans.toString(), Rational.sum(r_3_7, r_20_25).toString());
    }

    @Test
    public void test_minus_r_0_1_and_r_5_15() {
	Rational ans = new Rational(-5,15);
	assertEquals(ans.toString(), r_0_1.minus(r_5_15).toString());
    }

    @Test
    public void test_minus_r_13_4_and_r_24_6() {
	Rational ans = new Rational(-3,4);
	assertEquals(ans.toString(), r_13_4.minus(r_24_6).toString());
    }

    @Test
    public void test_minus_r_20_25_and_r_3_7() {
	Rational ans = new Rational(13,35);
	assertEquals(ans.toString(), r_20_25.minus(r_3_7).toString());
    }

    @Test
    public void test_difference_r_0_1_and_r_5_15() {
	Rational ans = new Rational(-5,15);
	assertEquals(ans.toString(), Rational.difference(r_0_1, r_5_15).toString());
    }

    @Test
    public void test_difference_r_24_6_and_r_13_4() {
	Rational ans = new Rational(3,4);
	assertEquals(ans.toString(), Rational.difference(r_24_6, r_13_4).toString());
    }

    @Test
    public void test_difference_r_245_13_and_r_100_25() {
	Rational r_245_13 = new Rational(245, 13);
	Rational r_100_25 = new Rational(100, 25);
	Rational ans = new Rational(193,13);
	assertEquals(ans.toString(), Rational.difference(r_245_13, r_100_25).toString());
    }

    @Test
    public void test_reciprocalOf_r_24_6() {
	Rational ans = new Rational(6,24);
	assertEquals(ans.toString(), (r_24_6.reciprocalOf()).toString());
    }

    @Test
    public void test_reciprocalOf_r_1000_15() {
	Rational r_1000_15 = new Rational(1000,15);
	Rational ans = new Rational(15, 1000);
	assertEquals(ans.toString(), (r_1000_15.reciprocalOf()).toString());
    }

    /*@Test
    public void test_reciprocalOf_r_0_1() {
	Rational r_0_1 = new Rational(0,1);
	Rational ans = new Rational(1,0);
	assertEquals(ans.toString(), (r_0_1.reciprocalOf()).toString());
	}*/

    @Test
    public void test_reciprocalOf_r_200_200() {
	Rational r_200_200 = new Rational(200,200);
	Rational ans = new Rational(200,200);
	assertEquals(ans.toString(), (r_200_200.reciprocalOf()).toString());
    }

    @Test
    public void test_dividedBy_r_5_15_by_r_24_6() {
	Rational ans = new Rational(1,12);
	assertEquals(ans.toString(), (r_5_15.dividedBy(r_24_6)).toString());
    }

    @Test
    public void test_dividedBy_r_25_20_by_r_20_25() {
	Rational ans = new Rational(25,16);
	assertEquals(ans.toString(), (r_25_20.dividedBy(r_20_25)).toString());
    }

    @Test
    public void test_dividedBy_r_0_1_by_r_13_4() {
	Rational ans = new Rational(0,1);
	assertEquals(ans.toString(), (r_0_1.dividedBy(r_13_4)).toString()); 
    }

    @Test
    public void test_quotient_5_15_by_r_24_6() {
	Rational ans = new Rational(1,12);
	assertEquals(ans.toString(), Rational.quotient(r_5_15,r_24_6).toString());
    }

    @Test
    public void test_quotient_25_20_by_r_20_25() {
	Rational ans = new Rational(25,16);
	assertEquals(ans.toString(), Rational.quotient(r_25_20, r_20_25).toString());
    }

    @Test
    public void test_quotient_0_1_by_r_13_4() {
	Rational ans = new Rational(0,1);
	assertEquals(ans.toString(), Rational.quotient(r_0_1, r_13_4).toString());
    }
  }
