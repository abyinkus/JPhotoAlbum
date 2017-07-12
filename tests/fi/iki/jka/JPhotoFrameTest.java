package fi.iki.jka;

import org.junit.Test;
import sun.jvm.hotspot.utilities.AssertionFailure;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.prefs.Preferences;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class JPhotoFrameTest {
    @Test
    public void listSizeDoesnotChange () throws Exception {
        ActionEvent event = new ActionEvent("test",1,"Start Slideshow");

        JPhotoCollectionMock photos = new JPhotoCollectionMock();

        JPhotoFrame frame = new JPhotoFrame(null, photos);


        frame.actionPerformed(event);

        assertTrue(photos.size() == 0);
    }

    @Test
    public void testIntervalIsTheDefaultValue () throws Exception {
        ActionEvent event = new ActionEvent("test",1,"Start Slideshow");

        JPhotoCollectionMock photos = new JPhotoCollectionMock();

        JPhotosFrameInterval frame = new JPhotosFrameInterval("", photos);

        frame.actionPerformed(event);

        assertTrue ((frame.getInterval() == 5000));
    }

    @Test
    public void testIntervalIsDifferent () throws Exception {
        ActionEvent event = new ActionEvent("test",1,"Start Slideshow");

        JPhotoCollectionMock photos = new JPhotoCollectionMock();

        JPhotosFrameInterval frame = new JPhotosFrameInterval("", photos);


        frame.actionPerformed(event);

        assertTrue ((frame.getInterval() == 5000));
    }

    class JPhotosFrameInterval extends JPhotoFrame {
        protected JPhotosFrameInterval() throws Exception {
        }

        protected JPhotosFrameInterval(String name, JPhotoCollection photoCollection) throws Exception {
            super (name, photoCollection);
            setVisible(false);
        }

        public int getInterval () {
            return interval;
        }


            public void startFullView () {

            }

        @Override
        protected void createPhotoList() {

        }
    }

    class JPhotoCollectionMock extends JPhotoCollection {

        public boolean load(String name){
            return true;
        }

        @Override
        public int getSize() {
            return 1;
        }
    }
}

