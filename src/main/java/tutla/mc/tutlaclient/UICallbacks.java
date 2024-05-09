package tutla.mc.tutlaclient;

import io.github.itzispyder.improperui.script.CallbackHandler;
import io.github.itzispyder.improperui.script.CallbackListener;
import io.github.itzispyder.improperui.script.events.MouseEvent;
import io.github.itzispyder.improperui.util.ChatUtils;

public class UICallbacks implements CallbackListener {

    @CallbackHandler
    public void sendHelloWorld(MouseEvent e) {
        if (e.input.isDown()) {
            ChatUtils.sendMessage("Hello World");
        }
    }
}
