package com.justdoom.dontrunwithscissors.listener;

import com.justdoom.dontrunwithscissors.Main;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ShearsItem;
import net.minecraft.util.DamageSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Main.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class FallDamageListener {

    @SubscribeEvent
    public static void event(LivingDamageEvent event) {
        System.out.println(1);
        if (!(event.getEntity() instanceof PlayerEntity)) return;

        System.out.println(2);

        PlayerEntity player = (PlayerEntity) event.getEntity();
        if (event.getSource() == DamageSource.FALL
                && (player.getMainHandItem().getItem() instanceof ShearsItem
                || player.getOffhandItem().getItem() instanceof ShearsItem)
                && (int) (Math.random() * 5) == 0) { // TODO: change way to randomly get if player will be damaged
            event.setCanceled(true);
            player.hurt(Main.SHEARS, Float.MAX_VALUE);
        }
    }
}
