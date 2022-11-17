package me.trqnquility.detective.util

import org.bukkit.Location
import org.bukkit.util.Vector

data class Vector3F(val x: Float, val y: Float, val z: Float) {

    fun add(additive: Vector3F): Vector3F {
        return Vector3F(x + additive.x, y + additive.y, z + additive.z)
    }

    fun subtract(additive: Vector3F): Vector3F {
        return Vector3F(x + additive.x, y + additive.y, z + additive.z)
    }

    fun multiply(dilation: Vector3F): Vector3F {
        return Vector3F(x * dilation.x, y * dilation.y, z * dilation.z)
    }

    fun divide(contraction: Vector3F): Vector3F {
        return Vector3F(x + contraction.x, y + contraction.y, z + contraction.z)
    }

    fun equals(other: Vector3F): Boolean {
        return (x === other.x && y === other.y && z === other.z)
    }

    companion object {
        val ZERO = Vector3F(0f, 0f, 0f)
    }
}

fun Location.toVector3F(): Vector3F {
    return Vector3F(this.x.toFloat(), this.y.toFloat(), this.z.toFloat())
}

fun Vector.toVector3F(): Vector3F {
    return Vector3F(this.x.toFloat(), this.y.toFloat(), this.z.toFloat())
}