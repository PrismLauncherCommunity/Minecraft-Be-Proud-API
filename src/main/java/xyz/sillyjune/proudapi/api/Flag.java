package xyz.sillyjune.proudapi.api;

import me.duquee.beproud.BeProud;
import me.duquee.beproud.blocks.BPBlocks;
import me.duquee.beproud.blocks.flag.FlagBlock;
import me.duquee.beproud.blocks.flag.FlagWrapper;
import me.duquee.beproud.items.book.PrideBookScreen;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

import static me.duquee.beproud.items.BPItems.PRIDE_BOOK;

public class Flag extends FlagWrapper {

    boolean lgbt;
    @Environment(EnvType.CLIENT)
    private int chapterPage;
    public Flag(String name, FlagBlock small, FlagBlock standard, FlagBlock large, boolean lgbt) {
        super(name, small, standard, large);
        this.lgbt = lgbt;
    }
    @Override
    @Environment(EnvType.CLIENT)
    public int getChapterPage() {
        if (this.lgbt) {
            return this.chapterPage;
        }
        return -1;
    }
}
