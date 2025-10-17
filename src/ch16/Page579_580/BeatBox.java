package ch16.Page579_580;

import javax.sound.midi.*;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.ArrayList;

import static javax.sound.midi.ShortMessage.*;

public class BeatBox {
    private ArrayList<JCheckBox> checkboxList;
    private Sequencer sequencer;
    private Sequence sequence;
    private Track track;

    String[] instrumentNames = {"Bass Drum", "Closed Hi-Hat",
            "Open Hi-Hat", "Acoustic Snare", "Crash Cymbal", "Hand Clap",
            "High Tom", "Hi Bongo", "Maracas", "Whistle", "Low Conga",
            "Cowbell", "Vibraslap", "Low-mid Tom", "High Agogo",
            "Open Hi Conga"};
    int[] instruments = {35, 42, 46, 38, 49, 39, 50, 60, 70, 72, 64, 56, 58, 47, 67, 63};

    //The program starts by creating a new BeatBox object and calling buildGUI() to create the interface.
    public static void main(String[] args) {
        new BeatBox().buildGUI();
    }

    //
    public void buildGUI() {
        JFrame frame = new JFrame("Cyber BeatBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BorderLayout layout = new BorderLayout();
        JPanel background = new JPanel(layout);
        background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Box buttonBox = new Box(BoxLayout.Y_AXIS);

        JButton start = new JButton("Start");
        start.addActionListener(e -> buildTrackAndStart());
        buttonBox.add(start);

        JButton stop = new JButton("Stop");
        stop.addActionListener(e -> sequencer.stop());
        buttonBox.add(stop);

        JButton upTempo = new JButton("Tempo Up");
        upTempo.addActionListener(e -> changeTempo(1.03f));
        buttonBox.add(upTempo);

        JButton downTempo = new JButton("Tempo Down");
        downTempo.addActionListener(e -> changeTempo(0.97f));
        buttonBox.add(downTempo);

        JButton save = new JButton("serializeIt");
        save.addActionListener(e -> writeFile());
        buttonBox.add(save);

        JButton restore = new JButton("restore");
        restore.addActionListener(e -> readFile());
        buttonBox.add(restore);

        Box nameBox = new Box(BoxLayout.Y_AXIS);
        for (String instrumentName : instrumentNames) {
            JLabel instrumentLabel = new JLabel(instrumentName);
            instrumentLabel.setBorder(BorderFactory.createEmptyBorder(4, 1, 4, 1));
            nameBox.add(instrumentLabel);
        }

        background.add(BorderLayout.EAST, buttonBox);
        background.add(BorderLayout.WEST, nameBox);

        frame.getContentPane().add(background);

        GridLayout grid = new GridLayout(16, 16);
        grid.setVgap(1);
        grid.setHgap(2);

        JPanel mainPanel = new JPanel(grid);
        background.add(BorderLayout.CENTER, mainPanel);

        checkboxList = new ArrayList<>();
        for (int i = 0; i < 256; i++) {
            JCheckBox c = new JCheckBox();
            c.setSelected(false);
            checkboxList.add(c);
            mainPanel.add(c);
        }

        setUpMidi();

        frame.setBounds(50, 50, 300, 300);
        frame.pack();
        frame.setVisible(true);
    }

    private void setUpMidi() {
        try {
            sequencer = MidiSystem.getSequencer();
            sequencer.open();
            sequence = new Sequence(Sequence.PPQ, 4);
            track = sequence.createTrack();
            sequencer.setTempoInBPM(120);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void buildTrackAndStart() {
        int[] trackList;

        sequence.deleteTrack(track);
        track = sequence.createTrack();
        for (int i = 0; i < 16; i++) {
            trackList = new int[16];

            int key = instruments[i];
            for (int j = 0; j < 16; j++) {
                JCheckBox jc = checkboxList.get(j + 16 * i);
                if (jc.isSelected()) {
                    trackList[j] = key;
                } else {
                    trackList[j] = 0;
                }
            }
            makeTracks(trackList);
            track.add(makeEvent(CONTROL_CHANGE, 1, 127, 0, 16));
        }

        track.add(makeEvent(PROGRAM_CHANGE, 9, 1, 0, 15));
        try {

            sequencer.setSequence(sequence);
            sequencer.setLoopCount(sequencer.LOOP_CONTINUOUSLY);
            sequencer.setTempoInBPM(120);
            sequencer.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void changeTempo(float tempoMultiplier) {
        float tempoFactor = sequencer.getTempoFactor();
        sequencer.setTempoFactor(tempoFactor * tempoMultiplier);
    }

    private void makeTracks(int[] list) {
        for (int i = 0; i < 16; i++) {
            int key = list[i];

            if (key != 0) {
                track.add(makeEvent(NOTE_ON, 9, key, 100, i));
                track.add(makeEvent(NOTE_OFF, 9, key, 100, i + 1));
            }
        }
    }

    public static MidiEvent makeEvent(int cmd, int chnl, int one, int two, int tick) {
        MidiEvent event = null;
        try {
            ShortMessage msg = new ShortMessage();
            msg.setMessage(cmd, chnl, one, two);
            event = new MidiEvent(msg, tick);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return event;
    }

    ////Saves the current state of all checkboxes (the beat pattern) to a file called "Checkbox.ser"
    /// save your pattern to a file
    /// where serialization takes place
    private void writeFile() {
        boolean[] checkboxState = new boolean[256]; //Creates a new array of 256 boolean values.
        //Loops through all 256 checkboxes stored in checkboxList.
        for (int i = 0; i < 256; i++) {
            JCheckBox check = checkboxList.get(i);
            //If it’s selected, the code sets the corresponding element in checkboxState to true.
            if (check.isSelected()) {
                checkboxState[i] = true;
            }
        }
        try (ObjectOutputStream os =
                     new ObjectOutputStream(new FileOutputStream("Checkbox.ser"))) {
            os.writeObject(checkboxState); //serialize and writes the entire boolean[] to the file.
        } catch (IOException e) {
            e.printStackTrace(); //if try block doesn't run the catch block prints the error stack trace.
        }
    }

    //// Loads the saved beat pattern from "Checkbox.ser" and restores the checkbox selections.
    /// loading the pattern again
    private void readFile() {
        //Creates a variable named checkboxState that will later hold an array of 256 boolean values
        boolean[] checkboxState = null;
        //deserialize and reads the stored object (in this case, the boolean[] array that was written earlier).
        try (ObjectInputStream is =
                     new ObjectInputStream(new FileInputStream("Checkbox.ser"))) {
            checkboxState = (boolean[]) is.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Loops through all checkboxes and restores each one’s selected state from the saved data.
        for (int i = 0; i < 256; i++) {
            JCheckBox check = checkboxList.get(i);
            check.setSelected(checkboxState[i]);
        }

        sequencer.stop(); //Stops any currently playing beat (if one is running).
        buildTrackAndStart(); //builds the pattern and starts playing it again
    }
}
