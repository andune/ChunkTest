package org.morganm.chunktest;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class ChunkTest extends JavaPlugin implements Listener
{
	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(this, this);
		getLogger().info("ChunkTest "+getDescription().getVersion()+" loaded");
	}
	
	@EventHandler
	public void onPlayerTeleport(PlayerTeleportEvent event) {
		Player player = event.getPlayer();
		World world = player.getWorld();
		Chunk chunk = world.getChunkAt(event.getTo());
		int chunkx = chunk.getX();
		int chunkz = chunk.getZ();
		world.refreshChunk(chunkx, chunkz);
	}
}
