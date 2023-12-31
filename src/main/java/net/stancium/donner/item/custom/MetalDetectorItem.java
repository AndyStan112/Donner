package net.stancium.donner.item.custom;

import net.minecraft.client.resources.language.I18n;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.stancium.donner.util.ModTags;

public class MetalDetectorItem  extends Item {

    public MetalDetectorItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        if(!pContext.getLevel().isClientSide){
            boolean found = false;
            BlockPos clickPos = pContext.getClickedPos();
            Player player = pContext.getPlayer();

            for(int i=0; i< clickPos.getY() + 64;i++){
                BlockState clickedBlock = pContext.getLevel().getBlockState(clickPos.below(i));
                if(isValuable(clickedBlock)){
                   outputValuableCoordinates(clickPos.below(i),player,clickedBlock.getBlock());
                   found=true;
                   break;
                }
            }
            if(!found){
                outputFailure(player);
            }
        }
        pContext.getItemInHand().hurtAndBreak(1,pContext.getPlayer(),
                player -> player.broadcastBreakEvent(player.getUsedItemHand()) );
        return InteractionResult.SUCCESS;
    }

    private void outputFailure(Player player) {
        player.sendSystemMessage(Component.literal("Found nothing"));
    }

    private void outputValuableCoordinates(BlockPos blockPos, Player player, Block block) {
        player.sendSystemMessage(Component.literal("Found "+ I18n.get(block.getDescriptionId()) +
                " at ( " + blockPos.getX()+ " , " + blockPos.getY() +" , " + blockPos.getZ() + " ) " ));
    }

    private boolean isValuable(BlockState clickedBlock) {
        return clickedBlock.is(ModTags.Blocks.DETECTABLES);
    }

}
