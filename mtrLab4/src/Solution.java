import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] m = new int[]{10, 30, 45};
        int[] q = new int[]{40, 30, 25};

        double p12 = 0, p13 = 0, p23 = -0.8;

        double[] pcpStructure = new double[3];

        pcpStructure[0] = (Math.pow(q[1], 2) - p12 * q[0] * q[1] - p13 * q[0] * q[2]) /
                (Math.pow(q[0], 2) + Math.pow(q[1], 2) - 2 * p13 * q[0] * q[1] + Math.pow(q[0], 2) + Math.pow(q[2], 2) - 2 * p13 * q[0] * q[2]);

        pcpStructure[1] = (Math.pow(q[0], 2) - p12 * q[0] * q[1] - p23 * q[1] * q[2]) /
                (2 * Math.pow(q[1], 2) + Math.pow(q[0], 2) - 2 * p12 * q[0] * q[1] + Math.pow(q[1], 2) + Math.pow(q[2], 2) - 2 * p23 * q[2] * q[1]);

        pcpStructure[2] = 1 - (pcpStructure[0] + pcpStructure[1]);

        System.out.print("PCP structure: ");
        System.out.println(Arrays.toString(pcpStructure));

        double mp = pcpStructure[0] * m[0] + pcpStructure[1] * m[1] + pcpStructure[2] * m[2];
        System.out.println("\nmp: " + mp);

        double qp = Math.pow(pcpStructure[0], 2) * Math.pow(q[0], 2) + Math.pow(pcpStructure[1], 2) * Math.pow(q[1], 2)
                + Math.pow(pcpStructure[2], 2) * Math.pow(q[2], 2) + 2 * pcpStructure[0] * pcpStructure[1] * q[0] * q[1] * p12
                + 2 * pcpStructure[0] * pcpStructure[2] * q[0] * q[2] * p13 + 2 * pcpStructure[1] * pcpStructure[2] * q[1] * q[2] * p23;
       double qpSqrt = Math.sqrt(qp);
        System.out.println("\nsq " + qpSqrt);
    }
}
