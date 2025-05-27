
import javax.swing.*;
import java.awt.*;

public class SimpleSwingApp {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JSplitPane Demo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);

        // Tạo hai JPanel làm nội dung
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(Color.CYAN);
        leftPanel.add(new JLabel("Bên trái"));

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.LIGHT_GRAY);
        rightPanel.add(new JLabel("Bên phải"));

        // Tạo JSplitPane chia ngang
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(400); // vị trí chia ban đầu
        splitPane.setOneTouchExpandable(true); // nút bấm mở rộng nhanh
        splitPane.setDividerSize(0);

        // Thêm vào frame
        frame.add(splitPane);
        frame.setVisible(true);
    }
}
