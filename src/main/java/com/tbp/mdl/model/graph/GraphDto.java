package com.tbp.mdl.model.graph;

import com.tbp.mdl.model.graph.stats.NodeMetrics;
import com.tbp.mdl.model.moodle.Course;


import java.util.Collection;

public class GraphDto {

    Course course;
    Collection<Node> nodes;
    Collection<Edge> edges;

    public GraphDto(Graph graph, Course course) {
        nodes = graph.nodeMap.values();
        edges = graph.edgeMap.values();
        this.course = course;
        calcNodeDesc();
    }

    public Course getCourse() {
        return course;
    }

    public Collection<Node> getNodes() {
        return nodes;
    }

    public Collection<Edge> getEdges() {
        return edges;
    }

    private void calcNodeDesc() {
        NodeMetrics nodeMetrics = new NodeMetrics(nodes);
        for (Node n: nodes) {
            n.setMetricDescription(Node.BETWEENNESS, nodeMetrics.getQ1Betweenness(), nodeMetrics.getMedianBetweenness(), nodeMetrics.getQ3Betweenness());
            n.setMetricDescription(Node.CLOSENESS, nodeMetrics.getQ1Closeness(), nodeMetrics.getMedianCloseness(), nodeMetrics.getQ3Closeness());
            n.setMetricDescription(Node.ECCENTRICITY, nodeMetrics.getQ1Eccentricity(), nodeMetrics.getMedianEccentricity(), nodeMetrics.getQ3Eccentricity());
            n.setMetricDescription(Node.HARMONIC_CLOSENESS, nodeMetrics.getQ1HarmonicCloseness(), nodeMetrics.getMedianHarmonicCloseness(), nodeMetrics.getQ3HarmonicCloseness());
            n.setMetricDescription(Node.PAGE_RANK, nodeMetrics.getQ1PageRank(), nodeMetrics.getMedianPageRank(), nodeMetrics.getQ3PageRank());
            n.setMetricDescription(Node.INDEGREE, nodeMetrics.getQ1Indegree(), nodeMetrics.getMedianIndegree(), nodeMetrics.getQ3Indegree());
            n.setMetricDescription(Node.OUTDEGREE, nodeMetrics.getQ1Outdegree(), nodeMetrics.getMedianOutdegree(), nodeMetrics.getQ3Outdegree());
            n.setMetricDescription(Node.DEGREE, nodeMetrics.getQ1Degree(), nodeMetrics.getMedianDegree(), nodeMetrics.getQ3Degree());
            n.setMetricDescription(Node.EIGENVECTOR, nodeMetrics.getQ1Eigenvector(), nodeMetrics.getMedianEigenvector(), nodeMetrics.getQ3Eigenvector());
        }
    }



}