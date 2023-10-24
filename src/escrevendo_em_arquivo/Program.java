package escrevendo_em_arquivo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Program {

	public static void main(String[] args) {
		List<String> lines = new ArrayList<>();
		for (int i = 0; i < 2; i++) {
			lines.add("Line " +i+ " Bom dia, Boa tarde, Boa noite");

		}

		String path = "c:\\treinamento\\out.txt";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
			for (String line : lines) {
				bw.write(line);
				bw.newLine();
			}

		} catch (IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}

	}
}
