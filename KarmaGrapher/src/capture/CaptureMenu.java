package capture;

import java.io.IOException;

import javax.swing.JFrame;

import save.DataHandler;

@SuppressWarnings("serial")
public class CaptureMenu extends JFrame {

	int t = 0;
	String hold;
	String url;
	String path;
	StatReader kr;
	DataHandler dh;
	long inittime;

	public CaptureMenu(String url, int dt, StatReader kr) {

		inittime = System.currentTimeMillis();
		

		try {
			kr.BufferSource(url);
		} catch (IOException e) {
			
			System.out.println("Unable to Get source");
			System.exit(1);
			
		}

		dh = new DataHandler();

		path = dh.selectSave();

		t = dt;
		this.kr = kr;
		this.url = url;

	}

	public void capture(int c) {
		
		dh.buffer("t; Karma; Percentage;\n").getBytes();

		int i = 0;
		

		while (i < c) {

			try {
				hold = kr.getKarma();

				System.out.println(hold);

				if (hold != null) {

					dh.buffer((getRuntime() + "; " + hold + ";").getBytes());

					hold = kr.getViews();

					if (hold != null) {
						dh.buffer((hold+";\n").getBytes());
					}
				}

				Thread.sleep(t);
			} catch (InterruptedException e) {
				System.out.println("Client Side Failed");
			}

			i++;

		}

		dh.flush(path);

	}

	public long getRuntime() {
		return System.currentTimeMillis() - inittime;
	}

}
