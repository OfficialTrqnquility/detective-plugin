package me.trqnquility.detective.handler

import me.trqnquility.detective.packet.PacketPlayerMove
import me.trqnquility.detective.repository.MovementHistory
import me.trqnquility.detective.util.toVector3F
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent

class MovementListener(private val movementHistory: MovementHistory): Listener {

    @EventHandler
    fun onMove(event: PlayerMoveEvent) {
        movementHistory.add(event.player.uniqueId, PacketPlayerMove(event.player.location.toVector3F(), event.player.location.yaw, event.player.location.pitch, event.player.velocity.toVector3F()))
    }
}