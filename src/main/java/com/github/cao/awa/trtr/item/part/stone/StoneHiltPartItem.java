package com.github.cao.awa.trtr.item.part.stone;

import com.github.cao.awa.apricot.anntation.Auto;
import com.github.cao.awa.trtr.item.TrtrItem;
import net.minecraft.util.Identifier;

@Auto
public class StoneHiltPartItem extends TrtrItem {
    @Auto
    public static final Identifier IDENTIFIER = Identifier.tryParse("trtr:stone_hilt_part");

    @Auto
    public StoneHiltPartItem(Settings settings) {
        super(settings);
    }
}
