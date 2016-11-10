/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bot2;


/**
 *
 * @author Crash
 */
import java.io.File;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenLocation;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.robot.desktop.DesktopMouse;


public class Bot2 implements Runnable{

    public static ImageTarget baropen, barclose, donate,
            valk, wb, wiz, elixir, gold, delixir, reload, 
            poison, donated, trunk, earth, tryagain, archer;
    public static ScreenRegion found = null;
    public static ScreenRegion r;
    public static ImageTarget cuser;
    public static ArrayList<ImageTarget> users;
    public static ImageTarget crash, spivak;
    public static DesktopMouse mouse = new DesktopMouse();
    public static long[] ban;
    public static long reloaddelay = 0;
    public static List<ScreenRegion> rs;
    public static ScreenRegion s;
    public static String lastcmd = "null";
    public static void sieve() throws Exception{
        baropen = createImageTarget("./baropen.png");
        barclose = createImageTarget("./barclose.png");
        donate = createImageTarget("./donate.png");
        valk = createImageTarget("./valk.png");
        wb = createImageTarget("./wb.png");
        wiz = createImageTarget("./wiz.png");
        elixir = createImageTarget("./elixir.png");
        gold = createImageTarget("./gold.png");
        delixir = createImageTarget("./delixir.png");
        reload = createImageTarget("./reload.png");
        poison = createImageTarget("./poison.png");
        donated= createImageTarget("./donated.png");
        trunk = createImageTarget("./trunk.png");
        earth = createImageTarget("./earth.png");
        tryagain = createImageTarget("./tryagain.png");
        archer = createImageTarget("./archer.png");
        
    }
    public void run(){
        try{
            ServerSocket listener = new ServerSocket(5000);
            try {
                while (true) {
                    Socket socket = listener.accept();
                    try {
                        PrintWriter out =
                            new PrintWriter(socket.getOutputStream(), true);
                        out.println(lastcmd);
                    } finally {
                        socket.close();
                    }
                }
            }
            finally {
                listener.close();
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public static ImageTarget createImageTarget(String filename) throws Exception{
        return new ImageTarget(new File(filename));
    }
    public static void click(ImageTarget imageImageTarget) throws Exception {
        //ImageTarget imageImageTarget = new ImageTarget(new File(filename));

        // Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        s = new DesktopScreenRegion();
        //ScreenRegion r = s.wait(imageImageTarget, 1000);
        r = s.find(imageImageTarget);

        //System.out.printf("%s\n", r.toString());
        //System.out.printf("%d %d %d %d\n", r.getBounds().x, r.getBounds().y, r.getBounds().width, r.getBounds().height);
        if (r == null) {
            //System.out.println(filename + "not found.");
            return;
        }

        // Display "Hello World" next to the found target for 3 seconds
        //Canvas canvas = new DesktopCanvas();
        //canvas.addLabel(r, "X").display(3);
        // Click the center of the found target
        mouse.click(r.getCenter());
    }

    public static void click(ImageTarget imageImageTarget, int quant) throws Exception {
        
        //ImageTarget imageImageTarget = new ImageTarget(new File(filename));

        // Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        s = new DesktopScreenRegion();
        //ScreenRegion r = s.wait(imageImageTarget, 1000);
        r = s.find(imageImageTarget);

        //System.out.printf("%s\n", r.toString());
        //System.out.printf("%d %d %d %d\n", r.getBounds().x, r.getBounds().y, r.getBounds().width, r.getBounds().height);
        if (r == null) {
            //System.out.println(filename + " not found.");
            return;
        }

        // Display "Hello World" next to the found target for 3 seconds
        //Canvas canvas = new DesktopCanvas();
        //canvas.addLabel(r, "X").display(3);
        // Click the center of the found target
        for (int i = 0; i < quant; i++) {
            mouse.click(r.getCenter());
            delay(100);
        }
    }

    public static boolean find(ImageTarget imageImageTarget) throws Exception {
        //ImageTarget imageImageTarget = new ImageTarget(new File(filename));

        // Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        s = new DesktopScreenRegion();
        r = s.find(imageImageTarget);
        found = r;
        if (r == null) {
            //System.out.println(filename + " not found.");
            return false;
        }
        return true;
    }
    
    public static boolean wait(ImageTarget imageImageTarget) throws Exception {
        //ImageTarget imageImageTarget = new ImageTarget(new File(filename));

        // Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        s = new DesktopScreenRegion();
        r = s.wait(imageImageTarget, 3000);
        found = r;
        if (r == null) {
            //System.out.println(filename + " not found.");
            return false;
        }
        return true;
    }

    public static void delay(int timee) throws Exception {
        Thread.sleep(timee);
    }

    public static void donate() throws Exception {
        ScreenLocation sl = found.getCenter();
        sl.setX(sl.getX() + 194);
        sl.setY(sl.getY() + 51);
        //ImageTarget imageImageTarget = new ImageTarget(new File(donate));
        s = new DesktopScreenRegion();
        rs = s.findAll(donate);
        
        for (ScreenRegion r : rs){
            //if (r.getBounds().y < sl.getY() && sl.getY() < r.getBounds().y+r.getBounds().height){
            int difx = Math.abs(sl.getX() - r.getCenter().getX());
            int dify = Math.abs(sl.getY() - r.getCenter().getY());
            int e = 21;
            System.out.printf("%d %d %d\n", difx, dify, e);
            if (difx < e && dify < e){
                mouse.click(sl);
                delay(500);
                if (cuser == crash || cuser == spivak) click(earth);
                click(wiz, 7);
				click(archer, 2);
                click(trunk);
                return;
            }
        }
        
    }

    public static boolean check(String filename) throws Exception {
        ScreenRegion user = found;
        ImageTarget imageImageTarget = new ImageTarget(new File(filename));
        ScreenRegion s = new DesktopScreenRegion();
        List<ScreenRegion> rs = s.findAll(imageImageTarget);
        for (ScreenRegion r : rs){
            if (Math.abs(r.getBounds().y-user.getBounds().y) < 50) return false;
        }
        return true;
    }
    public static void setcmd(String a){
        lastcmd = a;
    }
    public static void main(String[] args) throws MalformedURLException {
        
        (new Thread(new Bot2())).start();
        try {
            sieve();
            users = new ArrayList<ImageTarget>();
            crash = createImageTarget("./crash-ask.png");
            users.add(crash);
			spivak = createImageTarget("./spivak.png");
            users.add(spivak);
            
            users.add(createImageTarget("./katz-ask.png"));
            users.add(createImageTarget("./katz2.png"));
            users.add(createImageTarget("./kenji.png"));
            users.add(createImageTarget("./satodama.png"));
            users.add(createImageTarget("./shai.png"));
            users.add(createImageTarget("./emersony.png"));
            users.add(createImageTarget("./ltcrew.png"));
            users.add(createImageTarget("./seiji2.png"));
            users.add(createImageTarget("./tamazato.png"));
            users.add(createImageTarget("./branzera.png"));
            users.add(createImageTarget("./kehai.png"));
            
            ban = new long[users.size()];
            for (int i = 0; i < users.size(); i++){
                ban[i] = 0;
            }
            while (true) {
                System.out.println(">Free memoty (Mbytes): " + 
  Runtime.getRuntime().freeMemory()/1024);
            if (wait(tryagain)){
                click(tryagain);
            }else if (wait(reload)) {
                    setcmd("Reload");
                    delay(3*60*1000);
                    click(reload);
                    delay(5000);
                    setcmd("End Reload");
                } else if (find(baropen)) {
                    setcmd("baropen");
                    delay(20*1000);
                    click(baropen);
                    delay(3000);
                    setcmd("end baropen");
                } else {
                    setcmd("Loop users");
                    for (int i = 0; i < users.size(); i++){
                        //ImageTarget user = users.get(i);
                        cuser = users.get(i);
                        if ((/*cuser == crash ||*/ getmillis() - ban[i] > 3*60*1000) && find(users.get(i))){
                            //if (ban[i] != 0){
                            //    if (getmillis() - ban[i] < 2*60*1000) continue;
                            //}
                            System.out.println("found "+users.get(i));
                            System.out.println("-Total memory (Mbytes): " + 
  Runtime.getRuntime().totalMemory()/1024);
                            donate();
                            System.out.println("+Total memory (Mbytes): " + 
  Runtime.getRuntime().totalMemory()/1024);
                            ban[i] = getmillis();
                        }
                    }
                    setcmd("end loop users");
                }
                //delay(2*60*1000);
                System.gc();
                if (Runtime.getRuntime().totalMemory()/1024 > 1000000) System.exit(0);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static long getmillis(){
        return Calendar.getInstance().getTimeInMillis();
    }
}
