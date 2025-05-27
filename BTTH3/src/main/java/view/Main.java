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
import java.util.List;
import java.awt.event.*;
import javax.swing.border.Border;
//import view.Shoe;Main
//import view.ShoeData;

public class  Main{

    public static void main(String[] args) {
        Main app = new Main(); // Tạo đối tượng của lớp BTTH3
        // tạo của sổ
        JFrame frame = new JFrame("SHOE STORE");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1500, 800);
        frame.setResizable(false);          //  Không cho resize
        frame.setLocationRelativeTo(null);  // căn giữa màn hình
        frame.setLayout(new BorderLayout());
        frame.getContentPane().setBackground(Color.WHITE);
        
        Shoe newShoe =  new Shoe(
                "Forum Low",
                "Retro basketball style reborn for the streets.",
                "./image/img6.png",
                "Adidas",
                "$110.00");
//        JPanel  newPanel = app.createShoePanel(newShoe);
        JPanel leftPanel = app.createLeftPanel(newShoe);
        leftPanel.setBackground(Color.BLUE);
        leftPanel.setOpaque(false);
        leftPanel.setPreferredSize(new Dimension(400, 0));

        JPanel rightPanel = app.createRightPanel(newShoe);
        rightPanel.setBackground(Color.WHITE);
        rightPanel.setOpaque(true);

        frame.add(leftPanel, BorderLayout.WEST);
//      frame.add(rightPanel,BorderLayout.CENTER);
        frame.add(new JScrollPane(rightPanel), BorderLayout.CENTER);
        frame.setVisible(true);
    }

    private JPanel createLeftPanel(Shoe newShoe) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding

        ImageIcon icon = new ImageIcon(newShoe.getImagePath());
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.GREEN);
        JLabel title = new JLabel(newShoe.getTitle());
        title.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel price = new JLabel(newShoe.getPrice());
        price.setFont(new Font("Arial", Font.BOLD, 16));
        JLabel brand = new JLabel(newShoe.getBrand());
        JLabel note = new JLabel("<html><p style='width:200px;'>"+ newShoe.getNote() +"</p></html>");
//      Label note = new JLabel("This product is excluded from all promotional discounts and offers.");

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

    private JPanel createRightPanel(Shoe newShoe) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 4, 20, 20)); // 2 cột, tự động xuống dòng
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // padding bên trong

        List<Shoe> shoes = ShoeData.getShoes();
        for (Shoe shoe : shoes) {
            panel.add(createShoePanel(shoe,newShoe));
        }

        return panel;
    }

    private JPanel createShoePanel(Shoe shoe,Shoe newShoe) {
        JPanel shoePanel = new RoundedPanel(20, new Color(232, 232, 232),newShoe,shoe);
        shoePanel.setPreferredSize(new Dimension(240, 310)); // xét chiều rộng và cao cho panel (từng thẻ giày )
        shoePanel.setLayout(new BoxLayout(shoePanel, BoxLayout.Y_AXIS));
//        shoePanel.setBorder(BorderFactory.createCompoundBorder(
//                new RoundedBorder(15), // Border bo góc
////                 BorderFactory.createLineBorder(Color.GRAY), // border viền ngoài
//                BorderFactory.createEmptyBorder(10, 10, 10, 10) // padding bên trong
//        ));
//        shoePanel.setBorder(BorderFactory.createLineBorder(new Color(232, 232, 232)));
//        shoePanel.setOpaque(false);
//        shoePanel.setBackground(new Color(232, 232, 232));
        JLabel title = new JLabel(shoe.getTitle());
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Arial", Font.BOLD, 20));
        JLabel note = new JLabel(shoe.getNote());
        note.setAlignmentX(Component.CENTER_ALIGNMENT);
//        note.setOpaque(true);
//        note.setBackground(Color.GREEN);
        ImageIcon icon = new ImageIcon(shoe.getImagePath());
        Image image = icon.getImage();
        Image resizedImage = image.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
        ImageIcon resizedIcon = new ImageIcon(resizedImage);
        JLabel imageLabel = new JLabel(resizedIcon);
//        imageLabel.setOpaque(true);
//        imageLabel.setBackground(Color.GREEN);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.X_AXIS));
        infoPanel.setOpaque(false); // nếu không muốn có nền cho panel phụ
        JLabel brand = new JLabel(shoe.getBrand());
        brand.setFont(new Font("Arial", Font.ROMAN_BASELINE, 20));
        JLabel price = new JLabel(shoe.getPrice());
        price.setFont(new Font("Tahoma", Font.TYPE1_FONT, 20));
//        infoPanel.setOpaque(true);
//        infoPanel.setBackground(Color.GREEN);
        infoPanel.add(brand);
        infoPanel.add(Box.createHorizontalGlue()); // brand sang trái , price sang phải 
        infoPanel.add(price);
//        infoPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

// Tạo viền khi hover
//        Border hoverBorder = BorderFactory.createLineBorder(new Color( 75, 147, 245 ), 1);
//        Border emptyBorder = BorderFactory.createEmptyBorder(); // viền rỗng ban đầu
//
//        shoePanel.addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseEntered(MouseEvent e) {
//                shoePanel.setBorder(hoverBorder);
//            }
//
//            @Override
//            public void mouseExited(MouseEvent e) {
//                shoePanel.setBorder(emptyBorder);
//            }
//        });
        
        shoePanel.add(title);
        shoePanel.add(Box.createVerticalStrut(8));
        shoePanel.add(note);
        shoePanel.add(Box.createVerticalStrut(8));
        shoePanel.add(imageLabel);
        shoePanel.add(Box.createVerticalStrut(15));
        shoePanel.add(infoPanel);
//        shoePanel.add(Box.createVerticalStrut(20));
        return shoePanel;
    }
}
