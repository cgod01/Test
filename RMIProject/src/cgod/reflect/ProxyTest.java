package cgod.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

public class ProxyTest {  
    public static void main(String[] args)throws Exception{  
        Class ClazzProxy=Proxy.getProxyClass(Collection.class.getClassLoader(),Collection.class);      //获得代理类的字节码  
        System.out.println(ClazzProxy);  
        Constructor[] cons=ClazzProxy.getConstructors();                                             //获得代理类的构造方法  
        StringBuilder sb=new StringBuilder();   
        for(Constructor con:cons){  
            System.out.print(con.getName());  
            sb.append('(');  
            Class[] cls=con.getParameterTypes();  
            for(Class cl:cls){  
                sb.append(cl.getName()+',');  
            }  
            if(cls!=null&&cls.length!=0)  
            sb.deleteCharAt(sb.length()-1);  
            sb.append(')');  
        }  
        System.out.println(sb.toString());  
          
          
        System.out.println("Method----------------------------------------");  
  
        Method[] meths=ClazzProxy.getMethods();                                                 //获得代理类的成员方法  
  
        for(Method meth:meths){  
            StringBuilder sb1=new StringBuilder();   
            System.out.print(meth.getName());  
            sb1.append('(');  
            Class[] cls=meth.getParameterTypes();  
            for(Class cl:cls){  
                sb1.append(cl.getName()+',');  
            }  
            if(cls!=null&&cls.length!=0)  
            sb1.deleteCharAt(sb1.length()-1);  
            sb1.append(')');  
            System.out.println(sb1.toString());  
        }  
          
        System.out.println("----------------------------------------------");  
          
        Constructor con=ClazzProxy.getConstructor(InvocationHandler.class);     //获得构造方法  
        class Ivct implements InvocationHandler{  
            public void invoke(){}  
  
            @Override  
            public Object invoke(Object arg0, Method arg1, Object[] arg2)  
                    throws Throwable {  
                // TODO Auto-generated method stub  
                return null;  
            }  
        }  
        Collection coll=(Collection)con.newInstance(new Ivct());  
          
        //coll.size();                                                    //size会调用InvocationHandler的invoke方法，但是上面的invoke方法返回值是null，而  
                                                                            //size需要的是一个int类型的返回值，所以会报错  
          
          
          
          
        Collection proxy2=(Collection)Proxy.newProxyInstance(  
                Collection.class.getClassLoader(),  
                new Class[]{Collection.class},  
                new InvocationHandler(){  
  
                     ArrayList al=new ArrayList();  
                    public Object invoke(Object proxy, Method method,  
                            Object[] args) throws Throwable {  
                        Object obj=method.invoke(al, args);  
                        System.out.println(obj+"Test..........");  
                        return obj;  
                    }  
                      
                      
                });  
        proxy2.add("zs");                                      //每次调用add方法时,add就会调用InvocationHandler的invoke方法  
        proxy2.add("ls");  
        proxy2.add("ww");  
        System.out.println(proxy2);  
        System.out.println(proxy2.size());  
    }  
}  
