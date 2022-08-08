package campominado.visao;

import java.awt.GridLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import campominado.modelo.Tabuleiro;

@SuppressWarnings("serial")
public class PainelTabuleiro extends JPanel {

	public PainelTabuleiro(Tabuleiro tabuleiro) {
		setLayout(new GridLayout(tabuleiro.getLinhas(), tabuleiro.getColunas()));
		
		tabuleiro.paraCada(c -> add(new BotaoCampo(c)));
		tabuleiro.registrarObservadores(e -> {
			
			SwingUtilities.invokeLater(() -> {
				
				if(tabuleiro.objetivoAlcancado()) {
					JOptionPane.showMessageDialog(null, "Você ganhou!!!!");
				} else {
					JOptionPane.showMessageDialog(null, "Você perdeu!!!!");
				}
				
				tabuleiro.reiniciar();
				
				
			});
		});
	}
	
	
}
