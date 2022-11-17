package me.trqnquility.detective.packet

import me.trqnquility.detective.util.Vector3F

data class PacketPlayerMove(val location: Vector3F, val yaw: Float, val pitch: Float, val velocity: Vector3F)