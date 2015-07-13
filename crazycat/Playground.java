package com.sxl.crazycat;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.MotionEvent;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

public class Playground extends SurfaceView implements View.OnTouchListener{
	private static  int WIDTH =20;
	private static final int ROW =10;
	private static final int COL =10;
	private static final  int BLOCK = 15;
	
	Dot matrix[][];
    Dot cat;
	public Playground(Context context) {
		super(context);
		getHolder().addCallback(callback);
		matrix = new Dot[ROW][COL];
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				matrix[i][j]= new Dot(j, i);
			}
		}
		setOnTouchListener(this);
		initGame();
	}
	
	Callback callback = new Callback() {
		
		@Override
		public void surfaceDestroyed(SurfaceHolder holder) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void surfaceCreated(SurfaceHolder holder) {
			redraw();
			
		}
		
		@Override
		public void surfaceChanged(SurfaceHolder holder, int format, int width,
				int height) {
			 WIDTH=width/(COL+1);
			redraw();
		}
	};
	
	private boolean isAtEdge(Dot d){
		if(d.getX()*d.getY()==0||d.getX()+1==COL||d.getY()+1==ROW){
			return true;
		}
		return false;
	}
	private Dot getDot(int x,int y){
		return matrix[y][x];
	}
	private Dot getNeighbour(Dot d,int dir){
		switch (dir) {
		case 1:
			return getDot(d.getX()-1, d.getY());
		case 2:
			if(d.getY()%2==0){
				return getDot(d.getX()-1, d.getY()-1);
			}else{
				return getDot(d.getX(),d.getY()-1 );	
			}
		case 3:
			if(d.getY()%2==0){
				return getDot(d.getX(), d.getY()-1);
			}else{
				return getDot(d.getX()+1,d.getY()-1 );	
			}
		case 4:
			return getDot(d.getX()+1, d.getY());
		case 5:
			if(d.getY()%2==0){
				return getDot(d.getX(), d.getY()+1);
			}else{
				return getDot(d.getX()+1,d.getY()+1 );	
			}
		case 6:
			if(d.getY()%2==0){
				return getDot(d.getX()-1, d.getY()+1);
			}else{
				return getDot(d.getX(),d.getY()+1 );	
			}
		
		default:
			break;
		}
		return null;
	}
	private void redraw(){
		Canvas c=getHolder().lockCanvas();
		c.drawColor(Color.LTGRAY);
		Paint paint = new Paint();
		for (int i = 0; i < ROW; i++) {
			int offset = 0;
			if(i%2!=0){
				offset=WIDTH/2;
			}
			for (int j = 0; j < COL; j++) {
				Dot d=getDot(j,i);
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
  
				default:
					break;
				}
			c.drawOval(new RectF(d.getX()*WIDTH+offset, d.getY()*WIDTH,
					(d.getX()+1)*WIDTH+offset, (d.getY()+1)*WIDTH),
					paint);
			}
		}
		getHolder().unlockCanvasAndPost(c);
		 }
	
	private void initGame(){
		for (int i = 0; i < ROW; i++) {
			for (int j = 0; j < COL; j++) {
				matrix[i][j].setStatus(Dot.STATUS_OFF);
			}
		}
		cat = new Dot(4,5);
		getDot(4,5).setStatus(Dot.STATUS_IN);
		for (int i = 0; i < BLOCK;) {
			int x=(int) ((Math.random()*1000)%COL);
			int y=(int) ((Math.random()*1000)%ROW);
			if(getDot(x, y).getStatus()==Dot.STATUS_OFF){
				getDot(x, y).setStatus(Dot.STATUS_ON);
				i++;
			}
		}
	}

	int k=1;
	@Override
	public boolean onTouch(View v, MotionEvent event) {
	    if(event.getAction()==MotionEvent.ACTION_UP){
	    	int y = (int) (event.getY()/WIDTH);
	    	int x;
	    	if(y%2!=0){
	    	   x = (int) (event.getX()-WIDTH/2);
	    	}else{
	    	   x = (int) (event.getX()/WIDTH);
	    	}
	    	if(x+1>COL||y+1>ROW){
	    		initGame();
	    		getNeighbour(cat, k).setStatus(Dot.STATUS_IN);
	    		k++;
	    		redraw();
	    	}else{
	           matrix[y][x].setStatus(Dot.STATUS_ON);
	    	}
	    	redraw();
	    }
		return true;
	}
}


