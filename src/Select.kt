package com.nick

interface Select<T>
{
	fun selectOne(id: Int): T
	
	fun selectAll(): ArrayList<T>
}