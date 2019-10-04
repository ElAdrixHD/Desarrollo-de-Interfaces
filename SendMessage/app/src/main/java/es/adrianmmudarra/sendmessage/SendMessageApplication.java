package es.adrianmmudarra.sendmessage;

import android.app.Application;

public class SendMessageApplication extends Application {
    private static SendMessageApplication application;

    public SendMessageApplication() {
    }

    private synchronized static void initialize(){
        application = new SendMessageApplication();
    }

    public static SendMessageApplication getInstance(){
        if (application == null){
            initialize();
        }
        return application;
    }
}
