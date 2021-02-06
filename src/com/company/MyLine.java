package com.company;

import javax.sound.sampled.*;

public class MyLine implements SourceDataLine {

    SourceDataLine line;

    public static final Control.Type placeholder = FloatControl.Type.MASTER_GAIN;

    public MyLine() {

    }
     public void calcified_from(SourceDataLine line) {
        this.line = line;
    }

    // new methods created for the poem
    public void drop() {
        drain();
    }

    public void surrender() {
        close();
    }

    public int dancing (byte[] b, int off, int len) {
        return write(b, off, len);
    }

    public boolean placeholder7(Control.Type control) {
        return this.line.isControlSupported(control);
    }


    public void open(AudioFormat format) throws LineUnavailableException  {
        this.line.open(format);
    }

    public void open(AudioFormat format, int bufferSize)
        throws LineUnavailableException {
        this.line.open(format, bufferSize);
    }

    public int	write(byte[] b, int off, int len) {
        return this.line.write(b, off, len);
    }
    public int	available() {
        return this.line.available();
    }

    public void drain(){
        this.line.drain();
    }

    public void flush(){
        this.line.flush();
    }

    public int	getBufferSize() {
        return this.line.getBufferSize();
    }

    public AudioFormat	getFormat() {
        return this.line.getFormat();
    }

    public int	getFramePosition() {
        return this.line.getFramePosition();
    }

    public float getLevel() {
        return this.line.getLevel();
    }

    public long getLongFramePosition() {
        return this.line.getLongFramePosition();
    }
    public long getMicrosecondPosition() {
        return this.line.getMicrosecondPosition();
    }

    public boolean	isActive() {
        return this.line.isActive();
    }

    public boolean	isRunning() {
        return this.line.isRunning();
    }

    public  void	start() {
        this.line.start();
    }

    public    void	stop() {
        this.line.stop();
    }

    public void	addLineListener(LineListener listener) {
        this.line.addLineListener(listener);
    }

    public void	close() {
        this.line.close();
    }

    public Control	getControl(Control.Type control) {
        return this.line.getControl(control);
    }

    public MyFloatControl getControl2(Control.Type control) {
        MyFloatControl fc = new MyFloatControl((FloatControl) this.line.getControl(control));
        return fc;
    }

    public Control[] getControls() {
        return this.line.getControls();
    }

    public Line.Info	getLineInfo() {
        return this.line.getLineInfo();
    }

    public boolean	isControlSupported(Control.Type control) {
        return this.line.isControlSupported(control);
    }

    public boolean	isOpen() {
        return this.line.isOpen();
    }
    public void	open() throws LineUnavailableException {
        this.line.open();
    }
    public void	removeLineListener(LineListener listener) {
        this.line.removeLineListener(listener);
    }
}
