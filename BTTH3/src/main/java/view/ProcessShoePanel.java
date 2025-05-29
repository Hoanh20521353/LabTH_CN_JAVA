/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.awt.event.*;
import java.util.function.Consumer;
/**
 *
 * @author hoanhnguyen
 */
public class ProcessShoePanel {
        public static  JPanel createLeftPanel(Shoe newShoe) {
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding

        ImageIcon icon = new ImageIcon(newShoe.getImagePath());
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel title = new JLabel(newShoe.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 22));
        String upperText = title.getText().toUpperCase();
        title.setText(upperText);
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        JLabel price = new JLabel(newShoe.getPrice());
        price.setFont(new Font("Tahoma", Font.TYPE1_FONT, 20));
        price.setAlignmentX(Component.CENTER_ALIGNMENT);
    
        JLabel brand = new JLabel(newShoe.getBrand());
        brand.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
        brand.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel note = new JLabel("<html><p style='text-align:center; width:285px;'>"+ newShoe.getNote() +"</p></html>");
//      JLabel note = new JLabel("This product is excluded from all promotional discounts and offers.");
        note.setFont(new Font("Arial", Font.BOLD, 18));
        note.setForeground(new Color( 188, 188, 188 ));
        note.setAlignmentX(Component.CENTER_ALIGNMENT);
        
                
        // Thêm đường kẻ ngang
        JSeparator separator = new JSeparator(SwingConstants.HORIZONTAL);
        separator.setMaximumSize(new Dimension(Integer.MAX_VALUE, 10)); // chiều dài full theo chiều ngang
        separator.setForeground(Color.GRAY); // màu đường kẻ


        panel.add(imageLabel);
        panel.add(Box.createVerticalStrut(20));
        panel.add(separator);
        panel.add(Box.createVerticalStrut(8));
        panel.add(title);
        panel.add(Box.createVerticalStrut(8));
        panel.add(price);
        panel.add(Box.createVerticalStrut(8));
        panel.add(brand);
        panel.add(Box.createVerticalStrut(8));
        panel.add(note);

        return panel;
    }
        
        public static JPanel createRightPanel(Consumer<Shoe> onShoeSelected) {
        
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 4, 20, 20)); // 2 cột, tự động xuống dòng
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding bên trong

        List<Shoe> shoes = ShoeData.getShoes();
        for (Shoe shoe : shoes) {
            panel.add(createShoePanel(shoe,onShoeSelected));
        }

        return panel;
        }
        
        public static JPanel createShoePanel(Shoe shoe,Consumer<Shoe> onClick) {
        
        JPanel shoePanel = new RoundedPanel(20, new Color(232, 232, 232));
        shoePanel.setPreferredSize(new Dimension(240, 310)); // xét chiều rộng và cao cho panel (từng thẻ giày )
        shoePanel.setLayout(new BoxLayout(shoePanel, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel(shoe.getTitle());
        String upperText = title.getText().toUpperCase();
        title.setText(upperText);
        title.setFont(new Font("Arial", Font.BOLD, 18));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        JLabel note = new JLabel(shoe.getNote());
        note.setForeground(new Color( 188, 188, 188 ));
        note.setAlignmentX(Component.CENTER_ALIGNMENT);

        ImageIcon icon = new ImageIcon(shoe.getImagePath());
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
        infoPanel.setOpaque(false); // nếu không muốn có nền cho panel phụ
        JLabel brand = new JLabel(shoe.getBrand());
        brand.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
        JLabel price = new JLabel(shoe.getPrice());
        price.setFont(new Font("Tahoma", Font.TYPE1_FONT, 20));

        infoPanel.add(brand);
        infoPanel.add(Box.createHorizontalGlue()); // brand sang trái , price sang phải 
        infoPanel.add(price);
//      infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        shoePanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                onClick.accept(shoe); // Gửi shoe về cha
            }
        });
        
        shoePanel.add(title);
        shoePanel.add(Box.createVerticalStrut(8));
        shoePanel.add(note);
        shoePanel.add(Box.createVerticalStrut(8));
        shoePanel.add(imageLabel);
        shoePanel.add(Box.createVerticalStrut(15));
        shoePanel.add(infoPanel);
        return shoePanel;
    }
}
