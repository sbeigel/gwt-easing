package de.beigel.gwt.easing.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.AbsolutePanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.RootPanel;

public class Demo implements EntryPoint {
    
    public void onModuleLoad() {
        final AbsolutePanel ap = new AbsolutePanel();
        ap.setWidth("1000px");
        ap.setHeight("600px");
        RootPanel.get().add(ap);
        
        final HTML box = new HTML("Foo");
        box.setStyleName("box");
        
        ap.add(box);
        
        Ease.out(Transitions.BOUNCE, new Updater() {
            @Override
            public void update(double progress) {
                ap.setWidgetPosition(box, (int) (500 * progress), 10);
            }
        }).run(1250);
        
    }
}
