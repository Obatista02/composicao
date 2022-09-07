package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.workerLevel;

public class worker {

	private String name;
	private workerLevel level;
	private Double baseSalary;

	private departament derp;
	private List<HourConetract> contracts = new ArrayList<>();

	public worker() {

	}

	public worker(String name, workerLevel level, Double baseSalary, departament derp) {

		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.derp = derp;

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public workerLevel getLevel() {
		return level;
	}

	public void setLevel(workerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public departament getDerp() {
		return derp;
	}

	public void setDerp(departament derp) {
		this.derp = derp;
	}

	public List<HourConetract> getContract() {
		return contracts;
	}

	public void addContract(HourConetract contract) {
		contracts.add(contract);
	}

	public void removeContract(HourConetract contract) {
		contracts.remove(contract);
	}

	public Double income(int year, int month) {

		double sum = baseSalary;

		Calendar cal = Calendar.getInstance();
		for (HourConetract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);

			if (year == c_year && month == c_month) {
				sum += c.valeuTotal();
			}
		}
		return sum;

	}

}
