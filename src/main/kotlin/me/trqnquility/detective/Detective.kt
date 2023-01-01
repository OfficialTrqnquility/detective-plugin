package me.trqnquility.detective

import me.trqnquility.detective.handler.MovementListener
import me.trqnquility.detective.repository.MovementHistory
import me.trqnquility.detective.repository.MovementHistoryImpl
import org.bukkit.Bukkit
import org.bukkit.plugin.Plugin
import org.bukkit.plugin.java.JavaPlugin
import java.io.File

class Detective: JavaPlugin() {

    companion object {
        lateinit var instance: Plugin
    }

    private lateinit var movementHistory: MovementHistory



    override fun onEnable() {
        instance = this
        File("${this.dataFolder.path}\\data").mkdirs()
        this.saveDefaultConfig()

        this.movementHistory = MovementHistoryImpl(savePath = this.dataFolder.path + "\\data")

        Bukkit.getPluginManager().registerEvents(MovementListener(movementHistory), this)

        Bukkit.getScheduler().runTaskTimer( this, { -> Bukkit.getOnlinePlayers().forEach {
            if (movementHistory.get(it.uniqueId).isNotEmpty()) {
                movementHistory.save(it.uniqueId)
                println("saved ${it.player?.name}")
            }
        } }, 1L, this.config.getInt("save-interval").toLong())

    }

    override fun onDisable() {

    }
}