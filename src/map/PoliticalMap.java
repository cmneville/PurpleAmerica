/*
 * Political Map Project
 * Name: 
 * Block:
 * 
 * Program Purpose:
 *
 * Algorithm:
 * 
 * Future/possible improvements:
 *
 */
package map;

import edu.princeton.cs.introcs.StdDraw;
import java.io.File;
import java.util.Scanner;

/**
 *
 * @author
 */
public class PoliticalMap {

    public static void main(String[] args) {

        Scanner scan;

        try {
            scan = new Scanner(new File("C:\\Users\\chris\\Documents\\Programs\\PurpleAmerica\\src\\data\\AR.txt"));
        } catch (Exception e) {
            System.out.println("nope");
            scan = null;
        }
        
        
        Coordinate min = new Coordinate(scan.nextDouble(),scan.nextDouble());
        Coordinate max = new Coordinate(scan.nextDouble(),scan.nextDouble());
        
       
        double q = ((max.latitude- min.latitude));
        double p = ((max.longitude-min.longitude));
        
        
        while(q < 1000 && p < 1500){
            q += q;
            p += p;
        }
        StdDraw.setCanvasSize((int)(p),(int)(q));
        
        StdDraw.setXscale(min.longitude,max.longitude);
        StdDraw.setYscale(min.latitude,max.latitude);
        
        //System.out.println(max);
        int size = scan.nextInt();
        Region region = new Region(min, max, size);
        Subregion subregions;
        for (int i = 0; i < size; i++) {
            scan.nextLine();
            scan.nextLine();
            String subTag = scan.nextLine();
            String tag = scan.nextLine();
            
            //System.out.println(subTag);
            //System.out.println(tag);
            //System.out.println(scan.nextLine());
            int subSize = scan.nextInt();

            subregions = new Subregion(subSize);

            for (int j = 0; j < subSize; j++) {
                subregions.addCoordinate(new Coordinate(scan.nextDouble(), scan.nextDouble()));
            }
            region.addSubregion(subregions);
            //scan.nextLine();
        }

        region.draw();

    }
}
