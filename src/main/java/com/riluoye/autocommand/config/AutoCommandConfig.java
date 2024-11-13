package com.riluoye.autocommand.config;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import com.riluoye.autocommand.AutoCommand;

@Config(modid = AutoCommand.MODID)
public class AutoCommandConfig {
    
    @Config.Comment("Commands to execute when joining game (one command per line)")
    @Config.Name("Commands")
    public static String[] commands = {
        "/help",
        "/time set day"
    };

    @Config.Comment("Delay before executing commands (in milliseconds)")
    @Config.Name("Execution Delay")
    @Config.RangeInt(min = 0, max = 20000)
    public static int executionDelay = 5000;

    @Mod.EventBusSubscriber(modid = AutoCommand.MODID)
    private static class EventHandler {
        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(AutoCommand.MODID)) {
                ConfigManager.sync(AutoCommand.MODID, Config.Type.INSTANCE);
            }
        }
    }
} 