package View;

import Database.DatabaseManager;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class frmXuatKho extends JPanel {

	/**
	 * Create the frame.
	 */
	public frmXuatKho(DatabaseManager dbManager) {
		setLayout(new BorderLayout());
		JLabel lblNewLabel = new JLabel("frmXuatKho");
		add(lblNewLabel);

	}

}
