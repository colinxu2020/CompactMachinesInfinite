package top.fireddev.compactmachinesinfinite;

import net.minecraftforge.common.ForgeConfigSpec;

public class Config {
    public static ForgeConfigSpec CONFIG;

    private static ForgeConfigSpec.IntValue TINY_MACHINE_SIZE;
    private static ForgeConfigSpec.IntValue SMALL_MACHINE_SIZE;
    private static ForgeConfigSpec.IntValue NORMAL_MACHINE_SIZE;
    private static ForgeConfigSpec.IntValue LARGE_MACHINE_SIZE;
    private static ForgeConfigSpec.IntValue GIANT_MACHINE_SIZE;
    private static ForgeConfigSpec.IntValue MAXIMUM_MACHINE_SIZE;
    private static ForgeConfigSpec.IntValue XLARGE_MACHINE_SIZE;
    private static ForgeConfigSpec.IntValue EXTREME_MACHINE_SIZE;
    private static ForgeConfigSpec.IntValue ULTRA_MACHINE_SIZE;

    public static ForgeConfigSpec.BooleanValue AVOID_MOB_SPAWN;
    public static ForgeConfigSpec.BooleanValue ENABLE_BUG_FIX;

    private static final int  maxMachineSize = 1024, minMachineSize = 1;


    static {
        generateConfig();
    }

    private static void generateConfig() {
        ForgeConfigSpec.Builder builder = new ForgeConfigSpec.Builder();

        builder
                .comment("Machine Sizes")
                .push("size");
        TINY_MACHINE_SIZE = builder
                .comment("Tiny Machine Size")
                .defineInRange("tiny", 3, minMachineSize, maxMachineSize);
        SMALL_MACHINE_SIZE = builder
                .comment("Small Machine Size")
                .defineInRange("small", 5, minMachineSize, maxMachineSize);
        NORMAL_MACHINE_SIZE = builder
                .comment("Normal Machine Size")
                .defineInRange("normal", 7, minMachineSize, maxMachineSize);
        LARGE_MACHINE_SIZE = builder
                .comment("Large Machine Size")
                .defineInRange("large", 9, minMachineSize, maxMachineSize);
        GIANT_MACHINE_SIZE = builder
                .comment("Giant Machine Size")
                .defineInRange("giant", 11, minMachineSize, maxMachineSize);
        MAXIMUM_MACHINE_SIZE = builder
                .comment("Maximum Machine Size")
                .defineInRange("maximum", 13, minMachineSize, maxMachineSize);
        XLARGE_MACHINE_SIZE = builder
                .comment("Maximum Machine Size")
                .defineInRange("maximum", 13, minMachineSize, maxMachineSize);
        MAXIMUM_MACHINE_SIZE = builder
                .comment("Maximum Machine Size")
                .defineInRange("maximum", 13, minMachineSize, maxMachineSize);
        XLARGE_MACHINE_SIZE = builder
                .comment("XLarge Machine Size")
                .defineInRange("xlarge", 15, minMachineSize, maxMachineSize);
        EXTREME_MACHINE_SIZE = builder
                .comment("Extreme Machine Size")
                .defineInRange("extreme", 17, minMachineSize, maxMachineSize);
        ULTRA_MACHINE_SIZE = builder
                .comment("Ultra Machine Size")
                .defineInRange("ultra", 19, minMachineSize, maxMachineSize);

        builder.pop();

        AVOID_MOB_SPAWN = builder
                .comment("Avoid Entity Spawn In Compact Dimension")
                .define("avoid_entity_spawn", false);

        ENABLE_BUG_FIX = builder
                .comment("Fix a compact machines' bug which cause the use method doesn't been called correctly")
                .define("bug_fix", true);

        CONFIG = builder.build();
    }
    public static int getRoomSize(String name){
        return switch (name) {
            case "tiny" -> TINY_MACHINE_SIZE.get();
            case "small" -> SMALL_MACHINE_SIZE.get();
            case "normal" -> NORMAL_MACHINE_SIZE.get();
            case "large" -> LARGE_MACHINE_SIZE.get();
            case "giant" -> GIANT_MACHINE_SIZE.get();
            case "xlarge" -> XLARGE_MACHINE_SIZE.get();
            case "extreme" -> EXTREME_MACHINE_SIZE.get();
            case "ultra" -> ULTRA_MACHINE_SIZE.get();
            default -> MAXIMUM_MACHINE_SIZE.get();
        };
    }
}
