package com.example.teststuffforba;

import com.example.teststuffforba.zooming.PannableCanvas;
import javafx.event.EventHandler;
import javafx.scene.input.ScrollEvent;

public class MySceneGestures {

    private static final double MAX_SCALE = 10.0d;
    private static final double MIN_SCALE = .1d;

//    private DragContext sceneDragContext = new DragContext();

    MyHBox hbox;

    public MySceneGestures(MyHBox hbox) {
        this.hbox = hbox;
    }

    public EventHandler<ScrollEvent> getOnScrollEventHandler() {
        return onScrollEventHandler;
    }

    /**
     * Mouse wheel handler: zoom to pivot point
     */
    private EventHandler<ScrollEvent> onScrollEventHandler = new EventHandler<ScrollEvent>() {

        @Override
        public void handle(ScrollEvent event) {

            double delta = 1.2;

            double scale = hbox.getScale(); // currently we only use Y, same value is used for X
            double oldScale = scale;

            if (event.getDeltaY() < 0)
                scale /= delta;
            else
                scale *= delta;

            scale = clamp( scale, MIN_SCALE, MAX_SCALE);

            double f = (scale / oldScale)-1;

            double dx = (event.getSceneX() - (hbox.getBoundsInParent().getWidth()/2
                    + hbox.getBoundsInParent().getMinX()));
            double dy = (event.getSceneY() - (hbox.getBoundsInParent().getHeight()/2
                    + hbox.getBoundsInParent().getMinY()));

            hbox.setScale( scale);

            // note: pivot value must be untransformed, i. e. without scaling
            hbox.setPivot(f*dx, f*dy);

            event.consume();

        }

    };


    public static double clamp( double value, double min, double max) {

        if( Double.compare(value, min) < 0)
            return min;

        if( Double.compare(value, max) > 0)
            return max;

        return value;
    }
}
