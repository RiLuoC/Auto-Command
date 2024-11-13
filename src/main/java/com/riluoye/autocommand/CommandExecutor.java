package com.riluoye.autocommand;

import com.riluoye.autocommand.config.AutoCommandConfig;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.FMLNetworkEvent;

public class CommandExecutor {
    
    @SubscribeEvent
    public void onClientConnected(FMLNetworkEvent.ClientConnectedToServerEvent event) {
        System.out.println("Auto Command: Connected to server, preparing to execute commands...");
        // 延迟执行以确保玩家完全加载
        new Thread(() -> {
            try {
                Thread.sleep(AutoCommandConfig.executionDelay);
                Minecraft.getMinecraft().addScheduledTask(() -> {
                    // 确保玩家实例存在
                    if (Minecraft.getMinecraft().player != null) {
                        System.out.println("Auto Command: Executing commands...");
                        // 执行配置中的所有命令
                        for (String command : AutoCommandConfig.commands) {
                            if (!command.isEmpty()) {
                                Minecraft.getMinecraft().player.sendChatMessage(command);
                                // 在命令之间添加小延迟，避免服务器限制
                                try {
                                    Thread.sleep(500);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    } else {
                        System.out.println("Auto Command: Player instance is null!");
                    }
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
} 