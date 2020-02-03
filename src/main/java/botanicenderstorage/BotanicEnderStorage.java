package botanicenderstorage;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.Logger;
import botanicenderstorage.eventhandler.RightClickEnderPouchEvent;

@Mod(
    modid = BotanicEnderStorage.MODID,
    name = BotanicEnderStorage.NAME,
    version = BotanicEnderStorage.VERSION
)
public class BotanicEnderStorage {
    public static final String MODID = "botanicenderstorage";
    public static final String NAME = "Botanic Ender Storage";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
        MinecraftForge.EVENT_BUS.register(RightClickEnderPouchEvent.class);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        logger.info("BotanicEnderStorage has been init!");
    }
}
