import java.util.*;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main (String args[]) throws UnsupportedAudioFileException,IOException,LineUnavailableException
    {
        Scanner sc=new Scanner(System.in);
        String response="";
        File file=new File("12.wav");

        AudioInputStream audioStream=AudioSystem.getAudioInputStream(file);
        Clip clip=AudioSystem.getClip();


        clip.open(audioStream);
    
        while(!response.equals("Q"))
        {
            System.out.println("P =play, S=stop, R=Reset, Q=Quit");
            System.out.print("Enter your choice:");
            response=sc.next();
            response=response.toUpperCase();

            switch(response)
            {
                case "P":
                    clip.start();
                    break;
                case "S":
                    clip.stop();
                    break;
                case "R":
                    clip.setFramePosition(0); // Reset the clip to the beginning
                    break;
                    case "Q":
                    clip.stop();
                    clip.close();
                    break;
                default:
                    System.out.println("Not a valid response");
            }
        }
        sc.close();
    }
}
