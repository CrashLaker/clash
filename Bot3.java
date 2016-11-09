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
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.sikuli.script.*;


public class Bot3 {

    public static String baropen, barclose, donate,
            valk, wb, wiz, elixir, gold, delixir, reload, 
            poison, donated, trunk, earth;
    public static Screen found = null;
    public static Screen r;
    public static String cuser;
    public static ArrayList<String> users;
    public static long[] ban;
    public static long reloaddelay = 0;
    public static List<Screen> rs;
    public static Screen s;
    public static void sieve() throws Exception{
        baropen = "./baropen.png";
        barclose = "./barclose.png";
        donate = "./donate.png";
        valk = "./valk.png";
        wb = "./wb.png";
        wiz = "./wiz.png";
        elixir = "./elixir.png";
        gold = "./gold.png";
        delixir = "./delixir.png";
        reload = "./reload.png";
        poison = "./poison.png";
        donated= "./donated.png";
        trunk = "./trunk.png";
        earth = "./earth.png";
        
    }
    
    public static void click(String imageTarget) throws Exception {
        //ImageTarget imageImageTarget = new ImageTarget(new File(filename);

        // Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        s = new Screen();
        //ScreenRegion r = s.wait(imageImageTarget, 1000);
        //r = s.find(imageImageTarget);

        //System.out.printf("%s\n", r.toString();
        //System.out.printf("%d %d %d %d\n", r.getBounds().x, r.getBounds().y, r.getBounds().width, r.getBounds().height);
        if (r == null) {
            //System.out.println(filename + "not found.");
            return;
        }

        // Display "Hello World" next to the found target for 3 seconds
        //Canvas canvas = new DesktopCanvas();
        //canvas.addLabel(r, "X").display(3);
        // Click the center of the found target
        //mouse.click(r.getCenter();
        s.click(imageTarget);
    }

    public static void click(String imageTarget, int quant) throws Exception {
        
        //ImageTarget imageImageTarget = new ImageTarget(new File(filename);

        // Wait for the target to become visible on the screen for at most 5 seconds
        // Once the target is visible, it returns a screen region object corresponding
        // to the region occupied by this target
        s = new Screen();
        //ScreenRegion r = s.wait(imageImageTarget, 1000);
        //r = s.find(imageImageTarget);

        //System.out.printf("%s\n", r.toString();
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
            //mouse.click(r.getCenter();
            s.click(imageTarget);
            delay(100);
        }
    }



    public static void delay(int timee) throws Exception {
        Thread.sleep(timee);
    }

    public static void donate() throws Exception {
        Screen sl = found.getCenter();
        sl.setX(sl.getX() + 194);
        sl.setY(sl.getY() + 51);
        //ImageTarget imageImageTarget = new ImageTarget(new File(donate);
        s = new Screen();
        rs = s.findAll(donate);
        
        for (Screen r : rs){
            //if (r.getBounds().y < sl.getY() && sl.getY() < r.getBounds().y+r.getBounds().height){
            int difx = Math.abs(sl.getX() - r.getCenter().getX());
            int dify = Math.abs(sl.getY() - r.getCenter().getY());
            int e = 21;
            System.out.printf("%d %d %d\n", difx, dify, e);
            if (difx < e && dify < e){
                mouse.click(sl);
                delay(500);
                if (cuser == crash) click(earth);
                click(wiz, 6);
                click(trunk);
                return;
            }
        }
        
    }


    public static void main(String[] args) throws MalformedURLException {
        try {
            sieve();
            users = new ArrayList<String>();
            crash = "./crash-ask.png";
            users.add(crash);
            users.add("./katz-ask.png");
            users.add("./katz2.png");
            users.add("./spivak.png");
            users.add("./kenji.png");
            users.add("./satodama.png");
            users.add("./shai.png");
            users.add("./emersony.png");
            users.add("./ltcrew.png");
            users.add("./seiji2.png");
            users.add("./tamazato.png");
            
            ban = new long[users.size()];
            for (int i = 0; i < users.size(); i++){
                ban[i] = 0;
            }
            while (true) {
                System.out.println(">Free memoty (Mbytes): " + 
  Runtime.getRuntime().freeMemory()/1024);
                if (wait(reload)) {
                    System.out.println("Reload");
                    delay(3*60*1000);
                    click(reload);
                    delay(5000);
                    System.out.println("End Reload");
                } else if (find(baropen)) {
                    System.out.println("baropen");
                    delay(20*1000);
                    click(baropen);
                    delay(3000);
                    System.out.println("end baropen");
                } else {
                    System.out.println("Loop users");
                    for (int i = 0; i < users.size(); i++){
                        //ImageTarget user = users.get(i);
                        cuser = users.get(i);
                        if ((cuser == crash || getmillis() - ban[i] > 2*60*1000) && find(users.get(i))){
                            //if (ban[i] != 0){
                            //    if (getmillis() - ban[i] < 2*60*1000) continue;
                            //}
                            System.out.println("found "+users.get(i);
                            System.out.println("-Total memory (Mbytes): " + 
  Runtime.getRuntime().totalMemory()/1024);
                            donate();
                            System.out.println("+Total memory (Mbytes): " + 
  Runtime.getRuntime().totalMemory()/1024);
                            ban[i] = getmillis();
                        }
                    }
                    System.out.println("end loop users");
                }
                //delay(2*60*1000);
                System.gc();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public static long getmillis(){
        return Calendar.getInstance().getTimeInMillis();
    }
}
