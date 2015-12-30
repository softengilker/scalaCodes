package com.ilkerkonar.progfun.worksheet.week3

object IntSets {
  val t1 = new NonEmpty( 3, Empty, Empty )        //> t1  : com.ilkerkonar.progfun.worksheet.week3.NonEmpty = {.3.}
  t1 inc 4                                        //> res0: com.ilkerkonar.progfun.worksheet.week3.IntSet = {.3{.4.}}
  
  val t2 = new NonEmpty( 5, Empty, Empty )        //> t2  : com.ilkerkonar.progfun.worksheet.week3.NonEmpty = {.5.}
  t2 inc 6                                        //> res1: com.ilkerkonar.progfun.worksheet.week3.IntSet = {.5{.6.}}
  
  t1 union t2                                     //> res2: com.ilkerkonar.progfun.worksheet.week3.IntSet = {{.3.}5.}
  
}

abstract class IntSet {
	
	def inc( x : Int ) : IntSet
	
	def contains( x : Int ) : Boolean
	
	def union( other : IntSet ) : IntSet
}

object Empty extends IntSet {

	def contains( x : Int ) : Boolean = false
	
	def inc( x : Int ) : IntSet = new NonEmpty( x, Empty, Empty )
	
	override def toString = "."
	
	def union( other : IntSet ) : IntSet = other
}

class NonEmpty( elem : Int, left : IntSet, right : IntSet ) extends IntSet {

	def contains( x : Int ) : Boolean =
		if ( x < elem ) left contains x
		else if ( x > elem ) right contains x
		else true
		
	def inc( x : Int ) : IntSet =
		if ( x < elem ) new NonEmpty( elem, left inc x, right )
		else if ( x > elem ) new NonEmpty( elem, left, right inc x )
		else this
		
	override def toString = "{" + left + elem + right + "}"
	
	def union( other : IntSet ) : IntSet =
		( ( left union right ) union other ) inc elem
}