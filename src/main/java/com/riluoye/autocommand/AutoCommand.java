package com.riluoye.autocommand;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
    modid = AutoCommand.MODID, 
    name = AutoCommand.NAME, 
    version = AutoCommand.VERSION, 
    clientSideOnly = true,
    guiFactory = "com.riluoye.autocommand.config.GuiFactory"
)
public class AutoCommand {
    public static final String MODID = "autocommand";
    public static final String NAME = "Auto Command";
    public static final String VERSION = "1.0";

    private static Logger logger;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new CommandExecutor());
    }
} 