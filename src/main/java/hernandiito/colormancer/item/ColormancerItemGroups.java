package hernandiito.colormancer.item;

import hernandiito.colormancer.Colormancer;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ColormancerItemGroups {
    public static final ItemGroup COLORMANCER_GROUP = Registry.register(Registries.ITEM_GROUP,
        new Identifier(Colormancer.MOD_ID, "colormancer"),
        FabricItemGroup.builder().displayName(Text.translatable("itemGroup.colormancer"))
            .icon(() -> new ItemStack(ColormancerItems.EMPTY_VIAL)).entries((displayContext, entries) -> {
                entries.add(ColormancerItems.EMPTY_VIAL);
            }).build());
    public static void registerItemGroups() {
        Colormancer.LOGGER.info("Registering item groups for: " + Colormancer.MOD_ID);
    }
}
