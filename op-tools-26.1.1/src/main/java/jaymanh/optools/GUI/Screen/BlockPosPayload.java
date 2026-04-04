package jaymanh.optools.GUI.Screen;

import static jaymanh.optools.OpTools.MOD_ID;

import net.minecraft.core.BlockPos;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.Identifier;

public record BlockPosPayload(BlockPos pos) implements CustomPacketPayload {
    public static final Type<BlockPosPayload> ID = new Type<>(Identifier.fromNamespaceAndPath(MOD_ID,"block_pos"));
    public static final StreamCodec<RegistryFriendlyByteBuf, BlockPosPayload> PACKET_CODEC =
            StreamCodec.composite(BlockPos.STREAM_CODEC, BlockPosPayload::pos, BlockPosPayload::new);

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return ID;
    }
}