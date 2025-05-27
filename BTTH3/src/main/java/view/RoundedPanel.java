/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

/**
 *
 * @author hoanhnguyen
 */
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.border.Border;

public class RoundedPanel extends JPanel {
    private int radius;
    private Border defaultBorder;
    private Border hoverBorder;
    public RoundedPanel(int radius, Color bgColor,Shoe newShoe,Shoe shoe) {
        this.radius = radius;
        setBackground(bgColor);
        setOpaque(false); // để paintComponent có hiệu lực
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        
    // Tạo các border chỉ 1 lần
    hoverBorder = BorderFactory.createCompoundBorder(
        new RoundedBorder(radius),
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
    );
    defaultBorder = BorderFactory.createCompoundBorder(
        BorderFactory.createLineBorder(Color.GRAY,0),  
        BorderFactory.createEmptyBorder(10, 10, 10, 10)
    );
    
    setBorder(defaultBorder);
      // Sự kiện hover
    this.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            setBorder(hoverBorder);
            newShoe=shoe;
        }

        @Override
        public void mouseExited(MouseEvent e) {
            setBorder(defaultBorder);
        }
    });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Vẽ hình chữ nhật bo góc với màu nền
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
    }
}

