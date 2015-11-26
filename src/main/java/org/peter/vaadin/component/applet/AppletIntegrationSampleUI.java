package org.peter.vaadin.component.applet;

import org.peter.vaadin.component.applet.vaadin.AppletIntegration;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.VerticalLayout;

import java.util.Arrays;


public class AppletIntegrationSampleUI extends VerticalLayout {
    public AppletIntegration applet;
    public AppletIntegrationSampleUI() {
        this.setSizeFull();
        applet = new AppletIntegration() {

            private static final long serialVersionUID = 1L;

            @Override
            public void attach() {
                setAppletArchives(Arrays.asList(new String[] { "lib/applet-launcher/applet-launcher.jar","lib/jogl/jogl.jar","lib/gluegen/gluegen-rt.jar","com.xj.anylogic.engine.jar","com.xj.anylogic.engine.nl.jar","com.xj.anylogic.engine.al3d.jar","lib/aviatrix3d-all_2.0.0.jar","lib/j3d-org-elumens.jar","lib/j3d-org-geom-core.jar","lib/j3d-org-geom-hanim.jar","lib/j3d-org-geom-particle.jar","lib/j3d-org-geom-terrain.jar","lib/j3d-org-loader-3ds.jar","lib/j3d-org-loader-core.jar","lib/j3d-org-loader-dem.jar","lib/j3d-org-loader-stl.jar","lib/j3d-org-loader-vterrain.jar","lib/j3d-org-navigation.jar","lib/j3d-org-texture.jar","lib/j3d-org-util.jar","lib/javax.vecmath_1.5.0.jar","lib/uri.jar","lib/vlc_uri.jar","lib/xj3d-common_2.0.0.jar","lib/xj3d-config_2.0.0.jar","lib/xj3d-core_2.0.0.jar","lib/xj3d-device_2.0.0.jar","lib/xj3d-eai_2.0.0.jar","lib/xj3d-ecmascript_2.0.0.jar","lib/xj3d-external-sai-concrete_2.0.0.jar","lib/xj3d-external-sai_2.0.0.jar","lib/xj3d-images_2.0.0.jar","lib/xj3d-java-sai-concrete_2.0.0.jar","lib/xj3d-java-sai_2.0.0.jar","lib/xj3d-jaxp_2.0.0.jar","lib/xj3d-jsai_2.0.0.jar","lib/xj3d-net_2.0.0.jar","lib/xj3d-norender_2.0.0.jar","lib/xj3d-ogl_2.0.0.jar","lib/xj3d-parser_2.0.0.jar","lib/xj3d-render_2.0.0.jar","lib/xj3d-runtime_2.0.0.jar","lib/xj3d-sai-concrete_2.0.0.jar","lib/xj3d-sai_2.0.0.jar","lib/xj3d-sav_2.0.0.jar","lib/xj3d-script-base_2.0.0.jar","lib/xj3d-xml-util_2.0.0.jar","lib/xj3d-xml_2.0.0.jar","view3d.jar","lib/postgresql-9.3-1100.jdbc3.jar" }));
                setCodebase("VAADIN/applet/");
                setAppletClass("org.jdesktop.applet.util.JNLPAppletLauncher.class");
                setAppletParams("codebase_lookup" ,"false");
                setAppletParams("subapplet.classname" ,"view3d.Simulation$Applet");
                setAppletParams("subapplet.displayname" ,"3D Animation");
                setAppletParams("noddraw.check" ,"true");
                setAppletParams("progressbar" ,"true");
                setAppletParams("jnlpNumExtensions" ,"1");
                setAppletParams("jnlpExtension1" ,"http://www.runthemodel.com/javanetcache/media/jogl/builds/archive/jsr-231-1.1.1/webstart/jogl.jnlp");
                setAppletParams("java_arguments" ,"-Dsun.java2d.noddraw=true");
                setAppletParams("jnlp_href" ,"model.jnlp");
                setWidth("2000px");
                setHeight("1000px");
//                setSizeFull();
                setDefaultComponentAlignment(Alignment.BOTTOM_LEFT);

            }
        };
        this.addComponent(applet);
        applet.executeCommand("CMD_SAVE");
        applet.executeCommand("CMD_SAVE");
        applet.executeCommand("CMD_SAVE");
        applet.executeCommand("PROBANDO CONEXION CON APPLET");
        applet.executeCommand("PROBANDO CONEXION CON APPLET");
        applet.executeCommand("PROBANDO CONEXION CON APPLET");
        applet.executeCommand("PROBANDO CONEXION CON APPLET");
        applet.executeCommand("PROBANDO CONEXION CON APPLET");
        applet.executeCommand("PROBANDO CONEXION CON APPLET");
    }

    public AppletIntegration getApplet() {
        return applet;
    }

}