/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph.utils;

import java.util.ArrayList;
import java.util.List;
import graph.Node;

/**
 *
 * @author mikkomo
 */
public abstract class Result {

    private long runningTimeMs;
    private final String operation;
    private List<Result> subResults;


    public void start() {
        this.runningTimeMs = System.currentTimeMillis();
    }

    public void end() {
        this.runningTimeMs = (System.currentTimeMillis() - this.runningTimeMs);
    }

    @Override
    public abstract String toString();

    public void addSubResult(Result result) {
        if (this.subResults == null) {
            this.subResults = new ArrayList();
        }
        this.subResults.add(result);
    }

    public Result(String algorithm) {
        this.operation = algorithm;
    }


    public long getRunningTimeMs() {
        return runningTimeMs;
    }

    public String getAlgorithm() {
        return operation;
    }

    public List<Result> getSubResults() {
        return subResults;
    }

    
    
}
