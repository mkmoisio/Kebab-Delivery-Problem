package graph.utils;

/**
 *
 * @author mikkomo
 */
public class AlgorithmResult extends Result {

    public AlgorithmResult(String algorithm) {
        super(algorithm);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("Algorithm: ").append(super.getAlgorithm()).append("\n");
        sb.append("Running time: ").append(super.getRunningTimeMs()).append(" ms \n");

        return sb.toString();
    }

}
