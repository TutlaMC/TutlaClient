package tutla.mc.tutlaclient;
import io.github.itzispyder.improperui.script.CallbackHandler;
import io.github.itzispyder.improperui.script.CallbackListener;
import io.github.itzispyder.improperui.script.events.MouseEvent;
import io.github.itzispyder.improperui.util.ChatUtils;
import net.fabricmc.api.ModInitializer;
import io.github.itzispyder.improperui.ImproperUIAPI;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import tutla.mc.tutlaclient.UICallbacks;

public class TutlaClient implements ModInitializer {
    public static final KeyBinding BIND = KeyBindingHelper.registerKeyBinding(new KeyBinding(
            "binds.tutlaclient.menu",
            InputUtil.Type.KEYSYM,
            GLFW.GLFW_KEY_EQUAL,
            "binds.tutlaclient"
    ));
    @Override
    public void onInitialize() {
        System.out.println("it works but doesnt");
        ImproperUIAPI.init("tutla-client", TutlaClient.class,
                "scripts/main.ui"
        );
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (BIND.wasPressed()) {
                ImproperUIAPI.parseAndRunFile("tutla-client", "main.ui");
            }
        });
    }
}
