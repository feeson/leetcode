package util;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GetAndInvoke <T>{
    T bean;
    Map<String,Method> methodMap=new HashMap<>();
    public GetAndInvoke(T bean){
        this.bean=bean;
        Class<?> aClass = bean.getClass();
        Method[] methods = aClass.getMethods();
        for (Method method:methods)
            methodMap.put(method.getName(),method);
    }
    String[]methodArr;
    public void SetMethodArr(String[] methodArr){
        this.methodArr=methodArr;
    }
    public void SetMethodParam(Object[][]params){
        int len=params.length;

        for (int i=0;i<len;++i) {
            Method method = methodMap.get(methodArr[i]);
            Class<?>[] parameterTypes = method.getParameterTypes();
            int len2 = parameterTypes.length;
        }
    }
}
