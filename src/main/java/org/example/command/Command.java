package org.example.command;

import javax.swing.*;
import java.lang.ref.SoftReference;

public abstract class Command implements Buildable{
    protected int argSize;
    protected String name;

    public boolean isSizeCorrect(int size) {

        if (size != argSize) {
            return false;
        }

        return true;
    }
}
