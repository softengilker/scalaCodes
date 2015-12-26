package com.ilkerkonar.progfun.assignments.week2

import FunSets._

object MainApp extends App {

	println( contains( ( x : Int ) => x < 0, 5 ) )

	println( singletonSet( 8 )( -5 ) )

	println( union( singletonSet( 8 ), singletonSet( 7 ) )( 7 ) )

	println( intersect( singletonSet( 6 ), singletonSet( 6 ) )( 6 ) )

	println( diff( singletonSet( 3 ), singletonSet( 4 ) )( 3 ) )

	println( filter( singletonSet( 3 ), x => x > 0 )( 3 ) )

	println( forall( singletonSet( 1522 ), x => x > -9500 ) )

	println( exists( singletonSet( 152 ), x => x > -9500 ) )
}
