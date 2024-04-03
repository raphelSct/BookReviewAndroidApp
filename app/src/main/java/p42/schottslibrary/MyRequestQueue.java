package p42.schottslibrary;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MyRequestQueue {
    private static MyRequestQueue instance = null;
    private RequestQueue requestQueue;
    private MyRequestQueue() {}
    private MyRequestQueue(Context context) {
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }
    public static synchronized MyRequestQueue getInstance(Context context) {
        if (instance == null)
            instance = new MyRequestQueue(context);
        return instance;
    }
    public static synchronized MyRequestQueue getInstance() {
        return instance;
    }
    public <T> void add(Request<T> req) {
        requestQueue.add(req);
    }
}
