package br.com.trier.aula_02.utils;

import java.util.List;

import javax.swing.JOptionPane;

import br.com.trier.aula_02.carros.Carro;
import br.com.trier.aula_02.enums.CorCarro;
import br.com.trier.aula_02.services.CalculaPorcentagemCarros;
import br.com.trier.aula_02.services.ValidaAno;
import br.com.trier.aula_02.services.VerificaEnumCorCarro;

public class Tela {

private static int totalObjInstanciados = 0; //quantidade de carros Instânciados
	
	public static int opcao() {
		String opcaoStr = "1 - Cadastrar " + "\n2 - Listar carros por período de fabricação"
				+ "\n3 - Listar Carros por marca" + "\n4 - Listar carros por cor" + "\n5 - Sair";

		int n = Integer.parseInt(JOptionPane.showInputDialog(opcaoStr));
		while (n <= 0 || n > 5) {
			n = Integer.parseInt(JOptionPane.showInputDialog("Erro. Tente novamente!\n" + opcaoStr));
		}

		return n;
	}

	public static void cadastrar(int numero, List<Carro> list) {
		totalObjInstanciados++;
		String marca = JOptionPane.showInputDialog("Digite a marca do carro"); //marca do carro

		int ano = EscolheAtributos.AnoSelecionar();

		//método selecionar cor
		int valueCor = EscolheAtributos.corSelecionada();
		
		//converte a opção de 1 a 6 para cor determinada
		String cor = VerificaEnumCorCarro.verifica(valueCor); 
		
		//Instância e adiciona na lista
		list.add(new Carro(marca, ano, CorCarro.valueOf(cor)));
	}

	public static void listarCarroPeriodoFabricacao(List<Carro> list) {
		int somaObjetosSelecionados = 0; //Objetos de uma data de fabricação desejada
		
		int anoInicial = EscolheAtributos.AnoSelecionar();

		ValidaAno.validar(anoInicial); //valida ano

		int anoFinal = EscolheAtributos.AnoSelecionar();
		
		//verificar e imprimir os objetos com as condições desejadas
		String objSelecionados = "";
	for (Carro carro : list) {
			if (anoInicial <= carro.getAno() && anoFinal >= carro.getAno()) {
			  objSelecionados += carro.toString() + "\n";
				somaObjetosSelecionados++;
			}
		}
	JOptionPane.showMessageDialog(null, objSelecionados);	
	
	//percentual
		int percentual = CalculaPorcentagemCarros.calcularPorcentagem(
				totalObjInstanciados, somaObjetosSelecionados);
		
		JOptionPane.showMessageDialog(null,
				"Percentual de carros listados por fabricação:" + percentual);
	}

	public static void listarCarroPorMarca(List<Carro> list) {
		int somaObjetosSelecionados = 0;//Objetos de uma marca determinada
		
		String marca = JOptionPane.showInputDialog("Digite a marca do carro"); //marca desejada
		
		//verificar e imprimir os objetos com as condições desejadas
		String objSelecionados = "";
		for (Carro carro : list) {
			if(marca.equalsIgnoreCase(carro.getMarca())) {
				objSelecionados += carro.toString() + "\n";
				somaObjetosSelecionados++;
			}
		}
		
		JOptionPane.showMessageDialog(null, objSelecionados);
		
		//percentual
		int percentual = CalculaPorcentagemCarros.calcularPorcentagem(
				totalObjInstanciados, somaObjetosSelecionados);
		
		JOptionPane.showMessageDialog(null,
				"Percentual de carros listados por Marca:" + percentual);
	}

	public static void listarCarroPorCor(List<Carro> list) {
		int somaObjetosSelecionados = 0; //Objetos de uma cor determinada
		
		// método selecionar cor
		int valueCor = EscolheAtributos.corSelecionada();

		// converte a opção de 1 a 6 para cor determinada
		String cor = VerificaEnumCorCarro.verifica(valueCor);

		//verificar e imprimir os objetos com as condições desejadas	
		String objSelecionados = "";
		for (Carro carro : list) {
			if (carro.getCor().name().equals(cor)) {
				objSelecionados += carro.toString() + "\n";
				somaObjetosSelecionados++;
			}
		}
		JOptionPane.showMessageDialog(null, objSelecionados);
		
		//percentual
		int percentual = CalculaPorcentagemCarros.calcularPorcentagem(
				totalObjInstanciados, somaObjetosSelecionados);
		
		JOptionPane.showMessageDialog(null,
				"Percentual de carros listados por Cor:" + percentual);
	}

}
