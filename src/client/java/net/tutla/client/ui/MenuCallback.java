package net.tutla.client.ui;

import io.github.itzispyder.improperui.ImproperUIAPI;
import io.github.itzispyder.improperui.script.CallbackHandler;
import io.github.itzispyder.improperui.script.CallbackListener;
import io.github.itzispyder.improperui.script.events.MouseEvent;
import net.tutla.client.config.Config;

public class MenuCallback implements CallbackListener {

    @CallbackHandler
    public void saveSettings(MouseEvent e) {
        if (e.input.isDown()) Config.saveAll();
    }
}