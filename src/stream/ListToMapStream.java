package stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.Person;
import utils.DateTimeUtil;

/**
 * list转换为map var-object var-var，值对对象，值对值map，包括重复键，值的处理
 * 
 * @author bob
 *
 */
public class ListToMapStream {
	public static void main(String[] args) {
		List<Person> ps = new ArrayList<Person>();
		for (int i = 0; i < 10; i++) {
			Person p = new Person();
			p.setBirthDay(DateTimeUtil.formatAll(DateTimeUtil.addDays(new Date(), -i)));
			p.setAge(i);
			p.setId("id-" + i);
			p.setName("name-" + i);
			ps.add(p);
		}

		System.out.println("--------------------1.属性为key，对象为value----------------------------------");
		Map<String, Person> maps = ps.stream().collect(Collectors.toMap(Person::getId, a -> a, (k1, k2) -> k1));
		maps.forEach((key, value) -> {
			System.out.println("key: " + key + "    value: " + value);
		});

		System.out.println();
		System.out.println();
		System.out.println("--------------------2.属性为key，属性为value----------------------------------");
		Map<String, String> map = ps.stream().collect(Collectors.toMap(Person::getId, Person::getName));
		map.forEach((key, value) -> {
			System.out.println("key: " + key + "    value: " + value);
		});
		
		System.out.println();
		System.out.println();
		// 声明一个List集合
		List<Person> list = new ArrayList();
		list.add(new Person("1001", "小A"));
		list.add(new Person("1001", "小B"));
		list.add(new Person("1001", "小D"));
		list.add(new Person("1003", "小C"));
		System.out.println(list);

		System.out.println();
		System.out.println();
		// 解决方法：(分三种，具体哪种看业务需求)
		// 1.重复时用后面的value 覆盖前面的value
		System.out.println("--------------------1.重复时用后面的value 覆盖前面的value----------------------------------");
		Map<String, String> lmap1 = list.stream()
				.collect(Collectors.toMap(Person::getId, Person::getName, (key1, key2) -> key2));
		System.out.println(lmap1);

		System.out.println();
		System.out.println();
		// 2.重复时将前面的value 和后面的value拼接起来；
		System.out.println("--------------------2.重复时将前面的value 和后面的value拼接起来----------------------------------");
		Map<String, String> map22 = list.stream()
				.collect(Collectors.toMap(Person::getId, Person::getName, (key1, key2) -> key1 + "," + key2));
		System.out.println(map22);

		System.out.println();
		System.out.println();
		// 3.重复时将重复key的数据组成集合
		System.out.println("------------------------------3.重复时将重复key的数据组成集合--------------------------------------------");
		Map<String, List<String>> map33 = list.stream().collect(Collectors.toMap(Person::getId, p -> {
			List<String> getNameList = new ArrayList<>();
			getNameList.add(p.getName());
			return getNameList;
		}, (List<String> value1, List<String> value2) -> {
			value1.addAll(value2);
			return value1;
		}));
		System.out.println(map33);
	}
}
