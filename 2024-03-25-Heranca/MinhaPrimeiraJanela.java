import javax.swing.*;
import java.awt.*;

public class MinhaPrimeiraJanela extends JFrame {
    // programando uma janela gráfica

    public MinhaPrimeiraJanela() {
        super(); // chama o construtor da super classe
        this.setSize(1024, 600); // tamanho da janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); // se fechar a janela, ele para o programa
        this.setTitle("Maria Rita"); // titulo do programa (barra/menu superior)
        this.setCursor(Cursor.HAND_CURSOR); //mudando o cursor da janela
        this.getContentPane().setBackground(Color.orange);
        this.setVisible(true); // visibilidade da janela


    }


}
