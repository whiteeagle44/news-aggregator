package io.eagle44.newsproducer.newsdataio;

import java.util.List;

class NewsDataIOResponse {
    List<Result> results;

    public NewsDataIOResponse() {
    }

    public NewsDataIOResponse(List<Result> results) {
        this.results = results;
    }

    public List<Result> getResults() {
        return results;
    }

    public void setResults(List<Result> results) {
        this.results = results;
    }
}

