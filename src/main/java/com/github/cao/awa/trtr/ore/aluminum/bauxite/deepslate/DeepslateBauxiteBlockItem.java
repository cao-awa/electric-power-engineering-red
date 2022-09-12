package com.github.cao.awa.trtr.ore.aluminum.bauxite.deepslate;

import com.github.cao.awa.trtr.ref.item.trtr.*;
import net.minecraft.block.*;
import net.minecraft.item.*;
import net.minecraft.util.registry.*;

public class DeepslateBauxiteBlockItem extends TrtrBlockItem {
    public DeepslateBauxiteBlockItem(Block block, Settings settings) {
        super(block, settings);
    }

    public static void register(Block block) {
        Settings settings = new Settings();
        DeepslateBauxiteBlockItem bauxite = new DeepslateBauxiteBlockItem(block, settings);
        Registry.register(Registry.ITEM, DeepslateBauxiteBlock.IDENTIFIER, bauxite);
    }
}