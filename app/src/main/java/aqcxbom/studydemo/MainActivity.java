package aqcxbom.studydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import aqcxbom.functionClassUnion.reflectUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Class<?> cls = getClassLoader().loadClass("aqcxbom.testClassUnion.refTargetClass");
            reflectUtils.invokeMethod_a(cls, "vfun", new Object[]{1});
            reflectUtils.invokeMethod_a(cls, "ifun", new Object[]{1, "hello world!"});
            reflectUtils.invokeMethod_a(cls, "strfun", new Object[]{"Hello", " world!"});
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
