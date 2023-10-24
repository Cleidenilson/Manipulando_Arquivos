package exercicio_arquivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws IOException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		System.out.println("Informe o diretório do arquivo: ");
		String path = sc.nextLine();
		// FileReader fr = new FileReader(path);

		File sourceFile = new File(path);
		String sourceFolderStr = sourceFile.getParent();

		boolean success = new File(sourceFolderStr + "\\out").mkdir();

		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";

		FileWriter fw = new FileWriter(targetFileStr);
		List<Produto> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				String[] item = itemCsv.split(",");
				String produto = item[0];
				Double valor = Double.parseDouble(item[1]);
				Integer quantidade = Integer.parseInt(item[2]);

				list.add(new Produto(produto, valor, quantidade));
				System.out.println(produto + " " + valor + " " + quantidade);
				itemCsv = br.readLine();

			}
			try (BufferedWriter bw = new BufferedWriter(fw)) {
				for (Produto itens : list) {

					bw.write(itens.getProduto() + ", " + String.format("%.2f", itens.total()));
					bw.newLine();
					System.out.println((itens.getProduto() + " " + String.format("%.2f", itens.total())));

				}
				System.out.println(targetFileStr + " CREATED!");

			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());

		}
		sc.close();
	}

}
