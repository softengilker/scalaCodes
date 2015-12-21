package com.ilkerkonar.progfun.assignments.week1

object CountingChangeMain {

	def main( args : Array[ String ] ) {

		println( countChange( 4, List( 1, 2 ) ) )
	}

  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0)
      1
    else if (money > 0 && !coins.isEmpty)
      countChange(money - coins.head, coins) + countChange(money, coins.tail)
    else
      0
  }
}
