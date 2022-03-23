package io.github.davidqf555.minecraft.hypotheticals.common;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("hypotheticals")
public class Hypotheticals {

    public static final String MOD_ID = "hypotheticals";

    public Hypotheticals() {
        MinecraftForge.EVENT_BUS.register(this);
    }

}