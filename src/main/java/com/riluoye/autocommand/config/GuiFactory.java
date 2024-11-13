package com.riluoye.autocommand.config;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.fml.client.IModGuiFactory;
import net.minecraftforge.fml.client.config.GuiConfig;
import com.riluoye.autocommand.AutoCommand;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Config;
import java.util.Set;

public class GuiFactory implements IModGuiFactory {
    @Override
    public void initialize(Minecraft minecraftInstance) {
    }

    @Override
    public boolean hasConfigGui() {
        return true;
    }

    @Override
    public GuiScreen createConfigGui(GuiScreen parentScreen) {
        return new GuiConfig(
            parentScreen,
            ConfigElement.from(AutoCommandConfig.class).getChildElements(),
            AutoCommand.MODID,
            false,
            false,
            AutoCommand.NAME + " Configuration"
        );
    }

    @Override
    public Set<RuntimeOptionCategoryElement> runtimeGuiCategories() {
        return null;
    }
} 