package re.domi.invisiblights;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import re.domi.invisiblights.block.LightSourceBlock;
import re.domi.invisiblights.item.LightRodItem;

public class InvisibLights implements ModInitializer {
    public static final String MOD_ID = "invisiblights";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static final Block LIGHT_SOURCE_BLOCK = new LightSourceBlock(
            FabricBlockSettings.of(Material.AIR).noCollision().luminance(state -> state.get(LightSourceBlock.LIGHT_LEVEL))
    );

    public static final Item LIGHT_ROD = new LightRodItem(new FabricItemSettings().group(ItemGroup.TOOLS).maxCount(1));

    @Override
    public void onInitialize() {
        LOGGER.info("InvisibLights initializing...");

        // Register the blocks and items
        Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "light_source"), LIGHT_SOURCE_BLOCK);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, "light_rod"), LIGHT_ROD);

        LOGGER.info("InvisibLights initialized!");
    }
}