package com.nick

class Person
{
	var ssn: Int = 0
	
	var creditScore: Int = 0

	constructor(ssn: Int, creditScore: Int) : super()
	{
		this.ssn = ssn
		this.creditScore = creditScore
	}

	constructor() : super() {}
}