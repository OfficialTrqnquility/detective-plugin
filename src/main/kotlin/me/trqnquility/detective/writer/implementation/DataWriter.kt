package me.trqnquility.detective.writer.implementation

import me.trqnquility.detective.Detective
import me.trqnquility.detective.writer.Writer
import org.bukkit.Bukkit
import java.io.File
import java.io.FileWriter
import java.util.*

object DataWriter: Writer<String> {

    override fun write(input: String, path: String) {
        Bukkit.getScheduler().runTaskAsynchronously(Detective.instance) { ->
            val file = File("$path/${UUID.randomUUID()}.json")
            file.createNewFile()
            val writer = FileWriter(file)
            writer.write(input)
            writer.flush()
            writer.close()
        }

    }
}