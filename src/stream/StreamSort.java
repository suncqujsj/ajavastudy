package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import bean.Person;
import utils.DateTimeUtil;

public class StreamSort {
	public static void main(String[] args) {
		List<Person> ps = new ArrayList<Person>();
		for (int i = 0; i < 10; i++) {
			Person p = new Person();
			p.setBirthDay(DateTimeUtil.formatAll(DateTimeUtil.addDays(new Date(), -i)));
			p.setAge(i);
			ps.add(p);
		}

		// ����:һ��Ҫ��ps1���գ��÷������ᶯ��psԭʼ����
		System.out.println("--------------------BirthDay asc----------------------------------");
		List<Person> ps1 = ps.stream().sorted(Comparator.comparing(Person::getBirthDay)).collect(Collectors.toList());
		for (Person people : ps1) {
			System.out.println(people.getBirthDay());
		}

		System.out.println("--------------------age asc----------------------------------");
		List<Person> ps2 = ps.stream().sorted(Comparator.comparing(Person::getAge)).collect(Collectors.toList());
		for (Person people : ps2) {
			System.out.println(people.getAge());
		}

		System.out.println("-------------------------desc-----------------------------");

		// ����
		System.out.println("--------------------BirthDay desc----------------------------------");
		List<Person> ps3 = ps.stream().sorted(Comparator.comparing(Person::getBirthDay).reversed())
				.collect(Collectors.toList());
		for (Person people : ps3) {
			System.out.println(people.getBirthDay());
		}

		// ����
		System.out.println("--------------------age desc----------------------------------");
		List<Person> ps4 = ps.stream().sorted(Comparator.comparing(Person::getAge).reversed())
				.collect(Collectors.toList());
		for (Person people : ps4) {
			System.out.println(people.getAge());
		}
	}
}