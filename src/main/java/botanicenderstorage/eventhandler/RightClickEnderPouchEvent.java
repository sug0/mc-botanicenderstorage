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
        // check if player is holding anything at all
        ItemStack enderPouch = e.getItemStack();

        // check if the item is the ender pouch;
        // do nothing if it isn't
        if (!(enderPouch.getItem() instanceof ItemEnderPouch)) {
            return;
        }

        EntityPlayer player = e.getEntityPlayer();

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
