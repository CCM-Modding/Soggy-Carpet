package claycorp.wyldmod;

import claycorp.wyldmod.blocks.ModBlocks;
import claycorp.wyldmod.configuration.Config;
import claycorp.wyldmod.entity.ModEntity;
import claycorp.wyldmod.utils.Archive;
import claycorp.wyldmod.utils.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Archive.MOD_ID, name = Archive.MOD_NAME, version = Archive.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class WyldMod
{
    public static final String WindowDoor = "wyldmod:window";

    @Instance(Archive.MOD_ID)
    public static WyldMod instance;

    @SidedProxy(clientSide = "claycorp.wyldmod.utils.proxy.ClientProxy", serverSide = "claycorp.wyldmod.utils.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preInit(final FMLPreInitializationEvent event)
    {
        Config.load(event);
        ModBlocks.init();
    }

    @EventHandler
    public void init(final FMLInitializationEvent event)
    {
        proxy.initRenders();

        ModEntity.init();
    }

    @EventHandler
    public void postInit(final FMLPostInitializationEvent event)
    {
        ModEntity.addSpawns();
    }
}