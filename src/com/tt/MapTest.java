package com.tt;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
	public static void main(String[] args) {
		Map<String, Employee> staff = new HashMap<String, Employee>();
		staff.put("144-25-5464", new Employee("Amy"));
		staff.put("567-24-2546", new Employee("Harry"));
		staff.put("157-62-7935", new Employee("Gray"));
		staff.put("456-62-5527", new Employee("France"));
		System.out.println("初始化 " + staff);

		staff.remove("456-62-5527");// 删除
		System.out.println("删除后 " + staff);

		staff.put("144-25-5464", new Employee("Bob"));// 替换
		System.out.println("替换后 " + staff);

		System.out.println("查询后 " + staff.get("157-62-7935"));// 查询

		// 取得map中所有的key和value
		for (Map.Entry<String, Employee> entry : staff.entrySet()) {
			String key = entry.getKey();
			Employee value = entry.getValue();
			System.out.println("取得map中所有的key和value" + "key=" + key + ", value=" + value + "");
		}

		// 取得map中所有的key
		Set<String> keys = staff.keySet();
		for (String key : keys) {
			System.out.println("取得map中所有的key" + key);
		}

		// 取得map中所有的value
		Collection<Employee> values = staff.values();
		for (Employee value : values) {
			System.out.println("取得map中所有的value" + value);
		}
	}
}
