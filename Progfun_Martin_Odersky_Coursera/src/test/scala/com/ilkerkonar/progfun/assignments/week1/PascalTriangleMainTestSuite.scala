package com.ilkerkonar.progfun.assignments.week1

import org.junit.runner.RunWith
import org.scalatest.FunSuite
import org.scalatest.junit.JUnitRunner

import PascalTriangleMain.pascal

@RunWith( classOf[ JUnitRunner ] )
class PascalTriangleMainTestSuite extends FunSuite {

	test( "pascal: col=0,row=2" ) {
		assert( pascal( 0, 2 ) === 1 )
	}

	test( "pascal: col=1,row=2" ) {
		assert( pascal( 1, 2 ) === 2 )
	}

	test( "pascal: col=1,row=3" ) {
		assert( pascal( 1, 3 ) === 3 )
	}

	test( "pascal: col=2,row=4" ) {
		assert( pascal( 2, 4 ) === 6 )
	}

	test( "pascal: col=3,row=6" ) {
		assert( pascal( 3, 6 ) === 20 )
	}
}
