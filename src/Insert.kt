package com.nick

import java.sql.SQLException

interface Insert<T>
{
	@Throws(SQLException::class)
	fun insertNew(obj: T)
}