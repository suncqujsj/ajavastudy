package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import bean.Person;

public class StreamStudy {
	public static void main(String[] args) {
		List<Person> peos = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			Person peo = new Person("id" + i, "name" + i);
			peos.add(peo);
		}

		System.out.println("**********************************");

		Stream.of("aaa", "bbb", "vvv").forEach(System.out::println);
		Stream.of(1111, 2222, 3333).forEach(System.out::println);

		System.out.println("**********************************");

		// �� Map �����в��������ݣ���Ȼ��ֱ���� getKey() �� getValue() ��ȡֵ��
		Map<String, Double> m = new HashMap<>();
		m.put("AA", 1.1);
		m.put("BB", 1.3);
		m.put("DDD", 3.1);
		m.put("CCC", 2.1);

		// �������ȵ��� entrySet() ����һ����������ÿ�����󶼰���һ�� key ���Լ������������ value ֵ
		// ��������Ϊe�����������棬
		m.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).forEach(System.out::println);

		m.entrySet().stream().map(e -> e.getKey() + ":" + e.getValue()).forEach(n -> System.out.print(n + ";"));

		System.out.println("**********************************");

		ArrayList<String> list = new ArrayList<>();
		list.add("AAA");
		list.add("BBB");
		list.add("CCC");
		list.add("DDD");
		list.add("EEE");
		System.out.println(list);

		list.stream().forEach(System.out::println);
		list.stream().forEach(System.out::print);
		System.out.println();
		System.out.println("**********************************");
		list.stream().forEach(n -> System.out.print(n + ","));

		System.out.println("**********************************");
		Arrays.stream(new int[] { 1, 2, 3, 4, 5 }).forEach(n -> System.out.format("%d  ", n));// lamabad���ʽ
		System.out.println();
		System.out.println("#######################");
		// ָ�������￪ʼ���������������ҿ�����
		Arrays.stream(new double[] { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 }, 3, 6).forEach(n -> System.out.println(n));
		System.out.println("##############");

		Arrays.stream(new long[] { 111111, 444444, 444999 }).forEach(System.out::println);// ����
	}
}