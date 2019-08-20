package com.study.study_test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.alibaba.fastjson.JSONObject;
import com.study.entity.Employee;
import com.study.interfaces.MyPredicate;

public class TestLambda {
	
	protected void printToConsole(Object obj) {
		System.err.println(JSONObject.toJSONString(obj));
	}

	List<Employee> employees = Arrays.asList(
			new Employee("张三", 18, 99999L),
			new Employee("李四", 38, 5555L),
			new Employee("王五", 50, 6666L),
			new Employee("赵六", 16, 33333L),
			new Employee("田七", 8, 77777L));
	// 需求：获取当前公司中年龄大于30的员工信息
	public static List<Employee> filterAge(List<Employee> employees) {
		List<Employee> result = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getAge() > 30) {
				result.add(employee);
			}
		}
		return result;
	}

	// 需求：获取当前公司中薪资大于10000的员工信息
	public static List<Employee> filterSalary(List<Employee> employees) {
		List<Employee> result = new ArrayList<>();
		for (Employee employee : employees) {
			if (employee.getSalary().longValue() > 10000) {
				result.add(employee);
			}
		}
		return result;
	}
	
	public List<Employee> filterEmployee(List<Employee> employees, MyPredicate<Employee> p) {
		List<Employee> result = new ArrayList<>();
		for (Employee employee : employees) {
			if (p.test(employee)) {
				result.add(employee);
			}
		}
		return result;
	}

	@Test
	public void test1() {
		List<Employee> result = filterEmployee(employees, new MyPredicate<Employee>() {
			@Override
			public boolean test(Employee t) {
				return t.getSalary().longValue() > 6000L;
			}
		});
		printToConsole(result);
		List<Employee> result1 = filterEmployee(employees, Employee :: isAge);
		printToConsole(result1);
		List<Employee> result2 = filterEmployee(employees, x -> x.getAge() > 30);
		printToConsole(result2);
	}
	
	@Test
	public void test2() {
		employees.stream().filter(Employee :: isAge).forEach(System.err :: println);
	}
}
