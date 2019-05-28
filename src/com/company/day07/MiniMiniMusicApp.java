import javax.sound.midi.*;

public class MiniMiniMusicApp {
    public static void main(String[] args){
        MiniMiniMusicApp mini = new MiniMiniMusicApp();
        mini.play();
    }
    public void play(){
        try{

          //ȡ��Sequencer�������
          Sequencer player = MidiSystem.getSequencer();
          player.open();
          //�Ȳ��ܲ���������
          Sequence seq = new Sequence(Sequence.PPQ, 4);
          //Ҫ��ȡ��Track
          Track track = seq.createTrack();

          ShortMessage c = new ShortMessage();
          c.setMessage(155, 2, 30, 100);
          MidiEvent first = new MidiEvent(c, 5);
          track.add(first);

          ShortMessage a = new ShortMessage();
          a.setMessage(144, 1, 30, 100);
          MidiEvent noteOn = new MidiEvent(a, 1);
          track.add(noteOn);

          ShortMessage b = new ShortMessage();
          b.setMessage(128, 1, 44, 100);
          MidiEvent noteOff = new MidiEvent(b, 10);
          track.add(noteOff);

          player.setSequence(seq);

          player.start();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }//�رղ���
}