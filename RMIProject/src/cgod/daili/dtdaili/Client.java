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
		//���ص�����������
		ClassLoader cl = cls.getClassLoader();
		System.out.println(cl);
		//��ȡclsʵ�ֵĽӿ�
		Class[] inf = cls.getInterfaces();
		for (Class class1 : inf) {
			System.out.println("interface" + class1);
		}
		//���ظ�������������ͽӿ�����������java.lang.Class���󣬡������ཫ��ָ��������������壬����ʵ���ṩ�����нӿڡ�����ӿ���ͬ���еĴ������Ѿ�������������壬��ô���еĴ����ཫ����;���򣬽���̬������Щ�ӿڵĴ�������������������
		Class c = Proxy.getProxyClass(cl, inf);
		System.out.println("1=="+c);
		Constructor[] cccc = c.getConstructors();
		for (Constructor constructor : cccc) {
			System.out.println("asd===="+constructor);
		}
		//����һ��Constructor��������ӳ��Class��������ʾ�����ָ���������졣 parameterTypes������һ�������Class����ʶ��Ĺ��캯�����β����ͣ���������˳��
		Constructor ct = c.getConstructor(new Class[]{InvocationHandler.class});
		System.out.println("2=="+ct);
		//��ȡrealSubject�Ĵ���ʵ��
		Subject subject = (Subject)ct.newInstance(new Object[]{in});
		System.out.println("3=="+subject);
//		Subject subject = (Subject)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), in);
		subject.request("i am cgod!");
	}
}
