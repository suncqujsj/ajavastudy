package stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import bean.Person;
import utils.DateTimeUtil;

/**
 * list子集合过滤，满足属性值为特定条件的赛选
 * 
 * @author bob
 *
 */
public class ListFilterStream {
	public static void main(String[] args) {
		List<Person> ps = new ArrayList<Person>();
		for (int i = 0; i < 10; i++) {
			Person p = new Person();
			p.setBirthDay(DateTimeUtil.formatAll(DateTimeUtil.addDays(new Date(), -i)));
			p.setAge(i);
			p.setId("id-" + i);
			p.setName("name-" + i);
			p.setScore(i);
			ps.add(p);
		}

		// 查找年龄大于2并且分数大于8的集合
		System.out.println("--------------------1.查找年龄大于2并且分数大于8的集合----------------------------------");
		List<Person> childs = ps.stream().filter(s -> s.getScore() > 3 && s.getAge() >= 2).collect(Collectors.toList());
		// 输出查找结果
		for (Person person : childs) {
			System.out.println("Score:" + person.getScore() + "," + "Age:" + person.getAge());
		}
		
		System.out.println(ps.size());
	}
}