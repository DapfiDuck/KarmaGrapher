package save;

import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class DataHandler {
	

	JFileChooser ch = new JFileChooser();
	FileNameExtensionFilter filter = new FileNameExtensionFilter("Comma Seperated Value File (.csv)","csv", "csv");
	
	byte[] buffer;

	
	
	public DataHandler() {
		
		ch.setFileFilter(filter);
		
	}
	
	public void buffer(byte[] in) {
		
		if(buffer == null){
			buffer = in;
			return;
		}
		
		byte copy[] = buffer.clone();
		
		int nl = buffer.length+in.length;
		
		buffer = new byte[nl];
		
		for(int i = 0; i < copy.length; i++) {
			
			buffer[i] = copy[i];
			
		}
		
		for(int i = copy.length; i < buffer.length; i++){
			
			buffer[i] = in[i-copy.length];
			
		}
		
	}
	
	public String selectSave() {


		ch.showSaveDialog(null);

		return ch.getSelectedFile().getAbsolutePath();
	}
	

	public void flush(String path) {
		

		try {
			FileOutputStream writer = new FileOutputStream(path);
			writer.write(buffer);
			writer.close();
		} catch (IOException i) {
			JOptionPane.showMessageDialog(null, "Unable to save file");
		}

	}

}
