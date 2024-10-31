package View;

import Database.DatabaseManager;

import java.awt.Color;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class frmTrangChu extends JPanel {

    private JLabel timeLabel;
    private JLabel dateLabel;

    /**
     * Create the frame.
     */
    public frmTrangChu(DatabaseManager dbManager, String username) {
        setLayout(null);

        JPanel panel = new JPanel();
        panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
        panel.setBounds(10, 10, 956, 600);
        add(panel);
        panel.setLayout(null);

        JLabel lblTruong = new JLabel("TRƯỜNG ĐẠI HỌC KINH DOANH VÀ CÔNG NGHỆ HÀ NỘI");
        lblTruong.setFont(new Font("Arial", Font.BOLD, 18));
        lblTruong.setBounds(250, 22, 509, 20);
        panel.add(lblTruong);

        JLabel lblVien = new JLabel("Viện đào tạo sau đại học");
        lblVien.setFont(new Font("Arial", Font.BOLD, 16));
        lblVien.setBounds(407, 52, 200, 20);
        panel.add(lblVien);

        JLabel lblDetai = new JLabel("ĐỀ TÀI:");
        lblDetai.setFont(new Font("Arial", Font.BOLD, 16));
        lblDetai.setBounds(171, 165, 400, 20);
        panel.add(lblDetai);

        JLabel lblGVHD = new JLabel("Giảng viên hướng dẫn: TS. Vũ Văn Trường");
        lblGVHD.setFont(new Font("Arial", Font.BOLD, 16));
        lblGVHD.setBounds(331, 337, 400, 20);
        panel.add(lblGVHD);

        JLabel lblNhom = new JLabel("Nhóm thực hiện: Nhóm 3");
        lblNhom.setFont(new Font("Arial", Font.BOLD, 16));
        lblNhom.setBounds(331, 367, 400, 20);
        panel.add(lblNhom);

        JLabel lblLop = new JLabel("Lớp: Công nghệ thông tin 19.01 ");
        lblLop.setFont(new Font("Arial", Font.BOLD, 16));
        lblLop.setBounds(331, 397, 400, 20);
        panel.add(lblLop);

        JLabel lblHp = new JLabel("Lớp học phần: Cơ sở dữ liệu nâng cao");
        lblHp.setFont(new Font("Arial", Font.BOLD, 16));
        lblHp.setBounds(331, 427, 400, 20);
        panel.add(lblHp);

        JLabel lblTendetai1 = new JLabel("XÂY DỰNG HỆ THỐNG QUẢN LÝ KHO");
        lblTendetai1.setFont(new Font("Arial", Font.BOLD, 30));
        lblTendetai1.setBounds(226, 184, 596, 63);
        panel.add(lblTendetai1);

        JLabel lblTendetai2 = new JLabel("CHO DOANH NGHIỆP VỪA VÀ NHỎ");
        lblTendetai2.setFont(new Font("Arial", Font.BOLD, 30));
        lblTendetai2.setBounds(241, 236, 581, 63);
        panel.add(lblTendetai2);

        JLabel lblHNiThng = new JLabel("Hà Nội, tháng 12 năm 2024");
        lblHNiThng.setFont(new Font("Arial", Font.BOLD, 16));
        lblHNiThng.setBounds(397, 570, 210, 20);
        panel.add(lblHNiThng);

        JPanel panel_1 = new JPanel();
        panel_1.setBounds(976, 10, 285, 600);
        add(panel_1);
        panel_1.setLayout(null);

        JLabel lblWelcome = new JLabel("Chào " + username + "!");
        lblWelcome.setBounds(10, 10, 348, 19);
        lblWelcome.setFont(new Font("Arial", Font.BOLD, 16));
        panel_1.add(lblWelcome);

        // Thêm JLabel để hiển thị thời gian
        timeLabel = new JLabel();
        timeLabel.setFont(new Font("Arial", Font.BOLD, 24));
        timeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        timeLabel.setBounds(10, 214, 265, 30);
        panel_1.add(timeLabel);

        // Thêm JLabel để hiển thị ngày
        dateLabel = new JLabel();
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        dateLabel.setHorizontalAlignment(SwingConstants.CENTER);
        dateLabel.setBounds(10, 179, 265, 25);
        panel_1.add(dateLabel);
        
        JPanel panel_2 = new JPanel();
        panel_2.setBounds(10, 326, 265, 177);
        panel_2.setBorder(BorderFactory.createTitledBorder("Nhóm 3:"));
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblTranBaoTri = new JLabel("2400151 - Trần Bảo Trí");
        lblTranBaoTri.setBounds(20, 28, 166, 19);
        lblTranBaoTri.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_2.add(lblTranBaoTri);
        
        JLabel lblVuKhanhLinh = new JLabel("2400073 - Vũ Khánh Linh");
        lblVuKhanhLinh.setBounds(20, 66, 176, 19);
        lblVuKhanhLinh.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_2.add(lblVuKhanhLinh);
        
        JLabel lblPhiThiThuTrang = new JLabel("2400145 - Phí Thị Thu Trang");
        lblPhiThiThuTrang.setBounds(20, 104, 202, 19);
        lblPhiThiThuTrang.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_2.add(lblPhiThiThuTrang);
        
        JLabel lblNguyenVanPhap = new JLabel("DT.19TA04 - Nguyễn Văn Pháp");
        lblNguyenVanPhap.setBounds(20, 142, 221, 19);
        lblNguyenVanPhap.setFont(new Font("Arial", Font.PLAIN, 16));
        panel_2.add(lblNguyenVanPhap);
        
        JLabel lblPhinBiV = new JLabel("Phiên bản: v1.0.0");
        lblPhinBiV.setFont(new Font("Arial", Font.ITALIC, 14));
        lblPhinBiV.setBounds(83, 571, 166, 19);
        panel_1.add(lblPhinBiV);
        
        // Khởi tạo Timer để cập nhật đồng hồ và lịch mỗi giây
        Timer timer = new Timer(1000, e -> updateClockAndCalendar());
        timer.start();
    }

    // Phương thức cập nhật đồng hồ và lịch
    private void updateClockAndCalendar() {
        // Lấy thời gian hiện tại và định dạng nó
        String currentTime = new SimpleDateFormat("HH:mm:ss").format(new Date());
        timeLabel.setText(currentTime);

        // Lấy ngày hiện tại và định dạng nó
        String currentDate = new SimpleDateFormat("EEEE, dd MMMM yyyy").format(new Date());
        dateLabel.setText(currentDate);
    }
}
