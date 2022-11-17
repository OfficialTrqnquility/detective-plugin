package me.trqnquility.detective.writer

interface Writer<T> {

    fun write(input: T, path: String)
}