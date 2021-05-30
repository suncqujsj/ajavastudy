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

		// 从 Map 集合中产生流数据，。然后分别调用 getKey() 和 getValue() 获取值。
		Map<String, Double> m = new HashMap<>();
		m.put("AA", 1.1);
		m.put("BB", 1.3);
		m.put("DDD", 3.1);
		m.put("CCC", 2.1);

		// 我们首先调用 entrySet() 产生一个对象流，每个对象都包含一个 key 键以及与其相关联的 value 值
		// 将对象作为e参数传到后面，
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
		Arrays.stream(new int[] { 1, 2, 3, 4, 5 }).forEach(n -> System.out.format("%d  ", n));// lamabad表达式
		System.out.println();
		System.out.println("#######################");
		// 指定从哪里开始到哪里结束，左闭右开区间
		Arrays.stream(new double[] { 1.1, 2.2, 3.3, 4.4, 5.5, 6.6, 7.7 }, 3, 6).forEach(n -> System.out.println(n));
		System.out.println("##############");

		Arrays.stream(new long[] { 111111, 444444, 444999 }).forEach(System.out::println);// 引用
	}
}