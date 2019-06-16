import java.awt.*;
import javax.swing.*;
public class backgroundPanel extends JPanel {//通过在JFrame中添加一个JPanel,然后把图片放在JPanel上
    Image im;

    public backgroundPanel(Image im) {
        this.im = im;
        this.setOpaque(true);
    }

    //Draw the back ground.
    public void paintComponent(Graphics g) {
        super.paintComponents(g);
        g.drawImage(im, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}
