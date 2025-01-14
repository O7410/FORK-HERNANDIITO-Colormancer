package hernandiito.colormancer.item;

import hernandiito.colormancer.Colormancer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item EMPTY_VIAL = registerItem("empty_vial", new EmptyVialItem(new FabricItemSettings().maxCount(16)));
    public static final Item WATER_VIAL = registerItem("water_vial", new ColorVialItem(new FabricItemSettings().maxCount(16).food(ModFoodComponents.WATER_VIAL)));
    public static final Item COLOR_VIAL = registerItem("color_vial", new ColorVialItem(new FabricItemSettings().maxCount(16).food(ModFoodComponents.COLOR_VIAL)));
    public static final Item DYE_MIXTURE = registerItem("dye_mixture", new Item(new FabricItemSettings()));
    public static final Item PIGMENTS = registerItem("pigments", new Item(new FabricItemSettings()));
    public static final Item COLORMANCER_BOOK = registerItem("colormancer_book", new Item(new FabricItemSettings().maxCount(1)));

    private static void addItemsToIngredientTabItemsGroup(FabricItemGroupEntries entries) {
        entries.add(EMPTY_VIAL);
        entries.add(COLOR_VIAL);
        entries.add(DYE_MIXTURE);
        entries.add(PIGMENTS);
        entries.add(COLORMANCER_BOOK);
    }

    private static Item registerItem(String id, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Colormancer.MOD_ID, id), item);
    }

    public static void registerModItems() {
        Colormancer.LOGGER.info("Registering ModItems for " + Colormancer.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientTabItemsGroup);
    }
}
