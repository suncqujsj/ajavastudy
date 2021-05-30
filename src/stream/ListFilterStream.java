package stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import bean.Person;
import utils.DateTimeUtil;

/**
 * list�Ӽ��Ϲ��ˣ���������ֵΪ�ض���������ѡ
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

		// �����������2���ҷ�������8�ļ���
		System.out.println("--------------------1.�����������2���ҷ�������8�ļ���----------------------------------");
		List<Person> childs = ps.stream().filter(s -> s.getScore() > 3 && s.getAge() >= 2).collect(Collectors.toList());
		// ������ҽ��
		for (Person person : childs) {
			System.out.println("Score:" + person.getScore() + "," + "Age:" + person.getAge());
		}
		
		System.out.println(ps.size());
	}
}