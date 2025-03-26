
package view;
import java.util.*;

public class Bai3 {
    // Hàm tính hướng giữa 3 điểm (a, b, c)
    private static int crossProduct(int ax, int ay, int bx, int by, int cx, int cy) {
        return (bx - ax) * (cy - ay) - (by - ay) * (cx - ax);
    }

    // Hàm tính khoảng cách bình phương giữa hai điểm
    private static int squaredDistance(int ax, int ay, int bx, int by) {
        return (ax - bx) * (ax - bx) + (ay - by) * (ay - by);
    }

    // Thuật toán Graham Scan để tìm bao lồi (Convex Hull)
    public static List<int[]> convexHull(int[][] points) {
        if (points.length < 3) throw new IllegalArgumentException("Cần ít nhất 3 điểm để tạo bao lồi");
        
        Arrays.sort(points, (p1, p2) -> p1[1] == p2[1] ? Integer.compare(p1[0], p2[0]) : Integer.compare(p1[1], p2[1]));
        int[] pivot = points[0];
        
        Arrays.sort(points, 1, points.length, (p1, p2) -> {
            int orientation = crossProduct(pivot[0], pivot[1], p1[0], p1[1], p2[0], p2[1]);
            if (orientation == 0) {
                return Integer.compare(squaredDistance(pivot[0], pivot[1], p1[0], p1[1]),
                                       squaredDistance(pivot[0], pivot[1], p2[0], p2[1]));
            }
            return -Integer.compare(orientation, 0);
        });
        
        Stack<int[]> hull = new Stack<>();
        hull.push(points[0]);
        hull.push(points[1]);
        
        for (int i = 2; i < points.length; i++) {
            while (hull.size() >= 2) {
                int[] second = hull.pop();
                int[] first = hull.peek();
                if (crossProduct(first[0], first[1], second[0], second[1], points[i][0], points[i][1]) > 0) {
                    hull.push(second);
                    break;
                }
            }
            hull.push(points[i]);
        }
        return new ArrayList<>(hull);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số lượng trạm phát sóng: ");
        int n = scanner.nextInt();
        int[][] points = new int[n][2];
        
        System.out.println("Nhập tọa độ của từng trạm (x y):");
        for (int i = 0; i < n; i++) {
            points[i][0] = scanner.nextInt();
            points[i][1] = scanner.nextInt();
        }
        
        List<int[]> alertStations = convexHull(points);
        
        System.out.println("Các trạm cảnh báo cần thiết:");
        for (int[] p : alertStations) {
            System.out.println("(" + p[0] + ", " + p[1] + ")");
        }
        
        scanner.close();
    }
}