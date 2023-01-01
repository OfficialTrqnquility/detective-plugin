package me.trqnquility.detective.packet

import me.trqnquility.detective.util.Vector3F

data class PacketPlayerMove(
    val fromLocation: Vector3F,
    val toLocation: Vector3F,
    val fromYaw: Float,
    val toYaw: Float,
    val fromPitch: Float,
    val toPitch: Float,
    val velocity: Vector3F,
    val onGround: Boolean,
    val shifting: Boolean,
    val speed: Int,
    val inLiquid: Boolean,
    val swimming: Boolean,
    val depthStrider: Int,
)