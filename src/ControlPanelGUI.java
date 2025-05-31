import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Set;


/**
 * Class that makes pretty much the whole program.
 */
public class ControlPanelGUI {
    private JPanel mainPanel;
    private JButton noteD2;
    private JButton noteC2;
    private JButton noteE2;
    private JButton noteF2;
    private JButton noteDb2;
    private JButton noteEb2;
    private JButton noteGb2;
    private JButton noteG2;
    private JButton noteAb2;
    private JButton noteA2;
    private JButton noteBb2;
    private JButton noteB2;
    private JButton noteC3;
    private JButton noteDb3;
    private JButton noteD3;
    private JButton noteEb3;
    private JButton noteE3;
    private JButton noteF3;
    private JButton noteGb3;
    private JButton noteG3;
    private JButton noteAb3;
    private JButton noteA3;
    private JButton noteBb3;
    private JButton noteB3;
    private JButton noteC4;
    private JButton noteDb4;
    private JButton noteD4;
    private JButton noteEb4;
    private JButton noteE4;
    private JButton noteF4;
    private JButton noteGb4;
    private JButton noteG4;
    private JButton noteAb4;
    private JButton noteA4;
    private JButton noteBb4;
    private JButton noteB4;
    private JButton noteC5;
    private JButton noteDb5;
    private JButton noteD5;
    private JButton noteEb5;
    private JButton noteE5;
    private JButton noteF5;
    private JButton noteGb5;
    private JButton noteG5;
    private JButton noteAb5;
    private JButton noteA5;
    private JButton noteBb5;
    private JButton noteB5;
    private JButton noteC6;
    private JButton noteDb6;
    private JButton noteD6;
    private JButton noteEb6;
    private JButton noteE6;
    private JButton noteF6;
    private JButton noteGb6;
    private JButton noteG6;
    private JButton noteAb6;
    private JButton noteA6;
    private JButton noteBb6;
    private JButton noteB6;
    private JButton noteC7;
    private JLabel pianoBottom;
    private JLabel pianoSideL;
    private JLabel pianoSideR;
    private JLabel pianoMiddle;
    private JPanel noteDisplayTest;
    private JLabel noteDisplay;
    private JLabel pianoTopSideL;
    private JLabel pianoSplit;
    private JTextArea charDisplay;
    private JSlider volumeSlider;
    private JLabel pianoTopSideR2;
    private JLabel pianoTopSideR1;
    private JPanel volumePanel;
    private JLabel volumeLabel;
    private JComboBox instSelector;
    private JLabel pianoTop;

    private String selectedInstrument = "Piano";
    private boolean firstType = false;

    /**
     * The main method that runs it all
     */
    public ControlPanelGUI() {

        /**
         * Updates selectedInstrument after the user chooses a new instrument from the Combo box
         */
        instSelector.addActionListener(e -> {
            selectedInstrument = (String) instSelector.getSelectedItem();
            System.out.println(selectedInstrument);
        });

        ImageIcon wKeyUP = new ImageIcon(getClass().getResource("/PianoNotes/PianoKey.png"));
        ImageIcon wKeyDOWN = new ImageIcon(getClass().getResource("/PianoNotes/PianoKeyPressed.png"));
        ImageIcon bKeyUP = new ImageIcon(getClass().getResource("/PianoNotes/PianoBlackKey.png"));
        ImageIcon bKeyDOWN = new ImageIcon(getClass().getResource("/PianoNotes/PianoBlackKeyPressed2.png"));


        /**
         * All the notes on the piano. (C2-C7 = 61 notes)
         * Basic structure:
         * - If user clicks on the button (key) play the corresponding note and update what note was played.
         *
         * - Set a key for a note. If the key is pressed play the corresponding note and update what note was played.
         * - Update the key UI so it looks like someone pressed on the key and after a while return it to its previus state.
         *
         * Code not made by me (written with the help of ChatGPT) is marked with /* + *
         */
        //------------------------------------------------------------------------------------------------------------------//
        {
            noteC2.setIcon(wKeyUP);
            noteC2.addActionListener(new ActionListener() {                                                                            /* + */
                @Override                                                                                                              /* + */
                public void actionPerformed(ActionEvent e) {                                                                           /* + */
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C2.wav");                                        /* + Orginial Version: SoundPlayer.play("PianoSounds/C2.wav"); */
                    noteDisplay.setText("C2");
                }
            });
            noteC2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('+'), "playNoteC2"); /* + */
            noteC2.getActionMap().put("playNoteC2", new AbstractAction() {                                                       /* + */
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C2.wav");                                       /* + Orginial Version: SoundPlayer.play("PianoSounds/C2.wav"); */

                    noteC2.setIcon(wKeyDOWN);
                    noteDisplay.setText("C2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteC2.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteDb2.setIcon(bKeyUP);
            noteDb2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Db2.wav");
                    noteDisplay.setText("Db2");
                }
            });
            noteDb2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('1'), "playNoteDb2");
            noteDb2.getActionMap().put("playNoteDb2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Db2.wav");

