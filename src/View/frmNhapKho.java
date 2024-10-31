package View;

import Database.DatabaseManager;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class frmNhapKho extends JPanel {

	/**
	 * Create the frame.
	 */
	public frmNhapKho(DatabaseManager dbManager) {
		setLayout(new BorderLayout());
		JLabel lblNewLabel = new JLabel("Nhập kho");
		add(lblNewLabel);

	}

}
