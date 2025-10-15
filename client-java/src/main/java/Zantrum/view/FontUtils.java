package Zantrum.view;

import com.raylib.Raylib;
import com.raylib.Raylib.Font;
import org.bytedeco.javacpp.IntPointer;

public class FontUtils {

    private static final Raylib rlj = new Raylib(); // Raylib instance

    /**
     *
     * @param fontPath percorso al file .ttf
     * @param fontSize dimensione (in pixel)
     * @return oggetto Font caricato
     */
    public static Font loadHighQualityFont(String fontPath, int fontSize) {
        return rlj.LoadFontEx(fontPath, fontSize, (IntPointer) null, 0);
    }
}