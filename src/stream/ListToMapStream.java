package stream;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import bean.Person;
import utils.DateTimeUtil;

/**
 * listת��Ϊmap var-object var-var�������ظ�����ֵ�Ĵ���
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

		System.out.println("--------------------1.����Ϊkey������Ϊvalue----------------------------------");
		Map<String, Person> maps = ps.stream().collect(Collectors.toMap(Person::getId, a -> a, (k1, k2) -> k1));
		maps.forEach((key, value) -> {
			System.out.println("key: " + key + "    value: " + value);
		});

		System.out.println();
		System.out.println();
		System.out.println("--------------------2.����Ϊkey������Ϊvalue----------------------------------");
		Map<String, String> map = ps.stream().collect(Collectors.toMap(Person::getId, Person::getName));
		map.forEach((key, value) -> {
			System.out.println("key: " + key + "    value: " + value);
		});
		
		System.out.println();
		System.out.println();
		// ����һ��List����
		List<Person> list = new ArrayList();
		list.add(new Person("1001", "СA"));
		list.add(new Person("1001", "СB"));
		list.add(new Person("1001", "СD"));
		list.add(new Person("1003", "СC"));
		System.out.println(list);

		System.out.println();
		System.out.println();
		// ���������(�����֣��������ֿ�ҵ������)
		// 1.�ظ�ʱ�ú����value ����ǰ���value
		System.out.println("--------------------1.�ظ�ʱ�ú����value ����ǰ���value----------------------------------");
		Map<String, String> lmap1 = list.stream()
				.collect(Collectors.toMap(Person::getId, Person::getName, (key1, key2) -> key2));
		System.out.println(lmap1);

		System.out.println();
		System.out.println();
		// 2.�ظ�ʱ��ǰ���value �ͺ����valueƴ��������
		System.out.println("--------------------2.�ظ�ʱ��ǰ���value �ͺ����valueƴ������----------------------------------");
		Map<String, String> map22 = list.stream()
				.collect(Collectors.toMap(Person::getId, Person::getName, (key1, key2) -> key1 + "," + key2));
		System.out.println(map22);

		System.out.println();
		System.out.println();
		// 3.�ظ�ʱ���ظ�key��������ɼ���
		System.out.println("------------------------------3.�ظ�ʱ���ظ�key��������ɼ���--------------------------------------------");
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