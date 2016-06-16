import java.io.*;
import javax.sound.sampled.*;
public class AudioPlayer2 {

private static File file = new File("audio\\pylonActivating.wav");

public static void play(File file) 
{
    try
    {
        final Clip clip = (Clip)AudioSystem.getLine(new Line.Info(Clip.class));

        clip.addLineListener(new LineListener()
        {
            @Override
            public void update(LineEvent event)
            {
                if (event.getType() == LineEvent.Type.STOP)
                    clip.close();
            }
        });

        clip.open(AudioSystem.getAudioInputStream(file));
        clip.start();
    }
    catch (Exception exc)
    {
        exc.printStackTrace(System.out);
    }
}

public static void main(String[] args){
	play(file);
}

}