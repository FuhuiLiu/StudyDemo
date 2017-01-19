package aqcxbom.functionClassUnion;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by AqCxBoM on 2017/1/19.
 */
public class reflectUtils {
    public static Object invokeMethod_a(Class clsArg, String funcNameArg, Object[] Args) {
        Method method = null;
        if (clsArg != null) {
            if (Args == null) {
                Args = new Object[0];
            }

            Method[] methods = clsArg.getMethods();
            int methodLen = methods.length;
            for (int i = 0; i < methodLen; ++i) {
                method = methods[i];
                if ((method.getName().equals(funcNameArg)) &&
                        method.getParameterTypes().length == Args.length) {
                    for (int n = 0; n < Args.length; ++n) {
                        if (((method.getParameterTypes()[n].isPrimitive()) ||
                                Args[n] != null) &&
                                !getClass_a(
                                        method.getParameterTypes()[n]).isInstance(Args[n]))
                            method = null;
                    }

                    if (method != null) {
                        try {
                            method.setAccessible(true);
                            return method.invoke(clsArg, Args);
                        } catch (InvocationTargetException v0_3) {
                            v0_3.printStackTrace();
                        } catch (IllegalAccessException v0_4) {
                            v0_4.printStackTrace();
                        } catch (IllegalArgumentException v0_5) {
                            v0_5.printStackTrace();
                        }
                    }
                }
            }
        }
        return method;
    }

    public static Class getClass_a(Class clsArg) {
        if(clsArg.getName().equals("int")) {
            clsArg = Integer.class;
        }
        else if(clsArg.getName().equals("long")) {
            clsArg = Long.class;
        }
        else if(clsArg.getName().equals("short")) {
            clsArg = Short.class;
        }
        else if(clsArg.getName().equals("float")) {
            clsArg = Float.class;
        }
        else if(clsArg.getName().equals("double")) {
            clsArg = Double.class;
        }
        else if(clsArg.getName().equals("boolean")) {
            clsArg = Boolean.class;
        }
        return clsArg;
    }
}
