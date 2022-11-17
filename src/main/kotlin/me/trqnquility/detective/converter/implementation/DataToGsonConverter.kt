package me.trqnquility.detective.converter.implementation

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import me.trqnquility.detective.converter.Converter
import me.trqnquility.detective.packet.PacketPlayerMove

object DataToGsonConverter: Converter<List<PacketPlayerMove>, String> {

    private val mapper = jacksonObjectMapper()


    override fun convert(input: List<PacketPlayerMove>): String {
        return mapper.writeValueAsString(input)
    }
}