package com.ilkerkonar.progfun.assignments.week1

object BalanceParenthesesMain {

	def main( args : Array[ String ] ) {

		val str = "ilk(fg(gfg)))gg"

		println( balance( str.toList ) )
	}

	def balance( chars : List[ Char ] ) : Boolean = {

		def findBalance( chars : List[ Char ], count : Int, isAddedBefore : Boolean ) : Boolean = {

			if ( chars.isEmpty ) {
				isAddedBefore && count == 0
			} else {

				val ch = chars.head

				if ( ch.equals( '(' ) ) {
					findBalance( chars.tail, count + 1, true )
				} else if ( ch.equals( ')' ) ) {

					if ( count > 0 ) {
						findBalance( chars.tail, count - 1, isAddedBefore )
					} else {
						findBalance( chars.tail, count, isAddedBefore )
					}

				} else {
					findBalance( chars.tail, count, isAddedBefore )
				}
			}
		}

		findBalance( chars, 0, false )
	}
}