                    noteDb2.setIcon(bKeyDOWN);
                    noteDisplay.setText("Db2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteDb2.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteD2.setIcon(wKeyUP);
            noteD2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/D2.wav");
                    noteDisplay.setText("D2");
                }
            });
            noteD2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('ě'), "playNoteD2");
            noteD2.getActionMap().put("playNoteD2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/D2.wav");

                    noteD2.setIcon(wKeyDOWN);
                    noteDisplay.setText("D2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteD2.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteEb2.setIcon(bKeyUP);
            noteEb2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Eb2.wav");
                    noteDisplay.setText("Eb2");
                }
            });
            noteEb2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('2'), "playNoteEb2");
            noteEb2.getActionMap().put("playNoteEb2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Eb2.wav");

                    noteEb2.setIcon(bKeyDOWN);
                    noteDisplay.setText("Eb2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteEb2.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteE2.setIcon(wKeyUP);
            noteE2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/E2.wav");
                    noteDisplay.setText("E2");
                }
            });
            noteE2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('š'), "playNoteE2");
            noteE2.getActionMap().put("playNoteE2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/E2.wav");

                    noteE2.setIcon(wKeyDOWN);
                    noteDisplay.setText("E2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteE2.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteF2.setIcon(wKeyUP);
            noteF2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/F2.wav");
                    noteDisplay.setText("F2");
                }
            });
            noteF2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('č'), "playNoteF2");
            noteF2.getActionMap().put("playNoteF2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/F2.wav");

                    noteF2.setIcon(wKeyDOWN);
                    noteDisplay.setText("F2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteF2.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteGb2.setIcon(bKeyUP);
            noteGb2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Gb2.wav");
                    noteDisplay.setText("Gb2");
                }
            });
            noteGb2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('4'), "playNoteGb2");
            noteGb2.getActionMap().put("playNoteGb2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Gb2.wav");

                    noteGb2.setIcon(bKeyDOWN);
                    noteDisplay.setText("Gb2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteGb2.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteG2.setIcon(wKeyUP);
            noteG2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/G2.wav");
                    noteDisplay.setText("G2");
                }
            });
            noteG2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('ř'), "playNoteG2");
            noteG2.getActionMap().put("playNoteG2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/G2.wav");

                    noteG2.setIcon(wKeyDOWN);
                    noteDisplay.setText("G2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteG2.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteAb2.setIcon(bKeyUP);
            noteAb2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Ab2.wav");
                    noteDisplay.setText("Ab2");
                }
            });
            noteAb2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('5'), "playNoteAb2");
            noteAb2.getActionMap().put("playNoteAb2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Ab2.wav");

                    noteAb2.setIcon(bKeyDOWN);
                    noteDisplay.setText("Ab2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteAb2.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteA2.setIcon(wKeyUP);
            noteA2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/A2.wav");
                    noteDisplay.setText("A2");
                }
            });
            noteA2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('ž'), "playNoteA2");
            noteA2.getActionMap().put("playNoteA2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/A2.wav");

                    noteA2.setIcon(wKeyDOWN);
                    noteDisplay.setText("A2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteA2.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteBb2.setIcon(bKeyUP);
            noteBb2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Bb2.wav");
                    noteDisplay.setText("Bb2");
                }
            });
            noteBb2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('6'), "playNoteBb2");
            noteBb2.getActionMap().put("playNoteBb2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Bb2.wav");

                    noteBb2.setIcon(bKeyDOWN);
                    noteDisplay.setText("Bb2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteBb2.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteB2.setIcon(wKeyUP);
            noteB2.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/B2.wav");
                    noteDisplay.setText("B2");
                }
            });
            noteB2.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('ý'), "playNoteB2");
            noteB2.getActionMap().put("playNoteB2", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/B2.wav");

                    noteB2.setIcon(wKeyDOWN);
                    noteDisplay.setText("B2");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteB2.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteC3.setIcon(wKeyUP);
            noteC3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C3.wav");
                    noteDisplay.setText("C3");
                }
            });
            noteC3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('á'), "playNoteC3");
            noteC3.getActionMap().put("playNoteC3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C3.wav");

                    noteC3.setIcon(wKeyDOWN);
                    noteDisplay.setText("C3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteC3.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteDb3.setIcon(bKeyUP);
            noteDb3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Db3.wav");
                    noteDisplay.setText("Db3");
                }
            });
            noteDb3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('8'), "playNoteDb3");
            noteDb3.getActionMap().put("playNoteDb3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Db3.wav");

                    noteDb3.setIcon(bKeyDOWN);
                    noteDisplay.setText("Db3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteDb3.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteD3.setIcon(wKeyUP);
            noteD3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/D3.wav");
                    noteDisplay.setText("D3");
                }
            });
            noteD3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('í'), "playNoteD3");
            noteD3.getActionMap().put("playNoteD3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/D3.wav");

                    noteD3.setIcon(wKeyDOWN);
                    noteDisplay.setText("D3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteD3.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteEb3.setIcon(bKeyUP);
            noteEb3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Eb3.wav");
                    noteDisplay.setText("Eb3");
                }
            });
            noteEb3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('9'), "playNoteEb3");
            noteEb3.getActionMap().put("playNoteEb3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Eb3.wav");

                    noteEb3.setIcon(bKeyDOWN);
                    noteDisplay.setText("Eb3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteEb3.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteE3.setIcon(wKeyUP);
            noteE3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/E3.wav");
                    noteDisplay.setText("E3");
                }
            });
            noteE3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('é'), "playNoteE3");
            noteE3.getActionMap().put("playNoteE3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/E3.wav");

                    noteE3.setIcon(wKeyDOWN);
                    noteDisplay.setText("E3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteE3.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteF3.setIcon(wKeyUP);
            noteF3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/F3.wav");
                    noteDisplay.setText("F3");
                }
            });
            noteF3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('q'), "playNoteF3");
            noteF3.getActionMap().put("playNoteF3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/F3.wav");

                    noteF3.setIcon(wKeyDOWN);
                    noteDisplay.setText("F3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteF3.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteGb3.setIcon(bKeyUP);
            noteGb3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Gb3.wav");
                    noteDisplay.setText("Gb3");
                }
            });
            noteGb3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('Q'), "playNoteGb3");
            noteGb3.getActionMap().put("playNoteGb3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Gb3.wav");

                    noteGb3.setIcon(bKeyDOWN);
                    noteDisplay.setText("Gb3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteGb3.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteG3.setIcon(wKeyUP);
            noteG3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/G3.wav");
                    noteDisplay.setText("G3");
                }
            });
            noteG3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('w'), "playNoteG3");
            noteG3.getActionMap().put("playNoteG3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/G3.wav");

                    noteG3.setIcon(wKeyDOWN);
                    noteDisplay.setText("G3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteG3.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteAb3.setIcon(bKeyUP);
            noteAb3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Ab3.wav");
                    noteDisplay.setText("Ab3");
                }
            });
            noteAb3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('W'), "playNoteAb3");
            noteAb3.getActionMap().put("playNoteAb3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Ab3.wav");

                    noteAb3.setIcon(bKeyDOWN);
                    noteDisplay.setText("Ab3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteAb3.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteA3.setIcon(wKeyUP);
            noteA3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/A3.wav");
                    noteDisplay.setText("A3");
                }
            });
            noteA3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('e'), "playNoteA3");
            noteA3.getActionMap().put("playNoteA3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/A3.wav");

                    noteA3.setIcon(wKeyDOWN);
                    noteDisplay.setText("A3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteA3.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteBb3.setIcon(bKeyUP);
            noteBb3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Bb3.wav");
                    noteDisplay.setText("Bb3");
                }
            });
            noteBb3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('E'), "playNoteBb3");
            noteBb3.getActionMap().put("playNoteBb3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Bb3.wav");

                    noteBb3.setIcon(bKeyDOWN);
                    noteDisplay.setText("Bb3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteBb3.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteB3.setIcon(wKeyUP);
            noteB3.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/B3.wav");
                    noteDisplay.setText("B3");
                }
            });
            noteB3.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('r'), "playNoteB3");
            noteB3.getActionMap().put("playNoteB3", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/B3.wav");

                    noteB3.setIcon(wKeyDOWN);
                    noteDisplay.setText("B3");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteB3.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteC4.setIcon(wKeyUP);
            noteC4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C4.wav");
                    noteDisplay.setText("C4");
                }
            });
            noteC4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('t'), "playNoteC4");
            noteC4.getActionMap().put("playNoteC4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C4.wav");

                    noteC4.setIcon(wKeyDOWN);
                    noteDisplay.setText("C4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteC4.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteDb4.setIcon(bKeyUP);
            noteDb4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Db4.wav");
                    noteDisplay.setText("Db4");
                }
            });
            noteDb4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('T'), "playNoteDb4");
            noteDb4.getActionMap().put("playNoteDb4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Db4.wav");

                    noteDb4.setIcon(bKeyDOWN);
                    noteDisplay.setText("Db4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteDb4.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteD4.setIcon(wKeyUP);
            noteD4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/D4.wav");
                    noteDisplay.setText("D4");
                }
            });
            noteD4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('y'), "playNoteD4");
            noteD4.getActionMap().put("playNoteD4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/D4.wav");

                    noteD4.setIcon(wKeyDOWN);
                    noteDisplay.setText("D4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteD4.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteEb4.setIcon(bKeyUP);
            noteEb4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Eb4.wav");
                    noteDisplay.setText("Eb4");
                }
            });
            noteEb4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('Y'), "playNoteEb4");
            noteEb4.getActionMap().put("playNoteEb4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Eb4.wav");

                    noteEb4.setIcon(bKeyDOWN);
                    noteDisplay.setText("Eb4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteEb4.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteE4.setIcon(wKeyUP);
            noteE4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/E4.wav");
                    noteDisplay.setText("E4");
                }
            });
            noteE4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('u'), "playNoteE4");
            noteE4.getActionMap().put("playNoteE4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/E4.wav");

                    noteE4.setIcon(wKeyDOWN);
                    noteDisplay.setText("E4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteE4.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteF4.setIcon(wKeyUP);
            noteF4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/F4.wav");
                    noteDisplay.setText("F4");
                }
            });
            noteF4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('i'), "playNoteF4");
            noteF4.getActionMap().put("playNoteF4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/F4.wav");

                    noteF4.setIcon(wKeyDOWN);
                    noteDisplay.setText("F4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteF4.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteGb4.setIcon(bKeyUP);
            noteGb4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Gb4.wav");
                    noteDisplay.setText("Gb4");
                }
            });
            noteGb4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('I'), "playNoteGb4");
            noteGb4.getActionMap().put("playNoteGb4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Gb4.wav");

                    noteGb4.setIcon(bKeyDOWN);
                    noteDisplay.setText("Gb4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteGb4.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteG4.setIcon(wKeyUP);
            noteG4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/G4.wav");
                    noteDisplay.setText("G4");
                }
            });
            noteG4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('o'), "playNoteG4");
            noteG4.getActionMap().put("playNoteG4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/G4.wav");

                    noteG4.setIcon(wKeyDOWN);
                    noteDisplay.setText("G4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteG4.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteAb4.setIcon(bKeyUP);
            noteAb4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Ab4.wav");
                    noteDisplay.setText("Ab4");
                }
            });
            noteAb4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('O'), "playNoteAb4");
            noteAb4.getActionMap().put("playNoteAb4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Ab4.wav");

                    noteAb4.setIcon(bKeyDOWN);
                    noteDisplay.setText("Ab4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteAb4.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteA4.setIcon(wKeyUP);
            noteA4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/A4.wav");
                    noteDisplay.setText("A4");
                }
            });
            noteA4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('p'), "playNoteA4");
            noteA4.getActionMap().put("playNoteA4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/A4.wav");

                    noteA4.setIcon(wKeyDOWN);
                    noteDisplay.setText("A4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteA4.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteBb4.setIcon(bKeyUP);
            noteBb4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Bb4.wav");
                    noteDisplay.setText("Bb4");
                }
            });
            noteBb4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('P'), "playNoteBb4");
            noteBb4.getActionMap().put("playNoteBb4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Bb4.wav");

                    noteBb4.setIcon(bKeyDOWN);
                    noteDisplay.setText("Bb4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteBb4.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteB4.setIcon(wKeyUP);
            noteB4.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/B4.wav");
                    noteDisplay.setText("B4");
                }
            });
            noteB4.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('a'), "playNoteB4");
            noteB4.getActionMap().put("playNoteB4", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/B4.wav");

                    noteB4.setIcon(wKeyDOWN);
                    noteDisplay.setText("B4");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteB4.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteC5.setIcon(wKeyUP);
            noteC5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C5.wav");
                    noteDisplay.setText("C5");
                }
            });
            noteC5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('s'), "playNoteC5");
            noteC5.getActionMap().put("playNoteC5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C5.wav");

                    noteC5.setIcon(wKeyDOWN);
                    noteDisplay.setText("C5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteC5.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteDb5.setIcon(bKeyUP);
            noteDb5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Db5.wav");
                    noteDisplay.setText("Dd5");
                }
            });
            noteDb5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('S'), "playNoteDb5");
            noteDb5.getActionMap().put("playNoteDb5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Db5.wav");

                    noteDb5.setIcon(bKeyDOWN);
                    noteDisplay.setText("Dd5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteDb5.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteD5.setIcon(wKeyUP);
            noteD5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/D5.wav");
                    noteDisplay.setText("D5");
                }
            });
            noteD5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('d'), "playNoteD5");
            noteD5.getActionMap().put("playNoteD5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/D5.wav");

                    noteD5.setIcon(wKeyDOWN);
                    noteDisplay.setText("D5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteD5.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteEb5.setIcon(bKeyUP);
            noteEb5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Eb5.wav");
                    noteDisplay.setText("Eb5");
                }
            });
            noteEb5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('D'), "playNoteEb5");
            noteEb5.getActionMap().put("playNoteEb5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Eb5.wav");

                    noteEb5.setIcon(bKeyDOWN);
                    noteDisplay.setText("Eb5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteEb5.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteE5.setIcon(wKeyUP);
            noteE5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/E5.wav");
                    noteDisplay.setText("E5");
                }
            });
            noteE5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('f'), "playNoteE5");
            noteE5.getActionMap().put("playNoteE5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/E5.wav");

                    noteE5.setIcon(wKeyDOWN);
                    noteDisplay.setText("E5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteE5.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteF5.setIcon(wKeyUP);
            noteF5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/F5.wav");
                    noteDisplay.setText("F5");
                }
            });
            noteF5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('g'), "playNoteF5");
            noteF5.getActionMap().put("playNoteF5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/F5.wav");

                    noteF5.setIcon(wKeyDOWN);
                    noteDisplay.setText("F5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteF5.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteGb5.setIcon(bKeyUP);
            noteGb5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Gb5.wav");
                    noteDisplay.setText("Gb5");
                }
            });
            noteGb5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('G'), "playNoteGb5");
            noteGb5.getActionMap().put("playNoteGb5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Gb5.wav");

                    noteGb5.setIcon(bKeyDOWN);
                    noteDisplay.setText("Gb5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteGb5.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteG5.setIcon(wKeyUP);
            noteG5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/G5.wav");
                    noteDisplay.setText("G5");
                }
            });
            noteG5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('h'), "playNoteG5");
            noteG5.getActionMap().put("playNoteG5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/G5.wav");

                    noteG5.setIcon(wKeyDOWN);
                    noteDisplay.setText("G5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteG5.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteAb5.setIcon(bKeyUP);
            noteAb5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Ab5.wav");
                    noteDisplay.setText("Ab5");
                }
            });
            noteAb5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('H'), "playNoteAb5");
            noteAb5.getActionMap().put("playNoteAb5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Ab5.wav");

                    noteAb5.setIcon(bKeyDOWN);
                    noteDisplay.setText("Ab5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteAb5.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteA5.setIcon(wKeyUP);
            noteA5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/A5.wav");
                    noteDisplay.setText("A5");
                }
            });
            noteA5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('j'), "playNoteA5");
            noteA5.getActionMap().put("playNoteA5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/A5.wav");

                    noteA5.setIcon(wKeyDOWN);
                    noteDisplay.setText("A5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteA5.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteBb5.setIcon(bKeyUP);
            noteBb5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Bb5.wav");
                    noteDisplay.setText("Bb5");
                }
            });
            noteBb5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('J'), "playNoteBb5");
            noteBb5.getActionMap().put("playNoteBb5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Bb5.wav");

                    noteBb5.setIcon(bKeyDOWN);
                    noteDisplay.setText("Bb5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteBb5.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteB5.setIcon(wKeyUP);
            noteB5.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/B5.wav");
                    noteDisplay.setText("B5");
                }
            });
            noteB5.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('k'), "playNoteB5");
            noteB5.getActionMap().put("playNoteB5", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/B5.wav");

                    noteB5.setIcon(wKeyDOWN);
                    noteDisplay.setText("B5");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteB5.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteC6.setIcon(wKeyUP);
            noteC6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C6.wav");
                    noteDisplay.setText("C6");
                }
            });
            noteC6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('l'), "playNoteC6");
            noteC6.getActionMap().put("playNoteC6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C6.wav");

                    noteC6.setIcon(wKeyDOWN);
                    noteDisplay.setText("C6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteC6.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteDb6.setIcon(bKeyUP);
            noteDb6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Db6.wav");
                    noteDisplay.setText("Dd6");
                }
            });
            noteDb6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('L'), "playNoteDb6");
            noteDb6.getActionMap().put("playNoteDb6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Db6.wav");

                    noteDb6.setIcon(bKeyDOWN);
                    noteDisplay.setText("Dd6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteDb6.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteD6.setIcon(wKeyUP);
            noteD6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/D6.wav");
                    noteDisplay.setText("D6");
                }
            });
            noteD6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('z'), "playNoteD6");
            noteD6.getActionMap().put("playNoteD6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/D6.wav");

                    noteD6.setIcon(wKeyDOWN);
                    noteDisplay.setText("D6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteD6.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteEb6.setIcon(bKeyUP);
            noteEb6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Eb6.wav");
                    noteDisplay.setText("Eb6");
                }
            });
            noteEb6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('Z'), "playNoteEb6");
            noteEb6.getActionMap().put("playNoteEb6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Eb6.wav");

                    noteEb6.setIcon(bKeyDOWN);
                    noteDisplay.setText("Eb6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteEb6.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteE6.setIcon(wKeyUP);
            noteE6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/E6.wav");
                    noteDisplay.setText("E6");
                }
            });
            noteE6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('x'), "playNoteE6");
            noteE6.getActionMap().put("playNoteE6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/E6.wav");

                    noteE6.setIcon(wKeyDOWN);
                    noteDisplay.setText("E6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteE6.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteF6.setIcon(wKeyUP);
            noteF6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/F6.wav");
                    noteDisplay.setText("F6");
                }
            });
            noteF6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('c'), "playNoteF6");
            noteF6.getActionMap().put("playNoteF6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/F6.wav");

                    noteF6.setIcon(wKeyDOWN);
                    noteDisplay.setText("F6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteF6.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteGb6.setIcon(bKeyUP);
            noteGb6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Gb6.wav");
                    noteDisplay.setText("Gb6");
                }
            });
            noteGb6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('C'), "playNoteGb6");
            noteGb6.getActionMap().put("playNoteGb6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Gb6.wav");

                    noteGb6.setIcon(bKeyDOWN);
                    noteDisplay.setText("Gb6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteGb6.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteG6.setIcon(wKeyUP);
            noteG6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/G6.wav");
                    noteDisplay.setText("G6");
                }
            });
            noteG6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('v'), "playNoteG6");
            noteG6.getActionMap().put("playNoteG6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/G6.wav");

                    noteG6.setIcon(wKeyDOWN);
                    noteDisplay.setText("G6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteG6.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteAb6.setIcon(bKeyUP);
            noteAb6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Ab6.wav");
                    noteDisplay.setText("Ab6");
                }
            });
            noteAb6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('V'), "playNoteAb6");
            noteAb6.getActionMap().put("playNoteAb6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Ab6.wav");

                    noteAb6.setIcon(bKeyDOWN);
                    noteDisplay.setText("Ab6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteAb6.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteA6.setIcon(wKeyUP);
            noteA6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/A6.wav");
                    noteDisplay.setText("A6");
                }
            });
            noteA6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('b'), "playNoteA6");
            noteA6.getActionMap().put("playNoteA6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/A6.wav");

                    noteA6.setIcon(wKeyDOWN);
                    noteDisplay.setText("A6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteA6.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteBb6.setIcon(bKeyUP);
            noteBb6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Bb6.wav");
                    noteDisplay.setText("Bb6");
                }
            });
            noteBb6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('B'), "playNoteBb6");
            noteBb6.getActionMap().put("playNoteBb6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/Bb6.wav");

                    noteBb6.setIcon(bKeyDOWN);
                    noteDisplay.setText("Bb6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteBb6.setIcon(bKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteB6.setIcon(wKeyUP);
            noteB6.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/B6.wav");
                    noteDisplay.setText("B6");
                }
            });
            noteB6.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('n'), "playNoteB6");
            noteB6.getActionMap().put("playNoteB6", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/B6.wav");

                    noteB6.setIcon(wKeyDOWN);
                    noteDisplay.setText("B6");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteB6.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });

            noteC7.setIcon(wKeyUP);
            noteC7.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C7.wav");
                    noteDisplay.setText("C7");

                }
            });
            noteC7.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke('m'), "playNoteC7");
            noteC7.getActionMap().put("playNoteC7", new AbstractAction() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SoundPlayer.play("Sounds/" + selectedInstrument + "Sounds/C7.wav");

                    noteC7.setIcon(wKeyDOWN);
                    noteDisplay.setText("C7");

                    Timer timer = new Timer(150, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            noteC7.setIcon(wKeyUP);
                        }
                    });
                    timer.setRepeats(false);
                    timer.start();
                }
            });
        }
        //------------------------------------------------------------------------------------------------------------------//

        /**
         * Makes sure that the mainPanel is the first things thats focused.
         */
        mainPanel.setFocusable(true);
        mainPanel.requestFocusInWindow();
        /**
         * Map the typed character 'X' to the action "typeX" and define that action to append 'x' to the display
         */
        mainPanel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("typed X"), "typeX");
        mainPanel.getActionMap().put("typeX", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendCharToDisplay('x');
            }
        });

        /**
         * Adds a keyListener to mainPanel to handle typed keys
         * The first typed key clears the previous message ("Made by Daniel Matousek")
         * If the typed character is in the character set 'ALLOWED_KEYS' add it to the display.
         */
        mainPanel.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if (firstType == false){
                    charDisplay.setText("");
                    firstType = true;
                }
                char ch = e.getKeyChar();
                if (ALLOWED_KEYS.contains(ch)) {
                    appendCharToDisplay(ch);
                }
            }
        });

        /**
         * Updates the volume label and SoundPLayer volume whenever the user moves the slider
         * Code not made by me (written with the help of ChatGPT) is marked with /* + *
         */
        volumeSlider.addChangeListener(e -> {          /* + */
            int newVolume = volumeSlider.getValue();   /* + */
            volumeLabel.setText(newVolume + "%");      /* + */
            SoundPlayer.setVolume(newVolume);          /* + */
        });

    }

    /**
     * Adds the character and moves to the bottom of the text.
     * @param ch
     */
    private void appendCharToDisplay(char ch) {
        charDisplay.append(String.valueOf(ch));
        charDisplay.setCaretPosition(charDisplay.getDocument().getLength());
    }

    /**
     * Set of allowed keys
     */
    private static Set<Character> ALLOWED_KEYS = Set.of(
            '+', '1', 'ě', '2', 'š', 'č', '4', 'ř', '5',
            'ž', '6', 'ý', 'á', '8', 'í', '9', 'é', 'q',
            'Q', 'w', 'W', 'e', 'E', 'r', 't', 'T', 'y',
            'Y', 'u', 'i', 'I', 'o', 'O', 'p', 'P', 'a',
            's', 'S', 'd', 'D', 'f', 'g', 'G', 'h', 'H',
            'j', 'J', 'k', 'l', 'L', 'z', 'Z', 'x', 'c',
            'C', 'v', 'V', 'b', 'B', 'n', 'm'
    );

    public JPanel getMainPanel() {
        return mainPanel;
    }
}
