package jaymanh.optools.GUI.Screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import static jaymanh.optools.OpTools.MOD_ID;

public class ModScreenHandlers {
    public static final ScreenHandlerType<RefineryScreenHandler> REFINERY_SCREEN_HANDLER =
            Registry.register(Registries.SCREEN_HANDLER, Identifier.of(MOD_ID, "refinery"),
            new ExtendedScreenHandlerType<>(RefineryScreenHandler::new, BlockPosPayload.PACKET_CODEC));

    public static void registerScreenHandlers(){

    }
}
