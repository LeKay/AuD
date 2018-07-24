package Blatt5;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class GUI extends Frame
{
	Button btnCreate = new Button();
	Button btnSwitch = new Button();
	TextField txtNumberOfDiscs = new TextField();
	Label lblDiscs = new Label();
	Label lblSpeed = new Label();
	JSlider slSpeed = new JSlider(JSlider.HORIZONTAL, 0, 100, 30);

	protected final int width = 1000;
	protected final int height = 600;
	Logic logic;
	Image bufferedImage;
	Graphics bufferedGraphics;

	public GUI(Logic l)
	{
		logic = l;
		logic.setGUI(this);
		calcDelay();

		// Initialisierung des Frame
		setSize(width, height);
		setVisible(true);
		setLayout(new BorderLayout());
		setTitle("T�rme von Hanoi");

		//Panel f�r Buttons und Labels
		Panel pButton = new Panel();
		pButton.setLayout(new GridLayout(1, 4));
		Panel p = new Panel();
		p.setLayout(new GridLayout(3,1));
		p.add(lblSpeed);
		p.add(slSpeed);
		p.add(pButton);

		// Beschriftung der GUI-Elemente
		btnCreate.setLabel("Turm erstellen");
		switchLabel();
		lblDiscs.setText("Anzahl Scheiben (2-10):");
		lblDiscs.setAlignment(Label.RIGHT);
		txtNumberOfDiscs.setText("3");
		slSpeed.setMajorTickSpacing(10);
		slSpeed.setPaintTicks(true);

		// Hinzuf�gen zum Panel
		pButton.add(btnCreate);
		pButton.add(btnSwitch);
		pButton.add(lblDiscs);
		pButton.add(txtNumberOfDiscs);

		// Panel ans Frame binden
		add(p, BorderLayout.SOUTH);

		// Listener
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent evt)
				{
					System.exit(0);
				}
			});

		btnCreate.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					logic.switching = false;
					switchLabel();
					create();
				}
			});

		btnSwitch.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0)
				{
					logic.switching ^=true;
					switchLabel();
					startTransport();
				}
			});

		slSpeed.addChangeListener(new ChangeListener()
			{
				public void stateChanged(ChangeEvent arg0)
				{
					calcDelay();
				}
			});

		// Double buffering
		bufferedImage = createImage(width, 510);
		bufferedGraphics = bufferedImage.getGraphics();
		bufferedPaint();

		paint(getGraphics());
	}

	public void calcDelay()
	{
		long delay = slSpeed.getValue() * 10;
		logic.setDelay(delay);
		lblSpeed.setText("  Verz�gerung zwischen den Schritten: " + delay + "ms");
	}

	public void paint(Graphics g)
	{
		if (bufferedImage != null)
			g.drawImage(bufferedImage, 0, 0, this);
	}

	public void bufferedPaint()
	{
		bufferedGraphics.setColor(new Color(0xF8, 0xF8, 0xF8));
		bufferedGraphics.fillRect(20, 40, width - 40, 490);
		drawTower(bufferedGraphics);

		paint(getGraphics());
	}

	public void startTransport()
	{
		create();

		if (logic.switching)
			new Thread(logic).start();
	}

	public void create()
	{
		int numberOfDiscs = Integer.parseInt(txtNumberOfDiscs.getText());
		if (numberOfDiscs < 2)
			numberOfDiscs = 2;
		if (numberOfDiscs > 10)
			numberOfDiscs  = 10;

		txtNumberOfDiscs.setText("" + numberOfDiscs);
		logic.create(numberOfDiscs);
		bufferedPaint();
	}

	// Zeichnen der T�rme
	public void drawTower(Graphics g)
	{
		for (int t = 0; t < logic.towers.length; t++)
			for (int d = 0; d < logic.towers[t].size();d++)
			{
				Disc disc = logic.towers[t].get(d);
				final int width = logic.numberOfDiscs - disc.getWidth();

				g.setColor(disc.getColor());
				g.fillRect(180 + t*330 - width*15, 400 - 22*d, width*30, disc.getHeight());

				g.setColor(new Color(0xFF, 0xFF, 0xFF, 0x40));
				g.drawRect(181 + t*330 - width*15, 401 - 22*d, width*30 - 2, disc.getHeight() - 2);

				g.setColor(new Color(0x00, 0x00, 0x00, 0x18));
				g.drawRect(180 + t*330 - width*15, 400 - 22*d, width*30, disc.getHeight());
			}
	}

	public void switchLabel()
	{
		btnSwitch.setLabel(logic.switching ? "Abbrechen" : "Start");
	}
}