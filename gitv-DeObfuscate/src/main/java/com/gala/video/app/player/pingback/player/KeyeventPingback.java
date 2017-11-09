package com.gala.video.app.player.pingback.player;

import com.gala.video.app.player.pingback.ClickPingback;

public class KeyeventPingback extends ClickPingback {
    private static final String[] TYPES = new String[]{"r", "block", "rt", "rseat", "rpage", "c1", "c2", "now_c1", "now_qpid", "now_c2", "state"};

    public KeyeventPingback() {
        super(TYPES);
    }
}
