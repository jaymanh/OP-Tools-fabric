package jaymanh.optools.WorkStation;


import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.narration.NarrationMessageBuilder;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.text.Text;

public class RefineryGUI extends ClickableWidget {
    public RefineryGUI(int x, int y, int width, int height) {
        super(x, y, width, height, Text.empty());
    }

    @Override
    protected void renderWidget(DrawContext context, int mouseX, int mouseY, float delta) {
        
    }

    @Override
    protected void appendClickableNarrations(NarrationMessageBuilder builder) {

    }

}
