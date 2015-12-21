package com.ilkerkonar.progfun.worksheet.week2

object currying {

	def cube( x : Int ) = x * x * x           //> cube: (x: Int)Int
	
	def sumInt( a : Int, b : Int ) : Int =
		if ( a > b ) 0
		else a + sumInt( a + 1, b )       //> sumInt: (a: Int, b: Int)Int
		
	def sum( f : Int => Int, a : Int, b : Int ) : Int =
		if ( a > b ) 0
		else f(a) + sum( f, a + 1, b )    //> sum: (f: Int => Int, a: Int, b: Int)Int
		
	def sum2( f : Int => Int ) : ( Int, Int ) => Int = {
		def sumF( a : Int, b : Int ) : Int =
			if ( a > b ) 0
			else f( a ) + sumF( a + 1, b )
		sumF
	}                                         //> sum2: (f: Int => Int)(Int, Int) => Int
	
	def sum3( f : Int => Int )( a : Int, b : Int ) : Int =
			if ( a > b ) 0
			else f( a ) + sum3( f )( a + 1, b )
                                                  //> sum3: (f: Int => Int)(a: Int, b: Int)Int
                                    
	
	def sumCubes( a : Int, b : Int ) : Int =
		if ( a > b ) 0
		else cube(a) + sumCubes( a + 1, b )
                                                  //> sumCubes: (a: Int, b: Int)Int
                                    
                                                  
	def sumCubes2( a : Int, b : Int ) : Int = sum( cube, a, b )
                                                  //> sumCubes2: (a: Int, b: Int)Int
                                    
	
	def sumCubes3( a : Int, b : Int ) : Int = sum( x => x * x * x, a, b )
                                                  //> sumCubes3: (a: Int, b: Int)Int
                                    
	
	def sumCubes4 = sum2( x => x * x * x )    //> sumCubes4: => (Int, Int) => Int
                                                  
  sumCubes( 2, 4 )                                //> res0: Int = 99
  
  sumCubes2( 2, 4 )                               //> res1: Int = 99
  
  sumCubes3( 2, 4 )                               //> res2: Int = 99
  
  sumCubes4( 2, 4 )                               //> res3: Int = 99
  
  sum2( cube )( 2, 4 )                            //> res4: Int = 99
  
  sum3( cube )( 2, 4 )                            //> res5: Int = 99
}