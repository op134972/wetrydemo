package service.impl;

import service.Speaker;

/**
 * Created by wch on 18-7-18.
 */
public class SpeakerImpl implements Speaker {
    @Override
    public void speak(String word) {
        System.out.println("hi"+ word);
    }
}
