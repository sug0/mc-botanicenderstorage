package botanicenderstorage.eventhandler;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.init.SoundEvents;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import codechicken.enderstorage.item.ItemEnderPouch;
import vazkii.botania.api.mana.ManaItemHandler;

public class RightClickEnderPouchEvent {
    // taken from the botania source files
    private static final int COST_SELF = 250;

    @SubscribeEvent
    public static void rightClickEvent(PlayerInteractEvent.RightClickItem e) {
        ItemStack enderPouch = e.getItemStack();

        // check if the item is the ender pouch;
        // do nothing if it isn't
        if (!(enderPouch.getItem() instanceof ItemEnderPouch)) {
            return;
        }

        EntityPlayer player = e.getEntityPlayer();

        // we don't want to handle this ourselves;
        // leave it to the original mod
        if (player.isSneaking()) {
            return;
        }

        if (ManaItemHandler.requestManaExact(enderPouch, player, COST_SELF, false)) {
            // hurray!
            ManaItemHandler.requestManaExact(enderPouch, player, COST_SELF, true);
            player.playSound(SoundEvents.ENTITY_ENDERMEN_TELEPORT, 1F, 1F);
        } else {
            // we don't have enough mana to open the pouch
            e.setCanceled(true);
        }
    }
}
