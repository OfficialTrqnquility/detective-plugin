package me.trqnquility.detective.repository

import me.trqnquility.detective.packet.PacketPlayerMove
import java.util.*

interface MovementHistory {

    fun add(player: UUID, packet: PacketPlayerMove)

    fun get(player: UUID): List<PacketPlayerMove>

    fun save(player: UUID)


}