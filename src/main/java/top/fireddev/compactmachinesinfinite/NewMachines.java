package top.fireddev.compactmachinesinfinite;

import dev.compactmods.machines.CompactMachines;
import dev.compactmods.machines.machine.CompactMachineBlock;
import dev.compactmods.machines.machine.CompactMachineBlockEntity;
import dev.compactmods.machines.machine.CompactMachineItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static top.fireddev.compactmachinesinfinite.CompactMachinesInfinite.*;

public class NewMachines {
    static final BlockBehaviour.Properties MACHINE_BLOCK_PROPS = BlockBehaviour.Properties
            .of(Material.METAL)
            .strength(8.0F, 20.0F)
            .requiresCorrectToolForDrops();

    static final Supplier<Item.Properties> MACHINE_ITEM_PROPS = () -> new Item.Properties()
            .tab(CompactMachines.COMPACT_MACHINES_ITEMS);

    public static final RegistryObject<Block> MACHINE_BLOCK_XLARGE = BLOCKS.register("machine_xlarge", () ->
            new CompactMachineBlock(RoomSizeHelper.get("xlarge"), MACHINE_BLOCK_PROPS));
    public static final RegistryObject<Block> MACHINE_BLOCK_EXTREME = BLOCKS.register("machine_extreme", () ->
            new CompactMachineBlock(RoomSizeHelper.get("extreme"), MACHINE_BLOCK_PROPS));
    public static final RegistryObject<Block> MACHINE_BLOCK_ULTRA = BLOCKS.register("machine_ultra", () ->
            new CompactMachineBlock(RoomSizeHelper.get("ultra"), MACHINE_BLOCK_PROPS));
    public static final RegistryObject<Item> MACHINE_BLOCK_ITEM_XLARGE = ITEMS.register("machine_xlarge",
            () -> new CompactMachineItem(MACHINE_BLOCK_XLARGE.get(), MACHINE_ITEM_PROPS.get()));
    public static final RegistryObject<Item> MACHINE_BLOCK_ITEM_EXTREME = ITEMS.register("machine_extreme",
            () -> new CompactMachineItem(MACHINE_BLOCK_EXTREME.get(), MACHINE_ITEM_PROPS.get()));
    public static final RegistryObject<Item> MACHINE_BLOCK_ITEM_ULTRA = ITEMS.register("machine_ultra",
            () -> new CompactMachineItem(MACHINE_BLOCK_ULTRA.get(), MACHINE_ITEM_PROPS.get()));

    public static final RegistryObject<BlockEntityType<CompactMachineBlockEntity>> MACHINE_TILE_ENTITY = BLOCK_ENTITIES.register("compact_machine_infinite", () ->
            BlockEntityType.Builder.of(CompactMachineBlockEntity::new,
                            MACHINE_BLOCK_XLARGE.get(), MACHINE_BLOCK_EXTREME.get(), MACHINE_BLOCK_ULTRA.get())
                    .build(null));

    public static void setup(){

    }
}
