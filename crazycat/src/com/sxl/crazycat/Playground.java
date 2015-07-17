package com.sxl.crazycat;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.inputmethodservice.Keyboard;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by xsxgr123 on 2015/7/13.
 */
public class Playground extends SurfaceView implements View.OnTouchListener {

    private static int WIDTH = 20;
    private static final int ROW = 10;
    private static final int COL = 10;
    private static final int BLOCK = 15;

    Dot[][] matrix;
    Dot cat;


    public Playground(Context context) {
        super(context);
        getHolder().addCallback(callback);
        matrix = new Dot[ROW][COL];
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                matrix[i][j] = new Dot(j, i);

            }
        }
        setOnTouchListener(this);
        initaGame();
    }

    Callback callback = new Callback() {
        @Override
        public void surfaceCreated(SurfaceHolder holder) {
            redraw();
        }

        @Override
        public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
            WIDTH = width/(COL+1);
            redraw();
        }

        @Override
        public void surfaceDestroyed(SurfaceHolder holder) {

        }
    };
      private boolean isAtEdge(Dot d){
          if (d.getX()*d.getY()==0||d.getX()+1==COL||d.getY()+1==ROW){
              return true;
          }
          return false;
      }
    private Dot getDot(int x,int y){
        return matrix[y][x];
    }
    private  Dot getNeighbour(Dot d,int dir){
        switch (dir){
            case 1:
                return getDot(d.getX()-1,d.getY());
            case 2:
                if(d.getY()%2==0){
                    return getDot(d.getX()-1,d.getY()-1);
                }
                else{
                    return getDot(d.getX(),d.getY()-1);
                }
            case 3:
                if(d.getY()%2==0){
                    return getDot(d.getX(),d.getY()-1);
                }
                else{
                    return getDot(d.getX()+1,d.getY()-1);
                }
            case 4:
                return getDot(d.getX()+1,d.getY());
            case 5:
                if(d.getY()%2==0){
                    return getDot(d.getX(),d.getY()+1);
                }
                else{
                    return getDot(d.getX()+1,d.getY()+1);
                }
            case 6:
                if(d.getY()%2==0){
                    return getDot(d.getX()-1,d.getY()+1);
                }
                else{
                    return getDot(d.getX(),d.getY()+1);
                }

        }
        return null;
    }
    private  int getDistance(Dot d,int dir){
        int distance = 0;
        if (isAtEdge(d)){
            return  1;
        }
        Dot ori = d;
        Dot next;
        while(true){
            next = getNeighbour(ori,dir);
            if(next.getStatus() == Dot.STATUS_ON){
                return distance*-1;
            }
            if(isAtEdge(next)){
                distance++;
                return distance;
            }
            distance++;
             ori = next;
        }
    }
     private  void moveTo(Dot d){
         d.setStatus(Dot.STATUS_IN);
         getDot(cat.getX(), cat.getY()).setStatus(Dot.STATUS_OFF);
         cat.setXY(d.getX(),d.getY());
     }
    private void move(){
        if (isAtEdge(cat)){
            lose();
            return;
        }
        List<Dot> available = new ArrayList<>();
        List<Dot> positive = new ArrayList<>();
        HashMap<Dot,Integer> map = new HashMap<Dot,Integer>();
        for(int i = 1;i<7;i++){
            Dot d = getNeighbour(cat,i);
            if(d.getStatus()==Dot.STATUS_OFF){
                available.add(d);
                map.put(d, i);
                if(getDistance(d,i)>0){
                    positive.add(d);
                }
            }
        }
        if(available.size() == 0){
            win();
        }else if(available.size()==1){
            moveTo(available.get(0));
        }else{
            Dot best = null;
            if (positive.size()!=0){
                System.out.println("向前进");
                int min = 999;
                for (int i=0;i<positive.size();i++){
                    int a = getDistance(positive.get(i),map.get(positive.get(i)));
                    if(a<min){
                        min = a;
                        best = positive.get(i);
                    }
                }
            }else{
                System.out.println("躲路障");
                int max = 0;
                for (int i = 0;i<available.size();i++){
                    int b = getDistance(available.get(i),map.get(available.get(i)));
                    if(b<=max){
                        max = b;
                        best = available.get(i);
                    }
                }
            }
            moveTo(best);
        }
    }
    private void lose(){
        Toast.makeText(getContext(),"你输了！让猫跑了",Toast.LENGTH_SHORT).show();
    }
    private void win(){
        Toast.makeText(getContext(),"你赢了！成功的困住了猫",Toast.LENGTH_SHORT).show();
    }
    private void redraw() {
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.cat);
        Canvas c = getHolder().lockCanvas();
        c.drawColor(Color.CYAN);
        Paint paint = new Paint();
        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        c.drawBitmap(bitmap,0,0,paint);
        for (int i = 0; i < ROW; i++) {
            int offset = 0;
            if (i%2!=0){
                offset = WIDTH/2;
            }

            for (int j = 0; j < COL; j++) {
                Dot d = getDot(j,i);
                switch (d.getStatus()) {
                    case Dot.STATUS_OFF:
                        paint.setColor(0xFFEEEEEE);
                        break;
                    case Dot.STATUS_ON:
                        paint.setColor(0xFFFFAA00);
                        break;
                    case Dot.STATUS_IN:
                        paint.setColor(0xFFFF0000);

                        break;


                }
                c.drawOval(new RectF(d.getX() * WIDTH+offset, d.getY() * WIDTH, (d.getX() + 1) * WIDTH+offset, (d.getY() + 1) * WIDTH), paint);

            }
        }
        getHolder().unlockCanvasAndPost(c);

    } 

    private void initaGame() {
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                matrix[i][j].setStatus(Dot.STATUS_OFF);

            }

        }
        cat = new Dot(4, 5);
        getDot(4,5).setStatus(Dot.STATUS_IN);

        for (int i = 0; i < BLOCK; ) {
            int x = (int) ((Math.random() * 1000) % COL);
            int y = (int) ((Math.random() * 1000) % ROW);
            if (getDot(x,y).getStatus() == Dot.STATUS_OFF) {
                getDot(x,y).setStatus(Dot.STATUS_ON);
                i++;
            }
        }
    }
    int k =1;

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if (event.getAction() ==MotionEvent.ACTION_UP){
            int y = (int)(event.getY()/WIDTH);
            int x;
            if(y%2!=0){
                 x = (int) ((event.getX()-WIDTH/2)/WIDTH);
            }else{
                 x = (int)(event.getX()/WIDTH);
            }
            if(x+1>COL||y+1>ROW){
               initaGame();
             for(int i = 1;i<7;i++){
                 System.out.println(i+":"+getDistance(cat,i));
             }
            }else if(getDot(x,y).getStatus()==Dot.STATUS_OFF){
                getDot(x,y).setStatus(Dot.STATUS_ON);
                move();
            }
            redraw();
        }
        return true;
    }
}
