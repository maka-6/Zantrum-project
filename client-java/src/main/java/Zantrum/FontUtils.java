package Zantrum;

import com.raylib.Raylib;
import com.raylib.Raylib.Font;
import org.bytedeco.javacpp.IntPointer;

public class FontUtils {

    private static final Raylib rlj = new Raylib(); // Raylib instance

    /**
     * Carica un font ad alta qualità, già pronto per testi grandi o piccoli.
     *
     * @param fontPath percorso al file .ttf
     * @param fontSize dimensione (in pixel) a cui vuoi il font
     * @return oggetto Font caricato
     */
    public static Font loadHighQualityFont(String fontPath, int fontSize) {
        return rlj.LoadFontEx(fontPath, fontSize, (IntPointer) null, 0);
    }
}