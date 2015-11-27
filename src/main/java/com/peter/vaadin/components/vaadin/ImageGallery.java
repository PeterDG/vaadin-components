package com.peter.vaadin.components.vaadin;

import com.github.lotsabackscatter.blueimp.gallery.Gallery;
import com.github.lotsabackscatter.blueimp.gallery.Image;
import com.github.lotsabackscatter.blueimp.gallery.Options;
import com.vaadin.ui.VerticalLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peter on 4/5/2015.
 */
public class ImageGallery extends VerticalLayout {
    public Gallery gallery;
    public List<Image> imagesList;
    Options options;

    public ImageGallery() {
        setCaption("Galeria de imagenes");
        gallery = new Gallery();
        options = new Options();
        options.stretchImages = true;
        options.closeOnEscape = false;
        options.closeOnSwipeUpOrDown=false;
        options.closeOnSlideClick=false;
        this.addComponent(gallery);
    }

    public void setGallery(List<String> imageUrls) {
        this.removeAllComponents();
        gallery = new Gallery();
        this.addComponent(gallery);
        imagesList = new ArrayList<>();
        if (imageUrls != null) {
            for (String img : imageUrls) {
                imagesList.add(new Image.Builder().href(img).build());
            }
        }
        gallery.showGallery(imagesList,options);
    }

}
