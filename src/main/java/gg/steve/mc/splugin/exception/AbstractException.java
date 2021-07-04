package gg.steve.mc.splugin.exception;

import gg.steve.mc.splugin.utility.LogUtil;
import lombok.Data;

@Data
public abstract class AbstractException extends Exception {

    protected AbstractException() {
        LogUtil.warning(getDebugMessage());
    }

    public abstract String getDebugMessage();
}
