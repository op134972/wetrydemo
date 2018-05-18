package com.test.impl;

import com.test.api.Speaker;

/**
 * Created by wch on 18-3-30.
 */
public class SpeakerImpl implements Speaker {
    @Override
    public String speak(String words) {
        return words;
    }
}
