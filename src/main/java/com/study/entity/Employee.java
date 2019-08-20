package com.study.entity;

/**
 * 员工
 * @author Administrator
 *
 */
public class Employee {
	/** 姓名 */
	private String name;
	/** 年龄 */
	private Integer age;
	/** 薪水 */
	private Long salary;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getSalary() {
		return salary;
	}
	public void setSalary(Long salary) {
		this.salary = salary;
	}
	public Employee(String name, Integer age, Long salary) {
	    super();
	    this.name = name;
	    this.age = age;
	    this.salary = salary;
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}
	
	public static boolean isAge(Employee employee) {
		return employee.getAge() > 30;
	}
	public static boolean isSalary(Employee employee) {
		return employee.getSalary().longValue() > 10000;
	}
}
