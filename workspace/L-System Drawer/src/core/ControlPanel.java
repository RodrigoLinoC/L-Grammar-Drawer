package core;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author Rodrigo Lino da Costa
 *
 */
public class ControlPanel extends JPanel{

	DrawingPanel drawing;
	JComboBox<String> grammarOptions;
	JSlider slider;

	/**
	 * ControlPanel constructor
	 * @param drawing the drawing panel that this control panel will be responsible for
	 */
	public ControlPanel(DrawingPanel drawing) {
		this.drawing = drawing;
		this.setLayout(new GridLayout());
		setComboBox();
		setSlider();
	}

	/**
	 * Generates the slider part of the control panel
	 */
	private void setSlider() {
		slider = new JSlider(Constants.SLIDER_MIN_SIZE, Constants.SLIDER_MAX_SIZE, Constants.SLIDER_MIN_SIZE);
		slider.setMajorTickSpacing(2);
		slider.setMinorTickSpacing(1);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		slider.addChangeListener(new SliderListener());
		slider.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Recursive Depth"));
		
		this.add(slider);
	}

	/**
	 * Generates the combo box with the grammars
	 */
	private void setComboBox(){
		File[] files = (new File(Constants.FILE_PATH)).listFiles();
		String[] grammars = new String[files.length];
		for (int i = 0; i < files.length; i++) {
			grammars[i] = files[i].getName();
		}
		grammarOptions = new JComboBox<String>(grammars);
		grammarOptions.addActionListener(new ComboBoxListener());
		grammarOptions.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Lyndenmayer Definition"));
		
		this.add(grammarOptions);
	}
	
	/**
	 * Listener to the changes on the combo box
	 */
	private class ComboBoxListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			drawing.setGrammar(String.valueOf(grammarOptions.getSelectedItem()));
		}
	}
	
	/**
	 * Listener to the changes on the slider
	 *
	 */
	private class SliderListener implements ChangeListener {

		@Override
		public void stateChanged(ChangeEvent arg0) {
			drawing.setGrammarLevel(slider.getValue());
		}
		
	}
}
