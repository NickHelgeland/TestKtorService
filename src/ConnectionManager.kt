package com.nick

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

object ConnectionManager
{
	lateinit var connection: Connection
	
	init
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver")
			
			connection = DriverManager.getConnection(
				"jdbc:oracle:thin:@loanappdatabase.cs48qmknn4om.us-east-2.rds.amazonaws.com:1521:loanapp",
				"Nick", "myloanapp"
			)
		}
		catch (e: SQLException)
		{
			e!!.printStackTrace()
		}
		catch (e: ClassNotFoundException)
		{
			e!!.printStackTrace()
		}
	}
}