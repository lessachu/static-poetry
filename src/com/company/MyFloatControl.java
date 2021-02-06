/*
 * Author: Jan Chong (@lessachu)
 * Date: Feb 2021
 */

package com.company;

import javax.sound.sampled.FloatControl;

public class MyFloatControl {
    FloatControl control;

    public MyFloatControl(FloatControl c) {
        this.control = c;
    }

    public void setValue(float val) {
        this.control.setValue(val);
    }
}
