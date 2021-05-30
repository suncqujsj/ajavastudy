package stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.Person;
import utils.DateTimeUtil;

/**
 * list分组，key相同的对象分为一组
 * @author bob
 *
 */
public class ListToGroupStream {
	public static void main(String[] args) {
		List<Person> ps = new ArrayList<Person>();
		for (int i = 0; i < 10; i++) {
			Person p = new Person();
			p.setBirthDay(DateTimeUtil.formatAll(DateTimeUtil.addDays(new Date(), -i)));
			p.setAge(i);
			p.setId("id-" + i);
			p.setName("name-" + i);
			ps.add(p);
			
			Person p2 = new Person();
			p2.setBirthDay(DateTimeUtil.formatAll(DateTimeUtil.addDays(new Date(), -i)));
			p2.setAge(i);
			p2.setId("id-" + i);
			p2.setName("name-" + i);
			ps.add(p);
		}

		System.out.println("--------------------1.相同年龄的分为一组----------------------------------");
		Map<Integer, List<Person>> groupBy = ps.stream().collect(Collectors.groupingBy(Person::getAge));
		System.err.println("groupBy:"+groupBy);
	}
}