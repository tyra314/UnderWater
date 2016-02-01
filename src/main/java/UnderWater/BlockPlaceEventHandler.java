package UnderWater;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.potion.Potion;
import net.minecraftforge.event.world.BlockEvent.PlaceEvent;

public class BlockPlaceEventHandler {

	@SubscribeEvent
	public void onBlockPlace(PlaceEvent event) {
		Block b = event.world.getBlock(event.x, event.y + 1, event.z);

		// allow working under water, if player has water breathing
		if (event.player.isPotionActive(Potion.waterBreathing) && UnderWater.allowPlacingWithWaterBreathing) {
			return;
		}

		if (event.player.isInWater() && !b.equals(Blocks.air)) {
			event.setCanceled(true);
		}
	}
}
