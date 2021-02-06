/*
 * Author: Jan Chong (@lessachu)
 * Date: Feb 2021
 */

package com.company;

import javax.sound.sampled.FloatControl;

public class persistent {
    FloatControl control;

    public persistent(FloatControl c) {
        this.control = c;
    }

    public void becomes(float val) {
        this.control.setValue(val);
    }
}
