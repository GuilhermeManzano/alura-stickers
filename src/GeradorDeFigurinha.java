import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GeradorDeFigurinha {

    public void cria() throws IOException {
        BufferedImage imagemOriginal = ImageIO.read(new File("src/entrada/filme.jpg"));

        int largura = imagemOriginal.getWidth();
        int altura = imagemOriginal.getHeight();
        int novaAltura = altura + 200;
        BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
        graphics.drawImage(imagemOriginal, 0, 0, null);

         var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
         graphics.setColor(Color.RED);
         graphics.setFont(fonte);

         graphics.drawString("TOPZERA", 200, novaAltura - 100);

        ImageIO.write(novaImagem, "png", new File("src/saida/figurinha.png"));
    }
}
