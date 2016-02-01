package UnderWater;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;

@Mod(modid = UnderWater.MODID, version = UnderWater.VERSION)
public class UnderWater {
	public static final String MODID = "UnderWater";
	public static final String VERSION = "1.0";

	public static boolean allowPlacingWithWaterBreathing = false;

	@EventHandler
	public void init(FMLInitializationEvent event) {
		BlockPlaceEventHandler teh = new BlockPlaceEventHandler();

		MinecraftForge.EVENT_BUS.register(teh);
	}

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());

		config.load();

		// Configuration goes here.
		allowPlacingWithWaterBreathing = config.get(config.CATEGORY_GENERAL, "allowPlacingWithWaterBreathing", true)
				.getBoolean(true);

		config.save();
	}
}
