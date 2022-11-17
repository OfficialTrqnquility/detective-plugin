package me.trqnquility.detective.converter

interface Converter<F, T> {

    fun convert(input: F): T
}