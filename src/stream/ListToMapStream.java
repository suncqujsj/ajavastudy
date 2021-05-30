package stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.Person;
import utils.DateTimeUtil;

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
	}
}