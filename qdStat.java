import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class qdStat {

	static JFrame myFrame;
	static Category[] categories;
	static JPanel myContentPanel;
	static JPanel buttons;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		myFrame = new JFrame("qdStat");
		myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myContentPanel = new JPanel(new BorderLayout());
		buttons = new JPanel(new GridLayout(19, 1));

		// Build the menu
		JMenuBar menuBar = new JMenuBar();
		JMenu myMenu = new JMenu("File");
		JMenuItem close = new JMenuItem("Close");
		close.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);

			}
		});

		myMenu.add(close);
		menuBar.add(myMenu);
		JPanel menuPanel = new JPanel(new BorderLayout());
		menuPanel.add(menuBar, BorderLayout.LINE_START);
		myContentPanel.add(menuPanel, BorderLayout.NORTH);

		categories = new Category[19];
		categories[0] = new Category("Medien & Unterhaltung", 0);
		categories[1] = new Category("TV-Serien", 0);
		categories[2] = new Category("Die 2000er", 0);
		categories[3] = new Category("Kinofilme", 0);
		categories[4] = new Category("Macht & Geld", 0);
		categories[5] = new Category("Computerspiele", 0);
		categories[6] = new Category("Sport & Freizeit", 0);
		categories[7] = new Category("Musik & Hits", 0);
		categories[8] = new Category("Essen & Trinken", 0);
		categories[9] = new Category("Bücher & Wörter", 0);
		categories[10] = new Category("Kunst & Kultur", 0);
		categories[11] = new Category("Wunder der Technik", 0);
		categories[12] = new Category("Körper & Geist", 0);
		categories[13] = new Category("Im Labor", 0);
		categories[14] = new Category("Zeugen der Zeit", 0);
		categories[15] = new Category("Rund um die Welt", 0);
		categories[16] = new Category("Glaube & Religion", 0);
		categories[17] = new Category("Draußen im Grünen", 0);
		categories[18] = new Category("Comics", 0);

		myContentPanel.add(buttons, BorderLayout.CENTER);
		myFrame.setContentPane(myContentPanel);

		sortList();
		
		myFrame.setMinimumSize(new Dimension(300, 20));
		myFrame.pack();
		myFrame.setVisible(true);

	}

	// Sort List and build/display buttons
	static void sortList() {

		// Sort
		for (int i = 0; i < categories.length; i++) {
			int j = i;
			for (j = 0; j < categories.length; j++) {
				if (categories[i].counter > categories[j].counter) {
					Category x = categories[i];
					categories[i] = categories[j];
					categories[j] = x;
				}
			}
		}

		// Remove all buttons and add the updated ones
		buttons.removeAll();
		for (int i = 0; i < categories.length; i++) {
			final JButton b = new JButton();
			b.setLayout(new BorderLayout());
			
			b.add(new JLabel(categories[i].name), BorderLayout.LINE_START);
			b.add(new JLabel(""+categories[i].counter), BorderLayout.LINE_END);
					
//					new JButton(categories[i].name + " :"
//					+ categories[i].counter);
			b.setName(categories[i].name);
			b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent arg0) {
					for (int j = 0; j < categories.length; j++) {
						if (categories[j].name.equals(b.getName())) {
							categories[j].played();
							sortList();
						}
					}

				}
			});
			buttons.add(b);
		}
		myFrame.validate();
	}
	
	/* Write the current State to a file */
	void writeCurrentState(){
		
	}
	
	/*If exists, read saved values from file. */
	void read(){
		
	}

}
