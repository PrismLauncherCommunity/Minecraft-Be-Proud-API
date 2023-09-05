package xyz.sillyjune.proudapi.api;

import me.duquee.beproud.blocks.flag.FlagBlock;
import me.duquee.beproud.registry.Register;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public class Util {
    private static <T extends FlagBlock> T registerFlag(String id, Function<FabricBlockSettings,  T> factory) {
        FlagBlock flag = Register
                .block(id, factory)
                .settings(settings -> settings
                        .nonOpaque()
                        .strength(0.5F)
                        .sounds(BlockSoundGroup.WOOL)
                        .noCollision()
                        .pistonBehavior(PistonBehavior.DESTROY))
                .item()
                .register()
                .getBlock();

        return flag;
    }
    public static Flag createFlag(String type, boolean lgbt) {
        FlagBlock small = registerFlag("small_" + type + "_flag", FlagBlock::small);
        FlagBlock standard = registerFlag(type + "_flag", FlagBlock::standard);
        FlagBlock large = registerFlag("large_" + type + "_flag", FlagBlock::large);
        return new Flag(type, small, standard, large, lgbt);
    }
}
