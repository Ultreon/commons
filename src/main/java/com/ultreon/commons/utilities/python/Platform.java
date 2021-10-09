package com.ultreon.commons.utilities.python;

import com.ultreon.commons.utilities.system.OS;

@Deprecated
public class Platform {
    private Platform() {

    }

    public static OS getOS() {
        return new OS();
    }
}
