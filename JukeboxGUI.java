package jukebox;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JukeboxGUI extends JFrame {

	private Jukebox theJukebox = new Jukebox();
	
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JTextArea playlistBox;
	private JLabel lblNewLabel_1;
	private JPanel panel_1;
	private JTextField inputText;
	private JButton addBtn;
	private JButton removeBtn;
	private JTextField removeInput;
	private JLabel errorLabel;
	private JButton sortBtn;
	private JButton reverseSortBtn;
	private JButton playNextBtn;
	private JLabel countLbl;
	private JLabel currentSong;
	private JButton button;
	private JButton btnGeneratePlaylist;
	private JButton btnSave;
	private JButton btnLoad;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JukeboxGUI frame = new JukeboxGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JukeboxGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 441);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(219, 112, 147));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getPanel());
		contentPane.add(getLblNewLabel_1());
		contentPane.add(getPanel_1());
		contentPane.add(getInputText());
		contentPane.add(getAddBtn());
		contentPane.add(getRemoveBtn());
		contentPane.add(getRemoveInput());
		contentPane.add(getErrorLabel());
		contentPane.add(getSortBtn());
		contentPane.add(getReverseSortBtn());
		contentPane.add(getPlayNextBtn());
		contentPane.add(getCountLbl());
		contentPane.add(getPlaylistBox());
		contentPane.add(getCurrentSong());
		contentPane.add(getButton());
		contentPane.add(getBtnGeneratePlaylist());
		contentPane.add(getBtnSave());
		contentPane.add(getBtnLoad());
	}
	private JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Welcome to the Jukebox!");
			lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 18));
			lblNewLabel.setBounds(0, 11, 359, 28);
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(255, 222, 173));
			panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Music Heaven", TitledBorder.CENTER, TitledBorder.TOP, null, Color.RED));
			panel.setBounds(99, 11, 371, 44);
			panel.setLayout(null);
			panel.add(getLblNewLabel());
		}
		return panel;
	}
	private JTextArea getPlaylistBox() {
		if (playlistBox == null) {
			playlistBox = new JTextArea();
			playlistBox.setBackground(SystemColor.activeCaption);
			playlistBox.setForeground(SystemColor.info);
			playlistBox.setText(this.theJukebox.printPlayList());
			playlistBox.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			playlistBox.setBounds(10, 93, 193, 272);
		}
		return playlistBox;
	}
	
	private void updatePlaylistBox(){
		playlistBox.setText(this.theJukebox.printPlayList());
		countLbl.setText("Total Songs: " + this.theJukebox.getPlaylist().size());
		currentSong.setText("Currently Playing: " + this.theJukebox.getPlaylist().getFirst().getTitle());
	}
	
	private JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("The Playlist");
			lblNewLabel_1.setBounds(34, 78, 144, 16);
			lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 12));
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel_1;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBorder(new TitledBorder(null, null, TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panel_1.setBounds(34, 78, 144, 16);
			panel_1.setLayout(null);
		}
		return panel_1;
	}
	private JTextField getInputText() {
		if (inputText == null) {
			inputText = new JTextField();
			inputText.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
			inputText.setBounds(213, 145, 113, 20);
			inputText.setColumns(10);
		}
		return inputText;
	}
	private JButton getAddBtn() {
		if (addBtn == null) {
			addBtn = new JButton("Add Song!");
			addBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String input = inputText.getText();
					Song newSong = new Song(input);
					theJukebox.addSong(newSong);
					inputText.setText("");
					updatePlaylistBox();
				}
			});
			addBtn.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			addBtn.setBounds(336, 144, 114, 23);
		}
		return addBtn;
	}
	private JButton getRemoveBtn() {
		if (removeBtn == null) {
			removeBtn = new JButton("Remove Song!");
			removeBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					String input = removeInput.getText();
					if(theJukebox.playlistContains(input)){
						theJukebox.removeSong(input);
						errorLabel.setVisible(false);
						removeInput.setText("");
						updatePlaylistBox();
					} else {
						errorLabel.setVisible(true);
					}
				}
			});
			removeBtn.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			removeBtn.setBounds(336, 180, 114, 23);
		}
		return removeBtn;
	}
	private JTextField getRemoveInput() {
		if (removeInput == null) {
			removeInput = new JTextField();
			removeInput.setFont(new Font("Bahnschrift", Font.PLAIN, 11));
			removeInput.setColumns(10);
			removeInput.setBounds(213, 181, 113, 20);
		}
		return removeInput;
	}
	private JLabel getErrorLabel() {
		if (errorLabel == null) {
			errorLabel = new JLabel("Not in playlist!");
			errorLabel.setHorizontalAlignment(SwingConstants.CENTER);
			errorLabel.setForeground(new Color(255, 0, 0));
			errorLabel.setBounds(213, 206, 113, 20);
			errorLabel.setVisible(false);
		}
		return errorLabel;
	}
	private JButton getSortBtn() {
		if (sortBtn == null) {
			sortBtn = new JButton("Sort Playlist!");
			sortBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					theJukebox.sort();
					updatePlaylistBox();
				}
			});
			sortBtn.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			sortBtn.setBounds(213, 237, 114, 23);
		}
		return sortBtn;
	}
	private JButton getReverseSortBtn() {
		if (reverseSortBtn == null) {
			reverseSortBtn = new JButton("Reverse Sort!");
			reverseSortBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					theJukebox.reverseSort();
					updatePlaylistBox();
				}
			});
			reverseSortBtn.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			reverseSortBtn.setBounds(336, 237, 114, 23);
		}
		return reverseSortBtn;
	}
	private JButton getPlayNextBtn() {
		if (playNextBtn == null) {
			playNextBtn = new JButton("Play Next!");
			playNextBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					theJukebox.play();
					updatePlaylistBox();
				}
			});
			playNextBtn.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			playNextBtn.setBounds(276, 309, 113, 28);
		}
		return playNextBtn;
	}
	private JLabel getCountLbl() {
		if (countLbl == null) {
			countLbl = new JLabel("Total Songs: " + this.theJukebox.getPlaylist().size());
			countLbl.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			countLbl.setBounds(10, 364, 144, 14);
		}
		return countLbl;
	}
	private JLabel getCurrentSong() {
		if (currentSong == null) {
			currentSong = new JLabel("Currently Playing: ");
			currentSong.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			currentSong.setBounds(213, 337, 257, 28);
		}
		return currentSong;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton("Remove the Sap!");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					theJukebox.removeSoppySongs();
					updatePlaylistBox();
				}
			});
			button.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			button.setBounds(266, 271, 144, 23);
		}
		return button;
	}
	private JButton getBtnGeneratePlaylist() {
		if (btnGeneratePlaylist == null) {
			btnGeneratePlaylist = new JButton("Generate Playlist!");
			btnGeneratePlaylist.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					Jukebox newJukebox = new Jukebox("generate!");
					theJukebox = newJukebox;
					updatePlaylistBox();
				}
			});
			btnGeneratePlaylist.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			btnGeneratePlaylist.setBounds(266, 66, 144, 23);
		}
		return btnGeneratePlaylist;
	}
	private JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("Save Playlist!");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					theJukebox.savePlaylist();
				}
			});
			btnSave.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			btnSave.setBounds(213, 100, 114, 23);
		}
		return btnSave;
	}
	private JButton getBtnLoad() {
		if (btnLoad == null) {
			btnLoad = new JButton("Load Playlist!");
			btnLoad.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					theJukebox.loadPlaylist();
					updatePlaylistBox();
				}
			});
			btnLoad.setFont(new Font("Bahnschrift", Font.BOLD, 11));
			btnLoad.setBounds(336, 100, 114, 23);
		}
		return btnLoad;
	}
}
