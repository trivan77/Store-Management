package View.Component;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class Menu extends javax.swing.JPanel {
	public Menu() {
		// initComponent();
		setOpaque(false);
	}

	@Override
	protected void paintComponent(Graphics grp) {
		Graphics2D g2 = (Graphics2D) grp;

		g2.setColor(getBackground());
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint gp = new GradientPaint(0, 0, Color.decode("#4568dc"), 0, getHeight(), Color.decode("#b06ab3"));
		g2.setPaint(gp);
		g2.fillRoundRect(0, 0,getWidth(), getHeight(), 20, 20);
		super.paintComponents(grp);
	}
}
