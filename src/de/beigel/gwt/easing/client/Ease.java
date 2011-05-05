package de.beigel.gwt.easing.client;

import com.google.gwt.animation.client.Animation;

public class Ease {

    public static Animation in(final Transition t, final Updater updater) {
        return new Animation() {
            @Override
            protected void onUpdate(double progress) {
                updater.update(progress);
            }
            
            @Override
            protected double interpolate(double p) {
                return t.transition(p);
            }
        };
    }

    public static Animation out(final Transition t, final Updater updater) {
        return new Animation() {
            @Override
            protected void onUpdate(double progress) {
                updater.update(progress);
            }
            
            @Override
            protected double interpolate(double p) {
                return 1 - t.transition(1 - p);
            }
        };
    }

    public static Animation inOut(final Transition t, final Updater updater) {
        return new Animation() {
            @Override
            protected void onUpdate(double progress) {
                updater.update(progress);
            }
            
            @Override
            protected double interpolate(double p) {
                return (p <= 0.5) ? t.transition(2 * p) / 2 : (2 - t.transition(2 * (1 - p))) / 2;
            }
        };
    }
}