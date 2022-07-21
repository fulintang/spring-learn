package com.tang.tinyurl.exception;

/**
 * ERROR
 *
 * @author tangfulin
 * @version V3.0
 * @since 2022/7/21 10:59
 */
public class TinyUrlError extends RuntimeException {

    public TinyUrlError(String s) {
        super(s);
    }
}
