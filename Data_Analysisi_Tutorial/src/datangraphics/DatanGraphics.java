/*
 * Decompiled with CFR 0_102.
 * 
 * Could not load the following classes:
 *  datan.DatanUserFunction
 *  datan.Histogram
 *  datangraphics.DatanGraphics$1
 *  datangraphics.DatanGraphics$CloseButtonListener
 *  datangraphics.DatanGraphicsFrame
 */
package datangraphics;

import datan.DatanUserFunction;
import datan.Histogram;
import datangraphics.DatanGraphics;
import datangraphics.DatanGraphicsFrame;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.Vector;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public final class DatanGraphics {
    private static JFrame dGFrame;
    private static JFrame closeFrame;
    private static JOptionPane pane;
    private static JDialog dialog;
    private static PrintStream pr;
    static int frameIndex;
    static Vector<DatanGraphicsFrame> frames;
    static int wlisttop;
    static int wlisthdel;
    static int wlistvdel;
    static Dimension screendim;
    static Point startPoint;
    static Color[] ct;
    static float[] lw;
    static BasicStroke[] strokes;
    static double[] framecoords;
    private static int istr;
    private static int ilen;
    private static byte[] bstrng;
    private static byte[] bcmstr;
    private static final byte numbytes = 12;
    private static boolean iqpsfp;
    private static int[] ixyc;
    private static boolean lwrelPS;
    private static Color[] ctab;
    private static float[] linw;
    static int idin;
    static double rformt;
    static boolean[] lwrel;
    static double cdin;
    static double root2;
    static double[] qac;
    static double[] qbc;
    static double[] qdc;
    static double[] qdci;
    static double[] qaw2;
    static double[] qbw2;
    static double[] qdw2;
    static double[] qdw2i;
    static double[] qcaw2;
    static double[] qcbw2;
    static double[] qawp;
    static double[] qbwp;
    static double[] qdwp;
    static double[] qdwpi;
    static double[] qad;
    static double[] qbd;
    static double[] qdd;
    static double[] qddi;
    static double[] qform;
    static double[] qadc;
    static double[] qbdc;
    static double[] qadp;
    static double[] qbdp;
    static double[] qddp;
    static double[] qddpi;
    static int[] iqad;
    static int[] iqbd;
    static double[] qadcl;
    static double[] qbdcl;
    static int[] iqadp;
    static int[] iqbdp;
    static double[] papersize;
    static double[] paperborders;
    static double[] psOffsets;
    static double[] plsizval;
    static int[] iqdvsi;
    static boolean rotatePlot;
    static int iqplcl;
    static int iqnplc;
    static int iqnplm;
    static int[] iqoutx;
    static int[] iqouty;
    static int[] iqclix;
    static int[] iqcliy;
    static int[] iqclda;
    static double[] qoutx;
    static double[] qouty;
    static short[] bufPoints;
    static short[] newBufPoints;
    static int[] bufPoly;
    static int[] newBufPoly;
    static int numpolys;
    static int bufPointsLengthFilled;
    static int bufPointsLengthTotal;
    static int bufPolyLengthFilled;
    static int bufPolyLengthTotal;
    static boolean open;
    static boolean workstation1Open;
    static boolean workstation2Open;
    static String psFilename;
    static String workstation1Title;
    static int maxadev;
    static int iqnadv;
    static int psModus;
    static int[] aqadid;
    static int[] k;
    static int[] kk;
    static int kkk;
    static int[] ll;
    static int[] lll;
    static int[] mm;
    static int[] m;
    static final short[] iqlett;
    static int id;
    static int ih;
    static int iga;
    static int iga1;
    static int miga;
    static int miga1;
    static int ko;
    static int no;
    static int nu;
    static int nuj;
    static int na1;
    static int na2;
    static int na4;
    static int na5;
    static int na3;
    static int nul;
    static int nur;
    static double alengt;
    static double gvabs;
    static double rvabs;
    static double g1;
    static double gvabs2;
    static double rvabs2;
    static double ga;
    static double gr;
    static double gz;
    static byte[] c;
    static int iascii;
    static double fg1;
    static double fg2;
    static double utx;
    static double uty;
    static double z;
    static int[] idop;
    static int[] j;
    static int[] idat;
    static int[] nunu;
    static double[] avin;
    static double[] avnext;
    static double[] rv;
    static double[] av;
    static double[] op;
    static double[] gv;
    static double[] gve;
    static double[] rve;
    static double[] wert2d;
    static int ix;
    static int iy;
    static double xmovtx;
    static double piqurt;
    static boolean rnt;
    static int nc;
    static double an;
    static double en;
    static double atims;
    static double eps;
    static double atdel;
    static double aneps;
    static double eneps;
    static double eta;
    static double fixdef;
    static double deldef;
    static double ticdef;
    static double grdef;
    static int ntcdef;
    static boolean numdef;
    static boolean lscset;
    static double[] lastPoint;
    static double[] borderPoints;

    private static void open() {
        if (!open) {
            open = true;
            workstation1Open = false;
            workstation2Open = false;
            dGFrame = new JFrame();
            DatanGraphics.setWindowInWorldCoordinates(0.0, 0.0, 0.0, 0.0);
            DatanGraphics.setViewportInWorldCoordinates(0.0, 0.0, 0.0, 0.0);
            DatanGraphics.setWindowInComputingCoordinates(0.0, 0.0, 0.0, 0.0);
            DatanGraphics.setFormat(0.0, 0.0);
            screendim = Toolkit.getDefaultToolkit().getScreenSize();
            JFrame jFrame = new JFrame();
            jFrame.setVisible(true);
            startPoint = jFrame.getLocation();
            wlisttop = DatanGraphics.startPoint.y + 1;
            Dimension dimension = jFrame.getSize();
            Dimension dimension2 = jFrame.getContentPane().getSize();
            wlisthdel = (dimension.width - dimension2.width) / 2;
            if (wlisthdel < 2) {
                wlisthdel = 2;
            }
            wlistvdel = dimension.height - dimension2.height - wlisthdel;
            jFrame.dispose();
            numpolys = 0;
            bufPointsLengthFilled = 0;
            bufPolyLengthFilled = 0;
            frames = new Vector();
            frameIndex = -1;
            bufPointsLengthTotal = 160000;
            bufPoints = new short[bufPointsLengthTotal];
            bufPolyLengthTotal = 1000;
            bufPoly = new int[bufPolyLengthTotal];
            numpolys = 0;
            DatanGraphics.qac[0] = 0.0;
            DatanGraphics.qbc[0] = 1.0;
            DatanGraphics.qac[1] = 0.0;
            DatanGraphics.qbc[1] = 1.0;
            DatanGraphics.qaw2[0] = 0.0;
            DatanGraphics.qbw2[0] = 1.0;
            DatanGraphics.qaw2[1] = 0.0;
            DatanGraphics.qbw2[1] = 1.0;
            DatanGraphics.qawp[0] = 0.0;
            DatanGraphics.qbwp[0] = 1.0;
            DatanGraphics.qawp[0] = 0.0;
            DatanGraphics.qbwp[0] = 1.0;
            iqplcl = 1;
            lwrel = new boolean[1];
            DatanGraphics.lwrel[0] = false;
        }
    }

    private static void close() {
        if (workstation1Open) {
            DatanGraphics.closeWorkstation();
        }
        if (!frames.isEmpty()) {
            closeFrame = new JFrame("Close graphics frame(s)");
            closeFrame.setSize(300, 100);
            closeFrame.setResizable(false);
            Container container = closeFrame.getContentPane();
            container.setLayout(new FlowLayout());
            JButton jButton = new JButton("close graphics frame(s)");
//            CloseButtonListener closeButtonListener = new CloseButtonListener(null);
//            jButton.addActionListener((ActionListener)closeButtonListener);
            container.add(jButton);
            closeFrame.setVisible(true);
        }
        if (workstation2Open) {
            DatanGraphics.closeWorkstation();
        }
        open = false;
    }

    public static void openWorkstation(String string) {
        DatanGraphics.openWorkstation(string, "");
    }

    public static void openWorkstation(String string, String string2) {
        boolean bl = false;
        boolean bl2 = false;
        if (!(string.equals("") || string.equals(" "))) {
            bl = true;
        }
        if (!(string2.equals("") || string2.equals(" "))) {
            bl2 = true;
        }
        if (!open) {
            DatanGraphics.open();
        }
        if (workstation1Open || workstation2Open) {
            JOptionPane.showMessageDialog(dGFrame, "Cannot open workstation; open already", "", 0);
        }
        if (bl) {
            workstation1Open = true;
            workstation1Title = string;
        }
        if (bl2) {
            workstation2Open = true;
            String string3 = DatanGraphics.getExtension(string2);
            psModus = 0;
            if (string3.equals("ps")) {
                psModus = 0;
            } else if (string3.equals("eps")) {
                psModus = 1;
            } else {
                JOptionPane.showMessageDialog(dGFrame, "File extension must be .ps or .eps", "", 0);
            }
        }
        psFilename = string2;
    }

    public static void closeWorkstation() {
        if (workstation1Open) {
            DatanGraphics.showPlot();
            workstation1Open = false;
        }
        if (workstation2Open) {
            DatanGraphics.writePSFile(psFilename);
            workstation2Open = false;
        }
        numpolys = 0;
    }

    private static void showPlot() {
        DatanGraphics.flushPolyline();
        frameIndex = frames.size();
        boolean bl = false;
        if (frames.contains(null)) {
            bl = true;
            frameIndex = frames.indexOf(null);
        }
        DatanGraphicsFrame datanGraphicsFrame = new DatanGraphicsFrame(workstation1Title, psFilename, frameIndex, qform[0], qform[1], numpolys, bufPoly, bufPoints);
        bufPointsLengthFilled = 0;
        if (bl) {
            frames.setElementAt(datanGraphicsFrame, frameIndex);
        } else {
            frames.addElement(datanGraphicsFrame);
        }
    }

    private static void writePSFile(String string) {
        DatanGraphics.flushPolyline();
        FileOutputStream[] arrfileOutputStream = new FileOutputStream[1];
        PrintStream[] arrprintStream = new PrintStream[1];
        if (!DatanGraphics.openPrintStream(string, arrfileOutputStream, arrprintStream)) {
            return;
        }
        pr = arrprintStream[0];
        DatanGraphics.exportPS(true);
        DatanGraphics.closePrintStream(string, arrfileOutputStream[0], pr);
        bufPointsLengthFilled = 0;
    }

    private static boolean openPrintStream(String string, FileOutputStream[] arrfileOutputStream, PrintStream[] arrprintStream) {
        try {
            arrfileOutputStream[0] = new FileOutputStream(string);
        }
        catch (IOException var3_3) {
            JOptionPane.showMessageDialog(dGFrame, "Cannot open file (E)PS File\n", "Error in DatanGraphics", 0);
            System.out.println("Cannot open file (E)PS File\n" + var3_3.getMessage());
            return false;
        }
        arrprintStream[0] = new PrintStream(arrfileOutputStream[0]);
        return true;
    }

    private static void closePrintStream(String string, FileOutputStream fileOutputStream, PrintStream printStream) {
        printStream.close();
        try {
            fileOutputStream.close();
        }
        catch (IOException var3_3) {
            JOptionPane.showMessageDialog(dGFrame, "Cannot close file (E)PS File\n", "Error in DatanGraphics", 0);
            System.out.println("Cannot close file\n" + var3_3.getMessage());
        }
    }

    private static void exportPS(boolean bl) {
        int n;
        int n2;
        char[] arrc = new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h'};
        float[] arrf = new float[3];
        int n3 = 1;
        int n4 = 0;
        int n5 = 0;
        DatanGraphics.framecoords[0] = qad[0];
        DatanGraphics.framecoords[1] = qad[1];
        DatanGraphics.framecoords[2] = qbd[0];
        DatanGraphics.framecoords[3] = qbd[1];
        DatanGraphics.calculatePlotSize();
        float f = 118.11024f * (float)(plsizval[0] / (framecoords[2] - framecoords[0] + 1.0) + plsizval[1] / (framecoords[3] - framecoords[1] + 1.0));
        float f2 = 64.0f * f;
        if (psModus == 0) {
            pr.println("%!PS-Adobe-2.0");
            pr.println("initgraphics");
        } else {
            pr.println("%!PS-Adobe-2.0 EPSF-1.2");
            pr.println("%%Creator: DATAN");
            pr.print("%%CreationDate: ");
            pr.println();
            pr.println("%%DocumentFonts:");
            pr.println("%%Pages: 1");
            pr.print("%%BoundingBox: 0 0 ");
            pr.print((int)Math.ceil((framecoords[2] - framecoords[0]) * (double)f * 0.12));
            pr.print(' ');
            pr.println((int)Math.ceil((framecoords[3] - framecoords[1]) * (double)f * 0.12));
            pr.print("%%EndComments\n%%EndProlog\n%%Page: 1\n");
        }
        lwrelPS = false;
        if (lwrelPS) {
            pr.print("/p {");
            pr.print(f2);
            pr.print(" mul setlinewidth\n");
        } else {
            pr.print("/p {2.3622 mul setlinewidth\n");
        }
        pr.print("moveto dup 0 eq {0 1}if {rlineto}repeat stroke}bind def\n");
        pr.print("/z { ");
        ctab[0].getRGBColorComponents(arrf);
        for (n = 0; n < 3; ++n) {
            pr.print(arrf[n]);
            pr.print(' ');
        }
        pr.print("setrgbcolor} def\n");
        if (lwrelPS) {
            pr.print("/t {");
            pr.print(f2);
            pr.print(" mul setlinewidth\n");
        } else {
            pr.print("/t {2.3622 mul setlinewidth\n");
        }
        pr.print("moveto dup 0 eq {0 1}if {rlineto}repeat gsave z closepath\nfill grestore stroke} bind def\n.12 .12 scale\n1 setlinecap\n1 setlinejoin\n");
        for (n2 = 0; n2 < 8; ++n2) {
            pr.print("/");
            pr.print(arrc[n2]);
            pr.print(" { ");
            ctab[n2 + 1].getRGBColorComponents(arrf);
            for (n = 0; n < 3; ++n) {
                pr.print(arrf[n]);
                pr.print(' ');
            }
            pr.print("setrgbcolor ");
            pr.print(linw[n2]);
            pr.print("} def\n");
        }
        if (psModus == 0) {
            pr.print(psOffsets[0] * 236.22047424316406);
            pr.print(" ");
            pr.print(psOffsets[1] * 236.22047424316406);
            pr.println(" translate");
            if (rotatePlot) {
                pr.print(plsizval[1] * 236.22047424316406);
                pr.println(" 0 translate");
                pr.println("90 rotate");
            }
        }
        int n6 = -1;
        int n7 = -1;
        int n8 = -1;
        DatanGraphics.outpst(1, 0);
        for (int i = 0; i < numpolys; ++i) {
            int n9 = bufPoly[i];
            int n10 = bufPoints[n9 + 1];
            int n11 = 0;
            if (n10 > 0) {
                n3 = bufPoints[n9];
                DatanGraphics.tracoords(bufPoints[n9 + 2], bufPoints[n9 + 3], f, ixyc);
                n4 = ixyc[0];
                n5 = ixyc[1];
                boolean bl2 = n3 == n6 && n4 == n7 && n5 == n8;
                for (n2 = 1; n2 < n10; ++n2) {
                    DatanGraphics.tracoords(bufPoints[n9 + 2 * n2 + 2], bufPoints[n9 + 2 * n2 + 3], f, ixyc);
                    int n12 = ixyc[0];
                    int n13 = ixyc[1];
                    int n14 = n4 - n12;
                    int n15 = n5 - n13;
                    if (n14 != 0 || n15 != 0) {
                        ++n11;
                        DatanGraphics.outpst(0, n14);
                        DatanGraphics.outpst(0, n15);
                        bl2 = false;
                        n4 = n12;
                        n5 = n13;
                    }
                    if (n11 < 50 && n2 != n10 - 1 || bl2) continue;
                    DatanGraphics.outpst(0, n11);
                    DatanGraphics.outpst(0, n12);
                    DatanGraphics.outpst(0, n13);
                    DatanGraphics.outpst(5, n3);
                    bl2 = true;
                    n11 = 0;
                }
            }
            n6 = n3;
            n7 = n4;
            n8 = n5;
        }
        DatanGraphics.outpst(3, 0);
        if (psModus != 0) {
            pr.print("%%Trailer\n");
        }
        pr.print("showpage\n");
        pr.flush();
    }

    private static void calculatePlotSize() {
        double d = papersize[0] - paperborders[0] - paperborders[1];
        double d2 = papersize[1] - paperborders[2] - paperborders[3];
        double d3 = d2 / d;
        double d4 = qform[1] / qform[0];
        DatanGraphics.plsizval[0] = qform[0];
        DatanGraphics.plsizval[1] = qform[1];
        boolean bl = DatanGraphics.rotatePlot = d4 > 1.0 && d3 < 1.0 || d4 < 1.0 && d3 > 1.0;
        if (psModus == 0) {
            double d5;
            double d6;
            if (rotatePlot) {
                d6 = plsizval[1] / d;
                d5 = plsizval[0] / d2;
            } else {
                d6 = plsizval[0] / d;
                d5 = plsizval[1] / d2;
            }
            double d7 = Math.max(d6, d5);
            if (d7 > 1.0) {
                DatanGraphics.plsizval[0] = plsizval[0] / d7;
                DatanGraphics.plsizval[1] = plsizval[1] / d7;
            }
            DatanGraphics.psOffsets[0] = paperborders[0];
            DatanGraphics.psOffsets[1] = paperborders[2];
            if (!rotatePlot) {
                double[] arrd = psOffsets;
                arrd[0] = arrd[0] + (d - plsizval[0]) * 0.5;
                double[] arrd2 = psOffsets;
                arrd2[1] = arrd2[1] + (d2 - plsizval[1]) * 0.5;
            } else {
                double[] arrd = psOffsets;
                arrd[0] = arrd[0] + (d - plsizval[1]) * 0.5;
                double[] arrd3 = psOffsets;
                arrd3[1] = arrd3[1] + (d2 - plsizval[0]) * 0.5;
            }
        }
    }

    private static void outpst(int n, int n2) {
        if (n == 1) {
            istr = 0;
            return;
        }
        if (n == 3) {
            pr.write(bstrng, 0, istr);
            pr.println();
            istr = 0;
            return;
        }
        int n3 = DatanGraphics.inttobytes(n2, bcmstr, 12);
        ilen = 12 - n3;
        if (n == 1 || n == 5) {
            if (n == 1) {
                if (istr > 0) {
                    DatanGraphics.bstrng[DatanGraphics.istr] = 32;
                    ++istr;
                }
                for (int i = 0; i < ilen; ++i) {
                    DatanGraphics.bstrng[DatanGraphics.istr + i] = bcmstr[n3 + i];
                }
                istr+=ilen;
            } else {
                DatanGraphics.bstrng[DatanGraphics.istr] = 32;
                DatanGraphics.bstrng[DatanGraphics.istr + 1] = (byte)(97 + n2 - 1);
                istr+=2;
            }
            DatanGraphics.bstrng[DatanGraphics.istr] = 32;
//            DatanGraphics.bstrng[++DatanGraphics.istr] = iqpsfp ? 116 : 112;
            ++istr;
            return;
        }
        if (istr + ilen >= 70) {
            pr.write(bstrng, 0, istr);
            pr.println();
            istr = 0;
        }
        if (istr > 0) {
            DatanGraphics.bstrng[DatanGraphics.istr] = 32;
            ++istr;
        }
        for (int i = 0; i < ilen; ++i) {
            DatanGraphics.bstrng[DatanGraphics.istr + i] = bcmstr[n3 + i];
        }
        istr+=ilen;
    }

    private static void tracoords(short s, short s2, float f, int[] arrn) {
        arrn[0] = (int)((float)((double)s - framecoords[0]) * f + 0.5f);
        arrn[1] = (int)((float)((double)s2 - framecoords[1]) * f + 0.5f);
    }

    private static int inttobytes(int n, byte[] arrby, int n2) {
        char[] arrc = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        int n3 = n2;
        for (int i = n >= 0 ? n : - n; n3 > 0 && i != 0; i/=10) {
            int n4 = i % 10;
            arrby[--n3] = (byte)arrc[n4];
        }
        if (n == 0) {
            arrby[--n3] = (byte)arrc[0];
        } else if (n3 > 0 && n < 0) {
            arrby[--n3] = 45;
        }
        return n3;
    }

    public static void setWindowInComputingCoordinates(double d, double d2, double d3, double d4) {
        DatanGraphics.qac[0] = d;
        DatanGraphics.qac[1] = d3;
        DatanGraphics.qbc[0] = d2;
        DatanGraphics.qbc[1] = d4;
        if (qac[0] == qbc[0]) {
            DatanGraphics.qbc[0] = qac[0] + 1.0;
        }
        if (qac[1] == qbc[1]) {
            DatanGraphics.qbc[1] = qac[1] + 1.0;
        }
        DatanGraphics.setTransformations();
    }

    public static void setWindowInWorldCoordinates(double d, double d2, double d3, double d4) {
        if (d > d2) {
            DatanGraphics.qawp[0] = d2;
            DatanGraphics.qbwp[0] = d;
        } else {
            DatanGraphics.qawp[0] = d;
            DatanGraphics.qbwp[0] = d2;
        }
        if (d3 > d4) {
            DatanGraphics.qawp[1] = d4;
            DatanGraphics.qbwp[1] = d3;
        } else {
            DatanGraphics.qawp[1] = d3;
            DatanGraphics.qbwp[1] = d4;
        }
        if (qawp[0] == qbwp[0]) {
            DatanGraphics.qbwp[0] = qawp[0] + 1.0;
        }
        if (qawp[1] == qbwp[1]) {
            DatanGraphics.qbwp[1] = qawp[1] + 1.0;
        }
        DatanGraphics.setTransformations();
    }

    public static void setViewportInWorldCoordinates(double d, double d2, double d3, double d4) {
        DatanGraphics.qaw2[0] = d;
        DatanGraphics.qaw2[1] = d3;
        DatanGraphics.qbw2[0] = d2;
        DatanGraphics.qbw2[1] = d4;
        if (qaw2[0] == qbw2[0]) {
            DatanGraphics.qbw2[0] = qaw2[0] + 1.0;
        }
        if (qaw2[1] == qbw2[1]) {
            DatanGraphics.qbw2[1] = qaw2[1] + 1.0;
        }
        DatanGraphics.setTransformations();
    }

    private static void setTransformations() {
        for (int i = 0; i < 2; ++i) {
            DatanGraphics.qdc[i] = qbc[i] - qac[i];
            DatanGraphics.qdci[i] = 1.0 / qdc[i];
            DatanGraphics.qdw2[i] = qbw2[i] - qaw2[i];
            DatanGraphics.qdw2i[i] = 1.0 / qdw2[i];
            DatanGraphics.qdwp[i] = qbwp[i] - qawp[i];
            DatanGraphics.qdwpi[i] = 1.0 / qdwp[i];
        }
        double d = qdd[1] / qdd[0];
        double d2 = qdwp[1] / qdwp[0];
        if (d > d2) {
            double d3 = qdd[1] * d2 / d;
            double d4 = 0.5 * (qdd[1] - d3);
            DatanGraphics.qadp[1] = qad[1] + d4;
            DatanGraphics.qbdp[1] = qbd[1] - d4;
            DatanGraphics.qadp[0] = qad[0];
            DatanGraphics.qbdp[0] = qbd[0];
        } else {
            double d5 = qdd[0] * d / d2;
            double d6 = 0.5 * (qdd[0] - d5);
            DatanGraphics.qadp[0] = qad[0] + d6;
            DatanGraphics.qbdp[0] = qbd[0] - d6;
            DatanGraphics.qadp[1] = qad[1];
            DatanGraphics.qbdp[1] = qbd[1];
        }
        DatanGraphics.qddp[0] = qbdp[0] - qadp[0];
        DatanGraphics.qddp[1] = qbdp[1] - qadp[1];
        DatanGraphics.qddpi[0] = 1.0 / qddp[0];
        DatanGraphics.qddpi[1] = 1.0 / qddp[1];
    }

    private static void writeWindows() {
        System.out.println("c : " + qac[0] + " , " + qac[1] + " , " + qbc[0] + " , " + qbc[1] + " , " + qdc[0] + " , " + qdc[1] + " , " + qdci[0] + " , " + qdci[1]);
        System.out.println("w2 : " + qaw2[0] + " , " + qaw2[1] + " , " + qbw2[0] + " , " + qbw2[1] + " , " + qdw2[0] + " , " + qdw2[1] + " , " + qdw2i[0] + " , " + qdw2i[1]);
        System.out.println("wp : " + qawp[0] + " , " + qawp[1] + " , " + qbwp[0] + " , " + qbwp[1] + " , " + qdwp[0] + " , " + qdwp[1] + " , " + qdwpi[0] + " , " + qdwpi[1]);
        System.out.println("d : " + qad[0] + " , " + qad[1] + " , " + qbd[0] + " , " + qbd[1] + " , " + qdd[0] + " , " + qdd[1] + " , " + qddi[0] + " , " + qddi[1]);
        System.out.println("dp : " + qadp[0] + " , " + qadp[1] + " , " + qbdp[0] + " , " + qbdp[1] + " , " + qddp[0] + " , " + qddp[1] + " , " + qddpi[0] + " , " + qddpi[1]);
        System.out.println("clipping : " + qadcl[0] + " , " + qadcl[1] + " , " + qbdcl[0] + " , " + qbdcl[1]);
        System.out.println("form : " + qform[0] + " , " + qform[1]);
        System.out.println("framecoords : " + framecoords[0] + " , " + framecoords[1] + " , " + framecoords[2] + " , " + framecoords[3]);
    }

    public static void chooseColor(int n) {
        DatanGraphics.flushPolyline();
        iqplcl = n;
    }

    static void move(double d, double d2) {
        double d3 = DatanGraphics.transformSingleWorldToDevice(d, 0);
        double d4 = DatanGraphics.transformSingleWorldToDevice(d2, 1);
        if (iqnplc > 1) {
            DatanGraphics.flushPolyline();
        }
        if (DatanGraphics.inClippingWindow(d3, d4)) {
            iqnplc = 1;
            DatanGraphics.qoutx[0] = d3;
            DatanGraphics.qouty[0] = d4;
        } else {
            iqnplc = 0;
        }
        DatanGraphics.lastPoint[0] = d3;
        DatanGraphics.lastPoint[1] = d4;
    }

    static void draw(double d, double d2) {
        double d3 = DatanGraphics.transformSingleWorldToDevice(d, 0);
        double d4 = DatanGraphics.transformSingleWorldToDevice(d2, 1);
        boolean bl = DatanGraphics.inClippingWindow(lastPoint[0], lastPoint[1]);
        boolean bl2 = DatanGraphics.inClippingWindow(d3, d4);
        if (iqnplc >= iqnplm - 1) {
            DatanGraphics.flushPolyline();
            iqnplc = 1;
            DatanGraphics.qoutx[0] = lastPoint[0];
            DatanGraphics.qouty[0] = lastPoint[1];
        } else if (bl && bl2) {
            DatanGraphics.qoutx[DatanGraphics.iqnplc] = d3;
            DatanGraphics.qouty[DatanGraphics.iqnplc] = d4;
            ++iqnplc;
            DatanGraphics.lastPoint[0] = d3;
            DatanGraphics.lastPoint[1] = d4;
        } else if (bl && !bl2) {
            double[] arrd = DatanGraphics.borderPoint(lastPoint[0], lastPoint[1], d3, d4);
            DatanGraphics.qoutx[DatanGraphics.iqnplc] = arrd[0];
            DatanGraphics.qouty[DatanGraphics.iqnplc] = arrd[1];
            ++iqnplc;
            DatanGraphics.lastPoint[0] = d3;
            DatanGraphics.lastPoint[1] = d4;
        } else if (!bl && bl2) {
            double[] arrd = DatanGraphics.borderPoint(d3, d4, lastPoint[0], lastPoint[1]);
            DatanGraphics.flushPolyline();
            iqnplc = 1;
            DatanGraphics.qoutx[0] = arrd[0];
            DatanGraphics.qouty[0] = arrd[1];
            DatanGraphics.qoutx[DatanGraphics.iqnplc] = d3;
            DatanGraphics.qouty[DatanGraphics.iqnplc] = d4;
            ++iqnplc;
            DatanGraphics.lastPoint[0] = d3;
            DatanGraphics.lastPoint[1] = d4;
        } else {
            boolean bl3 = DatanGraphics.lineCrossesClippingWindow(lastPoint[0], lastPoint[1], d3, d4, borderPoints);
            if (bl3) {
                DatanGraphics.flushPolyline();
                iqnplc = 1;
                DatanGraphics.qoutx[0] = borderPoints[0];
                DatanGraphics.qouty[0] = borderPoints[1];
                DatanGraphics.qoutx[DatanGraphics.iqnplc] = borderPoints[2];
                DatanGraphics.qouty[DatanGraphics.iqnplc] = borderPoints[3];
                ++iqnplc;
            }
            DatanGraphics.lastPoint[0] = d3;
            DatanGraphics.lastPoint[1] = d4;
        }
    }

    private static boolean lineCrossesClippingWindow(double d, double d2, double d3, double d4, double[] arrd) {
        boolean bl = false;
        if ((d >= qadcl[0] || d3 >= qadcl[0]) && (d <= qbdcl[0] || d3 <= qbdcl[0]) && (d2 >= qadcl[1] || d4 >= qadcl[1]) && (d2 <= qbdcl[1] || d4 <= qbdcl[1])) {
            if (qadcl[0] < d && d < qbdcl[0] && qadcl[0] < d3 && d3 < qbdcl[0]) {
                arrd[1] = qadcl[1];
                arrd[3] = qbdcl[1];
                arrd[0] = d + (qadcl[1] - d2) * (d3 - d) / (d4 - d2);
                arrd[2] = d + (qbdcl[1] - d2) * (d3 - d) / (d4 - d2);
                bl = true;
            } else if (qadcl[1] < d2 && d2 < qbdcl[1] && qadcl[1] < d4 && d4 < qbdcl[1]) {
                arrd[0] = qadcl[0];
                arrd[2] = qbdcl[0];
                arrd[1] = d2 + (qadcl[0] - d) * (d4 - d2) / (d3 - d);
                arrd[3] = d2 + (qadcl[0] - d) * (d4 - d2) / (d3 - d);
                bl = true;
            } else {
                int n = 0;
                arrd[2 * n] = d + (qadcl[1] - d2) * (d3 - d) / (d4 - d2);
                arrd[2 * n + 1] = qadcl[1];
                if (qadcl[0] <= arrd[2 * n] && arrd[2 * n] <= qbdcl[0]) {
                    ++n;
                }
                arrd[2 * n] = d + (qbdcl[1] - d2) * (d3 - d) / (d4 - d2);
                arrd[2 * n + 1] = qbdcl[1];
                if (qadcl[0] <= arrd[2 * n] && arrd[2 * n] <= qbdcl[0]) {
                    ++n;
                }
                if (n < 2) {
                    arrd[2 * n] = qadcl[0];
                    arrd[2 * n + 1] = d2 + (qadcl[0] - d) * (d4 - d2) / (d3 - d);
                    if (qadcl[1] <= arrd[2 * n + 1] && arrd[2 * n + 1] <= qbdcl[1]) {
                        ++n;
                    }
                }
                if (n < 2) {
                    arrd[2 * n] = qbdcl[0];
                    arrd[2 * n + 1] = d2 + (qbdcl[0] - d) * (d4 - d2) / (d3 - d);
                    if (qadcl[1] <= arrd[2 * n + 1] && arrd[2 * n + 1] <= qbdcl[1]) {
                        ++n;
                    }
                }
                if (n == 2) {
                    bl = true;
                }
            }
        }
        return bl;
    }

    private static double[] borderPoint(double d, double d2, double d3, double d4) {
        double[] arrd = new double[2];
        int n = DatanGraphics.regionOfExternalPoint(d3, d4);
        switch (n) {
            case 1: {
                double d5 = qadcl[1];
                arrd[0] = d + (d5 - d2) * (d3 - d) / (d4 - d2);
                arrd[1] = d5;
                break;
            }
            case 2: {
                double d6 = qbdcl[1];
                arrd[0] = d + (d6 - d2) * (d3 - d) / (d4 - d2);
                arrd[1] = d6;
                break;
            }
            case 3: {
                double d7;
                arrd[0] = d7 = qadcl[0];
                arrd[1] = d2 + (d7 - d) * (d4 - d2) / (d3 - d);
                break;
            }
            case 4: {
                double d8;
                arrd[0] = d8 = qbdcl[0];
                arrd[1] = d2 + (d8 - d) * (d4 - d2) / (d3 - d);
                break;
            }
            case 5: {
                double d9 = qadcl[1];
                double d10 = qadcl[0];
                arrd[0] = d + (d9 - d2) * (d3 - d) / (d4 - d2);
                arrd[1] = d9;
                if (arrd[0] >= d10) break;
                arrd[0] = d10;
                arrd[1] = d2 + (d10 - d) * (d4 - d2) / (d3 - d);
                break;
            }
            case 6: {
                double d11 = qbdcl[1];
                double d12 = qadcl[0];
                arrd[0] = d + (d11 - d2) * (d3 - d) / (d4 - d2);
                arrd[1] = d11;
                if (arrd[0] <= d12) break;
                arrd[0] = d12;
                arrd[1] = d2 + (d12 - d) * (d4 - d2) / (d3 - d);
                break;
            }
            case 7: {
                double d13 = qadcl[1];
                double d14 = qadcl[0];
                arrd[0] = d + (d13 - d2) * (d3 - d) / (d4 - d2);
                arrd[1] = d13;
                if (arrd[0] >= d14) break;
                arrd[0] = d14;
                arrd[1] = d2 + (d14 - d) * (d4 - d2) / (d3 - d);
                break;
            }
            case 8: {
                double d15 = qbdcl[1];
                double d16 = qbdcl[0];
                arrd[0] = d + (d15 - d2) * (d3 - d) / (d4 - d2);
                arrd[1] = d15;
                if (arrd[0] <= d16) break;
                arrd[0] = d16;
                arrd[1] = d2 + (d16 - d) * (d4 - d2) / (d3 - d);
            }
        }
        return arrd;
    }

    private static boolean inClippingWindow(double d, double d2) {
        boolean bl = false;
        if (qadcl[0] <= d && d <= qbdcl[0] && qadcl[1] <= d2 && d2 <= qbdcl[1]) {
            bl = true;
        }
        return bl;
    }

    private static int regionOfExternalPoint(double d, double d2) {
        int n = 0;
        n = d < qadcl[0] ? (d2 < qadcl[1] ? 5 : (d2 > qbdcl[1] ? 7 : 3)) : (d > qbdcl[0] ? (d2 < qadcl[1] ? 6 : (d2 > qbdcl[1] ? 8 : 4)) : (d2 < qadcl[1] ? 1 : (d2 > qbdcl[1] ? 2 : 0)));
        return n;
    }

    private static void drawLine(double[] arrd, double[] arrd2, double d) {
        double[] arrd3 = new double[2];
        double d2 = arrd2[0] - arrd[0];
        double d3 = arrd2[1] - arrd[1];
        double d4 = Math.sqrt(d2 * d2 + d3 * d3);
        int n = 0;
        if (d > 0.0) {
            n = (int)(d4 / d + 0.5);
        }
        int n2 = 2 * n + 1;
        d2/=(double)n2;
        d3/=(double)n2;
        int n3 = 1;
        arrd3[0] = arrd[0];
        arrd3[1] = arrd[1];
        DatanGraphics.move(arrd3[0], arrd3[1]);
        for (int i = 0; i < n2; ++i) {
            n3 = - n3;
            arrd3[0] = arrd3[0] + d2;
            arrd3[1] = arrd3[1] + d3;
            if (n3 < 0) {
                DatanGraphics.draw(arrd3[0], arrd3[1]);
                continue;
            }
            DatanGraphics.move(arrd3[0], arrd3[1]);
        }
    }

    public static void drawContour(double d, double d2, double d3, double d4, int n, int n2, double d5, DatanUserFunction datanUserFunction) {
        double[] arrd = new double[500];
        DatanGraphics.setSmallClippingWindow();
        double d6 = 0.0;
        double d7 = 0.0;
        for (int i = 0; i < n; ++i) {
            double d8 = d + (double)i * d3;
            double d9 = d8 + d3;
            for (int j = 0; j < n2; ++j) {
                double d10;
                double d11;
                double d12 = d2 + (double)j * d4;
                double d13 = d12 + d4;
                if (j == 0) {
                    d11 = datanUserFunction.getValue(d8, d12);
                    d10 = datanUserFunction.getValue(d9, d12);
                } else {
                    d11 = d6;
                    d10 = d7;
                }
                double d14 = i != 0 && j < 500 ? arrd[j] : datanUserFunction.getValue(d8, d13);
                double d15 = datanUserFunction.getValue(d9, d13);
                if (j < 500) {
                    arrd[j] = d15;
                }
                d6 = d14;
                d7 = d15;
                DatanGraphics.drawContourForPixel(d8, d9, d12, d13, d11, d14, d10, d15, d5);
            }
        }
        DatanGraphics.setBigClippingWindow();
    }

    private static void drawContourForPixel(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, double d9) {
        boolean bl;
        boolean bl2;
        boolean bl3;
        boolean bl4;
        double[] arrd = new double[]{0.0, 0.0};
        double[] arrd2 = new double[]{0.0, 0.0};
        double d10 = 1.0E-27;
        double d11 = 0.0;
        double d12 = 0.0;
        double d13 = 0.0;
        double d14 = 0.0;
        double d15 = 0.0;
        double d16 = 0.0;
        double d17 = 0.0;
        double d18 = 0.0;
        double d19 = d2 - d;
        double d20 = d4 - d3;
        double d21 = d9 - d5;
        double d22 = d6 - d9;
        double d23 = d9 - d8;
        double d24 = d7 - d9;
        if (d21 * d24 < 0.0) {
            bl = false;
        } else {
            bl = true;
            d11 = Math.abs(d21 + d24) < d10 ? d : d + d19 * d21 / (d24 + d21);
            d15 = d3;
        }
        if (d22 * d21 < 0.0) {
            bl2 = false;
        } else {
            bl2 = true;
            d12 = d;
            d16 = Math.abs(d21 + d22) < d10 ? d3 : d3 + d20 * d21 / (d21 + d22);
        }
        if (d23 * d22 < 0.0) {
            bl3 = false;
        } else {
            bl3 = true;
            d13 = Math.abs(d23 + d22) < d10 ? d : d + d19 * d22 / (d23 + d22);
            d17 = d4;
        }
        if (d24 * d23 < 0.0) {
            bl4 = false;
        } else {
            bl4 = true;
            d14 = d2;
            d18 = Math.abs(d24 + d23) < d10 ? d3 : d3 + d20 * d24 / (d24 + d23);
        }
        if (bl) {
            arrd[0] = d11;
            arrd2[0] = d15;
            if (bl2) {
                arrd[1] = d12;
                arrd2[1] = d16;
                DatanGraphics.drawPolyline(arrd, arrd2);
            }
            if (bl3) {
                arrd[1] = d13;
                arrd2[1] = d17;
                DatanGraphics.drawPolyline(arrd, arrd2);
            }
            if (bl4) {
                arrd[1] = d14;
                arrd2[1] = d18;
                DatanGraphics.drawPolyline(arrd, arrd2);
            }
        }
        if (bl2) {
            arrd[0] = d12;
            arrd2[0] = d16;
            if (bl3) {
                arrd[1] = d13;
                arrd2[1] = d17;
                DatanGraphics.drawPolyline(arrd, arrd2);
            }
            if (bl4) {
                arrd[1] = d14;
                arrd2[1] = d18;
                DatanGraphics.drawPolyline(arrd, arrd2);
            }
        }
        if (bl3 && bl4) {
            arrd[0] = d13;
            arrd2[0] = d17;
            arrd[1] = d14;
            arrd2[1] = d18;
            DatanGraphics.drawPolyline(arrd, arrd2);
        }
    }

    public static void drawCaption(double d, String string) {
        double[] arrd = new double[]{0.0, 0.0};
        if (d <= 0.0) {
            d = 1.0;
        }
        double d2 = qbwp[0] - qawp[0];
        double d3 = qbwp[1] - qawp[1];
        d = 0.015 * d * Math.sqrt(d2 * d2 + d3 * d3);
        double d4 = qawp[0] + 0.5 * d2;
        double d5 = qawp[1] + 0.9 * d3;
        DatanGraphics.text(3, d4, d5, 1.0, 0.0, d, string, arrd);
    }

    public static void drawText(double d, double d2, double d3, String string) {
        double[] arrd = new double[]{0.0, 0.0};
        if (d3 <= 0.0) {
            d3 = 1.0;
        }
        d3 = 0.015 * d3 * Math.sqrt((qbwp[0] - qawp[0]) * (qbwp[0] - qawp[0]) + (qbwp[1] - qawp[1]) * (qbwp[1] - qawp[1]));
        double d4 = DatanGraphics.transformSingleComputingToWorld(d, 0);
        double d5 = DatanGraphics.transformSingleComputingToWorld(d2, 1) + 0.5 * d3;
        DatanGraphics.text(1, d4, d5, 1.0, 0.0, d3, string, arrd);
    }

    public static void drawHistogram(Histogram histogram) {
        double[] arrd = new double[3];
        double[] arrd2 = new double[3];
        double[] arrd3 = new double[2];
        double[] arrd4 = new double[2];
        DatanGraphics.setSmallClippingWindow();
        double d = histogram.getLowerBoundary();
        double d2 = histogram.getBinSize();
        int n = histogram.getNumberOfBins();
        double[] arrd5 = histogram.getContents();
        for (int i = 0; i < n; ++i) {
            arrd[0] = d + (double)i * d2;
            arrd[1] = arrd[0];
            arrd[2] = arrd[0] + d2;
            arrd2[0] = i == 0 ? 0.0 : arrd5[i - 1];
            arrd2[1] = arrd5[i];
            arrd2[2] = arrd2[1];
            DatanGraphics.drawPolyline(arrd, arrd2);
        }
        arrd3[0] = arrd[2];
        arrd4[0] = arrd2[2];
        arrd3[1] = arrd[2];
        arrd4[1] = 0.0;
        DatanGraphics.drawPolyline(arrd3, arrd4);
        DatanGraphics.setBigClippingWindow();
    }

    public static void drawDatapoint(int n, double d, double d2, double d3, double d4, double d5, double d6) {
        double[] arrd = new double[91];
        double[] arrd2 = new double[91];
        double d7 = d;
        if (d7 <= 0.0) {
            d7 = 1.0;
        }
        d7 = d7 * 0.01 * Math.sqrt((qbwp[0] - qawp[0]) * (qbwp[0] - qawp[0]) + (qbwp[1] - qawp[1]) * (qbwp[1] - qawp[1]));
        int n2 = Math.abs(n);
        boolean bl = false;
        if (n < 0) {
            bl = true;
        }
        if (n2 <= 1 || n2 > 9) {
            n2 = 1;
        }
        DatanGraphics.drawMark(n2, d, d2, d3);
        DatanGraphics.setSmallClippingWindow();
        double d8 = d7;
        if (n2 >= 7) {
            d8 = 0.0;
        }
        if (n2 == 3 || n2 == 4) {
            d8/=1.414;
        }
        double d9 = DatanGraphics.transformSingleComputingToWorld(d2, 0);
        double d10 = DatanGraphics.transformSingleComputingToWorld(d3, 1);
        double d11 = 0.0;
        double d12 = 0.0;
        double d13 = 0.0;
        double d14 = 0.0;
        boolean bl2 = false;
        boolean bl3 = false;
        if (d4 > 0.0) {
            double d15 = d9 + d8;
            double d16 = d9 - d8;
            double d17 = d2 + d4;
            d11 = DatanGraphics.transformSingleComputingToWorld(d17, 0);
            if (d11 > d15) {
                bl2 = true;
            }
            if (bl2) {
                DatanGraphics.move(d15, d10);
                DatanGraphics.draw(d11, d10);
                double d18 = d10 - d7;
                double d19 = d10 + d7;
                DatanGraphics.move(d11, d18);
                DatanGraphics.draw(d11, d19);
                double d20 = d2 - d4;
                d13 = DatanGraphics.transformSingleComputingToWorld(d20, 0);
                DatanGraphics.move(d16, d10);
                DatanGraphics.draw(d13, d10);
                DatanGraphics.move(d13, d18);
                DatanGraphics.draw(d13, d19);
            }
        }
        if (d5 > 0.0) {
            double d21 = d10 + d8;
            double d22 = d10 - d8;
            double d23 = d3 + d5;
            d12 = DatanGraphics.transformSingleComputingToWorld(d23, 1);
            if (d12 > d21) {
                bl3 = true;
            }
            if (bl3) {
                DatanGraphics.move(d9, d21);
                DatanGraphics.draw(d9, d12);
                double d24 = d9 - d7;
                double d25 = d9 + d7;
                DatanGraphics.move(d24, d12);
                DatanGraphics.draw(d25, d12);
                double d26 = d3 - d5;
                d14 = DatanGraphics.transformSingleComputingToWorld(d26, 1);
                DatanGraphics.move(d9, d22);
                DatanGraphics.draw(d9, d14);
                DatanGraphics.move(d24, d14);
                DatanGraphics.draw(d25, d14);
            }
        }
        d8 = d6;
        if (d4 > 0.0 && d5 > 0.0 && Math.abs(d8) < 1.0 && bl2 && bl3) {
            double d27 = d6 * d4 * d5;
            if (bl || Math.abs(d8) > 9.999999747378752E-5) {
                double d28 = d4 * d4;
                double d29 = d5 * d5;
                double d30 = d8 * d8;
                boolean bl4 = false;
                if (Math.abs((d4 - d5) / (d4 + d5)) < 1.0E-4) {
                    bl4 = true;
                }
                double d31 = bl4 ? 0.7853981633974483 : 0.5 * Math.atan2(d27 * 2.0, d28 - d29);
                d7 = Math.sin(d31);
                double d32 = Math.cos(d31);
                double d33 = d7 * d7;
                double d34 = d32 * d32;
                double d35 = d28 * d29 * (1.0 - d30);
                double d36 = d29 * d34 - d27 * 2.0 * d7 * d32 + d28 * d33;
                double d37 = Math.sqrt(Math.abs(d35 / d36));
                d36 = d29 * d33 + d27 * 2.0 * d7 * d32 + d28 * d34;
                double d38 = Math.sqrt(Math.abs(d35 / d36));
                for (int i = 0; i < 91; ++i) {
                    double d39 = (double)i * 0.06981;
                    double d40 = d37 * Math.cos(d39);
                    double d41 = d38 * Math.sin(d39);
                    arrd[i] = d2 + d40 * d32 - d41 * d7;
                    arrd2[i] = d3 + d40 * d7 + d41 * d32;
                }
                DatanGraphics.drawPolyline(arrd, arrd2);
            }
        }
        DatanGraphics.setBigClippingWindow();
    }

    public static void drawMark(int n, double d, double d2, double d3) {
        DatanGraphics.setSmallClippingWindow();
        double d4 = d;
        if (d4 <= 0.0) {
            d4 = 1.0;
        }
        d4 = d4 * 0.01 * Math.sqrt((qbwp[0] - qawp[0]) * (qbwp[0] - qawp[0]) + (qbwp[1] - qawp[1]) * (qbwp[1] - qawp[1]));
        int n2 = n;
        if (n2 < 1 || n2 > 9) {
            n2 = 1;
        }
        double d5 = DatanGraphics.transformSingleComputingToWorld(d2, 0);
        double d6 = DatanGraphics.transformSingleComputingToWorld(d3, 1);
        if (n2 <= 6) {
            double d7;
            int n3;
            int n4 = 1;
            if (n2 <= 2) {
                if (n2 == 2) {
                    n4 = 10;
                }
                d7 = 0.0;
                n3 = 46;
            } else if (n2 == 3 || n2 == 4) {
                if (n2 == 4) {
                    n4 = 10;
                }
                d7 = 0.785;
                n3 = 5;
            } else {
                if (n2 == 6) {
                    n4 = 10;
                }
                d7 = 0.0;
                n3 = 5;
            }
            for (int i = 1; i <= n4; ++i) {
                double d8 = 6.283 / (double)(n3 - 1);
                double d9 = d4 * (1.0 - (double)(i - 1) / (double)n4);
                for (int j = 1; j <= n3; ++j) {
                    double d10 = d7 + (double)(j - 1) * d8;
                    double d11 = d5 + d9 * Math.cos(d10);
                    double d12 = d6 + d9 * Math.sin(d10);
                    if (j == 1) {
                        DatanGraphics.move(d11, d12);
                        continue;
                    }
                    DatanGraphics.draw(d11, d12);
                }
            }
        } else {
            double d13;
            int n5;
            if (n2 == 7) {
                d13 = 0.0;
                n5 = 2;
            } else if (n2 == 8) {
                d13 = 0.785;
                n5 = 2;
            } else {
                d13 = 0.0;
                n5 = 4;
            }
            for (int i = 1; i <= n5; ++i) {
                double d14 = d13 + (double)(i - 1) * 6.283 / ((double)n5 * 2.0);
                double d15 = d4 * Math.cos(d14);
                double d16 = d4 * Math.sin(d14);
                double d17 = d5 + d15;
                double d18 = d6 + d16;
                DatanGraphics.move(d17, d18);
                d17 = d5 - d15;
                d18 = d6 - d16;
                DatanGraphics.draw(d17, d18);
            }
        }
        DatanGraphics.setBigClippingWindow();
    }

    public static void drawPolyline(double[] arrd, double[] arrd2) {
        DatanGraphics.setSmallClippingWindow();
        int n = arrd.length;
        for (int i = 0; i < n; ++i) {
            double d = qaw2[0] + (arrd[i] - qac[0]) * qdw2[0] * qdci[0];
            double d2 = qaw2[1] + (arrd2[i] - qac[1]) * qdw2[1] * qdci[1];
            if (i == 0) {
                DatanGraphics.move(d, d2);
                continue;
            }
            DatanGraphics.draw(d, d2);
        }
    }

    public static void drawBrokenPolyline(int n, double d, double[] arrd, double[] arrd2) {
        double d2;
        double d3;
        int n2;
        double d4;
        DatanGraphics.setSmallClippingWindow();
        double d5 = d;
        if (d5 < 0.0) {
            d5 = 1.0;
        }
        if ((n2 = n) < 1 || n2 > 3) {
            n2 = 1;
        }
        d5 = 0.01 * d5 * Math.sqrt((qbwp[0] - qawp[0]) * (qbwp[0] - qawp[0]) + (qbwp[1] - qawp[1]) * (qbwp[1] - qawp[1]));
        if (n2 == 1) {
            d3 = d5;
            d2 = d5;
            d4 = d5;
        } else if (n2 == 2) {
            d3 = d2 = 0.1 * d5;
            d4 = d5;
        } else {
            d3 = d5;
            d2 = 0.1 * d5;
            d4 = 0.5 * d5;
        }
        double d6 = 0.0;
        boolean bl = true;
        double d7 = d3;
        d6 = 0.0;
        double d8 = 0.0;
        double d9 = 0.0;
        boolean bl2 = false;
        for (int i = 0; i < arrd.length; ++i) {
            boolean bl3 = true;
            while (bl3) {
                double d10 = qaw2[0] + (arrd[i] - qac[0]) * qdw2[0] * qdci[0];
                double d11 = qaw2[1] + (arrd2[i] - qac[1]) * qdw2[1] * qdci[1];
                if (i == 0) {
                    d8 = d10;
                    d9 = d11;
                    DatanGraphics.move(d8, d9);
                    bl3 = false;
                    continue;
                }
                double d12 = Math.sqrt((d10 - d8) * (d10 - d8) + (d11 - d9) * (d11 - d9));
                double d13 = d6 + d12;
                double d14 = d13 - d7;
                if (d14 <= 0.0) {
                    d6+=d12;
                    bl3 = false;
                } else {
                    d10-=(d10 - d8) * d14 / d12;
                    d11-=(d11 - d9) * d14 / d12;
                    d6 = 0.0;
                    bl3 = true;
                }
                if (bl) {
                    DatanGraphics.draw(d10, d11);
                } else {
                    DatanGraphics.move(d10, d11);
                }
                d8 = d10;
                d9 = d11;
                if (!bl3) continue;
                boolean bl4 = bl = !bl;
                if (bl) {
                    boolean bl5 = bl2 = !bl2;
                    if (bl2) {
                        d7 = d2;
                        continue;
                    }
                    d7 = d3;
                    continue;
                }
                d7 = d4;
            }
        }
        DatanGraphics.flushPolyline();
        DatanGraphics.setBigClippingWindow();
    }

    public static void drawBoundary() {
        double[] arrd = new double[5];
        double[] arrd2 = new double[5];
        arrd[0] = qac[0];
        arrd2[0] = qac[1];
        arrd[1] = qbc[0];
        arrd2[1] = arrd2[0];
        arrd[2] = arrd[1];
        arrd2[2] = qbc[1];
        arrd[3] = arrd[0];
        arrd2[3] = arrd2[2];
        arrd[4] = arrd[0];
        arrd2[4] = arrd2[0];
        DatanGraphics.drawPolylineInBigClippingWindow(arrd, arrd2);
    }

    private static void drawPolylineInBigClippingWindow(double[] arrd, double[] arrd2) {
        DatanGraphics.setBigClippingWindow();
        int n = arrd.length;
        for (int i = 0; i < n; ++i) {
            double d = qaw2[0] + (arrd[i] - qac[0]) * qdw2[0] * qdci[0];
            double d2 = qaw2[1] + (arrd2[i] - qac[1]) * qdw2[1] * qdci[1];
            if (i == 0) {
                DatanGraphics.move(d, d2);
                continue;
            }
            DatanGraphics.draw(d, d2);
        }
    }

    private static void flushPolyline() {
        if (iqnplc > 0) {
            int n;
            if (bufPolyLengthFilled == bufPolyLengthTotal) {
                newBufPoly = new int[2 * bufPolyLengthTotal];
                for (n = 0; n < bufPolyLengthFilled; ++n) {
                    DatanGraphics.newBufPoly[n] = bufPoly[n];
                }
                bufPoly = newBufPoly;
                bufPolyLengthTotal = 2 * bufPolyLengthTotal;
            }
            if (bufPointsLengthFilled + iqnplc + 2 > bufPointsLengthTotal) {
                newBufPoints = new short[2 * bufPointsLengthTotal];
                for (n = 0; n < bufPointsLengthFilled; ++n) {
                    DatanGraphics.newBufPoints[n] = bufPoints[n];
                }
                bufPoints = newBufPoints;
                bufPointsLengthTotal = 2 * bufPointsLengthTotal;
            }
            DatanGraphics.bufPoly[DatanGraphics.numpolys] = n = bufPointsLengthFilled;
            ++numpolys;
            DatanGraphics.bufPoints[n] = (short)iqplcl;
            DatanGraphics.bufPoints[n + 1] = (short)iqnplc;
            n+=2;
            for (int i = 0; i < iqnplc; ++i) {
                DatanGraphics.bufPoints[n] = (short)qoutx[i];
                DatanGraphics.bufPoints[n + 1] = (short)qouty[i];
                n+=2;
            }
            bufPolyLengthFilled = numpolys;
            bufPointsLengthFilled = n;
            iqnplc = 0;
        }
    }

    private static void drawArrow(double[] arrd, int n, String string, double d) {
        int n2;
        double[] arrd2 = new double[2];
        double[] arrd3 = new double[4];
        double[] arrd4 = new double[]{0.0, 0.0};
        int n3 = Math.abs(n);
        int n4 = n3 == 1 ? (3 + n) / 2 : 2;
        boolean bl = false;
        for (n2 = 0; n2 < string.length(); ++n2) {
            bl = bl || string.charAt(n2) != ' ';
        }
        if (bl) {
            double d2;
            DatanGraphics.text(n4, arrd[0], arrd[1], 1.0, 0.0, d, string, arrd4);
            double d3 = n < 1 ? -1.0 : 1.0;
            int n5 = 3 - n3;
            double d4 = 0.8 * d;
            if (n3 == 1) {
                arrd2[1] = arrd[1];
                d2 = Math.max((Math.abs(qbw2[0] - qaw2[0]) - Math.abs(arrd4[0] - arrd[0])) * 0.25, 0.0);
                arrd2[0] = arrd4[0] - d3 * (d2 + d4);
            } else {
                arrd2[0] = arrd[0] - Math.abs(arrd[0] - arrd4[0]) * 0.5;
                d2 = Math.max((Math.abs(qbw2[1] - qaw2[1]) - d) * 0.25, 0.0);
                arrd2[1] = arrd4[1] - d3 * (d4 + d2 + d * 0.5);
            }
            if (d2 <= 0.0) {
                d4 = 0.0;
            }
            if (d2 > 0.0) {
                if (d4 > d2) {
                    d2 = d4;
                }
                for (n2 = 1; n2 <= 5; ++n2) {
                    arrd3[0] = arrd2[0];
                    arrd3[1] = arrd2[1];
                    if (n2 == 2 || n2 == 3 || n2 == 5) {
                        arrd3[n3 - 1] = arrd2[n3 - 1] + d3 * (d2 - d4);
                    }
                    if (n2 == 4) {
                        arrd3[n3 - 1] = arrd2[n3 - 1] + d3 * d2;
                    }
                    if (n2 == 3) {
                        arrd3[n5 - 1] = arrd2[n5 - 1] + d4 * 0.4;
                    }
                    if (n2 == 5) {
                        arrd3[n5 - 1] = arrd2[n5 - 1] - d4 * 0.4;
                    }
                    if (n2 == 1) {
                        DatanGraphics.move(arrd3[0], arrd3[1]);
                    } else {
                        DatanGraphics.draw(arrd3[0], arrd3[1]);
                    }
                    if (n2 != 2) continue;
                    arrd3[2] = arrd3[0];
                    arrd3[3] = arrd3[1];
                }
                DatanGraphics.draw(arrd3[2], arrd3[3]);
            }
        }
    }

    public static void drawCoordinateCross() {
        DatanGraphics.setSmallClippingWindow();
        double[] arrd = new double[2];
        double[] arrd2 = new double[2];
        arrd[0] = qac[0];
        arrd[1] = qbc[0];
        arrd2[0] = 0.0;
        arrd2[1] = 0.0;
        if (qac[1] * qbc[1] < 0.0) {
            DatanGraphics.drawBrokenPolyline(1, 1.0, arrd, arrd2);
        }
        arrd[0] = 0.0;
        arrd[1] = 0.0;
        arrd2[0] = qac[1];
        arrd2[1] = qbc[1];
        if (qac[0] * qbc[0] < 0.0) {
            DatanGraphics.drawBrokenPolyline(1, 1.0, arrd, arrd2);
        }
        DatanGraphics.setBigClippingWindow();
    }

    public static void drawFrame() {
        DatanGraphics.move(qawp[0], qawp[1]);
        DatanGraphics.draw(qbwp[0], qawp[1]);
        DatanGraphics.draw(qbwp[0], qbwp[1]);
        DatanGraphics.draw(qawp[0], qbwp[1]);
        DatanGraphics.draw(qawp[0], qawp[1]);
    }

    public static void setFormat(double d, double d2) {
        if (d == 0.0 && d2 == 0.0) {
            d = 5.0;
        }
        if (d2 == 0.0) {
            idin = (int)d;
            if (idin < 1) {
                idin = 1;
            }
            if (idin > 10) {
                idin = 10;
            }
            DatanGraphics.qform[0] = cdin / Math.pow(root2, idin);
            DatanGraphics.qform[1] = qform[0] / root2;
        } else if (d == 0.0) {
            idin = (int)d2;
            if (idin < 1) {
                idin = 1;
            }
            if (idin > 10) {
                idin = 10;
            }
            DatanGraphics.qform[1] = cdin / Math.pow(root2, idin);
            DatanGraphics.qform[0] = qform[1] / root2;
        } else {
            DatanGraphics.qform[0] = d;
            DatanGraphics.qform[1] = d2;
        }
        rformt = qform[0] / qform[1];
        if (rformt > 1.0) {
            DatanGraphics.qad[0] = 0.0;
            DatanGraphics.qbd[0] = 32767.0;
            DatanGraphics.qad[1] = 0.5 * (1.0 - 1.0 / rformt) * 32767.0;
            DatanGraphics.qbd[1] = 0.5 * (1.0 + 1.0 / rformt) * 32767.0;
        } else {
            DatanGraphics.qad[1] = 0.0;
            DatanGraphics.qbd[1] = 32767.0;
            DatanGraphics.qad[0] = 0.5 * (1.0 - rformt) * 32767.0;
            DatanGraphics.qbd[0] = 0.5 * (1.0 + rformt) * 32767.0;
        }
        for (int i = 0; i < 2; ++i) {
            DatanGraphics.qdd[i] = qbd[i] - qad[i];
            DatanGraphics.qddi[i] = 1.0 / qdd[i];
            DatanGraphics.qadc[i] = 0.0;
            DatanGraphics.qbdc[i] = qform[i];
            DatanGraphics.qadp[i] = qad[i];
            DatanGraphics.qbdp[i] = qbd[i];
            DatanGraphics.qddp[i] = qdd[i];
            DatanGraphics.qddpi[i] = qddi[i];
        }
        DatanGraphics.setTransformations();
    }

    private static void writePolylineBuffer() {
        if (numpolys > 0) {
            int n = 0;
            for (int i = 0; i < numpolys; ++i) {
                int n2 = bufPoints[n + 1];
                n+=2;
                for (int j = 0; j < n2; ++j) {
                    n+=2;
                }
            }
        }
    }

    public static void setSmallClippingWindow() {
        DatanGraphics.flushPolyline();
        DatanGraphics.qadcl[0] = DatanGraphics.transformSingleWorldToDevice(qaw2[0], 0);
        DatanGraphics.qadcl[1] = DatanGraphics.transformSingleWorldToDevice(qaw2[1], 1);
        DatanGraphics.qbdcl[0] = DatanGraphics.transformSingleWorldToDevice(qbw2[0], 0);
        DatanGraphics.qbdcl[1] = DatanGraphics.transformSingleWorldToDevice(qbw2[1], 1);
    }

    public static void setBigClippingWindow() {
        DatanGraphics.flushPolyline();
        DatanGraphics.qadcl[0] = qadp[0];
        DatanGraphics.qadcl[1] = qadp[1];
        DatanGraphics.qbdcl[0] = qbdp[0];
        DatanGraphics.qbdcl[1] = qbdp[1];
    }

    private void closeFrame(JFrame jFrame) {
        jFrame.dispose();
    }

    private static void text(int n, double d, double d2, double d3, double d4, double d5, String string, double[] arrd) {
        int n2;
        DatanGraphics.rv[0] = d3;
        DatanGraphics.rv[1] = d4;
        DatanGraphics.gv[0] = - d4;
        DatanGraphics.gv[1] = d3;
        gvabs2 = gv[0] * gv[0] + gv[1] * gv[1];
        gvabs = Math.sqrt(gv[0] * gv[0] + gv[1] * gv[1]);
        rvabs2 = 0.0;
        rvabs2 = rv[0] * rv[0] + rv[1] * rv[1];
        rvabs = Math.sqrt(rv[0] * rv[0] + rv[1] * rv[1]);
        DatanGraphics.avin[0] = d;
        DatanGraphics.avin[1] = d2;
        for (n2 = 0; n2 < 2; ++n2) {
            DatanGraphics.rve[n2] = rv[n2] / rvabs;
            DatanGraphics.gve[n2] = gv[n2] / gvabs;
        }
        gr = d5;
        c = string.getBytes();
        DatanGraphics.grlett();
        for (n2 = 0; n2 < 2; ++n2) {
            if (n == 1) {
                DatanGraphics.av[n2] = avin[n2] - gr * 0.5 * gve[n2];
                DatanGraphics.op[n2] = avin[n2] + alengt * rve[n2];
                continue;
            }
            if (n == 2) {
                DatanGraphics.av[n2] = avin[n2] - gr * 0.5 * gve[n2] - alengt * rve[n2];
                DatanGraphics.op[n2] = avin[n2] - alengt * rve[n2];
                continue;
            }
            if (n == 3) {
                DatanGraphics.av[n2] = avin[n2] - alengt * 0.5 * rve[n2];
                DatanGraphics.op[n2] = avin[n2] + gr * 0.5 * gve[n2];
                continue;
            }
            DatanGraphics.av[n2] = avin[n2] - gr * gve[n2] - alengt * 0.5 * rve[n2];
            DatanGraphics.op[n2] = avin[n2] - gr * 0.5 * gve[n2];
        }
        arrd[0] = op[0];
        arrd[1] = op[1];
        for (n2 = 0; n2 < nuj; ++n2) {
            int n3;
            nu = (int)((double)j[n2] / 1000.0 + 0.05);
            if (nu >= 0) {
                ga = gr;
            }
            if (nu == 1 || nu == 4) {
                ga = gr * fg1;
            }
            if (nu == 2 || nu == 3 || nu == 5 || nu == 6) {
                ga = gr * fg1 * fg2;
            }
            if (idop[n2 + 1] == 1) {
                g1 = ga;
            }
            if (nu >= 0) {
                gz = 0.0;
            }
            if (nu >= 1) {
                gz = gr - gr * fg1 / 2.0;
            }
            if (nu == 4) {
                gz = (- gr * fg1) / 2.0;
            }
            if (nu == 2) {
                gz = gr + (gr * fg1 - gr * fg1 * fg2) / 2.0;
            }
            if (nu == 3) {
                gz = gr - (gr * fg1 + gr * fg1 * fg2) / 2.0;
            }
            if (nu == 5) {
                gz = (gr * fg1 - gr * fg1 * fg2) / 2.0;
            }
            if (nu == 6) {
                gz = (- gr * fg1 + gr * fg1 * fg2) / 2.0;
            }
            for (n3 = 0; n3 < 2; ++n3) {
                DatanGraphics.avnext[n3] = av[n3] + gz * gve[n3];
            }
            id = j[n2] - nu * 1000;
            DatanGraphics.grsymb();
            if (idop[n2 + 1] == 1) continue;
            if (idop[n2] == 1) {
                ga = g1;
            }
            for (n3 = 0; n3 < 2; ++n3) {
                double[] arrd2 = av;
                int n4 = n3;
                arrd2[n4] = arrd2[n4] + ga * rve[n3] * ((double)iga / utx + z / utx - (double)miga / utx);
            }
        }
    }

    static void grlett() {
        int n = c.length;
        n = c.length;
        nuj = 0;
        DatanGraphics.nunu[0] = 0;
        DatanGraphics.nunu[1] = 0;
        DatanGraphics.nunu[2] = 0;
        na1 = 1;
        na5 = 0;
        for (DatanGraphics.no = 0; no < n; ++DatanGraphics.no) {
            DatanGraphics.idop[DatanGraphics.no] = 0;
            DatanGraphics.j[DatanGraphics.no] = 0;
        }
        alengt = 0.0;
        for (DatanGraphics.nur = 0; nur < n; ++DatanGraphics.nur) {
            boolean bl;
            iascii = c[nur];
            na2 = 0;
            for (DatanGraphics.nul = 0; nul < 3; ++DatanGraphics.nul) {
                if (iascii != k[nul]) continue;
                na2 = nul + 1;
            }
            if (na2 != 0) {
                na1 = na2;
                bl = false;
            } else {
                bl = true;
            }
            if (bl) {
                na4 = 0;
                for (DatanGraphics.nul = 0; nul < 3; ++DatanGraphics.nul) {
                    if (iascii != kk[nul]) continue;
                    na4 = nul + 1;
                }
                if (na4 != 0) {
                    if (na4 == 2 && na5 == 0) {
                        na5 = 2;
                    }
                    na5 = na4 + na5;
                    if (na4 == 3) {
                        na5 = 0;
                    }
                    if (na5 > 6) {
                        na5 = 0;
                    }
                    bl = false;
                } else {
                    bl = true;
                }
            }
            if (bl) {
                if (iascii == kkk) {
                    DatanGraphics.idop[DatanGraphics.nuj] = 1;
                    bl = false;
                } else {
                    bl = true;
                }
            }
            if (bl) {
                na3 = 63;
                for (DatanGraphics.nul = 0; nul < 94; ++DatanGraphics.nul) {
                    if (iascii != m[nul]) continue;
                    na3 = nul + 1;
                }
                ++nuj;
                if (na1 == 1) {
                    DatanGraphics.j[DatanGraphics.nuj - 1] = mm[na3 - 1];
                }
                if (na1 == 2) {
                    DatanGraphics.j[DatanGraphics.nuj - 1] = ll[na3 - 1];
                }
                if (na1 == 3) {
                    DatanGraphics.j[DatanGraphics.nuj - 1] = lll[na3 - 1];
                }
                id = j[nuj - 1];
                int[] arrn = j;
                int n2 = nuj - 1;
                arrn[n2] = arrn[n2] + na5 * 1000;
                bl = idop[nuj - 1] != 1;
            }
            if (!bl) continue;
            DatanGraphics.grleng();
            if (na5 == 0) {
                alengt+=gr * ((double)iga / utx + z / utx - (double)miga / utx);
                continue;
            }
            if (na5 == 1 || na5 == 4) {
                alengt+=gr * fg1 * ((double)iga / utx + z / utx - (double)miga / utx);
                continue;
            }
            if (na5 != 2 && na5 != 3 && na5 < 5) continue;
            alengt+=gr * fg1 * fg2 * ((double)iga / utx + z / utx - (double)miga / utx);
        }
    }

    static void grsymb() {
        DatanGraphics.move(avnext[0], avnext[1]);
        DatanGraphics.grleng();
        for (int i = 0; i < ko; ++i) {
            int n = (int)((double)Math.abs(idat[i]) / 100.0 + 0.1 - (double)miga);
            int n2 = (int)((double)Math.abs(idat[i]) - (double)(n + miga) * 100.0);
            for (int j = 0; j < 2; ++j) {
                DatanGraphics.wert2d[j] = avnext[j] + (double)n / utx * rve[j] * ga;
                DatanGraphics.wert2d[j] = wert2d[j] + (double)n2 / uty * gve[j] * ga - gve[j] * 10.0 * ga / uty;
            }
            if (idat[i] < 0) {
                DatanGraphics.move(wert2d[0], wert2d[1]);
                continue;
            }
            DatanGraphics.draw(wert2d[0], wert2d[1]);
        }
    }

    static void grleng() {
        int n;
        for (n = 0; n < 25; ++n) {
            DatanGraphics.idat[n] = iqlett[n + (id - 1) * 25];
        }
        miga = 0;
        ko = 0;
        for (n = 0; n < 25 && idat[n] != -999; ++n) {
            ++ko;
        }
        if (ko != 0) {
            iga1 = Math.abs(idat[0]);
            miga1 = Math.abs(idat[0]);
            for (DatanGraphics.ih = 0; ih < ko; ++DatanGraphics.ih) {
                if (Math.abs(idat[ih]) > iga1) {
                    iga1 = Math.abs(idat[ih]);
                }
                if (Math.abs(idat[ih]) >= miga1) continue;
                miga1 = Math.abs(idat[ih]);
            }
            iga = (int)((double)iga1 / 100.0);
            miga = (int)((double)miga1 / 100.0);
        } else {
            iga = 19;
        }
    }

    static double[] transformWorldToComputing(double[] arrd) {
        double[] arrd2 = new double[2];
        for (int i = 0; i < 2; ++i) {
            arrd2[i] = qac[i] + (arrd[i] - qaw2[i]) * qdc[i] * qdw2i[i];
        }
        return arrd2;
    }

    static double[] transformComputingToWorld(double[] arrd) {
        double[] arrd2 = new double[2];
        for (int i = 0; i < 2; ++i) {
            arrd2[i] = qaw2[i] + (arrd[i] - qac[i]) * qdw2[i] * qdci[i];
        }
        return arrd2;
    }

    static double transformSingleWorldToComputing(double d, int n) {
        double d2 = qac[n] + (d - qaw2[n]) * qdc[n] * qdw2i[n];
        return d2;
    }

    static double transformSingleComputingToWorld(double d, int n) {
        double d2 = qaw2[n] + (d - qac[n]) * qdw2[n] * qdci[n];
        return d2;
    }

    static double transformSingleWorldToDevice(double d, int n) {
        double d2 = qadp[n] + (d - qawp[n]) * qddp[n] * qdwpi[n];
        return d2;
    }

    private static void ladder(double[] arrd, double[] arrd2, int n, int n2, int n3, double d, double d2, int n4, double d3, double d4, double d5, boolean bl) {
        int n5;
        String string;
        int n6;
        boolean bl2;
        char[] arrc = new char[7];
        double[] arrd3 = new double[2];
        double[] arrd4 = new double[2];
        double[] arrd5 = new double[2];
        double[] arrd6 = new double[2];
        double[] arrd7 = new double[2];
        double[] arrd8 = new double[2];
        double[] arrd9 = new double[2];
        boolean[] arrbl = new boolean[1];
        double[] arrd10 = new double[1];
        int[] arrn = new int[3];
        NumberFormat numberFormat = NumberFormat.getNumberInstance(Locale.US);
        numberFormat.setGroupingUsed(false);
        numberFormat.setMaximumIntegerDigits(9);
        NumberFormat numberFormat2 = NumberFormat.getNumberInstance(Locale.US);
        numberFormat2.setGroupingUsed(false);
        numberFormat.setMaximumIntegerDigits(9);
        numberFormat2.setMaximumIntegerDigits(9);
        numberFormat2.setMaximumFractionDigits(5);
        NumberFormat numberFormat3 = NumberFormat.getNumberInstance(Locale.US);
        if (numberFormat3 instanceof DecimalFormat) {
            ((DecimalFormat)numberFormat3).applyPattern("0.#####E0");
        }
        int n7 = n4;
        double d6 = d2;
        xmovtx = 0.0;
        if (n7 <= 0) {
            n7 = 1;
        }
        arrd3 = DatanGraphics.transformComputingToWorld(arrd);
        arrd4 = DatanGraphics.transformComputingToWorld(arrd2);
        if (n == 1 && Math.abs(n3) == 2) {
            n6 = (14 - n3) / 4;
            arrd5[0] = 1.0;
            arrd5[1] = 0.0;
        } else {
            n6 = (3 - n3) / 2;
            arrd5[0] = 1.0;
            arrd5[1] = 0.0;
        }
        for (int i = 0; i < 2; ++i) {
            arrd7[i] = arrd3[i];
            arrd8[i] = arrd4[i];
            arrd9[i] = arrd[i];
        }
        double d7 = (Math.abs(arrd[n - 1]) + Math.abs(arrd2[n - 1])) * 0.5;
        int n8 = d7 > 0.0 ? 5 - (int)(Math.log(d7) / Math.log(10.0) + 0.5) : 5;
        if (n8 >= 0 && n8 <= 9) {
            numberFormat.setMaximumFractionDigits(n8);
            bl2 = true;
        } else {
            bl2 = false;
            numberFormat.setMaximumFractionDigits(0);
        }
        double d8 = Math.abs(arrd2[n - 1] - arrd[n - 1]);
        int n9 = d8 != 0.0 ? (int)Math.rint(Math.log(d8) / Math.log(10.0) - 0.5) : 0;
        double d9 = Math.pow(10.0, n9);
        int n10 = 0;
        if (d6 > 0.0) {
            n10 = (int)(d8 / d6) + 1;
        }
        if (d6 <= 0.0 || n10 > 50) {
            int n11;
            double d10 = d8 / d9;
            if (d10 <= 1.5) {
                d6 = d9 * 0.2;
                n7 = 2;
            } else if (d10 <= 3.5) {
                d6 = d9 * 0.5;
                n7 = 5;
            } else if (d10 <= 7.5) {
                d6 = d9;
                n7 = 5;
            } else {
                d6 = d9 * 2.0;
                n7 = 2;
            }
            double d11 = Math.abs(DatanGraphics.transformSingleWorldToComputing(d5, n - 1) - DatanGraphics.transformSingleWorldToComputing(0.0, n - 1));
            if (n6 == 1 || n6 == 2) {
                n11 = (int)(d11 * 1.4 / d6) + 1;
            } else {
                int n12;
                int n13;
                double d12;
                double d13 = Math.max(Math.abs(arrd[n - 1]), Math.abs(arrd2[n - 1]));
                int n14 = (int)(Math.log(d13) / Math.log(10.0));
                if (bl && d7 > 0.05) {
                    n12 = Math.max(n14, 0) + 3;
                    d12 = Math.abs(d - Math.rint(d));
                    n13 = Math.max(- (int)(Math.log(d6) / Math.log(10.0)), 0);
                    string = numberFormat.format(d12);
                    n5 = n8;
                } else {
                    n12 = 7;
                    if (Math.abs(n14) >= 9) {
                        ++n12;
                    }
                    if (d6 <= (d12 = Math.pow(10.0, n14)) * 0.99999) {
                        ++n12;
                    }
                    d12 = Math.abs(Math.rint(d / d12) - d / d12);
                    string = numberFormat2.format(d12);
                    n13 = 0;
                    n5 = 5;
                }
                n5 = string.length();
                n13 = Math.max(n5, n13);
                n11 = (int)(d11 * 0.8 * (double)(n12+=n13) / d6) + 1;
            }
            n7 = n11;
            d6*=(double)n11;
        }
        if (d4 > 0.0 || d5 > 0.0) {
            boolean bl3;
            int n15 = 0;
            while (bl3 = DatanGraphics.scale(arrd[n - 1], arrd2[n - 1], d, d6, n7, arrbl, arrd10, arrn) && n15 < 10) {
                boolean bl4 = arrbl[0];
                double d14 = arrd10[0];
                int n16 = arrn[0];
                int n17 = arrn[1];
                int n18 = arrn[2];
                double d15 = Math.abs(d14);
                double d16 = n16 == 1 ? d4 : d4 * 0.5;
                String string2 = " ";
                n5 = 0;
                string = " ";
                arrd9[n - 1] = d14;
                arrd7[n - 1] = DatanGraphics.transformSingleComputingToWorld(d14, n - 1);
                arrd8[n - 1] = arrd7[n - 1];
                if (d4 > 0.0) {
                    arrd8[Math.abs((int)n2) - 1] = arrd7[Math.abs(n2) - 1] + d16 * (double)(n2 / Math.abs(n2));
                    DatanGraphics.drawLine(arrd7, arrd8, 0.0);
                }
                arrd8[Math.abs((int)n2) - 1] = arrd7[Math.abs(n2) - 1];
                if (d5 <= 0.0 || n16 != 1) continue;
                arrd8[Math.abs((int)n3) - 1] = arrd7[Math.abs(n3) - 1] + d16 * 2.0 * (double)(n3 / Math.abs(n3));
                if (bl && bl2) {
                    if (bl4 && (d7 > 0.05000000074505806 || d15 < d7 * 9.999999747378752E-6) && d15 <= 500.0) {
                        if (n18 == 1) {
                            if (n17 == 0) {
                                string2 = "0";
                            } else {
                                string = numberFormat2.format(n17);
                                string2 = string + "&p";
                                if (n17 == 1) {
                                    string2 = "&p";
                                } else if (n17 == -1) {
                                    string2 = "-&p";
                                }
                            }
                        } else {
                            string = numberFormat2.format(n17);
                            string2 = string + "&p";
                            string = numberFormat2.format(n18);
                            string2 = string2 + "@/" + string;
                            if (n17 == 1) {
                                string2 = "&p@/" + string;
                            } else if (n17 == -1) {
                                string2 = "-&p@/" + string;
                            }
                        }
                    } else {
                        string2 = Math.abs(d14 - Math.rint(d14)) < Math.max(Math.abs(arrd2[n - 1] - arrd[n - 1]) * 1.0E-5, 1.0E-4) && d7 > 0.05 ? (string = numberFormat2.format((int)Math.rint(d14))) : (string = numberFormat.format(d14));
                    }
                } else {
                    int n19;
                    if (d15 <= d7 * 9.999999747378752E-6) {
                        d14 = 0.0;
                    }
                    string = numberFormat3.format(d14);
                    StringBuffer stringBuffer = new StringBuffer(string.length());
                    StringBuffer stringBuffer2 = new StringBuffer(string.length());
                    StringBuffer stringBuffer3 = new StringBuffer(string.length());
                    for (n19 = 0; n19 < string.length() && string.charAt(n19) != 'E'; ++n19) {
                        stringBuffer2.append(string.charAt(n19));
                    }
                    String string3 = stringBuffer2.toString();
                    for (n19 = string.indexOf((int)69) + 1; n19 < string.length(); ++n19) {
                        stringBuffer3.append(string.charAt(n19));
                    }
                    String string4 = stringBuffer3.toString();
                    string2 = string4.charAt(0) == '0' ? string3 : "%" + string3 + "*10^" + string4;
                }
                DatanGraphics.text(n6, arrd8[0], arrd8[1], arrd5[0], arrd5[1], d5, string2, arrd6);
                if (n6 != 1 && n6 != 2) continue;
                xmovtx = Math.max(Math.abs(arrd6[0] - arrd4[0]), xmovtx);
                arrd8[Math.abs((int)n3) - 1] = arrd7[Math.abs(n3) - 1];
            }
        }
    }

    private static boolean scale(double d, double d2, double d3, double d4, int n, boolean[] arrbl, double[] arrd, int[] arrn) {
        int n2;
        double d5;
        boolean bl;
        boolean bl2 = false;
        if (!rnt) {
            nc = 0;
            an = Math.min(d, d2);
            en = Math.max(d, d2);
            int n3 = (int)Math.rint((d3 - an) / d4) + 1;
            atims = d3 - (double)n3 * d4;
            atdel = d4 / (double)n;
            eps = (en - an) * 0.001;
            aneps = an - eps;
            eneps = en + eps;
            eta = Math.max((en - an) * 1.0E-5, 1.0E-4);
        }
        int n4 = 0;
        int n5 = 0;
        do {
            bl = false;
            rnt = atims < eneps;
            d5 = atims;
            if (atims > aneps && rnt) {
                bl2 = true;
            }
            if (nc == 0 || nc == n) {
                int n6;
                n2 = 1;
                nc = 0;
                if (Math.abs(d5) < 1000000.0 && Math.abs(d5 - (double)(n6 = (int)Math.rint(d5 / piqurt)) * piqurt) <= eta) {
                    bl = true;
                    if (n6 - 4 * (n6 / 4) == 0) {
                        n5 = n6 / 4;
                        n4 = 1;
                    } else if (n6 - 2 * (n6 / 2) == 0) {
                        n5 = n6 / 2;
                        n4 = 2;
                    } else {
                        n5 = n6;
                        n4 = 4;
                    }
                }
            } else {
                n2 = 0;
            }
            atims+=atdel;
            ++nc;
        } while (rnt && !bl2);
        if (!bl2) {
            nc = 0;
        }
        arrbl[0] = bl;
        arrd[0] = d5;
        arrn[0] = n2;
        arrn[1] = n5;
        arrn[2] = n4;
        return bl2;
    }

    public static void drawScaleX(String string) {
        double d;
        double[] arrd = new double[2];
        double[] arrd2 = new double[2];
        double[] arrd3 = new double[2];
        arrd[0] = qac[0];
        arrd[1] = qac[1];
        arrd2[0] = qbc[0];
        arrd2[1] = qac[1];
        double d2 = Math.sqrt((qbwp[0] - qawp[0]) * (qbwp[0] - qawp[0]) + (qbwp[1] - qawp[1]) * (qbwp[1] - qawp[1])) * 0.014999999664723873;
        if (lscset) {
            d = grdef * d2;
            d2 = ticdef * d2;
            DatanGraphics.ladder(arrd, arrd2, 1, 2, -2, fixdef, deldef, ntcdef, 0.0, d2, d, numdef);
        } else {
            d = d2;
            DatanGraphics.ladder(arrd, arrd2, 1, 2, -2, 0.0, 0.0, 0, 0.0, d2, d, true);
        }
        int n = qbc[0] - qac[0] >= 0.0 ? 1 : -1;
        arrd3[0] = Math.max(qaw2[0], qbw2[0]);
        arrd3[1] = Math.min(qaw2[1], qbw2[1]) - 2.0 * d2 - 3.0 * d;
        DatanGraphics.drawArrow(arrd3, n, string, d);
        arrd[1] = qbc[1];
        arrd2[1] = qbc[1];
        if (lscset) {
            DatanGraphics.ladder(arrd, arrd2, 1, -2, -2, fixdef, deldef, ntcdef, 0.0, d2, 0.0, numdef);
        } else {
            DatanGraphics.ladder(arrd, arrd2, 1, -2, -2, 0.0, 0.0, 0, 0.0, d2, 0.0, true);
        }
        lscset = false;
    }

    public static void drawScaleY(String string) {
        double d;
        double[] arrd = new double[2];
        double[] arrd2 = new double[2];
        double[] arrd3 = new double[2];
        arrd[0] = qac[0];
        arrd[1] = qac[1];
        arrd2[0] = qac[0];
        arrd2[1] = qbc[1];
        double d2 = Math.sqrt((qbwp[0] - qawp[0]) * (qbwp[0] - qawp[0]) + (qbwp[1] - qawp[1]) * (qbwp[1] - qawp[1])) * 0.014999999664723873;
        if (lscset) {
            d = grdef * d2;
            d2 = ticdef * d2;
            DatanGraphics.ladder(arrd, arrd2, 2, 1, -1, fixdef, deldef, ntcdef, 0.0, d2, d, numdef);
        } else {
            d = d2;
            DatanGraphics.ladder(arrd, arrd2, 2, 1, -1, 0.0, 0.0, 0, 0.0, d2, d, true);
        }
        int n = qbc[1] - qac[1] >= 0.0 ? 2 : -2;
        arrd3[0] = Math.min(qaw2[0], qbw2[0]) - 2.0 * d - xmovtx;
        arrd3[1] = Math.max(qaw2[1], qbw2[1]) - 0.5 * d;
        DatanGraphics.drawArrow(arrd3, n, string, d);
        arrd[0] = qbc[0];
        arrd2[0] = qbc[0];
        if (lscset) {
            DatanGraphics.ladder(arrd, arrd2, 2, -1, -1, fixdef, deldef, ntcdef, 0.0, d2, 0.0, numdef);
        } else {
            DatanGraphics.ladder(arrd, arrd2, 2, -1, -1, 0.0, 0.0, 0, 0.0, d2, 0.0, true);
        }
        lscset = false;
    }

    public static void setParametersForScale(double d, double d2, int n, double d3, double d4, boolean bl) {
        lscset = true;
        fixdef = d;
        deldef = d2;
        ntcdef = n;
        ticdef = d3 > 0.0 ? d3 : 1.0;
        grdef = d4 > 0.0 ? d4 : 1.0;
        numdef = bl;
    }

    public static void setStandardPaperSizeAndBorders() {
        DatanGraphics.papersize[0] = 21.02241;
        DatanGraphics.papersize[1] = 29.730177;
        DatanGraphics.paperborders[0] = 0.5;
        DatanGraphics.paperborders[1] = 0.5;
        DatanGraphics.paperborders[2] = 0.5;
        DatanGraphics.paperborders[3] = 0.5;
    }

    public static void setPaperSizeAndBorders(double d, double d2, double d3, double d4, double d5, double d6) {
        DatanGraphics.papersize[0] = d;
        DatanGraphics.papersize[1] = d2;
        DatanGraphics.paperborders[0] = d3;
        DatanGraphics.paperborders[1] = d4;
        DatanGraphics.paperborders[2] = d6;
        DatanGraphics.paperborders[3] = d5;
    }

    public static void setStandardScreenColors() {
        iqpsfp = true;
        DatanGraphics.ct[0] = new Color(0.0f, 0.0f, 0.9f);
        DatanGraphics.ct[1] = new Color(1.0f, 1.0f, 0.0f);
        DatanGraphics.ct[2] = new Color(1.0f, 1.0f, 1.0f);
        DatanGraphics.ct[3] = new Color(0.0f, 1.0f, 1.0f);
        DatanGraphics.ct[4] = new Color(1.0f, 0.784f, 0.0f);
        DatanGraphics.ct[5] = new Color(1.0f, 0.0f, 0.0f);
        DatanGraphics.ct[6] = new Color(0.753f, 0.753f, 0.753f);
        DatanGraphics.ct[7] = new Color(0.0f, 1.0f, 0.0f);
        DatanGraphics.ct[8] = new Color(1.0f, 0.0f, 1.0f);
        DatanGraphics.lw[0] = 70.0f;
        DatanGraphics.lw[1] = 70.0f;
        DatanGraphics.lw[2] = 70.0f;
        DatanGraphics.lw[3] = 70.0f;
        DatanGraphics.lw[4] = 70.0f;
        DatanGraphics.lw[5] = 70.0f;
        DatanGraphics.lw[6] = 70.0f;
        DatanGraphics.lw[7] = 70.0f;
        for (int i = 0; i < 8; ++i) {
            DatanGraphics.strokes[i] = new BasicStroke(lw[i], 1, 1);
        }
    }

    public static void setScreenColor(int n, Color color, float f) {
        if (n > 0 && n <= 8) {
            DatanGraphics.flushPolyline();
            DatanGraphics.ct[n] = color;
            DatanGraphics.lw[n - 1] = 35.0f * f;
            DatanGraphics.strokes[n - 1] = new BasicStroke(lw[n - 1], 1, 1);
        }
    }

    public static void setScreenBackground(Color color) {
        iqpsfp = false;
        DatanGraphics.ct[0] = color;
    }

    public static void setStandardPSColors() {
        DatanGraphics.ctab[0] = Color.white;
        DatanGraphics.ctab[1] = new Color(0.0f, 0.0f, 1.0f);
        DatanGraphics.ctab[2] = new Color(0.0f, 0.0f, 0.0f);
        DatanGraphics.ctab[3] = new Color(0.0f, 1.0f, 0.0f);
        DatanGraphics.ctab[4] = new Color(1.0f, 0.0f, 0.0f);
        DatanGraphics.ctab[5] = new Color(1.0f, 0.0f, 0.0f);
        DatanGraphics.ctab[6] = new Color(0.7f, 0.0f, 0.75f);
        DatanGraphics.ctab[7] = new Color(0.0f, 1.0f, 0.0f);
        DatanGraphics.ctab[8] = new Color(1.0f, 0.0f, 1.0f);
        for (int i = 0; i < 8; ++i) {
            DatanGraphics.linw[i] = 2.0f;
        }
    }

    public static void setPSColor(int n, Color color, float f) {
        if (n > 0 && n <= 8) {
            DatanGraphics.ctab[n] = color;
            DatanGraphics.linw[n - 1] = f;
        }
    }

    public static void setStandardPSColorsBlackAndWhite() {
        iqpsfp = false;
        DatanGraphics.ctab[0] = Color.white;
        for (int i = 1; i < 9; ++i) {
            DatanGraphics.ctab[i] = Color.black;
            DatanGraphics.linw[i - 1] = 2.0f;
        }
    }

    public static double roundUp(double d) {
        double d2;
        double d3 = 1.0;
        if (d < 0.0) {
            d3 = -1.0;
        }
        if ((d = Math.abs(d)) == 0.0) {
            d2 = 0.0;
        } else {
            double d4 = Math.log10(d);
            double d5 = Math.floor(d4);
            double d6 = Math.pow(10.0, d5);
            double d7 = Math.ceil(10.0 * d / d6);
            int n = (int)d7;
            int n2 = n % 10;
            d7 = d3 == 1.0 ? (d7+=1.0) : (d7-=1.0);
            d2 = d3 * d7 * 0.1 * d6;
        }
        return d2;
    }

    public static double roundDown(double d) {
        double d2;
        double d3 = 1.0;
        if (d < 0.0) {
            d3 = -1.0;
        }
        if ((d = Math.abs(d)) == 0.0) {
            d2 = 0.0;
        } else {
            double d4 = Math.log10(d);
            double d5 = Math.floor(d4);
            double d6 = Math.pow(10.0, d5);
            double d7 = Math.ceil(10.0 * d / d6);
            int n = (int)d7;
            int n2 = n % 10;
            d7 = d3 == 1.0 ? (d7-=1.0) : (d7+=1.0);
            d2 = d3 * d7 * 0.1 * d6;
        }
        return d2;
    }

    private static String getExtension(String string) {
        String string2 = null;
        int n = string.lastIndexOf(46);
        if (n > 0 && n < string.length() - 1) {
            string2 = string.substring(n + 1).toLowerCase();
        }
        return string2;
    }

    static /* synthetic */ JFrame access$100() {
        return closeFrame;
    }

    /*
     * Opcode count of 20903 triggered aggressive code reduction.  Override with --aggressivesizethreshold.
     */
    static {
        pane = new JOptionPane();
        ct = new Color[]{new Color(0.0f, 0.0f, 0.9f), new Color(1.0f, 1.0f, 0.0f), new Color(1.0f, 1.0f, 1.0f), new Color(0.0f, 1.0f, 1.0f), new Color(1.0f, 0.784f, 0.0f), new Color(1.0f, 0.0f, 0.0f), new Color(0.753f, 0.753f, 0.753f), new Color(0.0f, 1.0f, 0.0f), new Color(1.0f, 0.0f, 1.0f)};
        lw = new float[]{70.0f, 70.0f, 70.0f, 70.0f, 70.0f, 70.0f, 70.0f, 70.0f};
        strokes = new BasicStroke[]{new BasicStroke(lw[0], 1, 1), new BasicStroke(lw[1], 1, 1), new BasicStroke(lw[2], 1, 1), new BasicStroke(lw[3], 1, 1), new BasicStroke(lw[4], 1, 1), new BasicStroke(lw[5], 1, 1), new BasicStroke(lw[6], 1, 1), new BasicStroke(lw[7], 1, 1)};
        framecoords = new double[4];
        bstrng = new byte[80];
        bcmstr = new byte[12];
        iqpsfp = false;
        ixyc = new int[2];
        ctab = new Color[]{new Color(1.0f, 1.0f, 0.902f), new Color(0.0f, 0.0f, 1.0f), new Color(0.0f, 0.0f, 0.0f), new Color(0.0f, 1.0f, 0.0f), new Color(1.0f, 0.0f, 0.0f), new Color(1.0f, 0.0f, 0.0f), new Color(0.7f, 0.0f, 0.75f), new Color(0.0f, 1.0f, 0.0f), new Color(1.0f, 0.0f, 1.0f)};
        linw = new float[]{2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.0f};
        cdin = 118.92;
        root2 = 1.4142;
        qac = new double[2];
        qbc = new double[2];
        qdc = new double[2];
        qdci = new double[2];
        qaw2 = new double[2];
        qbw2 = new double[2];
        qdw2 = new double[2];
        qdw2i = new double[2];
        qcaw2 = new double[2];
        qcbw2 = new double[2];
        qawp = new double[2];
        qbwp = new double[2];
        qdwp = new double[2];
        qdwpi = new double[2];
        qad = new double[]{0.0, 0.0};
        qbd = new double[]{32767.0, 32767.0};
        qdd = new double[]{32767.0, 32767.0};
        qddi = new double[]{3.05185E-5, 3.05185E-5};
        qform = new double[2];
        qadc = new double[2];
        qbdc = new double[2];
        qadp = new double[2];
        qbdp = new double[2];
        qddp = new double[2];
        qddpi = new double[2];
        iqad = new int[2];
        iqbd = new int[2];
        qadcl = new double[2];
        qbdcl = new double[2];
        iqadp = new int[2];
        iqbdp = new int[2];
        papersize = new double[]{21.02241, 29.730177};
        paperborders = new double[]{0.5, 0.5, 0.5, 0.5};
        psOffsets = new double[2];
        plsizval = new double[2];
        iqdvsi = new int[]{0, 32767};
        iqnplm = 200;
        iqoutx = new int[iqnplm];
        iqouty = new int[iqnplm];
        iqclix = new int[2 * iqnplm];
        iqcliy = new int[2 * iqnplm];
        iqclda = new int[2 * iqnplm];
        qoutx = new double[iqnplm];
        qouty = new double[iqnplm];
        open = false;
        workstation1Open = false;
        workstation2Open = false;
        maxadev = 2;
        iqnadv = 0;
        aqadid = new int[]{0, 0};
        k = new int[]{64, 38, 37};
        kk = new int[]{94, 95, 35};
        kkk = 34;
        ll = new int[]{1, 96, 96, 4, 96, 96, 95, 62, 165, 3, 108, 12, 109, 14, 60, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 156, 29, 153, 97, 96, 33, 34, 56, 177, 37, 184, 176, 40, 41, 41, 43, 179, 45, 46, 186, 181, 178, 48, 182, 52, 47, 96, 185, 180, 183, 58, 6, 96, 32, 96, 96, 95, 91, 175, 93, 94, 122, 123, 143, 125, 128, 142, 124, 127, 130, 130, 131, 132, 133, 134, 145, 137, 129, 138, 139, 140, 79, 96, 144, 135, 141, 126};
        lll = new int[]{1, 96, 96, 4, 96, 96, 7, 63, 147, 148, 11, 173, 155, 14, 5, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 161, 146, 162, 94, 96, 166, 34, 159, 154, 37, 38, 150, 40, 152, 42, 43, 175, 151, 46, 167, 167, 49, 163, 169, 92, 168, 168, 157, 56, 164, 58, 59, 96, 61, 96, 96, 95, 91, 175, 93, 94, 170, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 171, 80, 81, 82, 83, 84, 172, 86, 87, 88, 89, 90};
        mm = new int[]{1, 96, 96, 4, 96, 96, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 96, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 96, 61, 96, 96, 95, 91, 175, 93, 94, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90};
        m = new int[]{33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 123, 124, 125, 126, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122};
        iqlett = new short[]{-810, 811, 911, 910, 810, -835, 935, 918, 818, 835, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -535, 835, 828, 535, -1335, 1535, 1528, 1335, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -313, 833, -1013, 1533, -1828, 328, -1518, 18, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1228, 1129, 830, 530, 229, 127, 125, 224, 523, 823, 1122, 1220, 1218, 1016, 815, 515, 216, 118, -735, 710, -999, 0, 0, 0, 0, 1535, -34, 135, 335, 434, 432, 331, 131, 32, 34, -1410, 1210, 1111, 1113, 1214, 1414, 1513, 1511, 1410, -999, 0, 0, 0, 0, 0, -1810, 530, 533, 835, 1335, 1533, 1530, 518, 513, 810, 1310, 1815, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -534, 434, 435, 535, 532, 430, 329, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1535, 1233, 1030, 925, 920, 1015, 1212, 1510, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 333, 530, 625, 620, 515, 312, 10, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -118, 1518, -1313, 323, -825, 810, -313, 1323, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -118, 1518, -825, 810, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -210, 110, 111, 211, 207, 105, 4, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -18, 1518, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -811, 911, 910, 810, 811, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 1535, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 131, 233, 334, 535, 635, 834, 933, 1031, 1127, 1117, 1014, 912, 811, 610, 510, 311, 212, 114, 17, 27, -999, 0, 0, 0, -26, 635, 610, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -28, 130, 333, 535, 835, 1034, 1232, 1228, 1124, 10, 1210, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -31, 234, 535, 835, 1034, 1231, 1228, 1125, 1024, 524, -1024, 1222, 1320, 1316, 1213, 1011, 710, 410, 211, 13, -999, 0, 0, 0, 0, -835, 14, 1314, -1020, 1010, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1235, 35, 24, 525, 825, 1024, 1222, 1319, 1316, 1213, 1111, 810, 510, 311, 13, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1232, 1134, 935, 535, 334, 132, 29, 17, 114, 212, 311, 510, 910, 1111, 1212, 1316, 1320, 1222, 1123, 924, 524, 323, 121, 18, -999, -31, 35, 1335, 410, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -535, 233, 30, 28, 423, 823, 1228, 1230, 1033, 735, 535, -423, 18, 15, 212, 510, 710, 1012, 1215, 1218, 823, -999, 0, 0, 0, -12, 111, 310, 710, 1011, 1113, 1217, 1232, 1034, 835, 535, 234, 30, 26, 124, 322, 521, 721, 1022, 1223, -999, 0, 0, 0, 0, -819, 820, 920, 919, 819, -811, 911, 910, 810, 811, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -210, 110, 111, 211, 207, 105, 4, -119, 120, 220, 219, 119, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1510, 18, 1523, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -23, 1523, -1515, 15, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 1518, 23, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -333, 535, 1035, 1333, 1328, 823, 820, -811, 911, 910, 810, 811, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1510, 310, 13, 23, 325, 1325, 1523, 1518, 1315, 515, 318, 520, 820, 1018, 815, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 635, 1210, -219, 1019, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 35, 735, 934, 1132, 1229, 1227, 1125, 1024, 723, 23, -723, 1121, 1218, 1216, 1012, 911, 710, 10, -999, 0, 0, 0, 0, 0, -1131, 1033, 934, 735, 535, 334, 233, 131, 27, 17, 114, 212, 311, 510, 710, 911, 1012, 1114, -999, 0, 0, 0, 0, 0, 0, -10, 35, 735, 1033, 1229, 1218, 1114, 1012, 811, 710, 10, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 35, 1235, -23, 923, -10, 1210, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 35, 1235, -23, 923, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1131, 1033, 934, 735, 535, 334, 233, 131, 27, 17, 114, 212, 311, 510, 710, 911, 1012, 1114, 1217, 1221, 821, -999, 0, 0, 0, -10, 35, -1235, 1210, -23, 1223, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 610, -310, 335, -35, 635, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -14, 112, 310, 410, 611, 712, 815, 835, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 35, -19, 1235, -424, 1210, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 10, 1210, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 35, 718, 1435, 1410, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 35, 1210, 1235, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 131, 233, 334, 535, 735, 934, 1033, 1131, 1227, 1217, 1114, 1012, 911, 710, 510, 311, 212, 114, 17, 27, -999, 0, 0, 0, -10, 35, 735, 1034, 1232, 1329, 1327, 1224, 1022, 721, 21, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 131, 233, 334, 535, 735, 934, 1033, 1131, 1227, 1217, 1114, 1012, 911, 710, 510, 311, 212, 114, 17, 27, -618, 1210, -999, 0, -10, 35, 735, 1034, 1232, 1329, 1327, 1224, 1022, 721, 21, -721, 1310, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1232, 1034, 735, 635, 234, 132, 29, 27, 125, 324, 823, 1021, 1119, 1217, 1215, 1112, 810, 510, 211, 112, 14, -999, 0, 0, 0, -610, 635, -35, 1235, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 17, 114, 212, 311, 510, 610, 811, 912, 1014, 1117, 1135, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 610, 1235, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 410, 828, 1210, 1635, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 1210, -10, 1235, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 623, 1235, -623, 610, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 1235, 10, 1210, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -910, 310, 335, 935, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 1510, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -510, 1110, 1135, 535, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -810, 835, 1030, 530, 835, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1523, 23, 525, 520, 23, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -828, 1028, 1330, 1333, 1035, 835, 533, 530, 828, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1023, 924, 725, 425, 224, 122, 19, 16, 113, 211, 410, 710, 911, 1012, -1025, 1011, 1110, -999, 0, 0, 0, 0, 0, 0, 0, -35, 10, -23, 124, 325, 625, 824, 922, 1019, 1016, 913, 811, 610, 310, 11, 12, -999, 0, 0, 0, 0, 0, 0, 0, 0, -1023, 924, 725, 425, 224, 122, 19, 16, 113, 211, 410, 710, 911, 1012, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1023, 924, 725, 425, 224, 122, 19, 16, 113, 211, 410, 710, 911, 1012, -1035, 1010, -999, 0, 0, 0, 0, 0, 0, 0, 0, -1023, 924, 725, 425, 224, 122, 19, 16, 113, 211, 410, 710, 911, 1012, -18, 1118, 1120, 1023, -999, 0, 0, 0, 0, 0, 0, -735, 535, 334, 232, 210, -26, 626, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1023, 924, 725, 425, 224, 122, 19, 16, 113, 211, 410, 710, 911, 1012, -1025, 1006, 904, 603, 303, 4, -999, 0, 0, 0, 0, -35, 10, -23, 124, 325, 525, 724, 823, 921, 910, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -110, 125, -31, 29, 229, 231, 31, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -525, 509, 407, 306, 105, 5, -431, 429, 629, 631, 431, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 10, -13, 1024, -619, 1010, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 12, 111, 310, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -25, 10, -23, 124, 325, 525, 724, 823, 810, -823, 924, 1125, 1325, 1524, 1623, 1610, -999, 0, 0, 0, 0, 0, 0, 0, 0, -25, 10, -23, 124, 325, 525, 724, 823, 921, 910, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -425, 224, 122, 19, 16, 113, 211, 410, 610, 811, 913, 1016, 1019, 922, 824, 625, 425, -999, 0, 0, 0, 0, 0, 0, 0, -25, 3, -23, 124, 325, 625, 824, 922, 1019, 1016, 913, 811, 610, 310, 11, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1025, 1003, -1023, 924, 725, 425, 224, 122, 19, 16, 113, 211, 410, 710, 911, 1012, -999, 0, 0, 0, 0, 0, 0, 0, 0, -25, 10, -23, 124, 325, 525, 724, 823, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1223, 1124, 825, 525, 324, 223, 121, 120, 219, 518, 818, 1117, 1215, 1213, 1011, 810, 510, 211, 113, -999, 0, 0, 0, 0, 0, -23, 823, -431, 412, 511, 710, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -810, 825, -812, 711, 510, 310, 211, 112, 14, 25, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -25, 510, 1025, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -25, 410, 721, 1010, 1425, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -25, 1010, -10, 1025, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -3, 203, 304, 1025, -25, 615, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -25, 1025, 10, 1010, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1535, 1335, 1033, 1025, 823, 1020, 1013, 1310, 1510, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1310, 1320, -1325, 1335, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -835, 1035, 1333, 1325, 1523, 1320, 1313, 1010, 810, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -18, 320, 820, 1316, 1816, 2118, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -534, 634, 635, 535, 532, 630, 729, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1030, 833, 333, 30, 28, 325, 825, 1023, 1020, 818, 318, 20, 23, 325, -818, 1015, 1013, 810, 310, 13, -999, 0, 0, 0, 0, -520, 823, 810, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -20, 323, 1023, 1320, 10, 1310, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -23, 1323, 818, 1315, 810, 310, 13, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1010, 1023, 315, 1315, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1323, 323, 318, 820, 1318, 1313, 810, 310, 13, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1323, 323, 318, 1318, 1313, 810, 510, 318, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -323, 1323, 310, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -310, 315, 1318, 1323, 323, 318, 1315, 1310, 310, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -313, 510, 1010, 1313, 1320, 1023, 523, 320, 318, 1318, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -313, 510, 1010, 1313, 1320, 1023, 523, 320, 313, -1323, 10, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -118, 1518, -810, 825, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -318, 1318, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -533, 835, 823, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -33, 335, 1035, 1333, 23, 1323, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 1335, 830, 1328, 823, 323, 325, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1023, 1035, 328, 1328, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1335, 335, 330, 833, 1330, 1325, 823, 323, 25, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1335, 335, 330, 1330, 1325, 823, 523, 330, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -335, 1335, 323, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -323, 328, 1330, 1335, 335, 330, 1328, 1323, 323, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -325, 523, 1023, 1325, 1333, 1035, 535, 333, 330, 1330, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -325, 523, 1023, 1325, 1333, 1035, 535, 333, 325, -1335, 23, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -318, 1318, -813, 823, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -318, 1318, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1225, 1013, 811, 610, 410, 211, 113, 16, 19, 122, 224, 425, 625, 824, 1022, 1210, -999, 0, 0, 0, 0, 0, 0, 0, 0, -3, 28, 131, 334, 535, 735, 934, 1033, 1131, 1129, 1127, 1025, 924, 623, 223, -623, 922, 1120, 1218, 1215, 1011, 710, 510, 212, -999, -24, 125, 225, 324, 422, 710, 1225, -710, 703, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -626, 325, 224, 122, 19, 16, 113, 211, 410, 610, 811, 913, 1016, 1019, 922, 824, 725, 130, 133, 434, 1134, -999, 0, 0, 0, -35, 34, 133, 332, 432, 1035, -431, 229, 127, 23, 17, 113, 311, 710, 810, 1009, 1006, 805, 5, -999, 0, 0, 0, 0, 0, -25, 125, 224, 321, 310, -321, 524, 725, 925, 1124, 1221, 1202, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1023, 924, 725, 425, 224, 123, 21, 20, 119, 318, 618, -318, 117, 16, 14, 112, 211, 410, 710, 911, 1012, -999, 0, 0, 0, -21, 124, 225, 325, 422, 413, 511, 610, 810, 1111, 1213, 1229, 1033, 835, 635, 434, 431, 529, 728, 1527, -999, 0, 0, 0, 0, -25, 13, 111, 310, 410, 611, 713, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -25, 10, -925, 725, 18, 710, 910, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 235, 334, 1110, -10, 621, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1011, 910, 811, 825, -812, 711, 510, 310, 211, 112, 14, 25, -14, 2, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -25, 225, 10, 311, 512, 714, 1020, 1125, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 34, 132, 231, 331, 1035, -331, 230, 128, 126, 325, 1029, -325, 123, 20, 14, 211, 711, 910, 1009, 1007, 906, 705, 5, -999, -425, 224, 122, 19, 16, 113, 211, 410, 610, 811, 913, 1016, 1019, 922, 824, 625, 425, -999, 0, 0, 0, 0, 0, 0, 0, -25, 1125, -410, 425, -825, 811, 910, 1010, 1111, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -425, 225, 122, 19, 16, 113, 211, 410, 610, 811, 913, 1016, 1019, 922, 824, 625, 425, -16, 7, 105, 304, 904, 1003, -999, 0, -325, 224, 122, 19, 17, 113, 211, 310, 710, 811, 913, 1017, 1019, 922, 824, 725, 325, -725, 1125, -999, 0, 0, 0, 0, 0, -625, 613, 711, 910, 1010, 1212, -125, 1125, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1225, 1212, 1111, 910, 710, 611, 512, 414, 424, 325, 225, 124, 22, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -225, 123, 20, 17, 114, 212, 510, 710, 1012, 1114, 1217, 1220, 1123, 925, 725, 624, 602, -999, 0, 0, 0, 0, 0, 0, 0, -25, 225, 1005, 1205, -5, 1225, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1225, 1212, 1111, 910, 710, 611, 512, 414, 424, 325, 225, 124, 22, -825, 802, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, -325, 123, 20, 16, 113, 211, 410, 510, 611, 713, 720, -713, 811, 910, 1010, 1211, 1313, 1416, 1420, 1323, 1125, -999, 0, 0, 0, -23, 1523, -18, 1518, -13, 1513, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -23, 1523, 1025, 1020, 1523, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -25, 1510, -1525, 10, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -18, 1318, -523, 525, 825, 823, 523, -513, 813, 810, 510, 513, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -20, 1520, -15, 1515, -1325, 310, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -20, 1520, -828, 813, -1510, 10, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -13, 310, 510, 1335, 1535, 1833, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -23, 1223, 1422, 1520, 1515, 1413, 1212, 12, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 820, 1510, 10, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -18, 1818, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1523, 323, 122, 20, 15, 113, 312, 1512, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -20, 810, 835, 1535, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -15, 18, 320, 820, 1813, 2313, 2515, 2518, 2320, 1820, 813, 313, 15, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 1835, 1810, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1520, 1323, 1023, 813, 313, 15, 20, 323, 823, 1013, 1313, 1515, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1528, 20, 1513, -1510, 10, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1510, 10, -13, 1520, 28, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1323, 1025, 1028, 1330, 1530, 1828, 1825, 1523, 1323, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 635, 1210, -219, 1019, -635, 437, 639, 837, 635, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -835, 810, 1015, 515, 810, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 635, 1210, -219, 1019, -337, 334, -937, 934, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -337, 334, 535, 735, 934, 937, -934, 1033, 1131, 1227, 1217, 1114, 1012, 911, 710, 510, 311, 212, 114, 17, 27, 131, 233, 334, -999, -35, 17, 114, 212, 311, 510, 610, 811, 912, 1014, 1117, 1135, -337, 334, -737, 734, -999, 0, 0, 0, 0, 0, 0, 0, 0, 510, -310, 333, 535, 1035, 1333, 1330, 1025, 1318, 1310, 810, 513, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1023, 924, 725, 425, 224, 122, 19, 16, 113, 211, 410, 710, 911, 1012, -1025, 1011, 1110, -333, 330, -733, 730, -999, 0, 0, 0, -425, 224, 122, 19, 16, 113, 211, 410, 610, 811, 913, 1016, 1019, 922, 824, 625, 425, -333, 330, -733, 730, -999, 0, 0, 0, -810, 825, -812, 711, 510, 310, 211, 112, 14, 25, -233, 230, -633, 630, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -506, 813, 1313, 506, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -530, 533, -1030, 1033, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 35, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 35, 1035, 1034, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -10, 535, 1010, 10, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -27, 131, 233, 334, 535, 735, 934, 1033, 1131, 1227, 1217, 1114, 1012, 911, 710, 510, 311, 212, 114, 17, 27, -223, 1023, -999, 0, -310, 10, -110, 635, 1110, -910, 1210, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -35, 1035, -323, 723, -10, 1010, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -210, 235, -810, 835, -35, 1035, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1035, 35, 523, 10, 1010, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -610, 631, 434, 235, 135, 34, -631, 834, 1035, 1135, 1234, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -430, 229, 127, 24, 22, 118, 216, 415, 615, 816, 918, 1022, 1024, 927, 829, 630, 430, -435, 635, -535, 510, -410, 610, -999, 0, -35, 27, 124, 222, 321, 520, 620, 821, 922, 1024, 1127, 1135, -435, 635, -535, 510, -410, 610, -999, 0, 0, 0, 0, 0, 0, -210, 510, 515, 316, 119, 23, 27, 131, 334, 535, 735, 934, 1131, 1227, 1223, 1119, 916, 715, 710, 1010, -999, 0, 0, 0, 0, -310, 10, 3, 303, 310, -301, 13, 0, 300, 301, -999, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        fg1 = 0.6;
        fg2 = 0.6;
        utx = 25.0;
        uty = 25.0;
        z = 8.0;
        idop = new int[100];
        j = new int[100];
        idat = new int[25];
        nunu = new int[3];
        avin = new double[2];
        avnext = new double[2];
        rv = new double[2];
        av = new double[2];
        op = new double[2];
        gv = new double[2];
        gve = new double[2];
        rve = new double[2];
        wert2d = new double[2];
        piqurt = 0.7853982;
        rnt = false;
        nc = 0;
        an = 0.0;
        en = 0.0;
        atims = 0.0;
        eps = 0.0;
        atdel = 0.0;
        aneps = 0.0;
        eneps = 0.0;
        eta = 0.0;
        lastPoint = new double[2];
        borderPoints = new double[4];
    }
}