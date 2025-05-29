package view;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
/**
 *
 * @author hoanhnguyen
 */
import javax.swing.*;
import java.awt.*;


public class  Main{
    
    private JPanel leftPanel;
    
    public static void main(String[] args) {
    SwingUtilities.invokeLater(() -> {
        Main app = new Main();
        app.createAndShowGUI();
    });
    }
    
    private void createAndShowGUI () {
        // tạo của sổ
        JFrame frame = new JFrame("SHOE STORE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 800);
        frame.setResizable(false);          //  Không cho resize
        frame.setLocationRelativeTo(null);  // căn giữa màn hình
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);
        
        Shoe defaultShoe = ShoeData.getShoes().get(0);
        // Left Panel with default shoe
        leftPanel = ProcessShoePanel.createLeftPanel(defaultShoe);   
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new Dimension(400, 0));
        
        // Right Panel
        JPanel rightPanel = ProcessShoePanel.createRightPanel(selectedShoe->{
        frame.remove(leftPanel); // Xoá panel cũ
        leftPanel =ProcessShoePanel.createLeftPanel(selectedShoe); // Tạo lại panel mới
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setOpaque(true);
        leftPanel.setPreferredSize(new Dimension(400, 0));
        frame.add(leftPanel, BorderLayout.WEST);
        frame.revalidate(); // Cập nhật lại layout
        frame.repaint();    // Vẽ lại
        });

        rightPanel.setBackground(Color.WHITE);
        rightPanel.setOpaque(true);

        frame.add(leftPanel, BorderLayout.WEST);
//      frame.add(rightPanel,BorderLayout.CENTER);
        frame.add(new JScrollPane(rightPanel), BorderLayout.CENTER);
        frame.setVisible(true);
    }

}
