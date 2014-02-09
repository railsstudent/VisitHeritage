package com.blueskyconnie.visitheritage.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.Log;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;

public final class QRCodeHelper {

	private static final String TAG = QRCodeHelper.class.getName();
	
	
	/**
	 * Writes the given Matrix on a new Bitmap object.
	 * @param matrix the matrix to write.
	 * @return the new {@link Bitmap}-object.
	 */
	private static Bitmap toBitmap(BitMatrix matrix){
	    int height = matrix.getHeight();
	    int width = matrix.getWidth();
	    Bitmap bmp = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
	    for (int x = 0; x < width; x++){
	        for (int y = 0; y < height; y++){
	            bmp.setPixel(x, y, matrix.get(x,y) ? Color.BLACK : Color.WHITE);
	        }
	    }
	    return bmp;
	}
	
	public static Bitmap generateCode (Activity activity, String content, int width, int height) {
		Bitmap qrcode_bmp = null;
		QRCodeWriter writer = new QRCodeWriter();
		try {
		    BitMatrix matrix = writer.encode(content, BarcodeFormat.QR_CODE, width, height);
		    qrcode_bmp = toBitmap(matrix);
		    return qrcode_bmp;
		} catch (WriterException e) {
		    e.printStackTrace();
		    Log.e(TAG, e.getMessage());
		    Crouton.makeText(activity, e.getMessage(), Style.INFO).show();
		}
		return qrcode_bmp;
	}
}
