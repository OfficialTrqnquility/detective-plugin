package me.trqnquility.detective.repository

import me.trqnquility.detective.converter.implementation.DataToGsonConverter
import me.trqnquility.detective.packet.PacketPlayerMove
import me.trqnquility.detective.writer.implementation.DataWriter
import java.util.*

class MovementHistoryImpl(private val data: MutableMap<UUID, MutableList<PacketPlayerMove>> = mutableMapOf(), private val savePath: String): MovementHistory {


    override fun add(player: UUID, packet: PacketPlayerMove) {
        if (data.containsKey(player)) {
            data[player]!!.add(packet)
        } else {
            data[player] = mutableListOf(packet)

        }
    }

    override fun get(player: UUID): List<PacketPlayerMove> {
        return data[player] ?: emptyList()
    }

    override fun save(player: UUID) {
        val saveData = data[player]!!
        data[player] = mutableListOf()
        DataWriter.write(DataToGsonConverter.convert(saveData), savePath)
    }
}