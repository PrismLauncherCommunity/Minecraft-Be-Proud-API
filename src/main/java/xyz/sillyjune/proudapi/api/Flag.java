package xyz.sillyjune.proudapi.api;

import me.duquee.beproud.BeProud;
import me.duquee.beproud.blocks.BPBlocks;
import me.duquee.beproud.blocks.flag.FlagBlock;
import me.duquee.beproud.blocks.flag.FlagWrapper;
import me.duquee.beproud.items.book.PrideBookScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import xyz.sillyjune.proudapi.ProudAPI;

import java.util.ArrayList;
import java.util.List;

import static me.duquee.beproud.items.BPItems.PRIDE_BOOK;
import static xyz.sillyjune.proudapi.ProudAPI.ALL;

public class Flag extends FlagWrapper {

    public boolean lgbt;
    @Environment(EnvType.CLIENT)
    public int chapterPage;
    public Flag(String name, FlagBlock small, FlagBlock standard, FlagBlock large, boolean lgbt) {
        super(name, small, standard, large);
        this.lgbt = lgbt;
        if (!this.lgbt) {
            ProudAPI.ALL.add(this);
            ALL.remove(this);
        }
    }
    @Override
    @Environment(EnvType.CLIENT)
    public int getChapterPage() {
        if (this.lgbt) {
            return this.chapterPage;
        }
        return Integer.parseInt(null);
    }

}
