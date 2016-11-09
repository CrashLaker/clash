package bot2;


import org.sikuli.script.*;
import org.sikuli.basics.Debug;
class Test {
  public static void main(String[] args) throws FindFailed {
    Debug.setDebugLevel(3);
    Screen s = new Screen();
    s.find(s.userCapture().getFile()).highlight(2);
  }
}