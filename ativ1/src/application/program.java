package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.HourConetract;
import entities.departament;
import entities.worker;
import entities.enums.workerLevel;

public class program {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Digite o nome do departamento: ");
		String departament = sc.nextLine();
		System.out.println("Dados do Funcionario: ");
		System.out.print("Nome: ");
		String name = sc.nextLine();
		System.out.print("Nivel: ");
		String wokerLevel = sc.nextLine();
		System.out.print("Base salarial: ");
		double baseSalary = sc.nextDouble();

		worker job = new worker(name, workerLevel.valueOf(wokerLevel), baseSalary,
				new departament(departament));

		System.out.print("Quantos contratos o funcionario tem? ");
		int n = sc.nextInt();

		for (int i = 1; i <= n; i++) {
			System.out.println("Digite os dados do contrato #" + i);
			System.out.print("Data (DD/MM/YYYY): ");
			Date contractDate = sdf.parse(sc.next());
			System.out.print("Valor por hora: ");
			double valuePerHours = sc.nextDouble();
			System.out.print("Dureação: ");
			int hours = sc.nextInt();

			HourConetract contract = new HourConetract(contractDate, valuePerHours, hours);
			job.addContract(contract);

		}
		System.out.println();
		System.out.print("Digite o mes e ano para calcular a renda: ");
		String monthAndYear = sc.nextLine();

		int month = Integer.parseInt(monthAndYear.substring(0, 2));
		int year = Integer.parseInt(monthAndYear.substring(3));

		System.out.println("Nome: " + job.getName());
		System.out.println("Departamento: " + job.getDerp().getName());
		System.out.println("Rende de " + monthAndYear + ": " + String.format("%.2f", job.income(year, month)));

		sc.close();
	}

}
