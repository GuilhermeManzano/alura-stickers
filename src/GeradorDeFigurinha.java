import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class GeradorDeFigurinha {

    public static void gerarFigurinha(Movie movie) {
        try {
            InputStream inputStream = new URL(movie.getImage()).openStream();
            BufferedImage imagemOriginal = ImageIO.read(inputStream);

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

            String regex = movie.getTitle().split(":")[0];
            String createFileSticker = String.format("src/saida/%s.png", regex);
            ImageIO.write(novaImagem, "png", new File(createFileSticker));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
