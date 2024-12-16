import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ImageViewer extends JFrame {
    private ImagePanel imagePanel;
    private JButton openButton;

    public ImageViewer() {
        setTitle("Image Viewer");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Panel gambar
        imagePanel = new ImagePanel();
        add(new JScrollPane(imagePanel), BorderLayout.CENTER);

        // Tombol untuk membuka file gambar
        JPanel buttonPanel = new JPanel();
        openButton = new JButton("Open Image");
        buttonPanel.add(openButton);
        add(buttonPanel, BorderLayout.SOUTH);

        openButton.addActionListener(new OpenImageAction());
    }

    private class OpenImageAction implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter("Image files", "jpg", "png", "jpeg"));
            int result = fileChooser.showOpenDialog(ImageViewer.this);

            if (result == JFileChooser.APPROVE_OPTION) {
                String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                OFImage image = ImageFileManager.loadImage(filePath);
                imagePanel.setImage(image);
                imagePanel.repaint();
            }
        }
    }
}
