package jaymanh.optools;

import jaymanh.optools.GUI.Screen.RefineryScreenHandler;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderPipelines;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Inventory;

import static jaymanh.optools.OpTools.MOD_ID;

public class RefineryScreen extends AbstractContainerScreen<RefineryScreenHandler> {
    private static final Identifier TEXTURE = Identifier.fromNamespaceAndPath(MOD_ID, "textures/gui/refinery_gui.png");

    public RefineryScreen(RefineryScreenHandler handler, Inventory inventory, Component title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init() {
        super.init();
        titleLabelY = 10000;
        inventoryLabelY = 10000;
    }

    @Override
    public void extractBackground(GuiGraphicsExtractor context, int mouseX, int mouseY, float delta) {
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        context.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x, y, 0, 0, imageWidth, imageHeight, 256, 256);
        renderProgressArrow(context, x, y);
    }

    private void renderProgressArrow(GuiGraphicsExtractor context, int x, int y) {
        if (menu.isCrafting()) {
            context.blit(RenderPipelines.GUI_TEXTURED, TEXTURE, x + 85, y + 30, 176, 0, 8, menu.getScaledProgress(), 256, 256);
        }
    }

    @Override
    public void extractRenderState(GuiGraphicsExtractor context, int mouseX, int mouseY, float delta) {
        extractBackground(context, mouseX, mouseY, delta);
        super.extractRenderState(context, mouseX, mouseY, delta);
        extractTooltip(context, mouseX, mouseY);
    }
}