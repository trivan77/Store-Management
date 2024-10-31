package View;

import Database.DatabaseManager;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class frmChuyenKho extends JPanel {

	/**
	 * Create the frame.
	 */
	public frmChuyenKho(DatabaseManager dbManager) {
		setLayout(new BorderLayout());
		JLabel lblNewLabel = new JLabel("frmChuyenKho");
		add(lblNewLabel);

	}

}
