package com.test;

import org.springframework.stereotype.Service;

/**
 * Created by wch on 18-3-30.
 */
@Service
public class SpeakerImpl implements Speaker {
    @Override
    public String speak(String words) {
        return words;
    }
}
