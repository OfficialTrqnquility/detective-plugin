package me.trqnquility.detective.handler

import me.trqnquility.detective.packet.PacketPlayerMove
import me.trqnquility.detective.repository.MovementHistory
import me.trqnquility.detective.util.toVector3F
import org.bukkit.enchantments.Enchantment
import org.bukkit.entity.Entity
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerMoveEvent
import org.bukkit.potion.PotionEffectType

class MovementListener(private val movementHistory: MovementHistory) : Listener {

    @EventHandler
    fun onMove(event: PlayerMoveEvent) {
        movementHistory.add(
            event.player.uniqueId,
            PacketPlayerMove(
                event.from.toVector3F(),
                event.to.toVector3F(),
                event.from.yaw,
                event.to.yaw,
                event.from.pitch,
                event.to.pitch,
                event.player.velocity.toVector3F(),
                (event.player as Entity).isOnGround,
                event.player.isSneaking,
                event.player.activePotionEffects.find { it.type == PotionEffectType.SPEED }?.amplifier ?: 0,
                (event.player.isInWater || event.player.isInLava),
                event.player.isSwimming,
                event.player.equipment.boots?.getEnchantmentLevel(Enchantment.DEPTH_STRIDER) ?: 0,
            )
        )
    }
}