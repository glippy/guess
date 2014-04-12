package com.example.guess;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

public class MainActivity extends Activity {

	int blue = 0;
	int red = 0;
	int yellow = 0;
	int green = 0;
	int perl = 0;
	int orange = 0;

	int opened = 0;
	int openedCell_1 = 0;
	int openedCell_2 = 0;
	int tmp1;
	int tmp2;

	int oldX;
	int oldY;

	int cnt = 0;

	private int field[][] = new int[4][6];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TextView count = (TextView) findViewById(R.id.count);
		count.setText(Integer.toString(cnt));

		createField();

	}

	public void createField() {

		for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 6; x++) {
				int cellColor = 0;
				while (cellColor == 0) {
					cellColor = getCell();
				}
				field[y][x] = cellColor;
			}
		}
	}

	public int getCell() {

		int color = getRandom();

		if (color == 1) {
			if (blue != 4) {
				blue++;
				return 1;
			} else {
				getRandom();
			}
		}

		if (color == 2) {
			if (red != 4) {
				red++;
				return 2;
			} else {
				getRandom();
			}
		}

		if (color == 3) {
			if (yellow != 4) {
				yellow++;
				return 3;
			} else {
				getRandom();
			}
		}

		if (color == 4) {
			if (green != 4) {
				green++;
				return 4;
			} else {
				getRandom();
			}
		}

		if (color == 5) {
			if (perl != 4) {
				perl++;
				return 5;
			} else {
				getRandom();
			}
		}

		if (color == 6) {
			if (orange != 4) {
				orange++;
				return 6;
			} else {
				getRandom();
			}
		}

		return 0;

	}

	public int getRandom() {

		return (int) (Math.random() * 6 + 1);

	}

	public void checkCell(int y, int x, int z) {

		int cell = 7;

		cell = field[y][x];

		if (cell != 7) {
			if (oldX != x || oldY != y) {

				if (opened == 0) {
					openCell(cell, z);
					openedCell_1 = cell;
					opened++;
					tmp1 = z;
					oldX = x;
					oldY = y;
				} else if (opened == 1) {
					if (openedCell_1 == cell) {
						openCell(cell, z);
						openedCell_1 = 0;
						opened = 0;
						field[y][x] = 7;
						field[oldY][oldX] = 7;
						cnt++;
						TextView count = (TextView) findViewById(R.id.count);
						count.setText(Integer.toString(cnt));

					} else {
						openCell(cell, z);
						openedCell_2 = cell;
						opened++;
						tmp2 = z;
						cnt++;
						TextView count = (TextView) findViewById(R.id.count);
						count.setText(Integer.toString(cnt));

					}
				} else if (opened == 2) {
					closeCell(tmp1, tmp2);
					tmp1 = 0;
					tmp2 = 0;
					opened = 0;
				}

			}
		}

	}

	public void openCell(int cell, int z) {

		if (cell == 1) {
			findViewById(z).setBackgroundResource(R.drawable.btnblue);
		} else if (cell == 2) {
			findViewById(z).setBackgroundResource(R.drawable.btnred);
		} else if (cell == 3) {
			findViewById(z).setBackgroundResource(R.drawable.btnyellow);
		} else if (cell == 4) {
			findViewById(z).setBackgroundResource(R.drawable.btngreen);
		} else if (cell == 5) {
			findViewById(z).setBackgroundResource(R.drawable.btnperl);
		} else if (cell == 6) {
			findViewById(z).setBackgroundResource(R.drawable.btnorange);
		} else if (cell == 0) {
			findViewById(z).setBackgroundResource(R.drawable.btnblack);
		}

	}

	public void closeCell(int tmp1, int tmp2) {
		findViewById(tmp1).setBackgroundResource(R.drawable.buttonshape);
		findViewById(tmp2).setBackgroundResource(R.drawable.buttonshape);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void buttonClick(View view) {

		switch (view.getId()) {
		case R.id.Btn00: {
			int z = R.id.Btn00;
			checkCell(0, 0, z);
			break;
		}
		case R.id.Btn01: {
			int z = R.id.Btn01;
			checkCell(0, 1, z);
			break;
		}
		case R.id.Btn02: {
			int z = R.id.Btn02;
			checkCell(0, 2, z);
			break;
		}
		case R.id.Btn03: {
			int z = R.id.Btn03;
			checkCell(0, 3, z);
			break;
		}
		case R.id.Btn04: {
			int z = R.id.Btn04;
			checkCell(0, 4, z);
			break;
		}
		case R.id.Btn05: {
			int z = R.id.Btn05;
			checkCell(0, 5, z);
			break;
		}
		case R.id.Btn10: {
			int z = R.id.Btn10;
			checkCell(1, 0, z);
			break;
		}
		case R.id.Btn11: {
			int z = R.id.Btn11;
			checkCell(1, 1, z);
			break;
		}
		case R.id.Btn12: {
			int z = R.id.Btn12;
			checkCell(1, 2, z);
			break;
		}
		case R.id.Btn13: {
			int z = R.id.Btn13;
			checkCell(1, 3, z);
			break;
		}
		case R.id.Btn14: {
			int z = R.id.Btn14;
			checkCell(1, 4, z);
			break;
		}
		case R.id.Btn15: {
			int z = R.id.Btn15;
			checkCell(1, 5, z);
			break;
		}
		case R.id.Btn20: {
			int z = R.id.Btn20;
			checkCell(2, 0, z);
			break;
		}
		case R.id.Btn21: {
			int z = R.id.Btn21;
			checkCell(2, 1, z);
			break;
		}
		case R.id.Btn22: {
			int z = R.id.Btn22;
			checkCell(2, 2, z);
			break;
		}
		case R.id.Btn23: {
			int z = R.id.Btn23;
			checkCell(2, 3, z);
			break;
		}
		case R.id.Btn24: {
			int z = R.id.Btn24;
			checkCell(2, 4, z);
			break;
		}
		case R.id.Btn25: {
			int z = R.id.Btn25;
			checkCell(2, 5, z);
			break;
		}
		case R.id.Btn30: {
			int z = R.id.Btn30;
			checkCell(3, 0, z);
			break;
		}
		case R.id.Btn31: {
			int z = R.id.Btn31;
			checkCell(3, 1, z);
			break;
		}
		case R.id.Btn32: {
			int z = R.id.Btn32;
			checkCell(3, 2, z);
			break;
		}
		case R.id.Btn33: {
			int z = R.id.Btn33;
			checkCell(3, 3, z);
			break;
		}
		case R.id.Btn34: {
			int z = R.id.Btn34;
			checkCell(3, 4, z);
			break;
		}
		case R.id.Btn35: {
			int z = R.id.Btn35;
			checkCell(3, 5, z);
			break;
		}
		default: {
		}

		}

	}

	public void btnClickRestart(View view) {

		blue = 0;
		red = 0;
		yellow = 0;
		green = 0;
		perl = 0;
		orange = 0;

		opened = 0;
		openedCell_1 = 0;
		openedCell_2 = 0;

		cnt = 0;

		TextView count = (TextView) findViewById(R.id.count);
		count.setText(Integer.toString(cnt));

		createField();

		findViewById(R.id.Btn00).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn01).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn02).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn03).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn04).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn05).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn10).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn11).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn12).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn13).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn14).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn15).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn20).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn21).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn22).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn23).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn24).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn25).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn30).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn31).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn32).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn33).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn34).setBackgroundResource(R.drawable.buttonshape);
		findViewById(R.id.Btn35).setBackgroundResource(R.drawable.buttonshape);

	}

}
