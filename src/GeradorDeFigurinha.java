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
            BufferedImage oldImage = getImage(movie);
            BufferedImage newImage = convertImage(oldImage);

            drawImage(oldImage, newImage);

            generateImageFile(movie, newImage);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static BufferedImage getImage(Movie movie) throws IOException {
        InputStream inputStream = new URL(movie.getImage()).openStream();

        return ImageIO.read(inputStream);
    }

    private static BufferedImage convertImage(BufferedImage image) {
        int largura = image.getWidth();
        int altura = image.getHeight();
        int novaAltura = altura + 200;

        return new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);
    }

    private static void drawImage(BufferedImage oldImage, BufferedImage newImage) {
        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(newImage, 0, 0, null);

        createImageText(graphics, oldImage);
    }

    private static void createImageText(Graphics2D graphics, BufferedImage oldImage) {
        var fonte = new Font(Font.SANS_SERIF, Font.BOLD, 64);
        graphics.setColor(Color.RED);
        graphics.setFont(fonte);

        graphics.drawString("TOPZERA", 200, oldImage.getHeight() - 100);
    }

    private static void generateImageFile(Movie movie, BufferedImage newImage) throws IOException {
        String regex = movie.getTitle().split(":")[0];
        String createFileSticker = String.format("src/saida/%s.png", regex);

        ImageIO.write(newImage, "png", new File(createFileSticker));
    }
}
