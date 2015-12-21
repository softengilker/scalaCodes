package com.ilkerkonar.progfun.worksheet.week2

object rationalNumber {
  val a = new Rational( 2, 3 )                    //> a  : com.ilkerkonar.progfun.worksheet.week2.Rational = 2/3
	
	-a                                        //> res0: com.ilkerkonar.progfun.worksheet.week2.Rational = -2/3
	
	a - new Rational( 1, 3 )                  //> res1: com.ilkerkonar.progfun.worksheet.week2.Rational = 1/3
	
	val x = new Rational( 1, 3 )              //> x  : com.ilkerkonar.progfun.worksheet.week2.Rational = 1/3
	
	val y = new Rational( 5, 7 )              //> y  : com.ilkerkonar.progfun.worksheet.week2.Rational = 5/7
	
	val z = new Rational( 3, 2 )              //> z  : com.ilkerkonar.progfun.worksheet.week2.Rational = 3/2
	
	x - y - z                                 //> res2: com.ilkerkonar.progfun.worksheet.week2.Rational = -79/42
	
	val z2 = new Rational( 3 )                //> z2  : com.ilkerkonar.progfun.worksheet.week2.Rational = 3/1
	
	x - y                                     //> res3: com.ilkerkonar.progfun.worksheet.week2.Rational = 8/-21
	
	val ?+* = new Rational( 1, 3 )            //> ?+*  : com.ilkerkonar.progfun.worksheet.week2.Rational = 1/3
}

class Rational( x:Int, y:Int ) {

  require( y != 0, "Denominator must not be zero ")
  
  def this( x:Int ) = this( x, 1 )
  
	private def gcd( a:Int, b:Int ) : Int = if ( b == 0 ) a else gcd( b, a % b )
	 
	val numer = x / gcd( x, y )
  val denom = y / gcd( x, y )
  
  //assert( denom > 0 )
	
	override def toString = numer + "/" + denom
	
	def unary_- = new Rational( numer * -1, denom )
	
	def add( r : Rational ) = new Rational( numer * r.denom + r.numer * denom, r.denom * denom )
	
	def -( r : Rational ) = add( -r )
}