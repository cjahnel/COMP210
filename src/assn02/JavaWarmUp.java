package assn02;
import java.text.DecimalFormat;
import java.util.Scanner;

// Here is a starter code that you may optionally use for this assignment.
// TODO: You need to complete these sections

public class JavaWarmUp {
    private static final DecimalFormat df = new DecimalFormat("0.00");

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        String[] categoriesList = {"phone", "laptop", "smart_watch"};

        int n = s.nextInt();
        // Date Time1 Category Fee Quantity Time2 AsmCost

        // create corresponding size arrays
        String date[] = new String[n];
        String time1[] = new String[n];
        String category[] = new String[n];
        double fee[] = new double[n];
        int quantity[] = new int[n];
        double time2[] = new double[n];
        double asmCost[] = new double[n];

		// TODO: Fill in the above arrays with data entered from the console.
        for (int i = 0; i < n; i++) {
            date[i] = s.next();
            time1[i] = s.next();
            category[i] = s.next();
            fee[i] = s.nextDouble();
            quantity[i] = s.nextInt();
            time2[i] = s.nextDouble();
            asmCost[i] = s.nextDouble();
        }

        // Calculate the # of batches, total Fee, total Quantity, total Labor and Assembly costs by category.
        // Maintain following category-wise total stats in the following Category Arrays
        int[] numOfBatchesC = new int[categoriesList.length];// so numOfBatchesC[0] = # of batches in category categoriesList[0]
        double[] totFeeC = new double[categoriesList.length]; // total fee of each category = sum(fee * qty)
        int[] totQuantityC = new int[categoriesList.length];    // total qty of each category = sum (qty)
        double[] totLaborCostC = new double[categoriesList.length]; // total labor cost of each category = sum(time2 x 16)
        double[] totAsmCostC = new double[categoriesList.length]; // total Assembly cost of each category = sum(AsmCost)

		// TODO: for each item i, incrementally total the values in the above arrays
        for (int i = 0; i < n; i++) {
            int catIndex = 0;
            // set the value of catIndex for each i to be such that category[i] == categoriesList[catIndex]
            // TODO: Your code for setting catIndex here
            for (int j = 0; j < categoriesList.length; j++) {
                if (categoriesList[j].equals(category[i])) {
                    catIndex = j;
                    break;
                }
            }
            numOfBatchesC[catIndex]++;
            // TODO: fill in rest of the Category arrays here
            totFeeC[catIndex] += fee[i] * quantity[i];
            totQuantityC[catIndex] += quantity[i];
            totLaborCostC[catIndex] += time2[i] * 16;
            totAsmCostC[catIndex] += asmCost[i];
        }

        boolean bigDataFile = true;
        for (int numOfBatches : numOfBatchesC) {
            if (numOfBatches < 2) {
                bigDataFile = false;
                break;
            }
        }

        if (bigDataFile) {
            // Find items with highest and lowest price per unit
            int highestItemIndex = getMaxPriceIndex(fee);
            int lowestItemIndex = getMinPriceIndex(fee);

            // TODO: Print items with highest and lowest price per unit.
            // make sure the format is correct!
            // Your code starts here:
            System.out.println(date[highestItemIndex]);
            System.out.println(time1[highestItemIndex]);
            System.out.println(category[highestItemIndex]);
            System.out.println(fee[highestItemIndex]);
            System.out.println(date[lowestItemIndex]);
            System.out.println(time1[lowestItemIndex]);
            System.out.println(category[lowestItemIndex]);
            System.out.println(fee[lowestItemIndex]);
            // Your code ends here.
        }

		// TODO: Calculate & Print Category-wise Statistics
        for (int j = 0; j < categoriesList.length; j++) {
            if (numOfBatchesC[j] > 0) {
                System.out.println(categoriesList[j]);
                // TODO: print the remaining stats
                System.out.println(totQuantityC[j]); // total number of products assembled
                // double avgAsmFeeC = totAsmCostC[j] / totQuantityC[j];
                // System.out.println(avgAsmFeeC); // average assembling fee per unit
                double avgFeeC = Math.round(totFeeC[j] / totQuantityC[j] * 100.0) / 100.0;
                System.out.println(df.format(avgFeeC)); // average fee per unit
                double totCostC = totAsmCostC[j] + totLaborCostC[j];
                double totNetProfitC = totFeeC[j] - totCostC;
                double avgNetProfitC = Math.round(totNetProfitC / totQuantityC[j] * 100.0) / 100.0;
                System.out.println(df.format(avgNetProfitC)); // average net profit per unit
            }
        }
    }

    // TODO: Find index of item with the highest price per unit.
    static int getMaxPriceIndex(double[] priceT){
		// Your code starts here:
        double max = 0;
        int maxIndex = -1;

        for (int i = 0; i < priceT.length; i++) {
            if (priceT[i] >= max) {
                max = priceT[i];
                maxIndex = i;
            }
        }
        return maxIndex;
		// Your code ends here.
    }

    // TODO: Find index of item with the lowest price per unit.
    static int getMinPriceIndex(double[] priceT){
		// Your code starts here:
        double min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < priceT.length; i++) {
            if (priceT[i] <= min) {
                min = priceT[i];
                minIndex = i;
            }
        }
        return minIndex;
		// Your code ends here.
    }
}
