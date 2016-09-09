package cgod.daili.dtdaili;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Client {
	public static void main(String[] args) throws Exception {
		RealSubject rs = new RealSubject();
		InvocationHandler in = new DynamicSubject(rs);
		Class cls = rs.getClass();
		System.out.println(cls);
		//返回的类的类加载器
		ClassLoader cl = cls.getClassLoader();
		System.out.println(cl);
		//获取cls实现的接口
		Class[] inf = cls.getInterfaces();
		for (Class class1 : inf) {
			System.out.println("interface" + class1);
		}
		//返回给定的类加载器和接口数组代理类的java.lang.Class对象，。代理类将由指定的类加载器定义，并将实现提供的所有接口。如果接口相同排列的代理类已经被类加载器定义，那么现有的代理类将返回;否则，将动态生成这些接口的代理类和由类加载器定义
		Class c = Proxy.getProxyClass(cl, inf);
		System.out.println("1=="+c);
		Constructor[] cccc = c.getConstructors();
		for (Constructor constructor : cccc) {
			System.out.println("asd===="+constructor);
		}
		//返回一个Constructor对象，它反映此Class对象所表示的类的指定公共构造。 parameterTypes参数是一个数组的Class对象识别的构造函数的形参类型，在声明的顺序
		Constructor ct = c.getConstructor(new Class[]{InvocationHandler.class});
		System.out.println("2=="+ct);
		//获取realSubject的代理实例
		Subject subject = (Subject)ct.newInstance(new Object[]{in});
		System.out.println("3=="+subject);
//		Subject subject = (Subject)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), in);
		subject.request("i am cgod!");
	}
}
