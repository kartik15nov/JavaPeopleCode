package trcom.peoplesoft.hr;//Java code to generate QR code

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class GenerateQRCode {

    // Function to create the QR code
    public static void createQRCode(String data, String path, String charset, Map hashMap, int height, int width) throws WriterException, IOException {
        BitMatrix matrix = new MultiFormatWriter().encode(new String(data.getBytes(charset), charset), BarcodeFormat.QR_CODE, width, height);
        MatrixToImageWriter.writeToFile(matrix, path.substring(path.lastIndexOf('.') + 1), new File(path));
    }

    public static void prepareDataAndGenerateQRCode(String data1, String path1, String charset1, int height1, int width1) throws WriterException, IOException, NotFoundException {
        // The data that the QR code will contain
        String data = data1;

        // The path where the image will get saved
        String path = path1;

        // Encoding charset
        String charset = charset1;
        int height = height1;
        int width = width1;

        Map<EncodeHintType, ErrorCorrectionLevel> hashMap = new HashMap<EncodeHintType, ErrorCorrectionLevel>();

        hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        // Create the QR code and save
        // in the specified folder
        // as a jpg/png file
        createQRCode(data, path, charset, hashMap, 200, 200);
        //System.out.println("QR Code Generated!!! ");
    }
}

