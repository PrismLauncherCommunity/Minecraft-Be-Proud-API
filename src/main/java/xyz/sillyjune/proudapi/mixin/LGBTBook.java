package xyz.sillyjune.proudapi.mixin;

import me.duquee.beproud.blocks.flag.FlagWrapper;
import me.duquee.beproud.items.book.PrideBookScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.List;

import static xyz.sillyjune.proudapi.ProudAPI.ALL;


@Environment(EnvType.CLIENT)
@Mixin(FlagWrapper.class)
public abstract class LGBTBook {





    @Inject(method = "loadChapters", at = @At("HEAD"), remap = false)
    private static void loadChapters(CallbackInfo ci) {
        ALL.forEach((wrapper) -> {
            if (!wrapper.isBlank() && !wrapper.lgbt) {
                wrapper.chapterPage = PrideBookScreen.loadChapter(wrapper.getName());
            }
        });

    }
}
