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
            scan = new Scanner(new File("/data/AK.txt"));
        } catch (Exception e) {
            System.out.println("nope");
            scan = null;
        }

        Coordinate min = new Coordinate(scan.nextDouble(), scan.nextDouble());
        Coordinate max = new Coordinate(scan.nextDouble(), scan.nextDouble());
        System.out.println(max);
        int size = scan.nextInt();
        Region region = new Region(min, max, size);
        Subregion subregions;
        for (int i = 0; i < size - 1; i++) {
            String subTag = scan.nextLine();
            String tag = scan.nextLine();
            int subSize = scan.nextInt();

            subregions = new Subregion(subSize);

            for (int j = 0; j < subSize - 1; j++) {
                subregions.addCoordinate(new Coordinate(scan.nextDouble(), scan.nextDouble()));
            }
            region.addSubregion(subregions);
        }

        region.draw();

    }
}
