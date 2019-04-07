package com.nick

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class CreditScoreDAO : Insert<Person>, Select<Person>
{	
	@Throws(SQLException::class)
	override fun insertNew(obj: Person)
	{
		val connection: Connection = ConnectionManager.connection
		
		val statement: PreparedStatement = connection.prepareStatement("INSERT INTO CREDIT_SCORES VALUES(?,?)")
		statement.setInt(1,obj.ssn)
		statement.setInt(2,obj.creditScore)
		
		val resultSet: ResultSet = statement.executeQuery();
	}
	
	@Throws(SQLException::class)
	override fun selectOne(id: Int) : Person
	{
		val person = Person()
		val connection: Connection = ConnectionManager.connection
		val statement: Statement = connection.createStatement()
		val resultSet: ResultSet = statement.executeQuery("SELECT * FROM CREDIT_SCORES WHERE SSN=" 
				+ "'" + id + "'")
		
		while(resultSet.next())
			{
				person.ssn = resultSet.getInt(1)
				person.creditScore = resultSet.getInt(2)
			}
		
		return person;
	}
	
	@Throws(SQLException::class)
	override fun selectAll() : ArrayList<Person>
	{
		val personList: ArrayList<Person> = ArrayList<Person>()
		val connection: Connection = ConnectionManager.connection
		val statement: Statement = connection.createStatement()
		val resultSet: ResultSet = statement.executeQuery("SELECT * FROM CREDIT_SCORES")
		
		while(resultSet.next())
			{
				val person: Person = Person(resultSet.getInt(1), resultSet.getInt(2))
				
				personList.add(person)
			}
		
		return personList;
	}
}