import java.util.*;

/**
 * Created by mkravtsova on 9/20/16.
 */
public class MergeSort {

    static void mergeSort(int[] num, int i, int j) {

        int low = i;
        int high = j;

        if (low >= high) {

            return;
        }

        int middle = (low + high) / 2;

        mergeSort(num, low, middle);
        mergeSort(num, middle + 1, high);

        int end_low = middle;
        int start_high = middle + 1;

        while ((low <= end_low) && (start_high <= high)) {

            if (num[low] < num[start_high]) {

                low++;
            }
            else {

                int Temp = num[start_high];

                for (int k = start_high- 1; k >= low; k--) {

                    num[k+1] = num[k];
                }

                num[low] = Temp;
                low ++;
                end_low ++;
                start_high ++;
            }
        }
    }
}
