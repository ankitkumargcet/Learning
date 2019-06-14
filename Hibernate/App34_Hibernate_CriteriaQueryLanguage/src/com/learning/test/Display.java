package com.learning.test;

import java.util.Iterator;
import java.util.List;

import com.learning.entity.Employee;

public class Display {
	public static void displayAll(List<Employee> list) {

		// Displaying value on console
		Iterator<Employee> itr = list.iterator();
		while (itr.hasNext()) {
			Employee emp = itr.next();
			System.out.println(
					"[ " + emp.getEno() + ", " + emp.getEname() + ", " + emp.getEsal() + ", " + emp.getEaddr() + " ]");
		}
	}
}
