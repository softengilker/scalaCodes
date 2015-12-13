package com.ilkerkonar.progfun.assignments.week1.pascalstriangle

object CountingChangeMain {

	def main( args : Array[ String ] ) {

		println( countChange( 4, List( 1, 2 ) ) )
	}

	def countChange( money : Int, coins : List[ Int ] ) : Int = {

		def calculate( money : Int, coins : List[ Int ], total : Int, wayCount : Int ) : Int = {

			if ( coins.isEmpty )
				wayCount
			else if ( total == money ) {

				calculate( money, coins.tail, 0, wayCount + 1 )

			} else if ( !coins.tail.isEmpty ) {

				calculate( money, coins, total + coins.tail.head, wayCount )

			} else {

				calculate( money, coins, total + coins.head, wayCount )

			}
		}

		calculate( money, coins, 0, 0 )
	}
}
